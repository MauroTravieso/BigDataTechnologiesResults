package five.spark.sql.driver

import org.apache.spark.sql.SparkSession

object DataFrameFromCSV {

  def main(args: Array[String]): Unit = {

    // Spark Session (DataFrames)
    val spark = SparkSession
      .builder()
      .appName("Loading data from CSV file")
      .config("spark.master", "local[*]")
      .getOrCreate()

    val path = "src/main/resources/"
    val filename = "got_dataset.csv"

    val eventDF = spark.read
      .format("csv")
      .option("delimiter", ",")
      .option("header", "true")
      .option("inferSchema", "true")
      .option("mode", "DROPMALFORMED")
      .option("path", path + filename)
      .load()

    eventDF.printSchema()

    eventDF.show(5)

    println("Number of records: " + eventDF.count())

    eventDF.createOrReplaceTempView("events")

    val sqlDF_count = spark.sql("SELECT name, likelihoodOfReturn FROM events WHERE execution LIKE '%Poisoned%'")
    sqlDF_count.show()

  }

}
