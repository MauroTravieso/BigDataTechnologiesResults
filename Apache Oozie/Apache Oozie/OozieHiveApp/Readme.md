## Apache Oozie
### Use Case: Oozie-Hive Integration

### Motivation: 
#### - Being able to create, ingest and perform operations over CSV data
#### - Manage field data from a standard properties Hive table to recipient specific fields Hive ORC data format table. 
#### - Appliying Oozie workflow and placing job parameters in the corresponding properties file as best pratice.

### Mauro Travieso Pena

---
* **Oozie work flow definition:**
```
<!-- Workflow - Person Data - Hive Table -->
<workflow-app xmlns = "uri:oozie:workflow:0.4" name = "simple-workFlow">
   <start to = "Create_People_Table" />
  
   <!-- Step 1 --> 
   <action name = "Create_People_Table">
      <hive xmlns = "uri:oozie:hive-action:0.4">
         <job-tracker>${jobTracker}</job-tracker>
         <name-node>${nameNode}</name-node>
	       <job-xml>conf.xml</job-xml>
	       <configuration>
            <property>
               <name>mapred.job.queue.name</name>
               <value>${queueName}</value>
            </property>
         </configuration>
         <script>${script_name_external}</script>
      </hive>
      <ok to = "Create_ORC_Table" />
      <error to = "kill_job" />
   </action>

   <!-- Step 2 -->
   <action name = "Create_ORC_Table">
      <hive xmlns = "uri:oozie:hive-action:0.4">
         <job-tracker>${jobTracker}</job-tracker>
         <name-node>${nameNode}</name-node>
	       <job-xml>conf.xml</job-xml>
	       <configuration>
            <property>
               <name>mapred.job.queue.name</name>
               <value>${queueName}</value>
            </property>
         </configuration>
         <script>${script_name_orc}</script>
      </hive>
      <ok to = "Insert_Into_Table" />
      <error to = "kill_job" />
   </action>

   <!-- Step 3 -->
   <action name = "Insert_Into_Table">
      <hive xmlns = "uri:oozie:hive-action:0.4">
         <job-tracker>${jobTracker}</job-tracker>
         <name-node>${nameNode}</name-node>
	       <job-xml>conf.xml</job-xml>
	       <configuration>
            <property>
               <name>mapred.job.queue.name</name>
               <value>${queueName}</value>
            </property>
         </configuration>
         <script>${script_name_copy}</script>
      </hive>
      <ok to = "end" />
      <error to = "kill_job" />
   </action>
   
   <kill name = "kill_job">
      <message>Hive failed, error message[${wf:errorMessage(wf:lastErrorNode())}]</message>
   </kill>
	
   <end name = "end" />

</workflow-app>
```

* **Job properties definition:**
```
# Oozie job properties
nameNode=hdfs://nameNode:port
jobTracker=namenode:port
script_name_external=<path-to>/external.hql
script_name_orc=<path-to>/orc.hql
script_name_copy=<path-to>/copydata.hql
hive_database=oozie_hive
workflow_path=oozie/oozie_hive/app
queueName=default

oozie.use.system.libpath=true

oozie.wf.application.path=${nameNode}/user/${user.name}/${workflow_path}
```

* **Hive scripts definition:**

***external.hql***
```
CREATE DATABASE IF NOT EXISTS oozie_hive;
USE oozie_hive;
CREATE EXTERNAL TABLE oozie_hive.people_table (
first_name STRING,
last_name STRING,
year_of_birth INT,
address STRING,
city STRING,
state STRING,
zip INT)
COMMENT 'People data hive external table'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION '/user/cloudera/oozie/oozie_hive/input'
TBLPROPERTIES("skip.header.line.count"="1");
```

***orc.hql***
```
CREATE DATABASE IF NOT EXISTS oozie_hive;
USE oozie_hive;
CREATE EXTERNAL TABLE oozie_hive.orc_table(
fullname STRING, 
yearofbirth INT,
age INT,         
address STRING,
zip INT)
COMMENT 'ORC data hive internal table'
STORED AS ORC;
```

***copydata.hql***
```
CREATE DATABASE IF NOT EXISTS oozie_hive;
USE oozie_hive;
INSERT INTO TABLE oozie_hive.orc_table
SELECT
CONCAT(first_name,' ',last_name) AS fullname,
year_of_birth AS yearofbirth,
(YEAR(CURRENT_DATE)-year_of_birth) AS age,
CONCAT(city,' ',state) AS address,
zip
FROM oozie_hive.people_table;
```

* **To start the oozie job:**
```
$ oozie job -oozie http://ybolhdpm01.yotabites.com:11000/oozie/?user.name=mpena -config <path-to>/job.properties -run
```

* **Oozie Job Results:**

Job info:

![Image1](./Images/1.png)

Job DAG (Direct Acyclic Graph):

![Image2](./Images/2.png)

* **To test the scripts managed by Ozzie through HQL commands**
```
$ hive
```
```
hive> SHOW DATABASES;
OK
default
.
.
oozie_hive
.
.
```
```
hive> USE oozie_hive;
```
```
hive> SHOW TABLES;
OK
orc_table
people_table
Time taken: 0.012 seconds, Fetched: 2 row(s)
```
```
hive> SELECT * FROM people_table;
OK
Abby	Smith	1984	3456 main	Orlando	FL	45235
Amaya	Williams	1974	123 Orange	Newark	NJ	27656
Alchemy	Davis	1964	Warners	San Jose	CA	34789
Time taken: 0.06 seconds, Fetched: 3 row(s)
```
```
hive> SELECT * FROM orc_table;
OK
Abby Smith	1984	37	Orlando FL	45235
Amaya Williams	1974	47	Newark NJ	27656
Alchemy Davis	1964	57	San Jose CA	34789
Time taken: 0.048 seconds, Fetched: 3 row(s)
```
---
