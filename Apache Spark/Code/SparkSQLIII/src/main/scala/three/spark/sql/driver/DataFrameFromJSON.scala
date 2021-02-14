package three.spark.sql.driver

import org.apache.spark.sql.SparkSession

object DataFrameFromJSON {

  def main(args: Array[String]): Unit = {

    // Spark Session (DataFrames)
    val spark = SparkSession
      .builder()
      .appName("Loading data from JSON file")
      .config("spark.master", "local[*]")
      .getOrCreate()

    val path = "src/main/resources/"
    val filename = "got_dataset.json"

    val eventDF = spark.read
      .option("header", "true")
      .json(path + filename)

    // Schema
    eventDF.printSchema()

    // Data
    eventDF.show(5)

    // Number of records
    println("Number of records: " + eventDF.count())

    // SQL queries
    eventDF.createOrReplaceTempView("events")

    val sqlDF_count = spark.sql("SELECT COUNT(*) AS contain_Stark FROM events WHERE name LIKE '%Stark%'")
    sqlDF_count.show(5)

    val sqlDF_likeStark = spark.sql("SELECT name AS name_Stark FROM events WHERE name LIKE '%Stark%'")
    sqlDF_likeStark.show()

  }

}
