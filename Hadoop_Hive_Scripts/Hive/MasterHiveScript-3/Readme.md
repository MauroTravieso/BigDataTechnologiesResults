# Hive

## Hive Master Scripts Hands-on 3

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
$ mkdir data
$ cd data
$ mkdir employee
$ mkdir salary
```

---
* **On a different terminal - To copy a file from Windows(local) to Linux(remote)**

- Go where the pscp.exe file is
```
> cd C:\ProKarma\Programs 
```

- To copy a file from Windows(local) to Linux(remote)
```
> pscp -P <port> <origin_file> <user>@<remote_IP_add>:</destiny_directory>
```
```
> pscp -P 22 C:\ProKarma\Assignments\MasterHiveScripts\MasterHiveScripts-2\emp_salary.csv mpena@10.1.1.27:/home/mpena/hive/data/salary
```
```
> pscp -P 22 C:\ProKarma\Assignments\MasterHiveScripts\MasterHiveScripts-2\employee.csv mpena@10.1.1.27:/home/mpena/hive/data/employee
```

---
* **On the remote terminal**
```
mpena@yboledge02 ~]$ hadoop fs -put /home/mpena/hive/data/salary/emp_salary.csv /user/mpena/hive/data/salary
```
```
mpena@yboledge02 ~]$ hadoop fs -put /home/mpena/hive/data/employee/employee.csv /user/mpena/hive/data/employee
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
* **CREATE INTERNAL TABLES**

- CREATE EMPLOYEE TABLE 
```
CREATE TABLE IF NOT EXISTS employee_tbl_mpena (
empid INT,
name STRING,
state STRING,
birthyear STRING)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
TBLPROPERTIES("skip.header.line.count"="1");	
```

- CREATE EMPLOYEE SALARY TABLE 
```
CREATE TABLE IF NOT EXISTS emp_salary_mpena (
empid INT,
year STRING,
salary FLOAT)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
TBLPROPERTIES("skip.header.line.count"="1");	
```

---
* **LOAD DATA INTO INTERNAL TABLES**

- LOAD EMPLOYEE DATASET USING LOCAL FILE 
```
> LOAD DATA INPATH '/user/mpena/hive/data/employee/employee.csv' INTO TABLE employee_tbl_mpena;
```

* **LOAD SALARY DATASET USING HDFS FILE**
```
> LOAD DATA INPATH '/user/mpena/hive/data/salary/emp_salary.csv' INTO TABLE emp_salary_mpena;
```

---
[!] Due to permission denied in the remote linux cluster:

- CREATE EMPLOYEE TABLE 

```
CREATE TABLE IF NOT EXISTS employee_tbl_mpena (
empid INT,
name STRING,
state STRING,
birthyear STRING)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
LOCATION "/user/mpena/hive/data/employee"
TBLPROPERTIES("skip.header.line.count"="1");	
```

- CREATE EMPLOYEE SALARY TABLE 

```
CREATE TABLE IF NOT EXISTS emp_salary_mpena (
empid INT,
year STRING,
salary FLOAT)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
LOCATION "/user/mpena/hive/data/salary"
TBLPROPERTIES("skip.header.line.count"="1");	
```

---
* **CHECK LOCATION OF EMPLOYEE AND SALARY TABLES**
```
> !hdfs dfs -ls /user/hive/warehouse/yotabites.db/employee_tbl_mpena;
```
```
> !hdfs dfs -ls /user/hive/warehouse/yotabites.db/emp_salary_mpena;
```

---
* **CHECK EMPLOYEE & SALARY DATA LOADED**

- Hive Settings to display Field Names in Report HEADER
```
> SET hive.cli.print.header=true;
```
```
> SELECT * FROM employee_tbl_mpena
WHERE state = 'KS' and birthyear = '1975';
```
```
> SELECT * FROM emp_salary_mpena
WHERE year = '2017';
```

---
* **TABLE JOINS - EMPLOYEE & SALARY TABLES**

* ***INNER JOIN***
```
SELECT 
e.empid,
e.name,
e.state,
s.salary,
s.year
FROM employee_tbl_mpena e INNER JOIN emp_salary_mpena s
ON (e.empid = s.empid ) 
CLUSTER BY e.empid;
```

* ***LEFT OUTER JOIN***
```
SELECT
e.empid,
e.name,
e.state,
s.year,
s.salary
FROM employee_tbl_mpena e LEFT OUTER JOIN emp_salary_mpena s
ON (e.empid = s.empid )
CLUSTER BY e.empid;
```

* ***RIGHT OUTER JOIN***
```
SELECT
s.empid,
e.name,
e.state,
s.year,
s.salary
FROM employee_tbl_mpena e RIGHT OUTER JOIN emp_salary_mpena s
ON (e.empid = s.empid ) 
CLUSTER BY s.empid;
```


* ***FULL OUTER JOIN***
```
SELECT
e.empid,
e.name,
e.state,
s.year,
s.salary
FROM employee_tbl_mpena e FULL OUTER JOIN emp_salary_mpena s
ON (e.empid = s.empid )
CLUSTER BY e.empid;
```

---
* **CREATE PARTITION TABLE FOR EMPLOYEE**
```
CREATE TABLE IF NOT EXISTS emp_partition_mpena (
empid INT,
name STRING,
state STRING,
birthyear STRING)
PARTITIONED BY (emp_state STRING)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
TBLPROPERTIES("skip.header.line.count"="1");	
```

