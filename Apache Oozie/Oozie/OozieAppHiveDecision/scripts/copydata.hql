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