# Hive Master Scripts Hands-on 1

#### Mauro Travieso 

---

### Tasks:

* **Create the corresponding folders in the remote Linux terminal**

- Open a cmd terminal

```
> ssh mpena@10.1.1.27
Password:
```
```
[mpena@yboledge02 ~]$ pwd
```
```
$ mkdir hive
$ cd hive
$ mkdir internal 
```

* **On a different cmd terminal**

- Go where the pscp.exe file is
```
> cd C:\ProKarma\Programs 
```
- To copy a file from Windows(local) to Linux(remote)
```
> pscp -P <port> <origin_file> <user>@<remote_IP_add>:</destiny_directory>
```
```
> pscp -P 22 C:\ProKarma\Assignments\MasterHiveScripts\MasterHiveScripts-1\course_data_internal.txt mpena@10.1.1.27:/home/mpena/hive/internal
```
* **Create the corresponding folders in the remote Linux terminal**
```
[mpena@yboledge02 ~]$ pwd
```
```
$ cd hive
$ mkdir external
$ cd external
$ mkdir csv
$ mkdir txt
```
* **On the local terminal - To copy a file from Windows(local) to Linux(remote)**
```
> pscp -P <port> <origin_file> <user>@<remote_IP_add>:</destiny_directory>
```
```
> pscp -P 22 C:\ProKarma\Assignments\MasterHiveScripts\MasterHiveScripts-1\course_data_external.csv mpena@10.1.1.27:/home/mpena/hive/external/csv
```
```
> pscp -P 22 C:\ProKarma\Assignments\MasterHiveScripts\MasterHiveScripts-1\course_data_external.txt mpena@10.1.1.27:/home/mpena/hive/external/txt
```
* **On the remote terminal**

```
mpena@yboledge02 ~]$ hadoop fs -put /home/mpena/hive/external/txt/course_data_external.txt /user/mpena/hive/external/txt
```
```
mpena@yboledge02 ~]$ hadoop fs -put /home/mpena/hive/external/csv/course_data_external.csv /user/mpena/hive/external/csv
```
```
mpena@yboledge02 ~]$ hadoop fs -put /home/mpena/hive/internal/course_data_internal.txt /user/mpena/hive/internal
```

* **On a cmd terminal**
```
$ beeline
beeline> !connect jdbc:hive2://ybolcldrmstr.yotabites.com:10000/default;principal=hive/_HOST@YOTABITES.COM;ssl=true
```
```
> SHOW DATABADES;
> USE ybtrainee
> SHOW TABLES;
```

* **Create external tables:**
```
CREATE EXTERNAL TABLE IF NOT EXISTS course_txt_ext_mpena (
Institution STRING,
Course_Number STRING,
Launch_Date STRING,
Course_Title STRING,
Instructors STRING,
Year INT,
Participants INT,
Certified INT,
Total_Course_Hours DECIMAL(3,2),
Median_Hours_Cert DECIMAL(3,2),
Median_Age INT,
Percent_Male DECIMAL(3,2),
Percent_Female DECIMAL(3,2))
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
LOCATION "/user/mpena/hive/external/txt"
TBLPROPERTIES("skip.header.line.count"="1");
```

-> It is still valid if the permissions to mpena user are granted -> LOCATION "/home/mpena/hive/external/txt"

```
CREATE EXTERNAL TABLE IF NOT EXISTS course_csv_ext_mpena (
Institution STRING,
Course_Number STRING,
Launch_Date STRING,
Course_Title STRING,
Instructors STRING,
Year INT,
Participants INT,
Certified INT,
Total_Course_Hours DECIMAL(3,2),
Median_Hours_Cert DECIMAL(3,2),
Median_Age INT,
Percent_Male DECIMAL(3,2),
Percent_Female DECIMAL(3,2))
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
WITH SERDEPROPERTIES (
 "separatorChar" = ",",
 "quoteChar"     = "\""
)
LOCATION "/user/mpena/hive/external/csv"
TBLPROPERTIES("skip.header.line.count"="1");
```

