## SparkSQL
### Creating Dataframe from CSV

---
**Output:**

*Schema:*
```
root
 |-- name: string (nullable = true)
 |-- role: string (nullable = true)
 |-- death_season: integer (nullable = true)
 |-- death_episode: integer (nullable = true)
 |-- execution: string (nullable = true)
 |-- likelihoodOfReturn: string (nullable = true)
 |-- likelihoodOfReturn_notes: string (nullable = true)
 |-- deathFlashback: boolean (nullable = true)
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

*SQL Query result:* <br> "SELECT name, likelihoodOfReturn FROM events WHERE execution LIKE '%Poisoned%'"
```
+------------------+------------------+
|              name|likelihoodOfReturn|
+------------------+------------------+
|         Jon Arryn|                0%|
| Joffrey Baratheon|                0%|
|      The Mountain|              100%|
|Myrcella Baratheon|                0%|
+------------------+------------------+``