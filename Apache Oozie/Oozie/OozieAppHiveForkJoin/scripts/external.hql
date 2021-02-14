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
LOCATION '/user/cloudera/oozie/oozie_hive_fork_join/input'
TBLPROPERTIES("skip.header.line.count"="1");