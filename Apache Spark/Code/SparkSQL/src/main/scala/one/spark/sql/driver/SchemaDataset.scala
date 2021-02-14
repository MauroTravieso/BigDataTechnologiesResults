package one.spark.sql.driver

import one.spark.sql.util.Event
import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object SchemaDataset {

  def main(args: Array[String]): Unit = {

    // Spark Configuration
    val sparkConf = new SparkConf()
      .setAppName("Loading data from CSV file")
      .setMaster("local[*]")

    // Spark Context (RDD)
    val sparkContext = new SparkContext(sparkConf)

    // Spark Session (DataFrames)
    val spark = SparkSession
      .builder()
      .appName("Loading data from CSV file")
      .config("spark.master", "local")
      .getOrCreate()

    val path = "src/main/resources/"
    val filename = "got_dataset.csv"

    // Load the .csv data directly as an RDD
    val eventRDD = sparkContext.textFile(path + filename)

    import spark.implicits._
    // Reading the Header
    val headerColumns = eventRDD.first()
    println(headerColumns)

    // Removing the header
    val eventRDDFiltered = eventRDD.filter(header => !header.startsWith(headerColumns))
    //eventRDDFiltered.collect().foreach(println)

    // Split each line into Array[String] with comma as delimiter
    val eventMap = eventRDDFiltered.map(line => line.split(","))

    // Convert RDD of Array[String] into the RDD of Event case class
    val eventCaseRDD = eventMap.map(e => Event(e(0), e(1), e(2), e(3), e(4), e(5), e(6), e(7)))

    // Convert Event RDD into Event DataFrame
    val eventDF = eventCaseRDD.toDF
    eventDF.printSchema()

    val newEventDF = eventDF
      .na.fill(" ", Array("name"))
      .na.fill(" ", Array("role"))
      .na.fill(" ", Array("death_season"))
      .na.fill(" ", Array("death_season"))
      .na.fill(" ", Array("death_episode"))
      .na.fill(" ", Array("execution"))
      .na.fill(" ", Array("likelihoodOfReturn"))
      .na.fill(" ", Array("likelihoodOfReturn_notes"))
      .na.fill(" ", Array("deathFlashback"))

    newEventDF.printSchema()

    // It works correctly when data is properly imputed
    //eventDF.collect().foreach(println)
    newEventDF.show(5)
    println("Number of rows: " + newEventDF.count())

    // Quering the dataframe
    newEventDF.registerTempTable("events")

    val eventSQL = spark.sqlContext.sql("SELECT COUNT(*) FROM events")
    eventSQL.collect.foreach(println)
  }

}
