package integration.hbasespark.driver

import integration.hbasespark.util.Employee
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog

/**
 * Spark Application: HBase - Spark Integration
 *                    Creating Dataframe from CSV
 *                    Performing SQL functions on HBase data
 *
 * @author    Mauro Travieso
 * @version   1.0
 *
 * Bugs: Check HBase writing
 */

object SparkDataframeHBase {

  def main(args: Array[String]): Unit = {


    // Input Data
    //    val data = Seq(
    //      Employee("1","Abby","Smith","K","3456 main","Orlando","FL","45235"),
    //      Employee("2","Amaya","Williams","L","123 Orange","Newark","NJ","27656"),
    //      Employee("3","Alchemy","Davis","P","Warners","San Jose","CA","34789")
    //    )

    ///////////////////////////
    // Spark Configuration and Context definition
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Spark Dataframe HBase")
    val sparkContext = new SparkContext(sparkConf)

    // Input Data reading data from CSV file
    val value:RDD[String] = sparkContext.textFile("src/main/resources/employees.csv")

    val data: Seq[Employee] =
      sparkContext.parallelize(value.collect).map {
        line => {
          val fields = line.split(",")
          Employee(
            fields(0),
            fields(1),
            fields(2),
            fields(3),
            fields(4),
            fields(5),
            fields(6),
            fields(7)
          )
        }
      }.collect().toSeq

    // Spark Session
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("Spark Dataframe HBase")
      .getOrCreate()

    // Dataframe definition
    import spark.implicits._
    val df = spark.sparkContext.parallelize(data).toDF

    // Display Schema from DataFrame
    df.printSchema()

    // Collect and show Data from Dataframe
    df.show(false)

    ///////////////////////////////////
    // HBase schema definition (catalog)
    def catalog =
      s"""{
         |"table":{"namespace":"default", "name":"employee"},
         |"rowkey":"key",
         |"columns":{
         |"key":{"cf":"rowkey", "col":"key", "type":"string"},
         |"fName":{"cf":"person", "col":"firstName", "type":"string"},
         |"lName":{"cf":"person", "col":"lastName", "type":"string"},
         |"mName":{"cf":"person", "col":"middleName", "type":"string"},
         |"addressLine":{"cf":"address", "col":"addressLine", "type":"string"},
         |"city":{"cf":"address", "col":"city", "type":"string"},
         |"state":{"cf":"address", "col":"state", "type":"string"},
         |"zipCode":{"cf":"address", "col":"zipCode", "type":"string"}
         |}
         |}""".stripMargin

    // Storing the dataframe into HBase
    //    df.write
    //      .options(Map(HBaseTableCatalog.tableCatalog -> catalog, HBaseTableCatalog.newTable -> "4"))
    //      .format("org.apache.spark.sql.execution.datasources.hbase")
    //      .mode("append")
    //      .save()
    //
    //    df.show()

    //////////////////////////////////
    // Reading from HBase to DataFrame
    val hbaseDF = spark.read
      .options(Map(HBaseTableCatalog.tableCatalog -> catalog))
      .format("org.apache.spark.sql.execution.datasources.hbase")
      .load()

    // Display Schema from DataFrame
    hbaseDF.printSchema()

    // Collect and show Data from Dataframe
    hbaseDF.show(false)

    // Applying filters (SQL where clause)
    hbaseDF.filter($"key" === "1" && $"state" === "FL")
      .select("key", "fName", "lName")
      .show()

    //Create Temporary Table on DataFrame
    hbaseDF.createOrReplaceTempView("employeeTable")

    //Run SQL
    spark.sql("select * from employeeTable where fName = 'Amaya' ").show

  }

}
