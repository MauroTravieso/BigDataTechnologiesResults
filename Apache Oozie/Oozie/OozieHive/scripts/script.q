-- Create a input table and put value 1 in it
CREATE EXTERNAL TABLE test (a INT) STORED AS TEXTFILE LOCATION '${INPUT}';
INSERT INTO TABLE test VALUES(1);


-- create a output table using input data
INSERT OVERWRITE DIRECTORY '${OUTPUT}' SELECT * FROM test;