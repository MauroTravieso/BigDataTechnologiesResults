CREATE DATABASE employees;

USE employees;

CREATE TABLE employee (
empid INT,
name VARCHAR(10),
state VARCHAR(2),
yob VARCHAR(4)
);

INSERT INTO employee VALUES (
(101,"Jim","KS","1975"),
(102,"Mary","CA","1977"),
(103,"James","KS","1974"),
(104,"Cam","KS","1972"),
(105,"Jones","CA","1975"),
(106,"Renee","KS","1975"),
(107,"Jack","KS","1971"),
(108,"Jessy","CA","1978"),
(109,"Connie","CA","1979")
);

CREATE TABLE department (
id INT,
department VARCHAR(2),
benefits VARCHAR(7)
);

INSERT INTO department VALUES
(101,"DB","Partial"),
(102,"BD","Partial"),
(103,"SC","Partial"),
(104,"AC","Full"),
(104,"SC","Partial"),
(105,"MD","FULL"),
(106,"CS","Partial"),
(106,"MD","Partial"),
(107,"EN","Full"),
(107,"SC","Partial"),
(107,"MD","Partial"),
(108,"SC","Full"),
(109,"MD","Full"),
(110,"MD","Parial");

CREATE TABLE salary (
empid INT,
onboarding_date DATE,
salary FLOAT(8,2)
);

INSERT INTO salary VALUES
(101,"2001-04-14",50000),
(101,"2002-05-15",40000),
(102,"2001-06-16",35000),
(103,"2003-08-14",55000),
(104,"2004-01-13",50000),
(104,"2007-05-12",42000),
(105,"2019-03-10",15000),
(106,"2005-03-09",80000),
(106,"2011-04-05",26000),
(107,"2017-05-05",55000),
(107,"2010-06-08",90000),
(107,"2002-12-14",50000),
(108,"2006-11-24",12000),
(109,"2011-11-16",31000),
(110,"2016-11-12",32000);


