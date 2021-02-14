//import org.apache.log4j.{Level, Logger}
import com.databricks.spark.xml.{XmlDataFrameReader, XmlDataFrameWriter}
import org.apache.hadoop.io.{NullWritable, Text}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{SaveMode, SparkSession}

/**
 * Spark Application: CSV formatter from text file/MySQL source table to
 *                    Avro     -> Print Schema/Show 5 rows/Count number of records
 *                    Parquet  -> Print Schema/Show 5 rows/Count number of records
 *                    ORC      -> Print Schema/Show 5 rows/Count number of records
 *                    JSON     -> Print Schema/Show 5 rows/Count number of records
 *                    XML      -> Print Schema/Show 5 rows/Count number of records
 *                    Sequence -> Print Schema/Show 5 rows/Count number of records
 *
 * @author    Mauro Travieso
 * @version   1.0
 *
 * Bugs: none known
 */
object CSVformatter {

  def main(args:Array[String]) {

    //    Logger.getLogger("org").setLevel(Level.ERROR)

    // Spark Session
    val spark = SparkSession
      .builder()
      .appName("CSV_Formatter Avro, Parquet, JSON, XML, ORC, Sequence")
      .master("local[*]")
      .enableHiveSupport() //For ORC files
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    // Reading the CSV file
    println("****************************************************************")
    println("CSV data")
    val df = spark.read
      .format("csv")
      .option("delimiter", ",")
      .option("header", "true")
      .option("inferSchema", "true")
      .option("mode", "DROPMALFORMED")
      .option("path", "src/main/resources/employee.csv")
      .load()

    // Prints the schema
    df.printSchema()

    // For testing purposes
    df.show(5)

    // Number of rows in the file
    println("Number of TextFile(CSV) file rows: " + df.count() + "\n")


    // Reading the CSV file through MySQL
    println("****************************************************************")
    println("CSV data, extracted from the Database")

    // Jdbc Connector (Connecting Spark with MySQL)
//    val jdbcDF = spark.read
//      .format("jdbc")
//      .option("driver","com.mysql.cj.jdbc.Driver")
//      .option("url", "jdbc:mysql://localhost:3306")    //.option("url", "jdbc:mysql:dbserver")
//      .option("dbtable", "employees.employee") //.option("dbtable", "schema.tablename")
//      .option("user", "user")
//      .option("password", "password")
//      .load()

    //    val sql="""select * from db.your_table where id>1"""
    //    val jdbcDF = spark.read
    //      .format("jdbc")
    //      .option("url", "jdbc:mysql:dbserver")
    //      .option("dbtable",  s"( $sql ) t")
    //      .option("user", "user")
    //      .option("password", "password")
    //      .load()
    //
    // Prints the schema
//    jdbcDF.printSchema()

    // For testing purposes
//    jdbcDF.show(5)

    // Number of rows in the file
//    println("Number of TextFile(CSV) file rows from MySQL: " + jdbcDF.count() + "\n")


    ////////////////////////////////
    // Write data to Avro format
    df.write //jdbcDF.write
      .format("com.databricks.spark.avro")
      .option("compression", "none")
      .mode(SaveMode.Overwrite)
      .save("output/avro_data/")

    // Prints the schema
    println("****************************************************************")
    println("Avro Schema")
    spark.read.format("com.databricks.spark.avro").load("output/avro_data").printSchema()

    // Show the Avro data
    println("Avro data")
    spark.read.format("com.databricks.spark.avro").load("output/avro_data")
      .show(5)

    println("Number of Avro file rows: " + spark.read.format("com.databricks.spark.avro").load("output/avro_data").count()+"\n")

    ////////////////////////////////
    // Write data to Parquet format (out-of-the-box)
    df.write //jdbcDF.write
      .option("compression","none")
      .format("parquet")
      .mode(SaveMode.Overwrite)
      .save("output/parquet_data")

    // Prints the schema
    println("****************************************************************")
    println("Parquet Schema")
    spark.read.parquet("output/parquet_data").printSchema()

    // Show the parquet data
    println("Parquet data")
    spark.read.parquet("output/parquet_data")
      .show(5)

    println("Number of Parquet file rows: " + spark.read.format("parquet").load("output/parquet_data").count()+"\n")

    //////////////////////////////
    //Write data to ORC format (out-of-the-box)
    df.write //jdbcDF.write
      .option("compression","none")
      .format("orc")
      .mode(SaveMode.Overwrite)
      .save("output/orc_data")

    // Show the ORC data
    println("****************************************************************")
    val orcDF = spark.read.orc("output/orc_data")

    // Show the ORC Schema
    println("ORC Schema")
    orcDF.printSchema()

    // Show the ORC data
    println("ORC data")
    orcDF.show(5)

    println("Number of ORC file rows: " + orcDF.count()+"\n")

    ////////////////////////////////
    // Write data to JSON format (out-of-the-box)
    df.write //jdbcDF.write
      .mode(SaveMode.Overwrite)
      .json("output/json_data")

    // Read JSON file into dataframe
    println("****************************************************************")
    println("JSON Schema")
    spark.read.json("output/json_data").printSchema()

    println("JSON data")
    spark.read.json("output/json_data").show(5)

    println("Number of JSON records: " + spark.read.json("output/json_data").count() + "\n")

    ///////////////////////////////
    // Write data to XML format
    df.write //jdbcDF.write
      // .option("compression","none") // Do not use
      .format("com.databricks.spark.xml")
      .option("rootTag","employees")
      .option("rowTag","employee")
      .mode(SaveMode.Overwrite)
      .xml("output/xml_data/")

    // Show the XML data
    println("****************************************************************")
    val xmlDF = spark.read
      .option("rowTag","employee")
      .xml("output/xml_data/")

    println("XML Schema")
    xmlDF.printSchema()

    println("XML data")
    xmlDF.show(5)
    println("Number of XML file rows: " + xmlDF.count() + "\n")

    // Close spark session
    //println("Spark Session stopped")
    //spark.close()


    ///////////////////////////////
    // Write data to Sequence format
    //val dataRDD = spark.sparkContext.sequenceFile()
    //df.write.format("sequence")

    //    val conf = new SparkConf().setAppName("SequenceFileManaging").setMaster("local[*]")
    //    val sc = new SparkContext(conf)

    val sc = spark.sparkContext
    val csvFile = sc.textFile("src/main/resources/employee.csv")
    val header = csvFile.first() // extracting the header
    csvFile.map(x => (NullWritable.get(),x))
      .filter(row => row != header)
      .saveAsSequenceFile("output/sequence_data")

    println("****************************************************************")
    println("Sequence file data")
    sc.sequenceFile("output/sequence_data",classOf[NullWritable],classOf[Text])
      .map(r => r.toString())
      //.collect() // Shows the whole data (for small datasets only)
      .take(5)
      .foreach(println)

    println("\nNumber of Sequence File Records: "+ sc.sequenceFile("output/sequence_data",classOf[NullWritable],classOf[Text]).count() + "\n")

    println("Spark Session stopped")
    sc.stop()
    //spark.close()
  }

}
