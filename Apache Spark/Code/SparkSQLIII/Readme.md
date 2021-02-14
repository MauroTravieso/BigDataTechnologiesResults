## SparkSQL
### Creating Dataframe from CSV

---
**Output:**

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

*Dealing with nulls:*
```
+-----------------+--------------------+------------+-------------+--------------------+------------------+------------------------+--------------+
|             name|                role|death_season|death_episode|           execution|likelihoodOfReturn|likelihoodOfReturn_notes|deathFlashback|
+-----------------+--------------------+------------+-------------+--------------------+------------------+------------------------+--------------+
|             Will|Ranger of the Nig...|           1|            1|Beheaded for dese...|                0%|                  unkown|        unkown|
|        Jon Arryn|Hand to the King ...|           1|            1|Poisoned by Lysa ...|                0%|                  unkown|        unkown|
|      Jory Cassel|Captain of the gu...|           1|            5|Stabbed by Jaime ...|                0%|                  unkown|        unkown|
|Viserys Targaryen|Exiled head of Ho...|           1|            6|Khal Drogo pours ...|                0%|                  unkown|        unkown|
|     Benjen Stark|First Ranger of t...|           1|            7|             Unknown|               15%|    He could have sur...|        unkown|
+-----------------+--------------------+------------+-------------+--------------------+------------------+------------------------+--------------+
only showing top 5 rows
```

*SQL Query result:* <br> "SELECT COUNT(*) AS contain_Stark FROM events WHERE name LIKE '%Stark%'"
```
+-------------+
|contain_Stark|
+-------------+
|            7|
+-------------+
```
*SQL Query result:* <br> "SELECT name AS name_Stark FROM events WHERE name LIKE '%Stark%'"
```
+-------------+
|   name_Stark|
+-------------+
| Benjen Stark|
| Eddard Stark|
| Talisa Stark|
|   Robb Stark|
|Catelyn Stark|
| Rickon Stark|
| Lyanna Stark|
+-------------+
```