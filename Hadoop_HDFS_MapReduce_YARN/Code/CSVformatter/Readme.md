
#### Spark Application: CSV formatter from text file/MySQL source table to

    Avro     -> Print Schema/Show 5 rows/Count number of records
    Parquet  -> Print Schema/Show 5 rows/Count number of records
    ORC      -> Print Schema/Show 5 rows/Count number of records
    JSON     -> Print Schema/Show 5 rows/Count number of records
    XML      -> Print Schema/Show 5 rows/Count number of records
    Sequence -> Print Schema/Show 5 rows/Count number of records
 
    @author    Mauro Travieso
    @version   1.0
 
    Bugs: none known
 
---

#### Output:

```
****************************************************************
CSV data
root<br>
 |-- empid: integer (nullable = true)
 |-- name: string (nullable = true)
 |-- state: string (nullable = true)
 |-- yob: integer (nullable = true)

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

Number of TextFile(CSV) file rows: 10

****************************************************************
CSV data, extracted from the Database
root
 |-- empid: integer (nullable = true)
 |-- name: string (nullable = true)
 |-- state: string (nullable = true)
 |-- yob: integer (nullable = true)

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

Number of TextFile(CSV) file rows from MySQL: 10

****************************************************************
Avro Schema
root
 |-- empid: integer (nullable = true)
 |-- name: string (nullable = true)
 |-- state: string (nullable = true)
 |-- yob: integer (nullable = true)

Avro data
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

Number of Avro file rows: 10

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
****************************************************************
Parquet Schema
root
 |-- empid: integer (nullable = true)
 |-- name: string (nullable = true)
 |-- state: string (nullable = true)
 |-- yob: integer (nullable = true)

Parquet data
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

Number of Parquet file rows: 10

****************************************************************
ORC Schema
root
 |-- empid: integer (nullable = true)
 |-- name: string (nullable = true)
 |-- state: string (nullable = true)
 |-- yob: integer (nullable = true)

ORC data
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

Number of ORC file rows: 10

****************************************************************
JSON Schema
root
 |-- empid: long (nullable = true)
 |-- name: string (nullable = true)
 |-- state: string (nullable = true)
 |-- yob: long (nullable = true)

JSON data
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

Number of JSON records: 10

****************************************************************
XML Schema
root
 |-- empid: long (nullable = true)
 |-- name: string (nullable = true)
 |-- state: string (nullable = true)
 |-- yob: long (nullable = true)

XML data
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

Number of XML file rows: 10

****************************************************************
Sequence file data
((null),106,Renee,KS,1975)
((null),107,Jack,KS,1971)
((null),108,Jessy,CA,1978)
((null),109,Connie,CA,1979)
((null),110,Bobby,KS,1973)

Number of Sequence File Records: 11

Spark Session stopped

Process finished with exit code 0
```
