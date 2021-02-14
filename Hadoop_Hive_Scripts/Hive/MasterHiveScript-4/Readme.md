# Hive

## Hive Master Scripts Hands-on 4

#### Mauro Travieso 

### Tasks:

---

* **Connect and create the corresponding folders in the remote Linux node terminal**

- Open a cmd terminal
```
> ssh mpena@10.1.1.27
Password:
```
```
[mpena@yboledge02 ~]$ pwd
```

---
* **Create the corresponding folders in the remote Linux terminal**
```
$ cd hive
$ cd data
$ mkdir stocks
```

---
* **On a different terminal** - To copy a file from Windows(local) to Linux(remote)

- Go where the pscp.exe file is
```
> cd C:\ProKarma\Programs 
```
- To copy a file from Windows(local) to Linux(remote)
```
> pscp -P <port> <origin_file> <user>@<remote_IP_add>:</destiny_directory>
```
```
> pscp -P 22 C:\ProKarma\Assignments\MasterHiveScripts\MasterHiveScripts-4\stocks_data.csv mpena@10.1.1.27:/home/mpena/hive/data/stocks
```

---
* **On the remote terminal**
```
[mpena@yboledge02 ~]$ hadoop fs -mkdir /user/mpena/hive/data/stocks
```
```
[mpena@yboledge02 ~]$ hadoop fs -put /home/mpena/hive/data/stocks/stocks_data.csv /user/mpena/hive/data/stocks
```
```
[mpena@yboledge02 data]$ hadoop fs -ls /user/mpena/hive/data/stocks
```

---
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

---
* **CREATE STOCKS TABLE**
```
CREATE TABLE IF NOT EXISTS stocks_tbl_mpena (
symbol STRING,
trans_date STRING,
price_open FLOAT,
price_high FLOAT,
price_low FLOAT,
price_close FLOAT)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
TBLPROPERTIES ('creator'='mpena', 'created_on' = '2020-11-29', 'description'='Stock Data');
```

---
* **GET DETAILS ABOUT TABLE**
```
> DESCRIBE FORMATTED stocks_tbl_mpena;
```

---
* **[!] LOAD DATASAET USING LOAD COMMAND**
```
> LOAD DATA INPATH '/user/mpena/data/stocks/stocks_data.csv' INTO TABLE stocks_tbl_mpena;
```

---
* **[!] Due to permission denied in the remote linux cluster:**
```
CREATE TABLE IF NOT EXISTS stocks_tbl_mpena (
symbol STRING,
trans_date STRING,
price_open FLOAT,
price_high FLOAT,
price_low FLOAT,
price_close FLOAT)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
LOCATION "/user/mpena/hive/data/stocks"
TBLPROPERTIES ('creator'='mpena', 'created_on' = '2020-11-29', 'description'='Stock Data');
```

---
* **[!] CHECK DATA LOADED IN HIVE TABLE**
```
> !hdfs dfs -ls /user/hive/warehouse/db_stocks.db;
```

---
* **[!] VIEW RECURSIVE DISPLAY OF TABLE AND DATA IN HIVE**
```
> !hdfs dfs -ls -R /user/hive/warehouse/db_stocks.db;
```

---
* **ORDER BY **

- Global Order By 
- Only One Reducer Used

- CHECK # OF REDUCERS FOR MAPREDUCE JOB WHEN YOU RUN BELOW SQL
```
> SELECT * FROM stocks_tbl_mpena ORDER BY price_close DESC;
```

INFO  : Hadoop job information for Stage-1: number of mappers: 1; number of reducers: 1

---
* **Hive Settings to display Field Names in Report HEADER**
```
> SET hive.cli.print.header=true;
```

---
* **SETTING # OF REDUCERS FOR MAPREDUCE JOB**
```
> SET mapreduce.job.reduces=1;
```
```
> SELECT * FROM stocks_tbl_mpena
ORDER BY price_close DESC;
```

---
* **SETTING # OF REDUCERS FOR MAPREDUCE JOB**
```
> SET mapreduce.job.reduces=3;
```

- RUNNING SQL AFTER CHANGING # OF REDUCERS
```
> SELECT * FROM stocks_tbl_mpena
ORDER BY price_close DESC;
```

INFO  : Hadoop job information for Stage-1: number of mappers: 1; number of reducers: 3

---
* **SORT BY**

- ORDER BY done separately at each Reducer may show incorrect results if more than one Reducer is used
```
> SELECT trans_date, symbol, price_close
FROM stocks_tbl_mpena WHERE year(trans_date) = '2010'
SORT BY symbol ASC, price_close DESC;
```

INFO  : Hadoop job information for Stage-1: number of mappers: 1; number of reducers: 3

---
* **[!] WRITING OUTPUT OF SQL TO FILE**
```
$ cd /home/mpena/hive
$ mkdir output
$ cd output
$ mkdir stocks_output
```
```
> SET mapreduce.job.reduces=1;
```
```
> INSERT OVERWRITE LOCAL DIRECTORY '/home/mpena/hive/output/stocks_output'
ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' 
SELECT trans_date, symbol, price_close
FROM stocks_tbl_mpena 
WHERE year(trans_date) = '2010'
SORT BY symbol ASC, price_close DESC;
```
```
# hadoop fs -mkdir /user/mpena/hive/output
# hadoop fs -mkdir /user/mpena/hive/output/stocks_output
```
```
> INSERT OVERWRITE DIRECTORY '/user/mpena/hive/output/stocks_output'
ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' 
SELECT trans_date, symbol, price_close
FROM stocks_tbl_mpena 
WHERE year(trans_date) = '2010'
SORT BY symbol ASC, price_close DESC;
```

---
* **[!] CHECK THE FILE(S) CREATED - ONE FOR EACH REDUCER!**
```
> ! ls -l /home/mpena/hive/output/stocks_output;
```

---
* **[!] DISTRIBUTE BY**

- Distribute By: Helps Assign All Key Value Pairs For a Key To One Reducer. 
- This Can Be Followed With Sort By At Each Reducer.
- Will Show Correct Results If One Or More Reducers Used.

```
> INSERT OVERWRITE LOCAL DIRECTORY '/home/mpena/hive/output/stocks_output'
ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' 
SELECT symbol, trans_date, price_close
FROM stocks_tbl_mpena WHERE year(trans_date) = '2010'
DISTRIBUTE BY symbol
SORT BY symbol ASC, price_close DESC;
```
```
> SELECT trans_date, symbol, price_close
FROM stocks_tbl_mpena
DISTRIBUTE BY symbol
SORT BY symbol ASC;
```

---
* **CLUSTER BY**

- Cluster By Is Replacement For Using Distribute By and Sort By, If Both Use Same Field.
- Using Cluster By Will Perform DISTRIBUTE BY First and Then SORT BY In That Order.

```
> INSERT OVERWRITE LOCAL DIRECTORY '/home/mpena/hive/output/stocks_output'
ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' 
SELECT trans_date, symbol, price_close
FROM stocks_tbl_mpena
CLUSTER BY symbol;
```

---
* **To select only the required tables**

- In the Hive shell:
```
> SHOW TABLES LIKE '*mpena';
```

- In HDFS:
```
$ hadoop fs -find /user/mpena/hive/warehouse/ -name *mpena
```

---
* You can also use hdfs to find a table in all databases: the path of hive databases is: /apps/hive/warehouse/ so, by using hdfs :
```
$ hadoop fs -find /apps/hive/warehouse/ -name *mpena
```

