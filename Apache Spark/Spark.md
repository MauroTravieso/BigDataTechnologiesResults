# ProKarma Boot Camp – Data Bases

## Spark RDD - Instructions and Assignments

### Mauro Travieso 

---

# Analysis on Game Of Thrones Dataset

## Load File into Spark

* **Open Spar shell:**
```
$ spark-shell
```
```
[mpena@ybolhdpe01 ~]$ spark-shell
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
20/12/18 10:19:56 WARN Utils: Service 'SparkUI' could not bind on port 4040. Attempting port 4041.
20/12/18 10:19:56 WARN Utils: Service 'SparkUI' could not bind on port 4041. Attempting port 4042.
Spark context Web UI available at http://ybolhdpe01.yotabites.com:4042
Spark context available as 'sc' (master = yarn, app id = application_1607998763486_0091).
Spark session available as 'spark'.
Welcome to
     ____              __
    / __/__  ___ _____/ /__
    \ \/ _ \/ _ `/ __/  '_/
  /___/ .__/\_,_/_/ /_/\_\   version 2.3.2.3.1.4.0-315
     /_/

Using Scala version 2.11.12 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_112)
Type in expressions to have them evaluated.
Type :help for more information.
```

* **Load file into Spark**
```
scala> val rdd = sc.textFile("hdfs://10.1.1.41:8020/user/mpena/Datasets/GoT/got_deaths.csv")
```
```
rdd: org.apache.spark.rdd.RDD[String] = hdfs://10.1.1.41:8020/user/mpena/Datasets/GoT/got_deaths.csv MapPartitionsRDD[1] at textFile at <console>:24
```

* Count number of records:
```
scala> rdd.count
```
```
res0: Long = 101
```

* **View sample data**

*Header*
```
scala> rdd.first
```
```
res2: String = name,role,death_season,death_episode,execution,likelihoodOfReturn,likelihoodOfReturn_notes,deathFlashback
```

*First 10 rows/records*

To not include the header
```
scala> val rdd = spark.read.format("CSV").option("header","true").load("hdfs://10.1.1.41:8020/user/mpena/Datasets/GoT/got_deaths.csv")
```
```
scala> rdd.take(10)
```
```
res3: Array[org.apache.spark.sql.Row] = Array([Will,Ranger of the Nights Watch,1,1,Beheaded for desertion by Ned Stark,0%,null,null], [Jon Arryn,Hand to the King before Ned Stark,1,1,Poisoned by Lysa Arryn and Littlefinger,0%,null,null], [Jory Cassel,Captain of the guards to House Stark,1,5,Stabbed by Jaime Lannister through the eye,0%,null,null], [Viserys Targaryen,Exiled head of House Targaryen and brother to Daenerys Targaryen,1,6,Khal Drogo pours molten gold on his head at Daenerys command,0%,null,null], [Benjen Stark,First Ranger of the Nights Watch, Brother of Ned Stark,1,7,Unknown,15%,He could have survived all this time or become a wight,null], [Robert Baratheon,Lord of the Seven Kingdoms,1,7,Mortally wounded by a wild boar after drinking wine given to him by Lancel Lannister a...
```

* **Constant indices definition**
```
val NAME = 0
val ROLE = 1
val DEATH_SEASON = 2
val DEATH_EPISODE = 3
val EXECUTION = 4
val LIKELIHOODOFRETURN = 5
val LIKELIHOODOFRETURN_NOTES = 6
val DEATHFLASHBACK = 7
```
```
scala> val NAME = 0
NAME: Int = 0

scala> val ROLE = 1
ROLE: Int = 1

scala> val DEATH_SEASON = 2
DEATH_SEASON: Int = 2

scala> val DEATH_EPISODE = 3
DEATH_EPISODE: Int = 3

scala> val EXECUTION = 4
EXECUTION: Int = 4

scala> val LIKELIHOODOFRETURN = 5
LIKELIHOODOFRETURN: Int = 5

scala> val LIKELIHOODOFRETURN_NOTES = 6
LIKELIHOODOFRETURN_NOTES: Int = 6

scala> val DEATHFLASHBACK = 7
DEATHFLASHBACK: Int = 7
```

* **Access individual elements (Transforming raw data into fields)**
```
scala> val namesRdd = rdd.map(x => x.split(',')(NAME))
```
```
namesRdd: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[14] at map at <console>:27
```


* *To test the results*
```
scala> namesRdd.take(5)
```
```
res8: Array[String] = Array(name, Will, Jon Arryn, Jory Cassel, Viserys Targaryen)
```

* **Filter records with specific names**
```
scala> val starkRdd = namesRdd.filter(x => x.contains("Stark"))
```
```
starkRdd: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[15] at filter at <console>:25
```

* *To verify*
```
scala> starkRdd.take(5)
```
```
res9: Array[String] = Array(Benjen Stark, Eddard Stark, Talisa Stark, Robb Stark, Catelyn Stark)
```

* **To count how many records with "Stark" there are in total**
```
scala> starkRdd.count
```
```
res10: Long = 7
```

---

* **How many characters have died in Season 3 (DEATH_SEAON) = 3**
```
val deathCount = rdd.filter(x => x.split(',')(DEATH_SEASON) == "3").count
```
```
deathCount: Long = 6
```

* **To list the number of characters's names who died in Season 5**
```
scala> val nameSeasonPair = rdd.map(x => (x.split(',')(NAME), x.split(',')(DEATH_SEASON)=="5")).groupBy(x=>x)
```
```
nameSeasonPair: org.apache.spark.rdd.RDD[(String, String)] = MapPartitionsRDD[22] at map at <console>:29
```
```
res11: Array[(String, Boolean)] = Array((name,false), (Will,false), (Jon Arryn,false), (Jory Cassel,false), (Viserys Targaryen,false), (Benjen Stark,false), (Robert Baratheon,false), (Syrio Forel,false), (Eddard Stark,false), (Drogo,false), (Rhaego,false), (Mirri Maz Duur,false), (Rakharo,false), (Yoren,false), (Renly Baratheon,false), (Rodrik Cassel,false), (Irri,false), (Maester Luwin,false), (Qhorin,false), (Pyat Pree,false), (Doreah,false), (Xaro Xhoan Daxos,false), (Hoster Tully,false), (Jeor Mormont,false), (Craster,false), (Kraznys,false), (Beric Dondarrion,false), (Ros,false), (Talisa Stark,false), (Robb Stark,false), (Catelyn Stark,false), (Polliver,false), (Tansy,false), (Joffrey Baratheon,false), (Karl Tanner,false), (Locke,false), (Rast,false), (Lysa Arryn,false), (Oberyn Ma...
```

* **To generate the tuple (Name, Death_Season)**

```
scala> val nmDeathRdd = nameSeasonPair.filter(x => x._2 == "5")
```
```
nmDeathRdd: org.apache.spark.rdd.RDD[(String, Boolean)] = MapPartitionsRDD[56] at filter at <console>:25
```

To print the names:
```
scala> nmDeathRdd.map(_._1).take(10).foreach(println)
```

* **Sort the death count by seasons and episodes**

```
scala> val seasonEpisodePair = rdd.map(x => ((x.split(',')(DEATH_SEASON), x.split(',')(DEATH_EPISODE)), 1))
```
```
seasonEpisodePair: org.apache.spark.rdd.RDD[((String, String), Int)] = MapPartitionsRDD[61] at map at <console>:29
```

```
scala> val seasonEpisodeCounts = seasonEpisodePair.reduceByKey((x ,y) => x + y)
```
```
scala> seasonEpisodeCounts.collect
res12: Array[((String, String), Int)] = Array(((death_season,death_episode),1), ((2,10),4), ((6,4),2), ((" Warden of the South"",6),1), ((6,2),3), ((4,9),5), ((" sister to Catelyn Stark"," briefly the wife of Littlefinger""),1), ((6,1),2), ((3,4),3), ((" Lord of Riverrun"",6),1), ((5,10),3), ((2,2),1), ((1,8),1), ((" Servant of House Stark"",2),1), ((" brother of Meera Reed"," traveling companion of Bran Stark""),1), ((1,6),1), ((6,7),1), ((2,3),1), ((3,5),1), ((Lord of the Seven Kingdoms,6),1), ((" former slave trader"," husband of Daenerys Targaryen""),1), ((" Claimant to the Iron Throne"," brother of Robert and Stannis Baratheon""),1), ((6,5),3), ((4,8),1), ((" leader of the mutiny at Crasters Keep"",4),1), ((4,1),1), ((" Father of Edmure Tully"," Catelyn Stark and Lysa Arryn""),1), ...
```
Check the ingestion procedure!!!
```
scala> seasonEpisodeCounts.take(10).foreach(println)
((death_season,death_episode),1)
((6,4),2)
(( Warden of the South",6),1)
((2,10),4)
((6,2),3)
((4,9),5)
(( sister to Catelyn Stark, briefly the wife of Littlefinger"),1)
((6,1),2)
((5,10),3)
(( Lord of Riverrun",6),1)
```

* **Sort the values in descending order**
```
scala> seasonEpisodeCounts.sortBy(x => x._2, false).take(10).foreach(println)
```
```
((6,10),9)
((6,9),6)
((4,9),5)
((6,8),4)
((2,10),4)
((6,3),3)
((1,10),3)
((6,2),3)
((3,4),3)
((5,10),3)
```