* **CHECK EXTERNAL TABLES DETAILS**
```
> DESCRIBE course_txt_ext_mpena;
```
```
0: jdbc:hive2://ybolcldrmstr.yotabites.com:10> DESCRIBE course_txt_ext_mpena;
INFO  : Compiling command(queryId=hive_20201129111818_43fb561e-8799-4fe7-baa2-d223a081ac63): DESCRIBE course_txt_ext_mpena
INFO  : Semantic Analysis Completed
INFO  : Returning Hive schema: Schema(fieldSchemas:[FieldSchema(name:col_name, type:string, comment:from deserializer), FieldSchema(name:data_type, type:string, comment:from deserializer), FieldSchema(name:comment, type:string, comment:from deserializer)], properties:null)
INFO  : Completed compiling command(queryId=hive_20201129111818_43fb561e-8799-4fe7-baa2-d223a081ac63); Time taken: 0.26 seconds
INFO  : Executing command(queryId=hive_20201129111818_43fb561e-8799-4fe7-baa2-d223a081ac63): DESCRIBE course_txt_ext_mpena
INFO  : Starting task [Stage-0:DDL] in serial mode
INFO  : Completed executing command(queryId=hive_20201129111818_43fb561e-8799-4fe7-baa2-d223a081ac63); Time taken: 0.028 seconds
INFO  : OK
+---------------------+---------------+----------+--+
|      col_name       |   data_type   | comment  |
+---------------------+---------------+----------+--+
| institution         | string        |          |
| course_number       | string        |          |
| launch_date         | string        |          |
| course_title        | string        |          |
| instructors         | string        |          |
| year                | int           |          |
| participants        | int           |          |
| certified           | int           |          |
| total_course_hours  | decimal(3,2)  |          |
| median_hours_cert   | decimal(3,2)  |          |
| median_age          | int           |          |
| percent_male        | decimal(3,2)  |          |
| percent_female      | decimal(3,2)  |          |
+---------------------+---------------+----------+--+
13 rows selected (0.337 seconds)
```
```
> DESCRIBE EXTENDED course_txt_ext_mpena;
```
```
0: jdbc:hive2://ybolcldrmstr.yotabites.com:10> DESCRIBE EXTENDED course_txt_ext_mpena;
INFO  : Compiling command(queryId=hive_20201129111919_6717af3b-d1dd-487c-b675-f3be8f063c56): DESCRIBE EXTENDED course_txt_ext_mpena
INFO  : Semantic Analysis Completed
INFO  : Returning Hive schema: Schema(fieldSchemas:[FieldSchema(name:col_name, type:string, comment:from deserializer), FieldSchema(name:data_type, type:string, comment:from deserializer), FieldSchema(name:comment, type:string, comment:from deserializer)], properties:null)
INFO  : Completed compiling command(queryId=hive_20201129111919_6717af3b-d1dd-487c-b675-f3be8f063c56); Time taken: 0.179 seconds
INFO  : Executing command(queryId=hive_20201129111919_6717af3b-d1dd-487c-b675-f3be8f063c56): DESCRIBE EXTENDED course_txt_ext_mpena
INFO  : Starting task [Stage-0:DDL] in serial mode
INFO  : Completed executing command(queryId=hive_20201129111919_6717af3b-d1dd-487c-b675-f3be8f063c56); Time taken: 0.019 seconds
INFO  : OK
+-----------------------------+----------------------------------------------------+----------+--+
|          col_name           |                     data_type                      | comment  |
+-----------------------------+----------------------------------------------------+----------+--+
| institution                 | string                                             |          |
| course_number               | string                                             |          |
| launch_date                 | string                                             |          |
| course_title                | string                                             |          |
| instructors                 | string                                             |          |
| year                        | int                                                |          |
| participants                | int                                                |          |
| certified                   | int                                                |          |
| total_course_hours          | decimal(3,2)                                       |          |
| median_hours_cert           | decimal(3,2)                                       |          |
| median_age                  | int                                                |          |
| percent_male                | decimal(3,2)                                       |          |
| percent_female              | decimal(3,2)                                       |          |
|                             | NULL                                               | NULL     |
| Detailed Table Information  | Table(tableName:course_txt_ext_mpena, dbName:ybtrainee, owner:hive, createTime:1606669085, lastAccessTime:0, retention:0, sd:StorageDescriptor(cols:[FieldSchema(name:institution, type:string, comment:null), FieldSchema(name:course_number, type:string, comment:null), FieldSchema(name:launch_date, type:string, comment:null), FieldSchema(name:course_title, type:string, comment:null), FieldSchema(name:instructors, type:string, comment:null), FieldSchema(name:year, type:int, comment:null), FieldSchema(name:participants, type:int, comment:null), FieldSchema(name:certified, type:int, comment:null), FieldSchema(name:total_course_hours, type:decimal(3,2), comment:null), FieldSchema(name:median_hours_cert, type:decimal(3,2), comment:null), FieldSchema(name:median_age, type:int, comment:null), FieldSchema(name:percent_male, type:decimal(3,2), comment:null), FieldSchema(name:percent_female, type:decimal(3,2), comment:null)], location:hdfs://ybolcldrmstr.yotabites.com:8020/user/mpena/hive/external/txt, inputFormat:org.apache.hadoop.mapred.TextInputFormat, outputFormat:org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat, compressed:false, numBuckets:-1, serdeInfo:SerDeInfo(name:null, serializationLib:org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe, parameters:{field.delim=,, serialization.format=,}), bucketCols:[], sortCols:[], parameters:{}, skewedInfo:SkewedInfo(skewedColNames:[], skewedColValues:[], skewedColValueLocationMaps:{}), storedAsSubDirectories:false), partitionKeys:[], parameters:{skip.header.line.count=1, totalSize=38156, EXTERNAL=TRUE, numRows=-1, rawDataSize=-1, COLUMN_STATS_ACCURATE=false, numFiles=1, transient_lastDdlTime=1606669085}, viewOriginalText:null, viewExpandedText:null, tableType:EXTERNAL_TABLE) |          |
+-----------------------------+----------------------------------------------------+----------+--+
15 rows selected (0.236 seconds)
```
```
> DESCRIBE FORMATTED course_txt_ext_mpena;
```
```
0: jdbc:hive2://ybolcldrmstr.yotabites.com:10> DESCRIBE FORMATTED course_txt_ext_mpena;
INFO  : Compiling command(queryId=hive_20201129112323_21f15292-e013-448a-b822-3de0ef3a9300): DESCRIBE FORMATTED course_txt_ext_mpena
INFO  : Semantic Analysis Completed
INFO  : Returning Hive schema: Schema(fieldSchemas:[FieldSchema(name:col_name, type:string, comment:from deserializer), FieldSchema(name:data_type, type:string, comment:from deserializer), FieldSchema(name:comment, type:string, comment:from deserializer)], properties:null)
INFO  : Completed compiling command(queryId=hive_20201129112323_21f15292-e013-448a-b822-3de0ef3a9300); Time taken: 0.22 seconds
INFO  : Executing command(queryId=hive_20201129112323_21f15292-e013-448a-b822-3de0ef3a9300): DESCRIBE FORMATTED course_txt_ext_mpena
INFO  : Starting task [Stage-0:DDL] in serial mode
INFO  : Completed executing command(queryId=hive_20201129112323_21f15292-e013-448a-b822-3de0ef3a9300); Time taken: 0.032 seconds
INFO  : OK
+-------------------------------+----------------------------------------------------+-----------------------+--+
|           col_name            |                     data_type                      |        comment        |
+-------------------------------+----------------------------------------------------+-----------------------+--+
| # col_name                    | data_type                                          | comment               |
|                               | NULL                                               | NULL                  |
| institution                   | string                                             |                       |
| course_number                 | string                                             |                       |
| launch_date                   | string                                             |                       |
| course_title                  | string                                             |                       |
| instructors                   | string                                             |                       |
| year                          | int                                                |                       |
| participants                  | int                                                |                       |
| certified                     | int                                                |                       |
| total_course_hours            | decimal(3,2)                                       |                       |
| median_hours_cert             | decimal(3,2)                                       |                       |
| median_age                    | int                                                |                       |
| percent_male                  | decimal(3,2)                                       |                       |
| percent_female                | decimal(3,2)                                       |                       |
|                               | NULL                                               | NULL                  |
| # Detailed Table Information  | NULL                                               | NULL                  |
| Database:                     | ybtrainee                                          | NULL                  |
| Owner:                        | hive                                               | NULL                  |
| CreateTime:                   | Sun Nov 29 10:58:05 CST 2020                       | NULL                  |
| LastAccessTime:               | UNKNOWN                                            | NULL                  |
| Protect Mode:                 | None                                               | NULL                  |
| Retention:                    | 0                                                  | NULL                  |
| Location:                     | hdfs://ybolcldrmstr.yotabites.com:8020/user/mpena/hive/external/txt | NULL                  |
| Table Type:                   | EXTERNAL_TABLE                                     | NULL                  |
| Table Parameters:             | NULL                                               | NULL                  |
|                               | COLUMN_STATS_ACCURATE                              | false                 |
|                               | EXTERNAL                                           | TRUE                  |
|                               | numFiles                                           | 1                     |
|                               | numRows                                            | -1                    |
|                               | rawDataSize                                        | -1                    |
|                               | skip.header.line.count                             | 1                     |
|                               | totalSize                                          | 38156                 |
|                               | transient_lastDdlTime                              | 1606669085            |
|                               | NULL                                               | NULL                  |
| # Storage Information         | NULL                                               | NULL                  |
| SerDe Library:                | org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe | NULL                  |
| InputFormat:                  | org.apache.hadoop.mapred.TextInputFormat           | NULL                  |
| OutputFormat:                 | org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat | NULL                  |
| Compressed:                   | No                                                 | NULL                  |
| Num Buckets:                  | -1                                                 | NULL                  |
| Bucket Columns:               | []                                                 | NULL                  |
| Sort Columns:                 | []                                                 | NULL                  |
| Storage Desc Params:          | NULL                                               | NULL                  |
|                               | field.delim                                        | ,                     |
|                               | serialization.format                               | ,                     |
+-------------------------------+----------------------------------------------------+-----------------------+--+
46 rows selected (0.302 seconds)
```

