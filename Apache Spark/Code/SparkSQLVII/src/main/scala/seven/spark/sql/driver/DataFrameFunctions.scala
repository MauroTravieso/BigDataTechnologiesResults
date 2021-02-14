package seven.spark.sql.driver

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{asc, desc}
import org.apache.spark.storage.StorageLevel

object DataFrameFunctions {

  def main(args: Array[String]): Unit = {

    // Spark Session (DataFrames)
    val spark = SparkSession
      .builder()
      .appName("Loading data from JSON file")
      .config("spark.master", "local[*]")
      .getOrCreate()

    val path = "src/main/resources/"
    val filename = "got_dataset.json"

    // Load DataFrame and persist for re-usability in memory through Cache()
    //    val eventDF = spark.read
    //      .option("header", "true")
    //      .json(path + filename).cache()

    // Load DataFrame and persist for re-usability in memory/disk
    // through configurable Persist()
    val eventDF = spark.read
      .option("header", "true")
      .json(path + filename).persist(StorageLevel.MEMORY_AND_DISK)


    //Return the column names in the dataframe
    println("Column names:")
    eventDF.columns.foreach(println)

    //Return the column datatype in the dataframe
    println("\nData types:")
    eventDF.dtypes.foreach(println)

    // Print Schema
    println("\nSchema:")
    eventDF.printSchema()

    // Print Data for 5 records
    eventDF.show(5)

    // Number of records
    println("Number of records: " + eventDF.count())

    // Return the first n rows in the DataFrame
    eventDF.select("name", "likelihoodOfReturn").take(2).foreach(println)

    // Return he first row
    println(eventDF.first())

    // Return the head
    println(eventDF.head())

    // Language Integrated Queries
    eventDF.select("name").limit(5).show()

    eventDF.select("name", "death_season")
      .where("death_season LIKE '5'")
      .limit(20)
      .show()

    // Filtering
    eventDF.select("name", "death_season")
      .filter("death_season LIKE '1'")
      .filter("death_episode LIKE '10'")
      .limit(20)
      .show()

    // GROUP BY
    eventDF.groupBy("name")
      .count()
      .filter("name LIKE '%Stark%'")
      .show()

    // ORDER BY
    eventDF.groupBy("name")
      .count()
      .filter("name LIKE '%Stark%'")
      .orderBy(desc("name"))
      .show()

    // DISTINCT
    eventDF.select("death_season")
      .distinct()
      .orderBy(desc("death_season"))
      .show()

    // DROP Column(s)
    val dropped_columnsDF = eventDF.drop("deathFlashback", "likelihoodOfReturn_notes")

    dropped_columnsDF.printSchema()

    //    // With Column
    //    import org.apache.spark.sql.functions.udf
    //    val upper: String => String =_.toUpperCase
    //    val upperUDF = udf(upper)
    ////    eventDF.withColumn("name",upperUDF("new_name"))
    //
    //    // With column renamed
    ////    eventDF.withColumn("name",upperUDF('new_name))
    ////      .withColumnRenamed("name","new_name")
    //
    //    // SORT
    //    eventDF.sort(desc("name")).show()
    //    eventDF.sort(asc("name")).show()

    // Repartition
    val repartitionDF = eventDF.repartition(5)

    println("Num partitions: " + repartitionDF.rdd.getNumPartitions)

    // SQL queries
    eventDF.createOrReplaceTempView("events")

    val sqlDF_count = spark.sql("SELECT COUNT(*) AS contain_Stark_poisoned FROM events WHERE name LIKE '%Stark%' AND execution LIKE 'Poisoned'")
    sqlDF_count.show()

    val sqlDF_more_deaths_season = spark.sql("SELECT death_season, COUNT(death_season) AS count FROM events GROUP BY death_season SORT BY death_season DESC")
    sqlDF_more_deaths_season.show()

    // Make DataFrame un-persisted in memory
    eventDF.unpersist()

    // Quering Hive tables
    // sqlContext.sql("show tables").show()

    // Write DF as AVRO format
    eventDF.write.format("com.databricks.spark.avro")
      .save("output/avro")

    // Write DF as CSV format
    eventDF.write.format("csv")
      .save("output/csv")

    // Write DF as JSON format
    eventDF.write.json("output/json")

    // Write DF as Parquet format
    eventDF.write.parquet("output/parquet")

  }

}
