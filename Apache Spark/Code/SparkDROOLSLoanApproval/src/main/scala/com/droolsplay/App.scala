package com.droolsplay

import com.droolsplay.util.DroolUtil.{applyRules, loadRules}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.functions.lit

/**
 * Spark Application: Spark JBoss DROOLS rules integration
 *                    Input -> .csv file
 *                    Seq   -> Data Structure fields filled with RDD
 *                    Rules applied to CreditScore
 *                    Filtering according to APPROVED and NOT APPROVED
 *
 * @author    Mauro Travieso
 * @version   1.0
 *
 * Bugs: none known
 */

object App extends Logging {
  def main(args: Array[String]): Unit = {

    // Generating the Spark Session
    // Spark session creation
    val sparkConf = new SparkConf().setMaster("local").setAppName("LoanApplicants")
    val sparkContext = new SparkContext(sparkConf)
    val spark = SparkSession.builder().appName("LoanApplicants").getOrCreate()

    // Input data
    val value:RDD[String] = sparkContext.textFile("src/main/resources/Applicants.csv")

    val data: Seq[ApplicantForLoan] =
      sparkContext.parallelize(value.collect).map {
        line => {
          val fields = line.split(",")
          ApplicantForLoan(
            fields(0).toInt,
            fields(1),
            fields(2),
            fields(3).toInt,
            fields(4).toInt)
        }
      }.collect().toSeq

    // Input data
    //    val inputData = Seq(
    //      ApplicantForLoan(1, "Ram", "Ghadiyaram", 680, 680),
    //      ApplicantForLoan(2, "Mohd", "Ismail", 12000, 679),
    //      ApplicantForLoan(3, "Phani", "Ramavajjala", 100, 600),
    //      ApplicantForLoan(4, "Trump", "Donald", 1000000, 788),
    //      ApplicantForLoan(5, "Nick", "Suizo", 10, 788),
    //      ApplicantForLoan(6, "Mauro", "Travieso", 15000, 690),
    //      ApplicantForLoan(7, "Sreenath", "Mamilla", 10, 788),
    //      ApplicantForLoan(8, "Naveed", "Farroqui", 10, 788),
    //      ApplicantForLoan(9, "Ashish", "Anand", 1000, 788),
    //      ApplicantForLoan(10, "Vasudha", "Nanduri", 1001, 788),
    //      ApplicantForLoan(11, "Tathagatha", "das", 1002, 788),
    //      ApplicantForLoan(12, "Sean", "Owen", 1003, 788),
    //      ApplicantForLoan(13, "Sandy", "Raza", 1004, 788),
    //      ApplicantForLoan(14, "Holden", "Karau", 1005, 788),
    //      ApplicantForLoan(15, "Gobinathan", "SP", 1005, 7),
    //      ApplicantForLoan(16, "Arindam", "SenGupta", 1005, 670),
    //      ApplicantForLoan(17, "NIKHIL", "POTLAPALLY", 100, 670),
    //      ApplicantForLoan(18, "Phanindra", "Ramavojjala", 100, 671)
    //    )


    // Load drl file using loadRules from DroolUtil class
    val rules = loadRules

    // Broadcast all the rules using broadcast variable
    val broadcastRules = spark.sparkContext.broadcast(rules)

    // Applicants RDD
    //val applicants = spark.sparkContext.parallelize(inputData)
    val applicants = spark.sparkContext.parallelize(data)
    logInfo("list of all applicants " + applicants.getClass.getName)

    import spark.implicits._
    val applicantsDS = applicants.toDF()
    applicantsDS.show(false)

    //val df_size_in_bytes: Long = checkDFSize(spark, applicantsDS)
    //logInfo("byteCountToDisplaySize - df_size_in_bytes " + df_size_in_bytes)
    //logInfo(applicantsDS.rdd.toDebugString)

    val approvedguys = applicants.map {
      x => {
        logDebug(x.toString)
        applyRules(broadcastRules.value, x)
      }
    }.filter((a: ApplicantForLoan) => a.isApproved == true)
    logInfo("approvedguys " + approvedguys.getClass.getName)
    approvedguys.toDS.withColumn("Remarks", lit("Good Going!!! Your credit score =>680 check your score in https://www.creditkarma.com")).show(false)

    val numApproved: Long = approvedguys.count
    logInfo("Number of applicants APPROVED: " + numApproved)
    println("Number of applicants APPROVED: " + numApproved)

    // Dataframes using RDD applicants
    // It sufficient to get isApproved == true
    //    val approvedGuys = applicantsDS.rdd.map { row =>
    //      //(id: Int, firstName: String, lastName: String, requestAmount: Int, creditScore: Int)
    //      applyRules(broadcastRules.value,
    //        ApplicantForLoan(
    //          row.getAs[Int]("id")
    //          , row.getAs[String]("firstName")
    //          , row.getAs[String]("lastName")
    //          , row.getAs[Int]("requestAmount")
    //          , row.getAs[Int]("creditScore"))
    //      )
    //    }.filter((a: ApplicantForLoan) => (a.isApproved == true))
    //
    //    logInfo("approvedGuys " + approvedGuys.getClass.getName)
    //
    //    approvedGuys.toDS().withColumn("Remarks", lit("Good Going!! your credit score =>680 check your score in https://www.creditkarma.com")).show(false)
    //
    //    val numApprovedGuys: Long = approvedGuys.count
    //    logInfo("Number of applicants APPROVED: " + numApprovedGuys)


    // Dataframes using RDD applicants
    // It sufficient to get isApproved == false
    val notApprovedguys = applicantsDS.rdd.map { row =>
      //(id: Int, firstName: String, lastName: String, requestAmount: Int, creditScore: Int)
      applyRules(broadcastRules.value,
        ApplicantForLoan(
          row.getAs[Int]("id")
          , row.getAs[String]("firstName")
          , row.getAs[String]("lastName")
          , row.getAs[Int]("requestAmount")
          , row.getAs[Int]("creditScore"))
      )
    }.filter((a: ApplicantForLoan) => a.isApproved == false)

    logInfo("notApprovedguys " + notApprovedguys.getClass.getName)

    notApprovedguys.toDS().withColumn("Remarks", lit("Credit score <680., Need to improve your credit history!!! Check your score : https://www.creditkarma.com")).show(false)

    val numNotApproved: Long = notApprovedguys.count
    logInfo("Number of applicants NOT APPROVED: " + numNotApproved)
    println("Number of applicants NOT APPROVED: " + numNotApproved)
  }
}

