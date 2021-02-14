## SparkSQL
### Creating Dataframe from Parquet

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

*SQL Query result:* <br> "SELECT name, death_season FROM events WHERE death_episode LIKE '10'"
```
+--------------------+------------+
|                name|death_season|
+--------------------+------------+
|               Drogo|           1|
|              Rhaego|           1|
|      Mirri Maz Duur|           1|
|       Maester Luwin|           2|
|              Qhorin|           2|
|           Pyat Pree|           2|
|              Doreah|           2|
|    Xaro Xhoan Daxos|           2|
|          Jojen Reed|           4|
|                Shae|           4|
|     Tywin Lannister|           4|
|    Selyse Baratheon|           5|
|   Stannis Baratheon|           5|
|             Myranda|           5|
|         Meryn Trant|           5|
|  Myrcella Baratheon|           5|
|            Jon Snow|           5|
|Grand Maester Pyc...|           6|
|              Lancel|           6|
|    The High Sparrow|           6|
+--------------------+------------+
only showing top 20 rows
```