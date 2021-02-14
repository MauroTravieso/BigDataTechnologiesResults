package four.spark.sql.driver

import org.apache.spark.sql.SparkSession

object DataFrameFromAVRO {

  def main(args: Array[String]): Unit = {

    // Spark Session (DataFrames)
    val spark = SparkSession
      .builder()
      .appName("Loading data from JSON file")
      .config("spark.master", "local[*]")
      .getOrCreate()

    val path = "src/main/resources/"
    val filename = "got_dataset.avro"

    val eventDF = spark.read
      .format("com.databricks.spark.avro")
      .load(path + filename)

    // Schema
    eventDF.printSchema()

    // Data
    eventDF.show(5)

    // Number of records
    println("Number of records: " + eventDF.count())

    // SQL queries
    eventDF.createOrReplaceTempView("events")

    val sqlDF_count = spark.sql("SELECT name, likelihoodOfReturn FROM events WHERE likelihoodOfReturn LIKE '100%'")
    sqlDF_count.show()
  }

}
