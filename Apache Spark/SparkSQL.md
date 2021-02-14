# ProKarma Boot Camp – Data Bases

## Spark RDD - Instructions and Assignments

### Mauro Travieso 

---

## SparkSQL

* **Spark Dataframe**

To working on various operations applied on a Dataframe and Datasets, eventsim dataset for spark sql, file is is going to be used:

    eventsim/avro/eventsim.avro
    eventsim/csv/eventsim.csv
    eventsim/json/eventsim.json
    eventsim/parquet/eventsim.parquet

```
[mpena@ybolhdpe01 GoT]$ hdfs dfs -ls /user/mpena/Datasets/EventSim
Found 5 items
drwxr-xr-x   - mpena hdfs          0 2020-12-17 23:42 /user/mpena/Datasets/EventSim/eventism.csv
-rw-r--r--   3 mpena hdfs 1203629088 2020-12-17 23:42 /user/mpena/Datasets/EventSim/eventism.json
drwxr-xr-x   - mpena hdfs          0 2020-12-17 23:43 /user/mpena/Datasets/EventSim/eventsim-avro
drwxr-xr-x   - mpena hdfs          0 2020-12-17 23:45 /user/mpena/Datasets/EventSim/eventsim-csv
drwxr-xr-x   - mpena hdfs          0 2020-12-17 23:45 /user/mpena/Datasets/EventSim/eventsim-parquet
```

* **To**
```
[mpena@ybolhdpe01 ~]$ pyspark
Python 2.7.5 (default, Apr  2 2020, 13:16:51)
[GCC 4.8.5 20150623 (Red Hat 4.8.5-39)] on linux2
Type "help", "copyright", "credits" or "license" for more information.
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
Welcome to
      ____              __
     / __/__  ___ _____/ /__
    _\ \/ _ \/ _ `/ __/  '_/
   /__ / .__/\_,_/_/ /_/\_\   version 2.3.2.3.1.4.0-315
      /_/

Using Python version 2.7.5 (default, Apr  2 2020 13:16:51)
SparkSession available as 'spark'.
>>> quit()
```

```
[mpena@ybolhdpe01 ~]$ spark-shell
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
Spark context Web UI available at http://ybolhdpe01.yotabites.com:4040
Spark context available as 'sc' (master = yarn, app id = application_1607998763486_0104).
Spark session available as 'spark'.
Welcome to
      ____              __
     / __/__  ___ _____/ /__
    _\ \/ _ \/ _ `/ __/  '_/
   /___/ .__/\_,_/_/ /_/\_\   version 2.3.2.3.1.4.0-315
      /_/

Using Scala version 2.11.12 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_112)
Type in expressions to have them evaluated.
Type :help for more information.

scala>
```
* **To create the Dataframe by reading the *.json* file**
```
scala> eventDS=spark.read.json("s3a://yb-spark-training/data/eventsim/json/eventsim.json")
```
```
scala> val df1=sqlContext.read.format("json").load("/opt/data/music_events.json")
```