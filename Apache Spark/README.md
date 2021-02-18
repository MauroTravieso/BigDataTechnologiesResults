## Apache Spark, SparkSQL, Spark-JBoss DROOLS integration

Mauro Travieso Pena's branch

***Spark RDD***

RDD management using Spark to analyze Game Of Thrones Dataset.

- Load file into Spark
- View sample data
- Constant indices definition
- Access individual elements (Transforming raw data into fields)
- Filter records with specific names
- Count how many records with "a condition" there are in total
- How many characters fulfill a condition
- List the number of characters's names who fulfill a condition
- Tuple generation
- Sorting

***Spark SQL***

- Activities developed in the Code folder

***Code folder:***

**Spark & SparkSQL**

***Spark:***

**CSV formatter:** CSV converter from text file/MySQL source table to:

* Avro     -> Print Schema/Show 5 rows/Count number of records
* Parquet  -> Print Schema/Show 5 rows/Count number of records
* ORC      -> Print Schema/Show 5 rows/Count number of records
* JSON     -> Print Schema/Show 5 rows/Count number of records
* XML      -> Print Schema/Show 5 rows/Count number of records
* Sequence -> Print Schema/Show 5 rows/Count number of records


**Spark JBoss DROOLS rules integration**

* Input -> .csv file
* Seq   -> Data Structure fields filled with RDD
* Rules applied to CreditScore
* Filtering according to APPROVED and NOT APPROVED

***SparkSQL:***

- **SparkSQL**: Creating Schema from CSV and converting RDD to DataFrame
- **SparkSQLII**: Creating and processing DataFrame from CSV
- **SparkSQLIII**: Creating and processing DataFrame from JSON
- **SparkSQLIV**: Creating and processing DataFrame from AVRO
- **SparkSQLV**: Creating and processing Dataframe from CSV
- **SparkSQLVI**: Creating and processing Dataframe from Parquet
- **SparkSQLVII**: Dataframe Functions
- **SparkSQLVIII**: Creating Dataframe from Relational Database & Performing tables join
