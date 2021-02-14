## HBase - Spark Integration
### Creating Dataframe from CSV
### Performing SQL functions on HBase data

Mauro Travieso 

---
**Output:**
```
Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
21/01/01 17:24:31 INFO SparkContext: Running Spark version 2.1.0
21/01/01 17:24:33 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
21/01/01 17:24:33 INFO SecurityManager: Changing view acls to: cloudera
21/01/01 17:24:33 INFO SecurityManager: Changing modify acls to: cloudera
21/01/01 17:24:33 INFO SecurityManager: Changing view acls groups to: 
21/01/01 17:24:33 INFO SecurityManager: Changing modify acls groups to: 
21/01/01 17:24:33 INFO SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(cloudera); groups with view permissions: Set(); users  with modify permissions: Set(cloudera); groups with modify permissions: Set()
21/01/01 17:24:33 INFO Utils: Successfully started service 'sparkDriver' on port 56865.
21/01/01 17:24:33 INFO SparkEnv: Registering MapOutputTracker
21/01/01 17:24:33 INFO SparkEnv: Registering BlockManagerMaster
21/01/01 17:24:33 INFO BlockManagerMasterEndpoint: Using org.apache.spark.storage.DefaultTopologyMapper for getting topology information
21/01/01 17:24:33 INFO BlockManagerMasterEndpoint: BlockManagerMasterEndpoint up
21/01/01 17:24:33 INFO DiskBlockManager: Created local directory at /tmp/blockmgr-a9d17cb2-ea80-4a59-a7d9-03893d89c19e
21/01/01 17:24:34 INFO MemoryStore: MemoryStore started with capacity 1947.0 MB
21/01/01 17:24:34 INFO SparkEnv: Registering OutputCommitCoordinator
21/01/01 17:24:35 INFO Utils: Successfully started service 'SparkUI' on port 4040.
21/01/01 17:24:35 INFO SparkUI: Bound SparkUI to 0.0.0.0, and started at http://192.168.173.137:4040
21/01/01 17:24:35 INFO Executor: Starting executor ID driver on host localhost
21/01/01 17:24:35 INFO Utils: Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 45680.
21/01/01 17:24:35 INFO NettyBlockTransferService: Server created on 192.168.173.137:45680
21/01/01 17:24:35 INFO BlockManager: Using org.apache.spark.storage.RandomBlockReplicationPolicy for block replication policy
21/01/01 17:24:35 INFO BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 192.168.173.137, 45680, None)
21/01/01 17:24:35 INFO BlockManagerMasterEndpoint: Registering block manager 192.168.173.137:45680 with 1947.0 MB RAM, BlockManagerId(driver, 192.168.173.137, 45680, None)
21/01/01 17:24:35 INFO BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 192.168.173.137, 45680, None)
21/01/01 17:24:35 INFO BlockManager: Initialized BlockManager: BlockManagerId(driver, 192.168.173.137, 45680, None)
21/01/01 17:24:41 INFO MemoryStore: Block broadcast_0 stored as values in memory (estimated size 206.0 KB, free 1946.8 MB)
21/01/01 17:24:41 INFO MemoryStore: Block broadcast_0_piece0 stored as bytes in memory (estimated size 18.7 KB, free 1946.8 MB)
21/01/01 17:24:41 INFO BlockManagerInfo: Added broadcast_0_piece0 in memory on 192.168.173.137:45680 (size: 18.7 KB, free: 1947.0 MB)
21/01/01 17:24:41 INFO SparkContext: Created broadcast 0 from textFile at SparkDataframeHBase.scala:26
21/01/01 17:24:43 INFO FileInputFormat: Total input paths to process : 1
21/01/01 17:24:43 INFO SparkContext: Starting job: collect at SparkDataframeHBase.scala:29
21/01/01 17:24:44 INFO DAGScheduler: Got job 0 (collect at SparkDataframeHBase.scala:29) with 2 output partitions
21/01/01 17:24:44 INFO DAGScheduler: Final stage: ResultStage 0 (collect at SparkDataframeHBase.scala:29)
21/01/01 17:24:44 INFO DAGScheduler: Parents of final stage: List()
21/01/01 17:24:44 INFO DAGScheduler: Missing parents: List()
21/01/01 17:24:44 INFO DAGScheduler: Submitting ResultStage 0 (src/main/resources/employees.csv MapPartitionsRDD[1] at textFile at SparkDataframeHBase.scala:26), which has no missing parents
21/01/01 17:24:44 INFO MemoryStore: Block broadcast_1 stored as values in memory (estimated size 3.2 KB, free 1946.8 MB)
21/01/01 17:24:44 INFO MemoryStore: Block broadcast_1_piece0 stored as bytes in memory (estimated size 1948.0 B, free 1946.8 MB)
21/01/01 17:24:44 INFO BlockManagerInfo: Added broadcast_1_piece0 in memory on 192.168.173.137:45680 (size: 1948.0 B, free: 1947.0 MB)
21/01/01 17:24:44 INFO SparkContext: Created broadcast 1 from broadcast at DAGScheduler.scala:996
21/01/01 17:24:44 INFO DAGScheduler: Submitting 2 missing tasks from ResultStage 0 (src/main/resources/employees.csv MapPartitionsRDD[1] at textFile at SparkDataframeHBase.scala:26)
21/01/01 17:24:44 INFO TaskSchedulerImpl: Adding task set 0.0 with 2 tasks
21/01/01 17:24:44 INFO TaskSetManager: Starting task 0.0 in stage 0.0 (TID 0, localhost, executor driver, partition 0, PROCESS_LOCAL, 6033 bytes)
21/01/01 17:24:44 INFO TaskSetManager: Starting task 1.0 in stage 0.0 (TID 1, localhost, executor driver, partition 1, PROCESS_LOCAL, 6033 bytes)
21/01/01 17:24:44 INFO Executor: Running task 0.0 in stage 0.0 (TID 0)
21/01/01 17:24:44 INFO Executor: Running task 1.0 in stage 0.0 (TID 1)
21/01/01 17:24:44 INFO HadoopRDD: Input split: file:/home/cloudera/IdeaProjects/SparkDataframeHBase/src/main/resources/employees.csv:66+67
21/01/01 17:24:44 INFO HadoopRDD: Input split: file:/home/cloudera/IdeaProjects/SparkDataframeHBase/src/main/resources/employees.csv:0+66
21/01/01 17:24:44 INFO deprecation: mapred.tip.id is deprecated. Instead, use mapreduce.task.id
21/01/01 17:24:44 INFO deprecation: mapred.task.id is deprecated. Instead, use mapreduce.task.attempt.id
21/01/01 17:24:44 INFO deprecation: mapred.task.is.map is deprecated. Instead, use mapreduce.task.ismap
21/01/01 17:24:44 INFO deprecation: mapred.task.partition is deprecated. Instead, use mapreduce.task.partition
21/01/01 17:24:44 INFO deprecation: mapred.job.id is deprecated. Instead, use mapreduce.job.id
21/01/01 17:24:44 INFO Executor: Finished task 0.0 in stage 0.0 (TID 0). 1337 bytes result sent to driver
21/01/01 17:24:44 INFO Executor: Finished task 1.0 in stage 0.0 (TID 1). 1204 bytes result sent to driver
21/01/01 17:24:44 INFO TaskSetManager: Finished task 1.0 in stage 0.0 (TID 1) in 319 ms on localhost (executor driver) (1/2)
21/01/01 17:24:44 INFO TaskSetManager: Finished task 0.0 in stage 0.0 (TID 0) in 377 ms on localhost (executor driver) (2/2)
21/01/01 17:24:44 INFO TaskSchedulerImpl: Removed TaskSet 0.0, whose tasks have all completed, from pool 
21/01/01 17:24:44 INFO DAGScheduler: ResultStage 0 (collect at SparkDataframeHBase.scala:29) finished in 0.400 s
21/01/01 17:24:44 INFO DAGScheduler: Job 0 finished: collect at SparkDataframeHBase.scala:29, took 0.643359 s
21/01/01 17:24:44 INFO SparkContext: Starting job: collect at SparkDataframeHBase.scala:43
21/01/01 17:24:44 INFO DAGScheduler: Got job 1 (collect at SparkDataframeHBase.scala:43) with 4 output partitions
21/01/01 17:24:44 INFO DAGScheduler: Final stage: ResultStage 1 (collect at SparkDataframeHBase.scala:43)
21/01/01 17:24:44 INFO DAGScheduler: Parents of final stage: List()
21/01/01 17:24:44 INFO DAGScheduler: Missing parents: List()
21/01/01 17:24:44 INFO DAGScheduler: Submitting ResultStage 1 (MapPartitionsRDD[3] at map at SparkDataframeHBase.scala:29), which has no missing parents
21/01/01 17:24:44 INFO MemoryStore: Block broadcast_2 stored as values in memory (estimated size 2.0 KB, free 1946.8 MB)
21/01/01 17:24:44 INFO MemoryStore: Block broadcast_2_piece0 stored as bytes in memory (estimated size 1332.0 B, free 1946.8 MB)
21/01/01 17:24:44 INFO BlockManagerInfo: Added broadcast_2_piece0 in memory on 192.168.173.137:45680 (size: 1332.0 B, free: 1947.0 MB)
21/01/01 17:24:44 INFO SparkContext: Created broadcast 2 from broadcast at DAGScheduler.scala:996
21/01/01 17:24:44 INFO DAGScheduler: Submitting 4 missing tasks from ResultStage 1 (MapPartitionsRDD[3] at map at SparkDataframeHBase.scala:29)
21/01/01 17:24:44 INFO TaskSchedulerImpl: Adding task set 1.0 with 4 tasks
21/01/01 17:24:44 INFO TaskSetManager: Starting task 0.0 in stage 1.0 (TID 2, localhost, executor driver, partition 0, PROCESS_LOCAL, 5956 bytes)
21/01/01 17:24:44 INFO TaskSetManager: Starting task 1.0 in stage 1.0 (TID 3, localhost, executor driver, partition 1, PROCESS_LOCAL, 6000 bytes)
21/01/01 17:24:44 INFO TaskSetManager: Starting task 2.0 in stage 1.0 (TID 4, localhost, executor driver, partition 2, PROCESS_LOCAL, 6004 bytes)
21/01/01 17:24:44 INFO TaskSetManager: Starting task 3.0 in stage 1.0 (TID 5, localhost, executor driver, partition 3, PROCESS_LOCAL, 6002 bytes)
21/01/01 17:24:44 INFO Executor: Running task 0.0 in stage 1.0 (TID 2)
21/01/01 17:24:44 INFO Executor: Running task 1.0 in stage 1.0 (TID 3)
21/01/01 17:24:44 INFO Executor: Running task 2.0 in stage 1.0 (TID 4)
21/01/01 17:24:44 INFO Executor: Finished task 1.0 in stage 1.0 (TID 3). 1192 bytes result sent to driver
21/01/01 17:24:44 INFO Executor: Running task 3.0 in stage 1.0 (TID 5)
21/01/01 17:24:44 INFO Executor: Finished task 0.0 in stage 1.0 (TID 2). 953 bytes result sent to driver
21/01/01 17:24:44 INFO TaskSetManager: Finished task 1.0 in stage 1.0 (TID 3) in 26 ms on localhost (executor driver) (1/4)
21/01/01 17:24:44 INFO Executor: Finished task 3.0 in stage 1.0 (TID 5). 1186 bytes result sent to driver
21/01/01 17:24:44 INFO TaskSetManager: Finished task 0.0 in stage 1.0 (TID 2) in 41 ms on localhost (executor driver) (2/4)
21/01/01 17:24:44 INFO TaskSetManager: Finished task 3.0 in stage 1.0 (TID 5) in 28 ms on localhost (executor driver) (3/4)
21/01/01 17:24:44 INFO Executor: Finished task 2.0 in stage 1.0 (TID 4). 1275 bytes result sent to driver
21/01/01 17:24:44 INFO TaskSetManager: Finished task 2.0 in stage 1.0 (TID 4) in 32 ms on localhost (executor driver) (4/4)
21/01/01 17:24:44 INFO TaskSchedulerImpl: Removed TaskSet 1.0, whose tasks have all completed, from pool 
21/01/01 17:24:44 INFO DAGScheduler: ResultStage 1 (collect at SparkDataframeHBase.scala:43) finished in 0.046 s
21/01/01 17:24:44 INFO DAGScheduler: Job 1 finished: collect at SparkDataframeHBase.scala:43, took 0.058298 s
21/01/01 17:24:44 WARN SparkContext: Using an existing SparkContext; some configuration may not take effect.
21/01/01 17:24:44 INFO SharedState: Warehouse path is 'file:/home/cloudera/IdeaProjects/SparkDataframeHBase/spark-warehouse/'.
21/01/01 17:24:47 INFO BlockManagerInfo: Removed broadcast_2_piece0 on 192.168.173.137:45680 in memory (size: 1332.0 B, free: 1947.0 MB)
```
***Dataframe schema:***
```
root
 |-- key: string (nullable = true)
 |-- fName: string (nullable = true)
 |-- lName: string (nullable = true)
 |-- mName: string (nullable = true)
 |-- addressLine: string (nullable = true)
 |-- city: string (nullable = true)
 |-- state: string (nullable = true)
 |-- zipCode: string (nullable = true)
```
```
21/01/01 17:24:51 INFO CodeGenerator: Code generated in 1425.061556 ms
21/01/01 17:24:51 INFO SparkContext: Starting job: show at SparkDataframeHBase.scala:59
21/01/01 17:24:51 INFO DAGScheduler: Got job 2 (show at SparkDataframeHBase.scala:59) with 1 output partitions
21/01/01 17:24:51 INFO DAGScheduler: Final stage: ResultStage 2 (show at SparkDataframeHBase.scala:59)
21/01/01 17:24:51 INFO DAGScheduler: Parents of final stage: List()
21/01/01 17:24:51 INFO DAGScheduler: Missing parents: List()
21/01/01 17:24:51 INFO DAGScheduler: Submitting ResultStage 2 (MapPartitionsRDD[7] at show at SparkDataframeHBase.scala:59), which has no missing parents
21/01/01 17:24:51 INFO MemoryStore: Block broadcast_3 stored as values in memory (estimated size 16.6 KB, free 1946.8 MB)
21/01/01 17:24:51 INFO MemoryStore: Block broadcast_3_piece0 stored as bytes in memory (estimated size 5.4 KB, free 1946.8 MB)
21/01/01 17:24:51 INFO BlockManagerInfo: Added broadcast_3_piece0 in memory on 192.168.173.137:45680 (size: 5.4 KB, free: 1947.0 MB)
21/01/01 17:24:51 INFO SparkContext: Created broadcast 3 from broadcast at DAGScheduler.scala:996
21/01/01 17:24:51 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 2 (MapPartitionsRDD[7] at show at SparkDataframeHBase.scala:59)
21/01/01 17:24:51 INFO TaskSchedulerImpl: Adding task set 2.0 with 1 tasks
21/01/01 17:24:51 INFO TaskSetManager: Starting task 0.0 in stage 2.0 (TID 6, localhost, executor driver, partition 0, PROCESS_LOCAL, 5921 bytes)
21/01/01 17:24:51 INFO Executor: Running task 0.0 in stage 2.0 (TID 6)
21/01/01 17:24:51 INFO Executor: Finished task 0.0 in stage 2.0 (TID 6). 1260 bytes result sent to driver
21/01/01 17:24:51 INFO TaskSetManager: Finished task 0.0 in stage 2.0 (TID 6) in 31 ms on localhost (executor driver) (1/1)
21/01/01 17:24:51 INFO TaskSchedulerImpl: Removed TaskSet 2.0, whose tasks have all completed, from pool 
21/01/01 17:24:51 INFO DAGScheduler: ResultStage 2 (show at SparkDataframeHBase.scala:59) finished in 0.032 s
21/01/01 17:24:51 INFO DAGScheduler: Job 2 finished: show at SparkDataframeHBase.scala:59, took 0.075422 s
21/01/01 17:24:51 INFO SparkContext: Starting job: show at SparkDataframeHBase.scala:59
21/01/01 17:24:51 INFO DAGScheduler: Got job 3 (show at SparkDataframeHBase.scala:59) with 3 output partitions
21/01/01 17:24:51 INFO DAGScheduler: Final stage: ResultStage 3 (show at SparkDataframeHBase.scala:59)
21/01/01 17:24:51 INFO DAGScheduler: Parents of final stage: List()
21/01/01 17:24:51 INFO DAGScheduler: Missing parents: List()
21/01/01 17:24:51 INFO DAGScheduler: Submitting ResultStage 3 (MapPartitionsRDD[7] at show at SparkDataframeHBase.scala:59), which has no missing parents
21/01/01 17:24:51 INFO MemoryStore: Block broadcast_4 stored as values in memory (estimated size 16.6 KB, free 1946.7 MB)
21/01/01 17:24:52 INFO MemoryStore: Block broadcast_4_piece0 stored as bytes in memory (estimated size 5.4 KB, free 1946.7 MB)
21/01/01 17:24:52 INFO BlockManagerInfo: Added broadcast_4_piece0 in memory on 192.168.173.137:45680 (size: 5.4 KB, free: 1947.0 MB)
21/01/01 17:24:52 INFO SparkContext: Created broadcast 4 from broadcast at DAGScheduler.scala:996
21/01/01 17:24:52 INFO DAGScheduler: Submitting 3 missing tasks from ResultStage 3 (MapPartitionsRDD[7] at show at SparkDataframeHBase.scala:59)
21/01/01 17:24:52 INFO TaskSchedulerImpl: Adding task set 3.0 with 3 tasks
21/01/01 17:24:52 INFO TaskSetManager: Starting task 0.0 in stage 3.0 (TID 7, localhost, executor driver, partition 1, PROCESS_LOCAL, 6141 bytes)
21/01/01 17:24:52 INFO TaskSetManager: Starting task 1.0 in stage 3.0 (TID 8, localhost, executor driver, partition 2, PROCESS_LOCAL, 6145 bytes)
21/01/01 17:24:52 INFO TaskSetManager: Starting task 2.0 in stage 3.0 (TID 9, localhost, executor driver, partition 3, PROCESS_LOCAL, 6143 bytes)
21/01/01 17:24:52 INFO Executor: Running task 0.0 in stage 3.0 (TID 7)
21/01/01 17:24:52 INFO Executor: Running task 2.0 in stage 3.0 (TID 9)
21/01/01 17:24:52 INFO Executor: Running task 1.0 in stage 3.0 (TID 8)
21/01/01 17:24:52 INFO Executor: Finished task 0.0 in stage 3.0 (TID 7). 1389 bytes result sent to driver
21/01/01 17:24:52 INFO Executor: Finished task 1.0 in stage 3.0 (TID 8). 1386 bytes result sent to driver
21/01/01 17:24:52 INFO TaskSetManager: Finished task 0.0 in stage 3.0 (TID 7) in 19 ms on localhost (executor driver) (1/3)
21/01/01 17:24:52 INFO TaskSetManager: Finished task 1.0 in stage 3.0 (TID 8) in 19 ms on localhost (executor driver) (2/3)
21/01/01 17:24:52 INFO Executor: Finished task 2.0 in stage 3.0 (TID 9). 1378 bytes result sent to driver
21/01/01 17:24:52 INFO TaskSetManager: Finished task 2.0 in stage 3.0 (TID 9) in 21 ms on localhost (executor driver) (3/3)
21/01/01 17:24:52 INFO TaskSchedulerImpl: Removed TaskSet 3.0, whose tasks have all completed, from pool 
21/01/01 17:24:52 INFO DAGScheduler: ResultStage 3 (show at SparkDataframeHBase.scala:59) finished in 0.025 s
21/01/01 17:24:52 INFO DAGScheduler: Job 3 finished: show at SparkDataframeHBase.scala:59, took 0.052725 s
21/01/01 17:24:52 INFO BlockManagerInfo: Removed broadcast_1_piece0 on 192.168.173.137:45680 in memory (size: 1948.0 B, free: 1947.0 MB)
21/01/01 17:24:52 INFO BlockManagerInfo: Removed broadcast_4_piece0 on 192.168.173.137:45680 in memory (size: 5.4 KB, free: 1947.0 MB)
21/01/01 17:24:52 INFO BlockManagerInfo: Removed broadcast_3_piece0 on 192.168.173.137:45680 in memory (size: 5.4 KB, free: 1947.0 MB)
21/01/01 17:24:52 INFO CodeGenerator: Code generated in 224.17245 ms
```
***Input Data:***
```
+---+-------+--------+-----+-----------+--------+-----+-------+
|key|fName  |lName   |mName|addressLine|city    |state|zipCode|
+---+-------+--------+-----+-----------+--------+-----+-------+
|1  |Abby   |Smith   |K    |3456 main  |Orlando |FL   |45235  |
|2  |Amaya  |Williams|L    |123 Orange |Newark  |NJ   |27656  |
|3  |Alchemy|Davis   |P    |Warners    |San Jose|CA   |34789  |
+---+-------+--------+-----+-----------+--------+-----+-------+
```
```
21/01/01 17:24:52 INFO CatalystSqlParser: Parsing command: string
21/01/01 17:24:52 INFO CatalystSqlParser: Parsing command: string
21/01/01 17:24:52 INFO CatalystSqlParser: Parsing command: string
21/01/01 17:24:52 INFO CatalystSqlParser: Parsing command: string
21/01/01 17:24:52 INFO CatalystSqlParser: Parsing command: string
21/01/01 17:24:52 INFO CatalystSqlParser: Parsing command: string
21/01/01 17:24:52 INFO CatalystSqlParser: Parsing command: string
21/01/01 17:24:52 INFO CatalystSqlParser: Parsing command: string
21/01/01 17:24:53 INFO SHCCredentialsManager: SHCCredentialsManager was not enabled.
```
***Imported data HBase schema:***<br> 
*Display Schema from DataFrame*
```
root
 |-- key: string (nullable = true)
 |-- fName: string (nullable = true)
 |-- lName: string (nullable = true)
 |-- mName: string (nullable = true)
 |-- addressLine: string (nullable = true)
 |-- city: string (nullable = true)
 |-- state: string (nullable = true)
 |-- zipCode: string (nullable = true)
```
```
21/01/01 17:24:54 INFO CodeGenerator: Code generated in 20.711086 ms
21/01/01 17:24:54 INFO ZooKeeper: Client environment:zookeeper.version=3.5.7-f0fdd52973d373ffd9c86b81d99842dc2c7f660e, built on 02/10/2020 11:30 GMT
21/01/01 17:24:54 INFO ZooKeeper: Client environment:host.name=quickstart.cloudera
21/01/01 17:24:54 INFO ZooKeeper: Client environment:java.version=1.8.0_181
21/01/01 17:24:54 INFO ZooKeeper: Client environment:java.vendor=Oracle Corporation
21/01/01 17:24:54 INFO ZooKeeper: Client environment:java.home=/usr/java/jdk1.8.0_181/jre
21/01/01 17:24:54 INFO ZooKeeper: Client environment:java.class.path=/usr/java/jdk1.8.0_181/jre/lib/charsets.jar:/usr/java/jdk1.8.0_181/jre/lib/deploy.jar:/usr/java/jdk1.8.0_181/jre/lib/ext/cldrdata.jar:/usr/java/jdk1.8.0_181/jre/lib/ext/dnsns.jar:/usr/java/jdk1.8.0_181/jre/lib/ext/jaccess.jar:/usr/java/jdk1.8.0_181/jre/lib/ext/jfxrt.jar:/usr/java/jdk1.8.0_181/jre/lib/ext/localedata.jar:/usr/java/jdk1.8.0_181/jre/lib/ext/nashorn.jar:/usr/java/jdk1.8.0_181/jre/lib/ext/sunec.jar:/usr/java/jdk1.8.0_181/jre/lib/ext/sunjce_provider.jar:/usr/java/jdk1.8.0_181/jre/lib/ext/sunpkcs11.jar:/usr/java/jdk1.8.0_181/jre/lib/ext/zipfs.jar:/usr/java/jdk1.8.0_181/jre/lib/javaws.jar:/usr/java/jdk1.8.0_181/jre/lib/jce.jar:/usr/java/jdk1.8.0_181/jre/lib/jfr.jar:/usr/java/jdk1.8.0_181/jre/lib/jfxswt.jar:/usr/java/jdk1.8.0_181/jre/lib/jsse.jar:/usr/java/jdk1.8.0_181/jre/lib/management-agent.jar:/usr/java/jdk1.8.0_181/jre/lib/plugin.jar:/usr/java/jdk1.8.0_181/jre/lib/resources.jar:/usr/java/jdk1.8.0_181/jre/lib/rt.jar:/home/cloudera/IdeaProjects/SparkDataframeHBase/target/classes:/home/cloudera/.ivy2/cache/org.scala-lang/scala-library/jars/scala-library-2.11.12.jar:/home/cloudera/.ivy2/cache/org.scala-lang/scala-reflect/jars/scala-reflect-2.11.12.jar:/home/cloudera/.ivy2/cache/org.scala-lang/scala-library/srcs/scala-library-2.11.12-sources.jar:/home/cloudera/.ivy2/cache/org.scala-lang/scala-reflect/srcs/scala-reflect-2.11.12-sources.jar:/home/cloudera/.m2/repository/org/apache/spark/spark-core_2.11/2.1.0/spark-core_2.11-2.1.0.jar:/home/cloudera/.m2/repository/org/apache/avro/avro-mapred/1.7.7/avro-mapred-1.7.7-hadoop2.jar:/home/cloudera/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7.jar:/home/cloudera/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7-tests.jar:/home/cloudera/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/home/cloudera/.m2/repository/com/twitter/chill_2.11/0.8.0/chill_2.11-0.8.0.jar:/home/cloudera/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/home/cloudera/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/home/cloudera/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/home/cloudera/.m2/repository/com/twitter/chill-java/0.8.0/chill-java-0.8.0.jar:/home/cloudera/.m2/repository/org/apache/xbean/xbean-asm5-shaded/4.4/xbean-asm5-shaded-4.4.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-client/2.2.0/hadoop-client-2.2.0.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.2.0/hadoop-hdfs-2.2.0.jar:/home/cloudera/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.2.0/hadoop-mapreduce-client-app-2.2.0.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.2.0/hadoop-mapreduce-client-common-2.2.0.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.2.0/hadoop-yarn-client-2.2.0.jar:/home/cloudera/.m2/repository/com/google/inject/guice/3.0/guice-3.0.jar:/home/cloudera/.m2/repository/javax/inject/javax.inject/1/javax.inject-1.jar:/home/cloudera/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.2.0/hadoop-yarn-server-common-2.2.0.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.2.0/hadoop-mapreduce-client-shuffle-2.2.0.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.2.0/hadoop-yarn-api-2.2.0.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.2.0/hadoop-mapreduce-client-core-2.2.0.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.2.0/hadoop-yarn-common-2.2.0.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.2.0/hadoop-mapreduce-client-jobclient-2.2.0.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-annotations/2.2.0/hadoop-annotations-2.2.0.jar:/home/cloudera/.m2/repository/org/apache/spark/spark-launcher_2.11/2.1.0/spark-launcher_2.11-2.1.0.jar:/home/cloudera/.m2/repository/org/apache/spark/spark-network-common_2.11/2.1.0/spark-network-common_2.11-2.1.0.jar:/home/cloudera/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/home/cloudera/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.5/jackson-annotations-2.6.5.jar:/home/cloudera/.m2/repository/org/apache/spark/spark-network-shuffle_2.11/2.1.0/spark-network-shuffle_2.11-2.1.0.jar:/home/cloudera/.m2/repository/org/apache/spark/spark-unsafe_2.11/2.1.0/spark-unsafe_2.11-2.1.0.jar:/home/cloudera/.m2/repository/net/java/dev/jets3t/jets3t/0.7.1/jets3t-0.7.1.jar:/home/cloudera/.m2/repository/org/apache/curator/curator-recipes/2.4.0/curator-recipes-2.4.0.jar:/home/cloudera/.m2/repository/org/apache/curator/curator-framework/2.4.0/curator-framework-2.4.0.jar:/home/cloudera/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar:/home/cloudera/.m2/repository/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar:/home/cloudera/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/home/cloudera/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/home/cloudera/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/home/cloudera/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/home/cloudera/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/home/cloudera/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.16/jcl-over-slf4j-1.7.16.jar:/home/cloudera/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/home/cloudera/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/home/cloudera/.m2/repository/com/ning/compress-lzf/1.0.3/compress-lzf-1.0.3.jar:/home/cloudera/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/home/cloudera/.m2/repository/net/jpountz/lz4/lz4/1.3.0/lz4-1.3.0.jar:/home/cloudera/.m2/repository/org/roaringbitmap/RoaringBitmap/0.5.11/RoaringBitmap-0.5.11.jar:/home/cloudera/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/home/cloudera/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/home/cloudera/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar:/home/cloudera/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar:/home/cloudera/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar:/home/cloudera/.m2/repository/org/scala-lang/scalap/2.11.0/scalap-2.11.0.jar:/home/cloudera/.m2/repository/org/scala-lang/scala-compiler/2.11.0/scala-compiler-2.11.0.jar:/home/cloudera/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.1/scala-parser-combinators_2.11-1.0.1.jar:/home/cloudera/.m2/repository/org/glassfish/jersey/core/jersey-client/2.22.2/jersey-client-2.22.2.jar:/home/cloudera/.m2/repository/javax/ws/rs/javax.ws.rs-api/2.0.1/javax.ws.rs-api-2.0.1.jar:/home/cloudera/.m2/repository/org/glassfish/hk2/hk2-api/2.4.0-b34/hk2-api-2.4.0-b34.jar:/home/cloudera/.m2/repository/org/glassfish/hk2/hk2-utils/2.4.0-b34/hk2-utils-2.4.0-b34.jar:/home/cloudera/.m2/repository/org/glassfish/hk2/external/aopalliance-repackaged/2.4.0-b34/aopalliance-repackaged-2.4.0-b34.jar:/home/cloudera/.m2/repository/org/glassfish/hk2/external/javax.inject/2.4.0-b34/javax.inject-2.4.0-b34.jar:/home/cloudera/.m2/repository/org/glassfish/hk2/hk2-locator/2.4.0-b34/hk2-locator-2.4.0-b34.jar:/home/cloudera/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/home/cloudera/.m2/repository/org/glassfish/jersey/core/jersey-common/2.22.2/jersey-common-2.22.2.jar:/home/cloudera/.m2/repository/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar:/home/cloudera/.m2/repository/org/glassfish/jersey/bundles/repackaged/jersey-guava/2.22.2/jersey-guava-2.22.2.jar:/home/cloudera/.m2/repository/org/glassfish/hk2/osgi-resource-locator/1.0.1/osgi-resource-locator-1.0.1.jar:/home/cloudera/.m2/repository/org/glassfish/jersey/core/jersey-server/2.22.2/jersey-server-2.22.2.jar:/home/cloudera/.m2/repository/org/glassfish/jersey/media/jersey-media-jaxb/2.22.2/jersey-media-jaxb-2.22.2.jar:/home/cloudera/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/home/cloudera/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet/2.22.2/jersey-container-servlet-2.22.2.jar:/home/cloudera/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet-core/2.22.2/jersey-container-servlet-core-2.22.2.jar:/home/cloudera/.m2/repository/io/netty/netty-all/4.0.42.Final/netty-all-4.0.42.Final.jar:/home/cloudera/.m2/repository/io/netty/netty/3.8.0.Final/netty-3.8.0.Final.jar:/home/cloudera/.m2/repository/com/clearspring/analytics/stream/2.7.0/stream-2.7.0.jar:/home/cloudera/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.2/metrics-core-3.1.2.jar:/home/cloudera/.m2/repository/io/dropwizard/metrics/metrics-jvm/3.1.2/metrics-jvm-3.1.2.jar:/home/cloudera/.m2/repository/io/dropwizard/metrics/metrics-json/3.1.2/metrics-json-3.1.2.jar:/home/cloudera/.m2/repository/io/dropwizard/metrics/metrics-graphite/3.1.2/metrics-graphite-3.1.2.jar:/home/cloudera/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.5/jackson-databind-2.6.5.jar:/home/cloudera/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.5/jackson-core-2.6.5.jar:/home/cloudera/.m2/repository/com/fasterxml/jackson/module/jackson-module-scala_2.11/2.6.5/jackson-module-scala_2.11-2.6.5.jar:/home/cloudera/.m2/repository/org/scala-lang/scala-reflect/2.11.7/scala-reflect-2.11.7.jar:/home/cloudera/.m2/repository/com/fasterxml/jackson/module/jackson-module-paranamer/2.6.5/jackson-module-paranamer-2.6.5.jar:/home/cloudera/.m2/repository/org/apache/ivy/ivy/2.4.0/ivy-2.4.0.jar:/home/cloudera/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar:/home/cloudera/.m2/repository/net/razorvine/pyrolite/4.13/pyrolite-4.13.jar:/home/cloudera/.m2/repository/net/sf/py4j/py4j/0.10.4/py4j-0.10.4.jar:/home/cloudera/.m2/repository/org/apache/spark/spark-tags_2.11/2.1.0/spark-tags_2.11-2.1.0.jar:/home/cloudera/.m2/repository/org/scalatest/scalatest_2.11/2.2.6/scalatest_2.11-2.2.6.jar:/home/cloudera/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.2/scala-xml_2.11-1.0.2.jar:/home/cloudera/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/home/cloudera/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/home/cloudera/.m2/repository/org/apache/spark/spark-sql_2.11/2.1.0/spark-sql_2.11-2.1.0.jar:/home/cloudera/.m2/repository/com/univocity/univocity-parsers/2.2.1/univocity-parsers-2.2.1.jar:/home/cloudera/.m2/repository/org/apache/spark/spark-sketch_2.11/2.1.0/spark-sketch_2.11-2.1.0.jar:/home/cloudera/.m2/repository/org/apache/spark/spark-catalyst_2.11/2.1.0/spark-catalyst_2.11-2.1.0.jar:/home/cloudera/.m2/repository/org/codehaus/janino/janino/3.0.0/janino-3.0.0.jar:/home/cloudera/.m2/repository/org/codehaus/janino/commons-compiler/3.0.0/commons-compiler-3.0.0.jar:/home/cloudera/.m2/repository/org/antlr/antlr4-runtime/4.5.3/antlr4-runtime-4.5.3.jar:/home/cloudera/.m2/repository/org/apache/parquet/parquet-column/1.8.1/parquet-column-1.8.1.jar:/home/cloudera/.m2/repository/org/apache/parquet/parquet-common/1.8.1/parquet-common-1.8.1.jar:/home/cloudera/.m2/repository/org/apache/parquet/parquet-encoding/1.8.1/parquet-encoding-1.8.1.jar:/home/cloudera/.m2/repository/org/apache/parquet/parquet-hadoop/1.8.1/parquet-hadoop-1.8.1.jar:/home/cloudera/.m2/repository/org/apache/parquet/parquet-format/2.3.0-incubating/parquet-format-2.3.0-incubating.jar:/home/cloudera/.m2/repository/org/apache/parquet/parquet-jackson/1.8.1/parquet-jackson-1.8.1.jar:/home/cloudera/.m2/repository/com/databricks/spark-avro_2.11/3.2.0/spark-avro_2.11-3.2.0.jar:/home/cloudera/.m2/repository/org/apache/avro/avro/1.7.6/avro-1.7.6.jar:/home/cloudera/.m2/repository/com/thoughtworks/paranamer/paranamer/2.3/paranamer-2.3.jar:/home/cloudera/.m2/repository/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:/home/cloudera/.m2/repository/org/tukaani/xz/1.0/xz-1.0.jar:/home/cloudera/.m2/repository/org/apache/spark/spark-hive_2.11/2.1.0/spark-hive_2.11-2.1.0.jar:/home/cloudera/.m2/repository/com/twitter/parquet-hadoop-bundle/1.6.0/parquet-hadoop-bundle-1.6.0.jar:/home/cloudera/.m2/repository/org/spark-project/hive/hive-exec/1.2.1.spark2/hive-exec-1.2.1.spark2.jar:/home/cloudera/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/home/cloudera/.m2/repository/javolution/javolution/5.5.1/javolution-5.5.1.jar:/home/cloudera/.m2/repository/log4j/apache-log4j-extras/1.2.17/apache-log4j-extras-1.2.17.jar:/home/cloudera/.m2/repository/org/antlr/antlr-runtime/3.4/antlr-runtime-3.4.jar:/home/cloudera/.m2/repository/org/antlr/stringtemplate/3.2.1/stringtemplate-3.2.1.jar:/home/cloudera/.m2/repository/antlr/antlr/2.7.7/antlr-2.7.7.jar:/home/cloudera/.m2/repository/org/antlr/ST4/4.0.4/ST4-4.0.4.jar:/home/cloudera/.m2/repository/com/googlecode/javaewah/JavaEWAH/0.3.2/JavaEWAH-0.3.2.jar:/home/cloudera/.m2/repository/org/iq80/snappy/snappy/0.2/snappy-0.2.jar:/home/cloudera/.m2/repository/stax/stax-api/1.0.1/stax-api-1.0.1.jar:/home/cloudera/.m2/repository/net/sf/opencsv/opencsv/2.3/opencsv-2.3.jar:/home/cloudera/.m2/repository/org/spark-project/hive/hive-metastore/1.2.1.spark2/hive-metastore-1.2.1.spark2.jar:/home/cloudera/.m2/repository/com/jolbox/bonecp/0.8.0.RELEASE/bonecp-0.8.0.RELEASE.jar:/home/cloudera/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/home/cloudera/.m2/repository/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar:/home/cloudera/.m2/repository/org/apache/derby/derby/10.10.2.0/derby-10.10.2.0.jar:/home/cloudera/.m2/repository/org/datanucleus/datanucleus-api-jdo/3.2.6/datanucleus-api-jdo-3.2.6.jar:/home/cloudera/.m2/repository/org/datanucleus/datanucleus-rdbms/3.2.9/datanucleus-rdbms-3.2.9.jar:/home/cloudera/.m2/repository/commons-pool/commons-pool/1.5.4/commons-pool-1.5.4.jar:/home/cloudera/.m2/repository/commons-dbcp/commons-dbcp/1.4/commons-dbcp-1.4.jar:/home/cloudera/.m2/repository/javax/jdo/jdo-api/3.0.1/jdo-api-3.0.1.jar:/home/cloudera/.m2/repository/javax/transaction/jta/1.1/jta-1.1.jar:/home/cloudera/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar:/home/cloudera/.m2/repository/org/apache/calcite/calcite-avatica/1.2.0-incubating/calcite-avatica-1.2.0-incubating.jar:/home/cloudera/.m2/repository/org/apache/calcite/calcite-core/1.2.0-incubating/calcite-core-1.2.0-incubating.jar:/home/cloudera/.m2/repository/org/apache/calcite/calcite-linq4j/1.2.0-incubating/calcite-linq4j-1.2.0-incubating.jar:/home/cloudera/.m2/repository/net/hydromatic/eigenbase-properties/1.1.5/eigenbase-properties-1.1.5.jar:/home/cloudera/.m2/repository/org/apache/httpcomponents/httpclient/4.5.2/httpclient-4.5.2.jar:/home/cloudera/.m2/repository/org/apache/httpcomponents/httpcore/4.4.4/httpcore-4.4.4.jar:/home/cloudera/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/home/cloudera/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/home/cloudera/.m2/repository/joda-time/joda-time/2.9.3/joda-time-2.9.3.jar:/home/cloudera/.m2/repository/org/jodd/jodd-core/3.5.2/jodd-core-3.5.2.jar:/home/cloudera/.m2/repository/org/datanucleus/datanucleus-core/3.2.10/datanucleus-core-3.2.10.jar:/home/cloudera/.m2/repository/org/apache/thrift/libthrift/0.9.2/libthrift-0.9.2.jar:/home/cloudera/.m2/repository/org/apache/thrift/libfb303/0.9.2/libfb303-0.9.2.jar:/home/cloudera/.m2/repository/com/databricks/spark-xml_2.11/0.11.0/spark-xml_2.11-0.11.0.jar:/home/cloudera/.m2/repository/commons-io/commons-io/2.8.0/commons-io-2.8.0.jar:/home/cloudera/.m2/repository/org/glassfish/jaxb/txw2/2.3.3/txw2-2.3.3.jar:/home/cloudera/.m2/repository/org/apache/ws/xmlschema/xmlschema-core/2.2.5/xmlschema-core-2.2.5.jar:/home/cloudera/.m2/repository/mysql/mysql-connector-java/8.0.22/mysql-connector-java-8.0.22.jar:/home/cloudera/.m2/repository/com/google/protobuf/protobuf-java/3.11.4/protobuf-java-3.11.4.jar:/home/cloudera/.m2/repository/org/apache/hbase/hbase-client/2.4.0/hbase-client-2.4.0.jar:/home/cloudera/.m2/repository/org/apache/hbase/thirdparty/hbase-shaded-protobuf/3.4.1/hbase-shaded-protobuf-3.4.1.jar:/home/cloudera/.m2/repository/org/apache/hbase/hbase-common/2.4.0/hbase-common-2.4.0.jar:/home/cloudera/.m2/repository/org/apache/hbase/hbase-logging/2.4.0/hbase-logging-2.4.0.jar:/home/cloudera/.m2/repository/org/apache/hbase/thirdparty/hbase-shaded-gson/3.4.1/hbase-shaded-gson-3.4.1.jar:/home/cloudera/.m2/repository/org/apache/hbase/hbase-hadoop-compat/2.4.0/hbase-hadoop-compat-2.4.0.jar:/home/cloudera/.m2/repository/org/apache/hbase/hbase-metrics-api/2.4.0/hbase-metrics-api-2.4.0.jar:/home/cloudera/.m2/repository/org/apache/hbase/hbase-hadoop2-compat/2.4.0/hbase-hadoop2-compat-2.4.0.jar:/home/cloudera/.m2/repository/org/apache/hbase/hbase-metrics/2.4.0/hbase-metrics-2.4.0.jar:/home/cloudera/.m2/repository/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0.jar:/home/cloudera/.m2/repository/org/apache/hbase/hbase-protocol-shaded/2.4.0/hbase-protocol-shaded-2.4.0.jar:/home/cloudera/.m2/repository/org/apache/hbase/hbase-protocol/2.4.0/hbase-protocol-2.4.0.jar:/home/cloudera/.m2/repository/org/apache/hbase/thirdparty/hbase-shaded-miscellaneous/3.4.1/hbase-shaded-miscellaneous-3.4.1.jar:/home/cloudera/.m2/repository/com/google/errorprone/error_prone_annotations/2.3.4/error_prone_annotations-2.3.4.jar:/home/cloudera/.m2/repository/org/apache/hbase/thirdparty/hbase-shaded-netty/3.4.1/hbase-shaded-netty-3.4.1.jar:/home/cloudera/.m2/repository/org/apache/zookeeper/zookeeper/3.5.7/zookeeper-3.5.7.jar:/home/cloudera/.m2/repository/org/apache/zookeeper/zookeeper-jute/3.5.7/zookeeper-jute-3.5.7.jar:/home/cloudera/.m2/repository/io/netty/netty-handler/4.1.45.Final/netty-handler-4.1.45.Final.jar:/home/cloudera/.m2/repository/io/netty/netty-common/4.1.45.Final/netty-common-4.1.45.Final.jar:/home/cloudera/.m2/repository/io/netty/netty-buffer/4.1.45.Final/netty-buffer-4.1.45.Final.jar:/home/cloudera/.m2/repository/io/netty/netty-transport/4.1.45.Final/netty-transport-4.1.45.Final.jar:/home/cloudera/.m2/repository/io/netty/netty-resolver/4.1.45.Final/netty-resolver-4.1.45.Final.jar:/home/cloudera/.m2/repository/io/netty/netty-codec/4.1.45.Final/netty-codec-4.1.45.Final.jar:/home/cloudera/.m2/repository/io/netty/netty-transport-native-epoll/4.1.45.Final/netty-transport-native-epoll-4.1.45.Final.jar:/home/cloudera/.m2/repository/io/netty/netty-transport-native-unix-common/4.1.45.Final/netty-transport-native-unix-common-4.1.45.Final.jar:/home/cloudera/.m2/repository/org/apache/htrace/htrace-core4/4.2.0-incubating/htrace-core4-4.2.0-incubating.jar:/home/cloudera/.m2/repository/org/jruby/jcodings/jcodings/1.0.55/jcodings-1.0.55.jar:/home/cloudera/.m2/repository/org/jruby/joni/joni/2.1.31/joni-2.1.31.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-auth/2.10.0/hadoop-auth-2.10.0.jar:/home/cloudera/.m2/repository/com/nimbusds/nimbus-jose-jwt/4.41.1/nimbus-jose-jwt-4.41.1.jar:/home/cloudera/.m2/repository/com/github/stephenc/jcip/jcip-annotations/1.0-1/jcip-annotations-1.0-1.jar:/home/cloudera/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/home/cloudera/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/home/cloudera/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/home/cloudera/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/home/cloudera/.m2/repository/org/apache/hadoop/hadoop-common/2.10.0/hadoop-common-2.10.0.jar:/home/cloudera/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/home/cloudera/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/home/cloudera/.m2/repository/org/mortbay/jetty/jetty-sslengine/6.1.26/jetty-sslengine-6.1.26.jar:/home/cloudera/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/home/cloudera/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/home/cloudera/.m2/repository/commons-beanutils/commons-beanutils/1.9.4/commons-beanutils-1.9.4.jar:/home/cloudera/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/home/cloudera/.m2/repository/com/jcraft/jsch/0.1.54/jsch-0.1.54.jar:/home/cloudera/.m2/repository/org/apache/curator/curator-client/2.7.1/curator-client-2.7.1.jar:/home/cloudera/.m2/repository/org/codehaus/woodstox/stax2-api/3.1.4/stax2-api-3.1.4.jar:/home/cloudera/.m2/repository/com/fasterxml/woodstox/woodstox-core/5.0.3/woodstox-core-5.0.3.jar:/home/cloudera/.m2/repository/org/apache/yetus/audience-annotations/0.5.0/audience-annotations-0.5.0.jar:/home/cloudera/IdeaProjects/SparkDataframeHBase/lib/shc-core-1.1.1-2.1-s_2.11.jar:/home/cloudera/idea-IC-183.6156.11/lib/idea_rt.jar
21/01/01 17:24:54 INFO ZooKeeper: Client environment:java.library.path=/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib
21/01/01 17:24:54 INFO ZooKeeper: Client environment:java.io.tmpdir=/tmp
21/01/01 17:24:54 INFO ZooKeeper: Client environment:java.compiler=<NA>
21/01/01 17:24:54 INFO ZooKeeper: Client environment:os.name=Linux
21/01/01 17:24:54 INFO ZooKeeper: Client environment:os.arch=amd64
21/01/01 17:24:54 INFO ZooKeeper: Client environment:os.version=2.6.32-573.el6.x86_64
21/01/01 17:24:54 INFO ZooKeeper: Client environment:user.name=cloudera
21/01/01 17:24:54 INFO ZooKeeper: Client environment:user.home=/home/cloudera
21/01/01 17:24:54 INFO ZooKeeper: Client environment:user.dir=/home/cloudera/IdeaProjects/SparkDataframeHBase
21/01/01 17:24:54 INFO ZooKeeper: Client environment:os.memory.free=240MB
21/01/01 17:24:54 INFO ZooKeeper: Client environment:os.memory.max=3545MB
21/01/01 17:24:54 INFO ZooKeeper: Client environment:os.memory.total=353MB
21/01/01 17:24:54 INFO ZooKeeper: Initiating client connection, connectString=127.0.0.1:2181 sessionTimeout=90000 watcher=org.apache.hadoop.hbase.zookeeper.ReadOnlyZKClient$$Lambda$17/1835364807@17006f1a
21/01/01 17:24:54 INFO X509Util: Setting -D jdk.tls.rejectClientInitiatedRenegotiation=true to disable client-initiated TLS renegotiation
21/01/01 17:24:54 INFO ClientCnxnSocket: jute.maxbuffer value is 4194304 Bytes
21/01/01 17:24:54 INFO ClientCnxn: zookeeper.request.timeout value is 0. feature enabled=
21/01/01 17:24:54 INFO ClientCnxn: Opening socket connection to server localhost/127.0.0.1:2181. Will not attempt to authenticate using SASL (unknown error)
21/01/01 17:24:54 INFO ClientCnxn: Socket connection established, initiating session, client: /127.0.0.1:40432, server: localhost/127.0.0.1:2181
21/01/01 17:24:54 INFO ClientCnxn: Session establishment complete on server localhost/127.0.0.1:2181, sessionid = 0x176c025b3b00011, negotiated timeout = 40000
21/01/01 17:24:57 INFO SparkContext: Starting job: show at SparkDataframeHBase.scala:99
21/01/01 17:24:57 INFO DAGScheduler: Got job 4 (show at SparkDataframeHBase.scala:99) with 1 output partitions
21/01/01 17:24:57 INFO DAGScheduler: Final stage: ResultStage 4 (show at SparkDataframeHBase.scala:99)
21/01/01 17:24:57 INFO DAGScheduler: Parents of final stage: List()
21/01/01 17:24:57 INFO DAGScheduler: Missing parents: List()
21/01/01 17:24:57 INFO DAGScheduler: Submitting ResultStage 4 (MapPartitionsRDD[11] at show at SparkDataframeHBase.scala:99), which has no missing parents
21/01/01 17:24:57 INFO MemoryStore: Block broadcast_5 stored as values in memory (estimated size 85.6 KB, free 1946.7 MB)
21/01/01 17:24:57 INFO MemoryStore: Block broadcast_5_piece0 stored as bytes in memory (estimated size 31.5 KB, free 1946.7 MB)
21/01/01 17:24:57 INFO BlockManagerInfo: Added broadcast_5_piece0 in memory on 192.168.173.137:45680 (size: 31.5 KB, free: 1947.0 MB)
21/01/01 17:24:57 INFO SparkContext: Created broadcast 5 from broadcast at DAGScheduler.scala:996
21/01/01 17:24:57 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 4 (MapPartitionsRDD[11] at show at SparkDataframeHBase.scala:99)
21/01/01 17:24:57 INFO TaskSchedulerImpl: Adding task set 4.0 with 1 tasks
21/01/01 17:24:57 INFO TaskSetManager: Starting task 0.0 in stage 4.0 (TID 10, localhost, executor driver, partition 0, ANY, 7515 bytes)
21/01/01 17:24:57 INFO Executor: Running task 0.0 in stage 4.0 (TID 10)
21/01/01 17:24:57 INFO HBaseTableScanRDD: returned 3 rows from hbase in 20 ms
21/01/01 17:24:57 INFO Executor: Finished task 0.0 in stage 4.0 (TID 10). 1512 bytes result sent to driver
21/01/01 17:24:57 INFO TaskSetManager: Finished task 0.0 in stage 4.0 (TID 10) in 140 ms on localhost (executor driver) (1/1)
21/01/01 17:24:57 INFO TaskSchedulerImpl: Removed TaskSet 4.0, whose tasks have all completed, from pool 
21/01/01 17:24:57 INFO DAGScheduler: ResultStage 4 (show at SparkDataframeHBase.scala:99) finished in 0.141 s
21/01/01 17:24:57 INFO DAGScheduler: Job 4 finished: show at SparkDataframeHBase.scala:99, took 0.245762 s
```
***Imported data from HBase table:***<br> 
*Collect and show Data from Dataframe*
```
+---+-------+--------+-----+-----------+--------+-----+-------+
|key|fName  |lName   |mName|addressLine|city    |state|zipCode|
+---+-------+--------+-----+-----------+--------+-----+-------+
|1  |Abby   |Smith   |K    |null       |Orlando |FL   |45235  |
|2  |Amaya  |Williams|L    |null       |Newark  |NJ   |27656  |
|3  |Alchemy|Davis   |P    |null       |San Jose|CA   |34789  |
+---+-------+--------+-----+-----------+--------+-----+-------+
```
```
21/01/01 17:24:57 INFO CodeGenerator: Code generated in 14.367789 ms
21/01/01 17:24:57 INFO SparkContext: Starting job: show at SparkDataframeHBase.scala:104
21/01/01 17:24:57 INFO DAGScheduler: Got job 5 (show at SparkDataframeHBase.scala:104) with 1 output partitions
21/01/01 17:24:57 INFO DAGScheduler: Final stage: ResultStage 5 (show at SparkDataframeHBase.scala:104)
21/01/01 17:24:57 INFO DAGScheduler: Parents of final stage: List()
21/01/01 17:24:57 INFO DAGScheduler: Missing parents: List()
21/01/01 17:24:57 INFO DAGScheduler: Submitting ResultStage 5 (MapPartitionsRDD[15] at show at SparkDataframeHBase.scala:104), which has no missing parents
21/01/01 17:24:57 INFO MemoryStore: Block broadcast_6 stored as values in memory (estimated size 85.8 KB, free 1946.6 MB)
21/01/01 17:24:57 INFO MemoryStore: Block broadcast_6_piece0 stored as bytes in memory (estimated size 31.6 KB, free 1946.6 MB)
21/01/01 17:24:57 INFO BlockManagerInfo: Added broadcast_6_piece0 in memory on 192.168.173.137:45680 (size: 31.6 KB, free: 1946.9 MB)
21/01/01 17:24:57 INFO SparkContext: Created broadcast 6 from broadcast at DAGScheduler.scala:996
21/01/01 17:24:57 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 5 (MapPartitionsRDD[15] at show at SparkDataframeHBase.scala:104)
21/01/01 17:24:57 INFO TaskSchedulerImpl: Adding task set 5.0 with 1 tasks
21/01/01 17:24:57 INFO TaskSetManager: Starting task 0.0 in stage 5.0 (TID 11, localhost, executor driver, partition 0, ANY, 7716 bytes)
21/01/01 17:24:57 INFO Executor: Running task 0.0 in stage 5.0 (TID 11)
21/01/01 17:24:59 INFO HBaseTableScanRDD: returned 1 rows from hbase in 157 ms
21/01/01 17:24:59 INFO Executor: Finished task 0.0 in stage 5.0 (TID 11). 1375 bytes result sent to driver
21/01/01 17:24:59 INFO TaskSetManager: Finished task 0.0 in stage 5.0 (TID 11) in 1659 ms on localhost (executor driver) (1/1)
21/01/01 17:24:59 INFO TaskSchedulerImpl: Removed TaskSet 5.0, whose tasks have all completed, from pool 
21/01/01 17:24:59 INFO DAGScheduler: ResultStage 5 (show at SparkDataframeHBase.scala:104) finished in 1.661 s
21/01/01 17:24:59 INFO DAGScheduler: Job 5 finished: show at SparkDataframeHBase.scala:104, took 1.730792 s
21/01/01 17:24:59 INFO CodeGenerator: Code generated in 18.197128 ms
```
***Applying filters:***<br> 
*(SQL like where clause)*
```
+---+-----+-----+
|key|fName|lName|
+---+-----+-----+
|  1| Abby|Smith|
+---+-----+-----+
```
```
21/01/01 17:24:59 INFO SparkSqlParser: Parsing command: employeeTable
21/01/01 17:24:59 INFO SparkSqlParser: Parsing command: select * from employeeTable where fName = 'Amaya' 
21/01/01 17:24:59 INFO CodeGenerator: Code generated in 18.973344 ms
21/01/01 17:24:59 INFO SparkContext: Starting job: show at SparkDataframeHBase.scala:110
21/01/01 17:24:59 INFO DAGScheduler: Got job 6 (show at SparkDataframeHBase.scala:110) with 1 output partitions
21/01/01 17:24:59 INFO DAGScheduler: Final stage: ResultStage 6 (show at SparkDataframeHBase.scala:110)
21/01/01 17:24:59 INFO DAGScheduler: Parents of final stage: List()
21/01/01 17:24:59 INFO DAGScheduler: Missing parents: List()
21/01/01 17:24:59 INFO DAGScheduler: Submitting ResultStage 6 (MapPartitionsRDD[20] at show at SparkDataframeHBase.scala:110), which has no missing parents
21/01/01 17:25:00 INFO MemoryStore: Block broadcast_7 stored as values in memory (estimated size 86.5 KB, free 1946.5 MB)
21/01/01 17:25:00 INFO MemoryStore: Block broadcast_7_piece0 stored as bytes in memory (estimated size 31.8 KB, free 1946.4 MB)
21/01/01 17:25:00 INFO BlockManagerInfo: Added broadcast_7_piece0 in memory on 192.168.173.137:45680 (size: 31.8 KB, free: 1946.9 MB)
21/01/01 17:25:00 INFO SparkContext: Created broadcast 7 from broadcast at DAGScheduler.scala:996
21/01/01 17:25:00 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 6 (MapPartitionsRDD[20] at show at SparkDataframeHBase.scala:110)
21/01/01 17:25:00 INFO TaskSchedulerImpl: Adding task set 6.0 with 1 tasks
21/01/01 17:25:00 INFO TaskSetManager: Starting task 0.0 in stage 6.0 (TID 12, localhost, executor driver, partition 0, ANY, 7618 bytes)
21/01/01 17:25:00 INFO Executor: Running task 0.0 in stage 6.0 (TID 12)
21/01/01 17:25:00 INFO HBaseTableScanRDD: returned 1 rows from hbase in 10 ms
21/01/01 17:25:00 INFO Executor: Finished task 0.0 in stage 6.0 (TID 12). 1436 bytes result sent to driver
21/01/01 17:25:00 INFO TaskSetManager: Finished task 0.0 in stage 6.0 (TID 12) in 30 ms on localhost (executor driver) (1/1)
21/01/01 17:25:00 INFO TaskSchedulerImpl: Removed TaskSet 6.0, whose tasks have all completed, from pool 
21/01/01 17:25:00 INFO DAGScheduler: ResultStage 6 (show at SparkDataframeHBase.scala:110) finished in 0.031 s
```
**Run SQL query<br>**
*spark.sql("select * from employeeTable where fName = 'Amaya' ").show*
```
+---+-----+--------+-----+-----------+------+-----+-------+
|key|fName|   lName|mName|addressLine|  city|state|zipCode|
+---+-----+--------+-----+-----------+------+-----+-------+
|  2|Amaya|Williams|    L|       null|Newark|   NJ|  27656|
+---+-----+--------+-----+-----------+------+-----+-------+
```
```
21/01/01 17:25:00 INFO DAGScheduler: Job 6 finished: show at SparkDataframeHBase.scala:110, took 0.527296 s
21/01/01 17:25:55 INFO ZooKeeper: Session: 0x176c025b3b00011 closed
21/01/01 17:25:55 INFO ClientCnxn: EventThread shut down for session: 0x176c025b3b00011
21/01/01 17:26:01 INFO SparkContext: Invoking stop() from shutdown hook
21/01/01 17:26:01 INFO SparkUI: Stopped Spark web UI at http://192.168.173.137:4040
21/01/01 17:26:01 INFO MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
21/01/01 17:26:01 INFO MemoryStore: MemoryStore cleared
21/01/01 17:26:01 INFO BlockManager: BlockManager stopped
21/01/01 17:26:01 INFO BlockManagerMaster: BlockManagerMaster stopped
21/01/01 17:26:01 INFO OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
21/01/01 17:26:01 INFO SparkContext: Successfully stopped SparkContext
21/01/01 17:26:01 INFO ShutdownHookManager: Shutdown hook called
21/01/01 17:26:01 INFO ShutdownHookManager: Deleting directory /tmp/spark-13b52ebd-d4eb-4954-92b3-d6874331468d

Process finished with exit code 0
```