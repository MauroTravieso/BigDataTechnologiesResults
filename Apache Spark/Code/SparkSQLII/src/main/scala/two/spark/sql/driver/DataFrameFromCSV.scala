package two.spark.sql.driver

object DataFrameFromCSV {

  package two.spark.sql.driver

  import org.apache.spark.sql.SparkSession

  object DataFrameFromCSV {

    def main(args: Array[String]): Unit = {

      // Spark Session (DataFrames)
      val spark = SparkSession
        .builder()
        .appName("Loading data from CSV file")
        .config("spark.master", "local[*]")
        .getOrCreate()

      import spark.implicits._

      val path = "src/main/resources/"
      val filename = "got_dataset.csv"
      
      val eventDF = spark.read
        .option("header", "true")
        .csv(path + filename)

      //    val eventDF = spark.read
      //      .options(Map("inferSchema"->"true","delimiter"->",","header"->"true"))
      //      .csv(path+filename)

      eventDF.printSchema()

      eventDF.show(5)

      println("Number of records: " + eventDF.count())


      // Dealing with nulls
      //    val cleanEventDS = eventDS.na.drop()
      val newEventDF = eventDF
        .na.fill(0)
        .na.fill("unkown")
        .show(5)

      eventDF.createOrReplaceTempView("events")

      val sqlDF = spark.sql("SELECT COUNT(*) FROM events WHERE name LIKE '%Stark%'")
      sqlDF.show(5)
    }

  }

}
