# DataBase Management

#### Mauro Travieso 

### Tasks

#### Topics:

* Read the concepts, best ways, database modelling basics
* How to design a database?
* Relational database vs non relational database
* Nested / Sub Queries, Joins, Set and Union Operators

### SQL Queries:

* Write a query to display the currentdate in all possible formats

*To display the current date:*
```
SELECT CURDATE();
```
-OR-
```
SELECT CURRENT_DATE();
```

*Date formats:*
```
SELECT DATE_FORMAT(CURRENT_DATE(), "%m/%d/%Y");
```
```
SELECT DATE_FORMAT(CURRENT_DATE(), "%M %D, %Y");
```
```
SELECT DATE_FORMAT(CURRENT_DATE(), "%W, %b %D, %Y");
```
```
SELECT DATE_FORMAT(CURRENT_DATE(), "%a, %M %D, %y");
```

* Write a Query to List out all employees where the present basic is perfectly rounded of to 100. <br>** Ex** : If Basic of A is 2011, Basic of B is 2100 , Basic of C is 2101 and Basic of D is 2200 . Then Only B and D should be displayed

```
SELECT Name 
FROM tblemployees 
WHERE ROUND(PresentBasic)%1000 IN (100,200,300,400,500,600,700,800,900);
```
*For readability testing purposes*
```
SELECT Name, ROUND(PresentBasic), ROUND(PresentBasic) % 1000  FROM tblemployees WHERE ROUND(PresentBasic)%1000 IN (100,200,300,400,500,600,700,800,900);
```

* Write a query to find out employees whose names have Leading or Trailing spaces

```
SELECT SUBSTRING_INDEX(Name, ' ' ,1) AS name
FROM tblemployees
WHERE CHAR_LENGTH(name) != CHAR_LENGTH(TRIM(name));
```
```
SELECT Name AS name
FROM tblemployees
WHERE CHAR_LENGTH(name) != CHAR_LENGTH(TRIM(name));
```
```
SELECT Name FROM tblemployees 
WHERE (Name LIKE ' %') OR (Name LIKE '% ');
```
```
SELECT Name AS name, CHAR_LENGTH(name) AS length, CHAR_LENGTH(TRIM(name)) AS trim_length 
FROM tblemployees
WHERE length != trim_length;
```
```
SELECT Name 
FROM tblemployees
WHERE Name REGEXP '(^[[:space:]]|[[:space:]]$)';
```

* Write a update query to remove trailing spaces from the employee names. Ex: If the employee name is Naseeruddin Shah    , then after running the update query the name should be Naseeruddin Shah.(without any spaces at the end)

```
UPDATE tblemployees
SET Name = RTRIM(Name);
```

* Write a similar update query to remove the leading spaces from the employee names
```
UPDATE tblemployees
SET Name = LTRIM(Name);
```

* Write a query to find list of employees and payments where the employee is paid VDA but not PF

```
SELECT 
DISTINCT tblemployees.Name, tblpayemployeeparamdetails.Amount 
FROM tblpayemployeeparamdetails 
INNER JOIN tblemployees ON tblemployees.EmployeeNumber = tblpayemployeeparamdetails.EmployeeNumber
WHERE tblpayemployeeparamdetails.ParamCode LIKE 'VDA' AND 
tblpayemployeeparamdetails.ParamCode NOT LIKE 'PF'
LIMIT 25;
```

*For readability testing purposes*
```
SELECT 
tblemployees.Name, tblpayemployeeparamdetails.Amount, tblpayemployeeparamdetails.ParamCode 
FROM tblpayemployeeparamdetails 
INNER JOIN tblemployees ON tblemployees.EmployeeNumber = tblpayemployeeparamdetails.EmployeeNumber
WHERE tblpayemployeeparamdetails.ParamCode LIKE 'VDA' AND 
tblpayemployeeparamdetails.ParamCode NOT LIKE 'PF'
LIMIT 25;
```

* Write a query to find list of employees and payments where the employee is paid VDA and PF

SELECT 
tblemployees.Name, tblpayemployeeparamdetails.Amount
FROM tblpayemployeeparamdetails 
INNER JOIN tblemployees ON tblemployees.EmployeeNumber = tblpayemployeeparamdetails.EmployeeNumber
WHERE tblpayemployeeparamdetails.ParamCode LIKE 'VDA' OR 
tblpayemployeeparamdetails.ParamCode LIKE 'PF'
LIMIT 25;
```

*For readability testing purposes*
```
SELECT 
tblemployees.Name, tblpayemployeeparamdetails.Amount, tblpayemployeeparamdetails.ParamCode 
FROM tblpayemployeeparamdetails 
INNER JOIN tblemployees ON tblemployees.EmployeeNumber = tblpayemployeeparamdetails.EmployeeNumber
WHERE tblpayemployeeparamdetails.ParamCode LIKE 'VDA' OR 
tblpayemployeeparamdetails.ParamCode LIKE 'PF'
LIMIT 25;
```

* Write a query to list all the employees whose name starts and ends with same character (case-sensitive)

```
SELECT TRIM(SUBSTRING_INDEX(Name, ' ', 1)) AS name 
FROM tblemployees 
WHERE (LEFT(name,1) = BINARY RIGHT(name,1)) AND CHAR_LENGTH(name)>1;
```

### Reading Activity:

[Dzone](https://dzone.com/articles/20-database-design-best)