---
* **CREATE PARTITION TABLE FOR SALARY**
```
CREATE TABLE IF NOT EXISTS sal_partition_mpena (
empid INT,
year STRING,
salary FLOAT)
PARTITIONED BY (sal_year STRING)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
TBLPROPERTIES("skip.header.line.count"="1");	
```

---
* **CHECK PARTITION TABLES CREATED**
```
> DESCRIBE FORMATTED emp_partition_mpena;
```
```
> DESCRIBE FORMATTED sal_partition_mpena;
```

---
* **CHECK PARTITION DETAILS**
```
> SHOW PARTITIONS emp_partition_mpena;
```
```
> SHOW PARTITIONS sal_partition_mpena;
```

---
* **[!] LOAD DATA INTO PARTITION TABLES** (when not denied permission)
```
> LOAD DATA INPATH '/user/cloudera/data/employee/employee_ks.csv' INTO TABLE emp_partition PARTITION (emp_state='KS');
```
```
> LOAD DATA INPATH '/user/cloudera/data/employee/employee_ca.csv' INTO TABLE emp_partition PARTITION (emp_state='CA');
```

---
* **! CHECK PARTITION LOCATION** 
```
> !hdfs dfs -ls /user/hive/warehouse/employee_db.db/emp_partition;
```
```
> !hdfs dfs -ls /user/hive/warehouse/employee_db.db/emp_partition/emp_state=KS;
```
```
> !hdfs dfs -ls /user/hive/warehouse/employee_db.db/emp_partition/emp_state=CA;
```

---
* **LOADING PARTITIONS USING INSERT...SELECT**
```
INSERT OVERWRITE TABLE emp_partition_mpena
PARTITION (emp_state= 'KS')
SELECT * FROM employee_tbl_mpena e
WHERE e.state = 'KS';
```
```
INSERT OVERWRITE TABLE sal_partition_mpena
PARTITION (sal_year= '2017')
SELECT * FROM emp_salary_mpena s
WHERE s.year = '2017';
```

* **[!] CHECK PARTITION DETAILS**
```
> !hdfs dfs -ls /user/hive/warehouse/employee_db.db/emp_partition;
```
```
> !hdfs dfs -ls /user/hive/warehouse/employee_db.db/sal_partition;
```
```
- SELECT with partition column in the where clause
```
```
SELECT * FROM emp_partition_mpena
WHERE state = 'KS';
```
```
SELECT * FROM sal_partition_mpena
WHERE year = '2017';
```

---
* **CREATE MULTIPLE PARTITIONS USING SINGLE INSERT**
```
FROM employee_tbl_mpena e
INSERT OVERWRITE TABLE emp_partition_mpena
PARTITION (emp_state= 'KS')
SELECT * WHERE state = 'KS'
INSERT OVERWRITE TABLE emp_partition_mpena
PARTITION (emp_state= 'CA')
SELECT * WHERE state = 'CA';
```
```
FROM emp_salary_mpena s
INSERT OVERWRITE TABLE sal_partition_mpena
PARTITION (sal_year = '2017')
SELECT * WHERE year = '2017'
INSERT OVERWRITE TABLE sal_partition_mpena
PARTITION (sal_year = '2018')
SELECT * WHERE year = '2018';
```

---
* **DROPPING A PARTITION**
```
> ALTER TABLE emp_partition_mpena DROP IF EXISTS PARTITION (emp_state = 'KS');
```
```
> ALTER TABLE sal_partition_mpena DROP IF EXISTS PARTITION (sal_year = '2018');
```
```
> SHOW PARTITIONS emp_partition_mpena;
```
```
> SHOW PARTITIONS sal_partition_mpena;
```

---
* **ENABLE DYNAMIC PARTITION**
```
> SET hive.exec.dynamic.partition=true;
```

---
* **SET DYNAMIC PARTITION MODE TO NON-STRICT (Strict by default)**
```
> SET hive.exec.dynamic.partition.mode=nonstrict;
```

* **SET NUMBER OF DYNAMIC PARTITIONS**
```
> SET hive.exec.max.dynamic.partitions=1000;
> SET hive.exec.max.dynamic.partitions.pernode=500;
```

---
* **CREATE DYNAMIC PARTITION TABLE FOR EMPLOYEE**
```
CREATE TABLE IF NOT EXISTS emp_dyn_partition_mpena (
empid INT,
name STRING,
birthyear STRING)
PARTITIONED BY (emp_state STRING)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
TBLPROPERTIES("skip.header.line.count"="1");
```

---
* **CREATE DATA FOR DYNAMIC PARTITION**
```
INSERT OVERWRITE TABLE emp_dyn_partition_mpena
PARTITION (emp_state)
SELECT e.empid, e.name, e.birthyear, e.state
FROM employee_tbl_mpena e;
```
```
SELECT * FROM employee_tbl_mpena;
```
```
SELECT * FROM emp_dyn_partition_mpena;
```
```
SHOW PARTITIONS emp_dyn_partition_mpena;
```

* **DROP DATABASE**

```
> DROP DATABASE employee_db;
```
```
> DROP DATABASE IF EXISTS employee_db;
```
```
> DROP DATABASE IF EXISTS employee_db CASCADE;
```