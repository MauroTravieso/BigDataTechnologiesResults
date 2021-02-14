## SparkSQL
### Dataframe Functions

---
**Output:**

*Column names:*
```
deathFlashback
death_episode
death_season
execution
likelihoodOfReturn
likelihoodOfReturn_notes
name
role
```

Data types:
```
   (deathFlashback,BooleanType)
   (death_episode,LongType)
   (death_season,LongType)
   (execution,StringType)
   (likelihoodOfReturn,StringType)
   (likelihoodOfReturn_notes,StringType)
   (name,StringType)
   (role,StringType)
```

*Schema:*
```
root
 |-- deathFlashback: boolean (nullable = true)
 |-- death_episode: long (nullable = true)
 |-- death_season: long (nullable = true)
 |-- execution: string (nullable = true)
 |-- likelihoodOfReturn: string (nullable = true)
 |-- likelihoodOfReturn_notes: string (nullable = true)
 |-- name: string (nullable = true)
 |-- role: string (nullable = true)
```

*DaraFrame show:*
```
+--------------+-------------+------------+--------------------+------------------+------------------------+-----------------+--------------------+
|deathFlashback|death_episode|death_season|           execution|likelihoodOfReturn|likelihoodOfReturn_notes|             name|                role|
+--------------+-------------+------------+--------------------+------------------+------------------------+-----------------+--------------------+
|          null|            1|           1|Beheaded for dese...|                0%|                    null|             Will|Ranger of the Nig...|
|          null|            1|           1|Poisoned by Lysa ...|                0%|                    null|        Jon Arryn|Hand to the King ...|
|          null|            5|           1|Stabbed by Jaime ...|                0%|                    null|      Jory Cassel|Captain of the gu...|
|          null|            6|           1|Khal Drogo pours ...|                0%|                    null|Viserys Targaryen|Exiled head of Ho...|
|          null|            7|           1|             Unknown|               15%|    He could have sur...|     Benjen Stark|First Ranger of t...|
+--------------+-------------+------------+--------------------+------------------+------------------------+-----------------+--------------------+
only showing top 5 rows
```

*Number of rows:*
```
Number of records: 100
```

*Return the first n rows in the DataFrame (take(2)*
```
[Will,0%]
[Jon Arryn,0%]
```

*Language Integrated Queries*<br>eventDF.select("name").limit(5).show()
```
+-----------------+
|             name|
+-----------------+
|             Will|
|        Jon Arryn|
|      Jory Cassel|
|Viserys Targaryen|
|     Benjen Stark|
+-----------------+
```
eventDF.select("name", "death_season")
      .where("death_season LIKE '5'")
      .limit(20)
      .show()
```
+------------------+------------+
|              name|death_season|
+------------------+------------+
|      Mance Rayder|           5|
|       Janos Slynt|           5|
|   Barristan Selmy|           5|
|     Maester Aemon|           5|
|             Karsi|           5|
| Shireen Baratheon|           5|
|  Hizdahr zo Loraq|           5|
|  Selyse Baratheon|           5|
| Stannis Baratheon|           5|
|           Myranda|           5|
|       Meryn Trant|           5|
|Myrcella Baratheon|           5|
|          Jon Snow|           5|
+------------------+------------+
```
*Filtering* <br> eventDF.select("name", "death_season")
                       .filter("death_season LIKE '1'")
                       .filter("death_episode LIKE '10'")
                       .limit(20)
                       .show()

```
+--------------+------------+
|          name|death_season|
+--------------+------------+
|         Drogo|           1|
|        Rhaego|           1|
|Mirri Maz Duur|           1|
+--------------+------------+
```
*GROUP BY*<br>
    eventDF.groupBy("name")
      .count()
      .filter("name LIKE '%Stark%'")
      .show()

```
+-------------+-----+
|         name|count|
+-------------+-----+
| Talisa Stark|    1|
| Eddard Stark|    1|
|Catelyn Stark|    1|
| Rickon Stark|    1|
|   Robb Stark|    1|
| Lyanna Stark|    1|
| Benjen Stark|    1|
+-------------+-----+
```

*ORDER BY*<br>
    eventDF.groupBy("name")
      .count()
      .filter("name LIKE '%Stark%'")
      .orderBy(desc("name"))
      .show()
```
+-------------+-----+
|         name|count|
+-------------+-----+
| Talisa Stark|    1|
|   Robb Stark|    1|
| Rickon Stark|    1|
| Lyanna Stark|    1|
| Eddard Stark|    1|
|Catelyn Stark|    1|
| Benjen Stark|    1|
+-------------+-----+
```
*DISTINCT / SORT BY*<br>
    eventDF.select("death_season")
      .distinct()
      .orderBy(desc("death_season"))
      .show()
```
+------------+
|death_season|
+------------+
|           6|
|           5|
|           4|
|           3|
|           2|
|           1|
+------------+
```

```
root
 |-- death_episode: long (nullable = true)
 |-- death_season: long (nullable = true)
 |-- execution: string (nullable = true)
 |-- likelihoodOfReturn: string (nullable = true)
 |-- name: string (nullable = true)
 |-- role: string (nullable = true)
```

*Repartition:*<br>

val repartitionDF = eventDF.repartition(5)

println("Num partitions: " + repartitionDF.rdd.getNumPartitions)

```
Num partitions: 5
```

*SQL Query result:* <br>
 
"SELECT COUNT(*) AS contain_Stark_poisoned FROM events WHERE name LIKE '%Stark%' AND execution LIKE 'Poisoned'")
```
+----------------------+
|contain_Stark_poisoned|
+----------------------+
|                     0|
+----------------------+
```
"SELECT death_season, COUNT(death_season) AS count FROM events GROUP BY death_season SORT BY death_season DESC")
```
+------------+-----+
|death_season|count|
+------------+-----+
|           6|   40|
|           5|   13|
|           1|   11|
|           3|    9|
|           2|   10|
|           4|   17|
+------------+-----+
```

*Write DF as AVRO, CSV, JSON and Parquet format*

```
Check the output directory to locate the various formats 
```

```
20/12/27 21:51:29 INFO ParquetWriteSupport: Initialized Parquet WriteSupport with Catalyst schema:
{
  "type" : "struct",
  "fields" : [ {
    "name" : "deathFlashback",
    "type" : "boolean",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "death_episode",
    "type" : "long",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "death_season",
    "type" : "long",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "execution",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "likelihoodOfReturn",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "likelihoodOfReturn_notes",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "name",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "role",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  } ]
}
and corresponding Parquet message type:
message spark_schema {
  optional boolean deathFlashback;
  optional int64 death_episode;
  optional int64 death_season;
  optional binary execution (UTF8);
  optional binary likelihoodOfReturn (UTF8);
  optional binary likelihoodOfReturn_notes (UTF8);
  optional binary name (UTF8);
  optional binary role (UTF8);
}
```
