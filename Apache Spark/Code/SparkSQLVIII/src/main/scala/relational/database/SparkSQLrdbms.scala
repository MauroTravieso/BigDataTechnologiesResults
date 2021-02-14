package relational.database

import org.apache.spark.sql.SparkSession

/**
 * Spark Application: Creating Dataframe from Relational Database
 *                    Performing SQL operations
 *                    Performing DataFrame/tables join
 *
 * @author    Mauro Travieso
 * @version   1.0
 *
 * Bugs: none known
 */

object SparkSQLrdbms {

  def main(args: Array[String]): Unit = {

    // Spark Session
    val spark = SparkSession
      .builder()
      .appName("Creating Dataframe from Relational Database")
      .master("local[*]")
      .enableHiveSupport() //For ORC files
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    // Jdbc Connector (Connecting Spark with MySQL)
    println("*** Table: employee ***")
    val employee_jdbcDF = spark.read
      .format("jdbc")
      .option("driver","com.mysql.cj.jdbc.Driver")
      .option("url", "jdbc:mysql://localhost:3306")  //.option("url", "jdbc:mysql:dbserver")
      .option("dbtable", "employees.employee")       //.option("dbtable", "schema.tablename")
      .option("user", "user")
      .option("password", "password")
      .load()

    // Prints the schema
    println("Schema:")
    employee_jdbcDF.printSchema()

    // For testing purposes
    println("Data:")
    employee_jdbcDF.show(5)

    // Number of rows in the file
    println("Number of file rows: " + employee_jdbcDF.count() + "\n")

    // Jdbc Connector (Connecting Spark with MySQL)
    println("*** Table: department ***")
    val department_jdbcDF = spark.read
      .format("jdbc")
      .option("driver","com.mysql.cj.jdbc.Driver")
      .option("url", "jdbc:mysql://localhost:3306")
      .option("dbtable", "employees.department")
      .option("user", "user")
      .option("password", "password")
      .load()

    // Prints the schema
    println("Schema:")
    department_jdbcDF.printSchema()

    // For testing purposes
    println("Data:")
    department_jdbcDF.show(5)

    // Number of rows in the file
    println("Number of TextFile(CSV) file rows from MySQL: " + department_jdbcDF.count() + "\n")

    // Jdbc Connector (Connecting Spark with MySQL)
    println("*** Table: salary ***")
    val salary_jdbcDF = spark.read
      .format("jdbc")
      .option("driver","com.mysql.cj.jdbc.Driver")
      .option("url", "jdbc:mysql://localhost:3306")
      .option("dbtable", "employees.salary")
      .option("user", "user")
      .option("password", "password")
      .load()

    // Prints the schema
    println("Schema:")
    salary_jdbcDF.printSchema()

    // For testing purposes
    println("Data:")
    salary_jdbcDF.show(5)

    // Number of rows in the file
    println("Number of rows: " + salary_jdbcDF.count() + "\n")

    // Joining tables
    employee_jdbcDF.createOrReplaceTempView("emp")
    department_jdbcDF.createOrReplaceTempView("dept")
    salary_jdbcDF.createOrReplaceTempView("sal")

    // SQL queries on DataFrames
    val employee_count = spark.sql("SELECT COUNT(emp.empid) AS employee_count FROM emp WHERE empid > 105")
    employee_count.show()

    val emp_dept_sal = spark.sql("SELECT dept.department, emp.name, sal.salary FROM emp INNER JOIN dept ON emp.empid = dept.id INNER JOIN sal ON dept.id = sal.empid ORDER BY dept.department, sal.salary DESC")
    emp_dept_sal.show()

    // To save as Hive tables
    spark.sql("CREATE TABLE employees.emp AS SELECT * FROM emp")
    spark.sql("CREATE TABLE employees.dept AS SELECT * FROM dept")
    spark.sql("CREATE TABLE employees.sal AS SELECT * FROM sal")

    emp_dept_sal.createOrReplaceTempView("emp_dept_sal")
    spark.sql("CREATE TABLE employees.emp_dept_sal AS SELECT * FROM emp_dept_sal")

    // To save as HBase

    // Define schema for the dataframe
    // that should be loaded into HBase
//    def catalog = s"""{
//                     |"table":{"namespace":"default", "name":"emp_dept_sal"},
//                     |"rowkey":"key",
//                     |"columns":{
//                     |"timestamp":{"cf":"rowkey", "col":"key", "type":"long"},
//                     |"name":{"cf":"data", "col":"employee", "type":"string"},
//                     |"department":{"cf":"data", "col":"department", "type":"string"},
//                     |"salary":{"cf":"data", "col":"salary", "type":"integer"}
//                     |}
//                     |}""".stripMargin
//
//    // Write dataframe into HBase
//    emp_dept_sal.write.options(
//      Map(HBaseTableCatalog.tableCatalog -> catalog, HBaseTableCatalog.newTable -> "5")) // create 5 regions
//      .format("org.apache.spark.sql.execution.datasources.hbase")
//      .save()

  }

}

