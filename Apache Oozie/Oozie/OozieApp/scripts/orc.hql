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