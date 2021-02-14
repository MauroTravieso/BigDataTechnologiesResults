## SparkSQL
### Creating Dataframe from CSV

---
**Output:**

*Schema:*
```

root
 |-- name: string (nullable = true)
 |-- role: string (nullable = true)
 |-- death_season: string (nullable = true)
 |-- death_episode: string (nullable = true)
 |-- execution: string (nullable = true)
 |-- likelihoodOfReturn: string (nullable = true)
 |-- likelihoodOfReturn_notes: string (nullable = true)
 |-- deathFlashback: string (nullable = true)
```
*DaraFrame show:*
```
+-----------------+--------------------+------------+-------------+--------------------+------------------+------------------------+--------------+
|             name|                role|death_season|death_episode|           execution|likelihoodOfReturn|likelihoodOfReturn_notes|deathFlashback|
+-----------------+--------------------+------------+-------------+--------------------+------------------+------------------------+--------------+
|             Will|Ranger of the Nig...|           1|            1|Beheaded for dese...|                0%|                    null|          null|
|        Jon Arryn|Hand to the King ...|           1|            1|Poisoned by Lysa ...|                0%|                    null|          null|
|      Jory Cassel|Captain of the gu...|           1|            5|Stabbed by Jaime ...|                0%|                    null|          null|
|Viserys Targaryen|Exiled head of Ho...|           1|            6|Khal Drogo pours ...|                0%|                    null|          null|
|     Benjen Stark|First Ranger of t...|           1|            7|             Unknown|               15%|    He could have sur...|          null|
+-----------------+--------------------+------------+-------------+--------------------+------------------+------------------------+--------------+
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

*SQL Query result:* <br> "SELECT COUNT(*) FROM events WHERE name LIKE '%Stark%'"
```
+--------+
|count(1)|
+--------+
|       7|
+--------+
```