* **CHECK EXTERNAL TABLE DATA**

- Hive Settings to display Field Names in Report HEADER
```
> SET hive.cli.print.header=true;
```
```
> SELECT * FROM course_txt_ext_mpena;
```
```
> SELECT * FROM course_csv_ext_mpena;
```

* **CREATE INTERNAL TABLES** 

- CREATE INTERNAL TABLE FOR TEXT
```
CREATE TABLE IF NOT EXISTS course_txt_int_mpena (
Institution STRING,
Course_Number STRING,
Launch_Date STRING,
Course_Title STRING,
Instructors STRING,
Year INT,
Participants INT,
Certified INT,
Total_Course_Hours DECIMAL(3,2),
Median_Hours_Cert DECIMAL(3,2),
Median_Age INT,
Percent_Male DECIMAL(3,2),
Percent_Female DECIMAL(3,2))
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
TBLPROPERTIES("skip.header.line.count"="1");	
```

* **CHECK INTERNAL TABLES DETAILS**
```
> DESCRIBE course_txt_int_mpena;
```
```
> DESCRIBE EXTENDED course_txt_int_mpena;
```
```
> DESCRIBE FORMATTED course_txt_int_mpena;
```

* **LOAD DATA INTO INTERNAL TABLES** 

- LOAD DATASET STORED IN HDFS
```
> LOAD DATA INPATH '/user/mpena/hive/internal/course_data_internal.txt' INTO TABLE course_txt_int_mpena;
```
----> Check if data file still exists in HDFS

