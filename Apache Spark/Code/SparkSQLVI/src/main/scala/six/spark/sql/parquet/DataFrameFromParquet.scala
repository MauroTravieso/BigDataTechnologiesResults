package six.spark.sql.parquet

import org.apache.spark.sql.SparkSession

object DataFrameFromParquet {

  def main(args: Array[String]): Unit = {

    // Spark Session (DataFrames)
    val spark = SparkSession
      .builder()
      .appName("Loading data from Parquet file")
      .config("spark.master", "local[*]")
      .getOrCreate()

    val path = "src/main/resources/"
    val filename = "got_dataset.parquet"

    val eventDF = spark.read
      .parquet(path + filename)

    eventDF.printSchema()

    eventDF.show(5)

    println("Number of records: " + eventDF.count())

    eventDF.createOrReplaceTempView("events")

    val sqlDF_count = spark.sql("SELECT name, death_season FROM events WHERE death_episode LIKE '10'")
    sqlDF_count.show()

  }

}
