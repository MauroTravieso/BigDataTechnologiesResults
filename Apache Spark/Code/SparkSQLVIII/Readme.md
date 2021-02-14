## SparkSQL
### Creating Dataframe from Relational Database
### Performing tables join

---
**Output:**

*Table employee schema:*
```
*** Table: employee ***
Schema:
root
 |-- empid: integer (nullable = true)
 |-- name: string (nullable = true)
 |-- state: string (nullable = true)
 |-- yob: integer (nullable = true)

```
*Table employee data:*
```
Data:
+-----+-----+-----+----+
|empid| name|state| yob|
+-----+-----+-----+----+
|  101|  Jim|   KS|1975|
|  102| Mary|   CA|1977|
|  103|James|   KS|1974|
|  104|  Cam|   KS|1972|
|  105|Jones|   CA|1975|
+-----+-----+-----+----+
only showing top 5 rows
```

---
*Table employee number of records:*
```
Number of file rows: 10
```

*Table department schema:*
```
*** Table: department ***
Schema:
root
 |-- id: integer (nullable = true)
 |-- department: string (nullable = true)
 |-- benefits: string (nullable = true)
```

*Table department data:*
```
Data:
+---+----------+--------+
| id|department|benefits|
+---+----------+--------+
|101|        EN|    Full|
|101|        DB| Partial|
|102|        BD| Partial|
|103|        SC| Partial|
|104|        AC|    Full|
+---+----------+--------+
only showing top 5 rows
```

*Table department number of records:*
```
Number of TextFile(CSV) file rows from MySQL: 15
```

---
*Table salary schema:*
```
*** Table: salary ***
Schema:
root
 |-- empid: integer (nullable = true)
 |-- onboarding_date: date (nullable = true)
 |-- salary: double (nullable = true)
```

*Table salary data:*
```
Data
+-----+---------------+-------+
|empid|onboarding_date| salary|
+-----+---------------+-------+
|  101|     2001-04-14|50000.0|
|  101|     2002-05-15|40000.0|
|  102|     2001-06-16|35000.0|
|  103|     2003-08-14|55000.0|
|  104|     2004-01-13|50000.0|
+-----+---------------+-------+
only showing top 5 rows
```

*Table salary number of records:*
```
Number of rows: 15
```

---
***SQL queries:***<br>

"SELECT COUNT(emp.empid) AS employee_count FROM emp WHERE empid > 105"
```
+--------------+
|employee_count|
+--------------+
|             5|
+--------------+
```

"SELECT dept.department, emp.name, sal.salary FROM emp INNER JOIN dept ON emp.empid = dept.id INNER JOIN sal ON dept.id = sal.empid ORDER BY dept.department, sal.salary DESC"
```
+----------+------+-------+
|department|  name| salary|
+----------+------+-------+
|        AC|   Cam|50000.0|
|        AC|   Cam|42000.0|
|        BD|  Mary|35000.0|
|        CS| Renee|80000.0|
|        CS| Renee|26000.0|
|        DB|   Jim|50000.0|
|        DB|   Jim|40000.0|
|        EN|  Jack|90000.0|
|        EN|  Jack|55000.0|
|        EN|   Jim|50000.0|
|        EN|  Jack|50000.0|
|        EN|   Jim|40000.0|
|        MD|  Jack|90000.0|
|        MD| Renee|80000.0|
|        MD|  Jack|55000.0|
|        MD|  Jack|50000.0|
|        MD| Bobby|32000.0|
|        MD|Connie|31000.0|
|        MD| Renee|26000.0|
|        MD| Jones|15000.0|
+----------+------+-------+
only showing top 20 rows
```