[!]-> Because of the access denied!!! in the remote linux node: 

- CREATE INTERNAL TABLE FOR TEXT
```
CREATE TABLE IF NOT EXISTS course_txt_int_mpena (
Institution STRING,
Course_Number STRING,
Launch_Date STRING,
Course_Title STRING,
Instructors STRING,
Year INT,
Participants INT,
Certified INT,
Total_Course_Hours DECIMAL(3,2),
Median_Hours_Cert DECIMAL(3,2),
Median_Age INT,
Percent_Male DECIMAL(3,2),
Percent_Female DECIMAL(3,2))
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
LOCATION "/user/mpena/hive/internal"
TBLPROPERTIES("skip.header.line.count"="1");	
``` 

* **CHECK LOCATION OF TABLES**

Directly from Hive console:
```
> !hdfs dfs -ls /user/hive/warehouse/yotabites.db/course_txt_int_mpena;
```
 - OR - 

From terminal:
```
$ hadoop fs -ls /user/hive/warehouse/yotabites.db/course_txt_int_mpena
```
[the command is okay, however, due to permission denied when loading the .txt file data into the table, the data is not loadeds into the hive/warehouse]

* **CHECK TABLE DATA** 
```
> SELECT * FROM course_txt_int_mpena LIMIT 2;
```

* **ALTER TABLES** (The command works okay, however, the table cannot be altered due to permission denied in the remote linux node)

- ALTER TABLE name RENAME to newname;
```
> ALTER TABLE course_txt_int_mpena RENAME TO course_txt_internal_mpena; 
```

- ALTER TABLE name ADD COLUMNS () ;
```
> ALTER TABLE course_txt_internal_mpena ADD COLUMNS (course_category STRING); 
```

- ALTER TABLE name CHANGE col_name new_name new_type
``` 
> ALTER TABLE course_txt_internal_mpena CHANGE course_category course_cat STRING; 
```

- ALTER TABLE name REPLACE COLUMNS (old_column, new_column) 
```
> ALTER TABLE course_txt_internal_mpena REPLACE COLUMNS (participants INT, student_count INT); 
```

* **DROP INTERNAL & EXTERNAL TABLES** 
```
> DROP TABLE course_txt_internal_mpena;
```
```
> DROP TABLE course_txt_ext_mpena;
```
```
> DROP TABLE course_csv_ext_mpena;
```

* **DROP DATABASE**
```
> DROP DATABASE IF EXISTS course_db;
```
```
> DROP DATABASE IF EXISTS course_db CASCADE;
```
