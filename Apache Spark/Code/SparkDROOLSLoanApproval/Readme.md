## Spark DROOLS integration setting up

Mauro Travieso Pena

---
Integrating **Spark** and **DROOLS**, and processing rules applied to input **.csv** file data.

***Spark Application:*** Spark JBoss DROOLS rules integration
     
                      Input  ->   .csv file
         Seq Data Structure  ->   fields filled with RDD
           Rules applied to  ->   CreditScore field
     Filtering according to  ->   APPROVED and NOT APPROVED
 
***Important note:** It is required Ultimate Edition to run it in IntelliJ IDE*

---
**Output:**
```
/home/mauro/MUM/Technologies/IntelliJ/Idea-IU-201.7223.91/jbr/bin/java...
Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
20/12/24 18:19:45 INFO SparkContext: Running Spark version 2.2.0
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.apache.hadoop.security.authentication.util.KerberosUtil (file:/home/mauro/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar) to method sun.security.krb5.Config.getInstance()
WARNING: Please consider reporting this to the maintainers of org.apache.hadoop.security.authentication.util.KerberosUtil
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
20/12/24 18:19:46 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
20/12/24 18:19:46 WARN Utils: Your hostname, mauro resolves to a loopback address: 127.0.1.1; using 192.168.2.164 instead (on interface wlp2s0)
20/12/24 18:19:46 WARN Utils: Set SPARK_LOCAL_IP if you need to bind to another address
20/12/24 18:19:46 INFO SparkContext: Submitted application: LoanApplicants
20/12/24 18:19:46 INFO SecurityManager: Changing view acls to: mauro
20/12/24 18:19:46 INFO SecurityManager: Changing modify acls to: mauro
20/12/24 18:19:46 INFO SecurityManager: Changing view acls groups to: 
20/12/24 18:19:46 INFO SecurityManager: Changing modify acls groups to: 
20/12/24 18:19:46 INFO SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(mauro); groups with view permissions: Set(); users  with modify permissions: Set(mauro); groups with modify permissions: Set()
20/12/24 18:19:46 INFO Utils: Successfully started service 'sparkDriver' on port 35691.
20/12/24 18:19:46 INFO SparkEnv: Registering MapOutputTracker
20/12/24 18:19:46 INFO SparkEnv: Registering BlockManagerMaster
20/12/24 18:19:46 INFO BlockManagerMasterEndpoint: Using org.apache.spark.storage.DefaultTopologyMapper for getting topology information
20/12/24 18:19:46 INFO BlockManagerMasterEndpoint: BlockManagerMasterEndpoint up
20/12/24 18:19:46 INFO DiskBlockManager: Created local directory at /tmp/blockmgr-527110ce-5e3b-47e6-bbf8-142c58f957ed
20/12/24 18:19:46 INFO MemoryStore: MemoryStore started with capacity 4.5 GB
20/12/24 18:19:46 INFO SparkEnv: Registering OutputCommitCoordinator
20/12/24 18:19:47 INFO Utils: Successfully started service 'SparkUI' on port 4040.
20/12/24 18:19:47 INFO SparkUI: Bound SparkUI to 0.0.0.0, and started at http://192.168.2.164:4040
20/12/24 18:19:47 INFO Executor: Starting executor ID driver on host localhost
20/12/24 18:19:47 INFO Utils: Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 40367.
20/12/24 18:19:47 INFO NettyBlockTransferService: Server created on 192.168.2.164:40367
20/12/24 18:19:47 INFO BlockManager: Using org.apache.spark.storage.RandomBlockReplicationPolicy for block replication policy
20/12/24 18:19:47 INFO BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 192.168.2.164, 40367, None)
20/12/24 18:19:47 INFO BlockManagerMasterEndpoint: Registering block manager 192.168.2.164:40367 with 4.5 GB RAM, BlockManagerId(driver, 192.168.2.164, 40367, None)
20/12/24 18:19:47 INFO BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 192.168.2.164, 40367, None)
20/12/24 18:19:47 INFO BlockManager: Initialized BlockManager: BlockManagerId(driver, 192.168.2.164, 40367, None)
20/12/24 18:19:47 INFO SharedState: Setting hive.metastore.warehouse.dir ('null') to the value of spark.sql.warehouse.dir ('file:/home/mauro/MUM/SparkProjets/Code/LoanApprovalSparkDROLLS/spark-warehouse/').
20/12/24 18:19:47 INFO SharedState: Warehouse path is 'file:/home/mauro/MUM/SparkProjets/Code/LoanApprovalSparkDROLLS/spark-warehouse/'.
20/12/24 18:19:48 INFO StateStoreCoordinatorRef: Registered StateStoreCoordinator endpoint
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Loading kie.conf from  jar:file:/home/mauro/.m2/repository/org/drools/drools-core/7.17.0.Final/drools-core-7.17.0.Final.jar!/META-INF/kie.conf in classloader jdk.internal.loader.ClassLoaders$AppClassLoader@9e89d68
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Adding Service org.drools.core.io.impl.ResourceFactoryServiceImpl
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Adding Service org.drools.core.marshalling.impl.MarshallerProviderImpl
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Adding Service org.drools.core.concurrent.ExecutorProviderImpl
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Loading kie.conf from  jar:file:/home/mauro/.m2/repository/org/kie/kie-internal/7.17.0.Final/kie-internal-7.17.0.Final.jar!/META-INF/kie.conf in classloader jdk.internal.loader.ClassLoaders$AppClassLoader@9e89d68
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Adding Service org.kie.internal.services.KieAssemblersImpl
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Adding Service org.kie.internal.services.KieRuntimesImpl
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Adding Service org.kie.internal.services.KieWeaversImpl
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Adding Service org.kie.internal.services.KieBeliefsImpl
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Loading kie.conf from  jar:file:/home/mauro/.m2/repository/org/drools/drools-compiler/7.17.0.Final/drools-compiler-7.17.0.Final.jar!/META-INF/kie.conf in classloader jdk.internal.loader.ClassLoaders$AppClassLoader@9e89d68
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Adding Service org.drools.compiler.kie.builder.impl.KieServicesImpl
20/12/24 18:19:48 INFO ServiceDiscoveryImpl: Adding Service org.drools.compiler.builder.impl.KnowledgeBuilderFactoryServiceImpl
20/12/24 18:19:48 INFO ClasspathKieProject: Found kmodule: file:/home/mauro/MUM/SparkProjets/Code/LoanApprovalSparkDROLLS/target/classes/META-INF/kmodule.xml
20/12/24 18:19:48 WARN ClasspathKieProject: Unable to find pom.properties in /home/mauro/MUM/SparkProjets/Code/LoanApprovalSparkDROLLS/target/classes
20/12/24 18:19:48 INFO ClasspathKieProject: Recursed up folders, found and used pom.xml /home/mauro/MUM/SparkProjets/Code/LoanApprovalSparkDROLLS/pom.xml
20/12/24 18:19:48 INFO KieRepositoryImpl: KieModule was added: FileKieModule[releaseId=org.example:LoanApprovalSparkDROLLS:1.0-SNAPSHOT,file=/home/mauro/MUM/SparkProjets/Code/LoanApprovalSparkDROLLS/target/classes]
20/12/24 18:19:49 INFO MemoryStore: Block broadcast_0 stored as values in memory (estimated size 119.4 KB, free 4.5 GB)
20/12/24 18:19:49 INFO MemoryStore: Block broadcast_0_piece0 stored as bytes in memory (estimated size 16.1 KB, free 4.5 GB)
20/12/24 18:19:49 INFO BlockManagerInfo: Added broadcast_0_piece0 in memory on 192.168.2.164:40367 (size: 16.1 KB, free: 4.5 GB)
20/12/24 18:19:49 INFO SparkContext: Created broadcast 0 from broadcast at App.scala:39
20/12/24 18:19:49 INFO App: list of all applicants org.apache.spark.rdd.ParallelCollectionRDD
20/12/24 18:19:51 INFO CodeGenerator: Code generated in 183.082372 ms
20/12/24 18:19:51 INFO SparkContext: Starting job: show at App.scala:47
20/12/24 18:19:51 INFO DAGScheduler: Got job 0 (show at App.scala:47) with 1 output partitions
20/12/24 18:19:51 INFO DAGScheduler: Final stage: ResultStage 0 (show at App.scala:47)
20/12/24 18:19:51 INFO DAGScheduler: Parents of final stage: List()
20/12/24 18:19:51 INFO DAGScheduler: Missing parents: List()
20/12/24 18:19:51 INFO DAGScheduler: Submitting ResultStage 0 (MapPartitionsRDD[3] at show at App.scala:47), which has no missing parents
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_1 stored as values in memory (estimated size 9.7 KB, free 4.5 GB)
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_1_piece0 stored as bytes in memory (estimated size 4.1 KB, free 4.5 GB)
20/12/24 18:19:51 INFO BlockManagerInfo: Added broadcast_1_piece0 in memory on 192.168.2.164:40367 (size: 4.1 KB, free: 4.5 GB)
20/12/24 18:19:51 INFO SparkContext: Created broadcast 1 from broadcast at DAGScheduler.scala:1006
20/12/24 18:19:51 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 0 (MapPartitionsRDD[3] at show at App.scala:47) (first 15 tasks are for partitions Vector(0))
20/12/24 18:19:51 INFO TaskSchedulerImpl: Adding task set 0.0 with 1 tasks
20/12/24 18:19:51 INFO TaskSetManager: Starting task 0.0 in stage 0.0 (TID 0, localhost, executor driver, partition 0, PROCESS_LOCAL, 5036 bytes)
20/12/24 18:19:51 INFO Executor: Running task 0.0 in stage 0.0 (TID 0)
20/12/24 18:19:51 INFO Executor: Finished task 0.0 in stage 0.0 (TID 0). 1196 bytes result sent to driver
20/12/24 18:19:51 INFO TaskSetManager: Finished task 0.0 in stage 0.0 (TID 0) in 97 ms on localhost (executor driver) (1/1)
20/12/24 18:19:51 INFO TaskSchedulerImpl: Removed TaskSet 0.0, whose tasks have all completed, from pool 
20/12/24 18:19:51 INFO DAGScheduler: ResultStage 0 (show at App.scala:47) finished in 0.113 s
20/12/24 18:19:51 INFO DAGScheduler: Job 0 finished: show at App.scala:47, took 0.185885 s
20/12/24 18:19:51 INFO SparkContext: Starting job: show at App.scala:47
20/12/24 18:19:51 INFO DAGScheduler: Got job 1 (show at App.scala:47) with 4 output partitions
20/12/24 18:19:51 INFO DAGScheduler: Final stage: ResultStage 1 (show at App.scala:47)
20/12/24 18:19:51 INFO DAGScheduler: Parents of final stage: List()
20/12/24 18:19:51 INFO DAGScheduler: Missing parents: List()
20/12/24 18:19:51 INFO DAGScheduler: Submitting ResultStage 1 (MapPartitionsRDD[3] at show at App.scala:47), which has no missing parents
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_2 stored as values in memory (estimated size 9.7 KB, free 4.5 GB)
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_2_piece0 stored as bytes in memory (estimated size 4.1 KB, free 4.5 GB)
20/12/24 18:19:51 INFO BlockManagerInfo: Added broadcast_2_piece0 in memory on 192.168.2.164:40367 (size: 4.1 KB, free: 4.5 GB)
20/12/24 18:19:51 INFO SparkContext: Created broadcast 2 from broadcast at DAGScheduler.scala:1006
20/12/24 18:19:51 INFO DAGScheduler: Submitting 4 missing tasks from ResultStage 1 (MapPartitionsRDD[3] at show at App.scala:47) (first 15 tasks are for partitions Vector(1, 2, 3, 4))
20/12/24 18:19:51 INFO TaskSchedulerImpl: Adding task set 1.0 with 4 tasks
20/12/24 18:19:51 INFO TaskSetManager: Starting task 0.0 in stage 1.0 (TID 1, localhost, executor driver, partition 1, PROCESS_LOCAL, 5040 bytes)
20/12/24 18:19:51 INFO TaskSetManager: Starting task 1.0 in stage 1.0 (TID 2, localhost, executor driver, partition 2, PROCESS_LOCAL, 5035 bytes)
20/12/24 18:19:51 INFO TaskSetManager: Starting task 2.0 in stage 1.0 (TID 3, localhost, executor driver, partition 3, PROCESS_LOCAL, 5078 bytes)
20/12/24 18:19:51 INFO TaskSetManager: Starting task 3.0 in stage 1.0 (TID 4, localhost, executor driver, partition 4, PROCESS_LOCAL, 5040 bytes)
20/12/24 18:19:51 INFO Executor: Running task 0.0 in stage 1.0 (TID 1)
20/12/24 18:19:51 INFO Executor: Running task 1.0 in stage 1.0 (TID 2)
20/12/24 18:19:51 INFO Executor: Running task 2.0 in stage 1.0 (TID 3)
20/12/24 18:19:51 INFO Executor: Running task 3.0 in stage 1.0 (TID 4)
20/12/24 18:19:51 INFO Executor: Finished task 0.0 in stage 1.0 (TID 1). 1202 bytes result sent to driver
20/12/24 18:19:51 INFO Executor: Finished task 1.0 in stage 1.0 (TID 2). 1185 bytes result sent to driver
20/12/24 18:19:51 INFO Executor: Finished task 2.0 in stage 1.0 (TID 3). 1221 bytes result sent to driver
20/12/24 18:19:51 INFO Executor: Finished task 3.0 in stage 1.0 (TID 4). 1197 bytes result sent to driver
20/12/24 18:19:51 INFO TaskSetManager: Finished task 0.0 in stage 1.0 (TID 1) in 18 ms on localhost (executor driver) (1/4)
20/12/24 18:19:51 INFO TaskSetManager: Finished task 1.0 in stage 1.0 (TID 2) in 20 ms on localhost (executor driver) (2/4)
20/12/24 18:19:51 INFO TaskSetManager: Finished task 2.0 in stage 1.0 (TID 3) in 19 ms on localhost (executor driver) (3/4)
20/12/24 18:19:51 INFO TaskSetManager: Finished task 3.0 in stage 1.0 (TID 4) in 18 ms on localhost (executor driver) (4/4)
20/12/24 18:19:51 INFO TaskSchedulerImpl: Removed TaskSet 1.0, whose tasks have all completed, from pool 
20/12/24 18:19:51 INFO DAGScheduler: ResultStage 1 (show at App.scala:47) finished in 0.022 s
20/12/24 18:19:51 INFO DAGScheduler: Job 1 finished: show at App.scala:47, took 0.037008 s
20/12/24 18:19:51 INFO SparkContext: Starting job: show at App.scala:47
20/12/24 18:19:51 INFO DAGScheduler: Got job 2 (show at App.scala:47) with 3 output partitions
20/12/24 18:19:51 INFO DAGScheduler: Final stage: ResultStage 2 (show at App.scala:47)
20/12/24 18:19:51 INFO DAGScheduler: Parents of final stage: List()
20/12/24 18:19:51 INFO DAGScheduler: Missing parents: List()
20/12/24 18:19:51 INFO DAGScheduler: Submitting ResultStage 2 (MapPartitionsRDD[3] at show at App.scala:47), which has no missing parents
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_3 stored as values in memory (estimated size 9.7 KB, free 4.5 GB)
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_3_piece0 stored as bytes in memory (estimated size 4.1 KB, free 4.5 GB)
20/12/24 18:19:51 INFO BlockManagerInfo: Added broadcast_3_piece0 in memory on 192.168.2.164:40367 (size: 4.1 KB, free: 4.5 GB)
20/12/24 18:19:51 INFO SparkContext: Created broadcast 3 from broadcast at DAGScheduler.scala:1006
20/12/24 18:19:51 INFO DAGScheduler: Submitting 3 missing tasks from ResultStage 2 (MapPartitionsRDD[3] at show at App.scala:47) (first 15 tasks are for partitions Vector(5, 6, 7))
20/12/24 18:19:51 INFO TaskSchedulerImpl: Adding task set 2.0 with 3 tasks
20/12/24 18:19:51 INFO TaskSetManager: Starting task 0.0 in stage 2.0 (TID 5, localhost, executor driver, partition 5, PROCESS_LOCAL, 5030 bytes)
20/12/24 18:19:51 INFO TaskSetManager: Starting task 1.0 in stage 2.0 (TID 6, localhost, executor driver, partition 6, PROCESS_LOCAL, 5036 bytes)
20/12/24 18:19:51 INFO TaskSetManager: Starting task 2.0 in stage 2.0 (TID 7, localhost, executor driver, partition 7, PROCESS_LOCAL, 5089 bytes)
20/12/24 18:19:51 INFO Executor: Running task 0.0 in stage 2.0 (TID 5)
20/12/24 18:19:51 INFO Executor: Running task 1.0 in stage 2.0 (TID 6)
20/12/24 18:19:51 INFO Executor: Running task 2.0 in stage 2.0 (TID 7)
20/12/24 18:19:51 INFO Executor: Finished task 2.0 in stage 2.0 (TID 7). 1265 bytes result sent to driver
20/12/24 18:19:51 INFO Executor: Finished task 1.0 in stage 2.0 (TID 6). 1201 bytes result sent to driver
20/12/24 18:19:51 INFO Executor: Finished task 0.0 in stage 2.0 (TID 5). 1176 bytes result sent to driver
20/12/24 18:19:51 INFO TaskSetManager: Finished task 2.0 in stage 2.0 (TID 7) in 12 ms on localhost (executor driver) (1/3)
20/12/24 18:19:51 INFO TaskSetManager: Finished task 0.0 in stage 2.0 (TID 5) in 13 ms on localhost (executor driver) (2/3)
20/12/24 18:19:51 INFO TaskSetManager: Finished task 1.0 in stage 2.0 (TID 6) in 12 ms on localhost (executor driver) (3/3)
20/12/24 18:19:51 INFO TaskSchedulerImpl: Removed TaskSet 2.0, whose tasks have all completed, from pool 
20/12/24 18:19:51 INFO DAGScheduler: ResultStage 2 (show at App.scala:47) finished in 0.015 s
20/12/24 18:19:51 INFO DAGScheduler: Job 2 finished: show at App.scala:47, took 0.026422 s
20/12/24 18:19:51 INFO CodeGenerator: Code generated in 13.778255 ms
```
```
+---+----------+-----------+-------------+-----------+
|id |firstName |lastName   |requestAmount|creditScore|
+---+----------+-----------+-------------+-----------+
|1  |Ram       |Ghadiyaram |680          |680        |
|2  |Mohd      |Ismail     |12000        |679        |
|3  |Phani     |Ramavajjala|100          |600        |
|4  |Trump     |Donald     |1000000      |788        |
|5  |Nick      |Suizo      |10           |788        |
|6  |Mauro     |Travieso   |15000        |690        |
|7  |Sreenath  |Mamilla    |10           |788        |
|8  |Naveed    |Farroqui   |10           |788        |
|9  |Ashish    |Anand      |1000         |788        |
|10 |Vasudha   |Nanduri    |1001         |788        |
|11 |Tathagatha|das        |1002         |788        |
|12 |Sean      |Owen       |1003         |788        |
|13 |Sandy     |Raza       |1004         |788        |
|14 |Holden    |Karau      |1005         |788        |
|15 |Gobinathan|SP         |1005         |7          |
|16 |Arindam   |SenGupta   |1005         |670        |
|17 |NIKHIL    |POTLAPALLY |100          |670        |
|18 |Phanindra |Ramavojjala|100          |671        |
+---+----------+-----------+-------------+-----------+
```
```
20/12/24 18:19:51 INFO App: approvedguys org.apache.spark.rdd.MapPartitionsRDD
20/12/24 18:19:51 INFO CodeGenerator: Code generated in 22.155943 ms
20/12/24 18:19:51 INFO SparkContext: Starting job: show at App.scala:60
20/12/24 18:19:51 INFO DAGScheduler: Got job 3 (show at App.scala:60) with 1 output partitions
20/12/24 18:19:51 INFO DAGScheduler: Final stage: ResultStage 3 (show at App.scala:60)
20/12/24 18:19:51 INFO DAGScheduler: Parents of final stage: List()
20/12/24 18:19:51 INFO DAGScheduler: Missing parents: List()
20/12/24 18:19:51 INFO DAGScheduler: Submitting ResultStage 3 (MapPartitionsRDD[8] at show at App.scala:60), which has no missing parents
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_4 stored as values in memory (estimated size 11.3 KB, free 4.5 GB)
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_4_piece0 stored as bytes in memory (estimated size 4.7 KB, free 4.5 GB)
20/12/24 18:19:51 INFO BlockManagerInfo: Added broadcast_4_piece0 in memory on 192.168.2.164:40367 (size: 4.7 KB, free: 4.5 GB)
20/12/24 18:19:51 INFO SparkContext: Created broadcast 4 from broadcast at DAGScheduler.scala:1006
20/12/24 18:19:51 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 3 (MapPartitionsRDD[8] at show at App.scala:60) (first 15 tasks are for partitions Vector(0))
20/12/24 18:19:51 INFO TaskSchedulerImpl: Adding task set 3.0 with 1 tasks
20/12/24 18:19:51 INFO TaskSetManager: Starting task 0.0 in stage 3.0 (TID 8, localhost, executor driver, partition 0, PROCESS_LOCAL, 5036 bytes)
20/12/24 18:19:51 INFO Executor: Running task 0.0 in stage 3.0 (TID 8)
20/12/24 18:19:51 INFO Executor: Finished task 0.0 in stage 3.0 (TID 8). 1237 bytes result sent to driver
20/12/24 18:19:51 INFO TaskSetManager: Finished task 0.0 in stage 3.0 (TID 8) in 82 ms on localhost (executor driver) (1/1)
20/12/24 18:19:51 INFO TaskSchedulerImpl: Removed TaskSet 3.0, whose tasks have all completed, from pool 
20/12/24 18:19:51 INFO DAGScheduler: ResultStage 3 (show at App.scala:60) finished in 0.083 s
20/12/24 18:19:51 INFO DAGScheduler: Job 3 finished: show at App.scala:60, took 0.094573 s
20/12/24 18:19:51 INFO SparkContext: Starting job: show at App.scala:60
20/12/24 18:19:51 INFO DAGScheduler: Got job 4 (show at App.scala:60) with 4 output partitions
20/12/24 18:19:51 INFO DAGScheduler: Final stage: ResultStage 4 (show at App.scala:60)
20/12/24 18:19:51 INFO DAGScheduler: Parents of final stage: List()
20/12/24 18:19:51 INFO DAGScheduler: Missing parents: List()
20/12/24 18:19:51 INFO DAGScheduler: Submitting ResultStage 4 (MapPartitionsRDD[8] at show at App.scala:60), which has no missing parents
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_5 stored as values in memory (estimated size 11.3 KB, free 4.5 GB)
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_5_piece0 stored as bytes in memory (estimated size 4.7 KB, free 4.5 GB)
20/12/24 18:19:51 INFO BlockManagerInfo: Added broadcast_5_piece0 in memory on 192.168.2.164:40367 (size: 4.7 KB, free: 4.5 GB)
20/12/24 18:19:51 INFO SparkContext: Created broadcast 5 from broadcast at DAGScheduler.scala:1006
20/12/24 18:19:51 INFO DAGScheduler: Submitting 4 missing tasks from ResultStage 4 (MapPartitionsRDD[8] at show at App.scala:60) (first 15 tasks are for partitions Vector(1, 2, 3, 4))
20/12/24 18:19:51 INFO TaskSchedulerImpl: Adding task set 4.0 with 4 tasks
20/12/24 18:19:51 INFO TaskSetManager: Starting task 0.0 in stage 4.0 (TID 9, localhost, executor driver, partition 1, PROCESS_LOCAL, 5040 bytes)
20/12/24 18:19:51 INFO TaskSetManager: Starting task 1.0 in stage 4.0 (TID 10, localhost, executor driver, partition 2, PROCESS_LOCAL, 5035 bytes)
20/12/24 18:19:51 INFO TaskSetManager: Starting task 2.0 in stage 4.0 (TID 11, localhost, executor driver, partition 3, PROCESS_LOCAL, 5078 bytes)
20/12/24 18:19:51 INFO TaskSetManager: Starting task 3.0 in stage 4.0 (TID 12, localhost, executor driver, partition 4, PROCESS_LOCAL, 5040 bytes)
20/12/24 18:19:51 INFO Executor: Running task 0.0 in stage 4.0 (TID 9)
20/12/24 18:19:51 INFO Executor: Running task 3.0 in stage 4.0 (TID 12)
20/12/24 18:19:51 INFO Executor: Running task 2.0 in stage 4.0 (TID 11)
20/12/24 18:19:51 INFO Executor: Running task 1.0 in stage 4.0 (TID 10)
20/12/24 18:19:51 INFO Executor: Finished task 0.0 in stage 4.0 (TID 9). 1281 bytes result sent to driver
20/12/24 18:19:51 INFO TaskSetManager: Finished task 0.0 in stage 4.0 (TID 9) in 11 ms on localhost (executor driver) (1/4)
20/12/24 18:19:51 INFO Executor: Finished task 3.0 in stage 4.0 (TID 12). 1291 bytes result sent to driver
20/12/24 18:19:51 INFO TaskSetManager: Finished task 3.0 in stage 4.0 (TID 12) in 12 ms on localhost (executor driver) (2/4)
20/12/24 18:19:51 INFO Executor: Finished task 2.0 in stage 4.0 (TID 11). 1318 bytes result sent to driver
20/12/24 18:19:51 INFO TaskSetManager: Finished task 2.0 in stage 4.0 (TID 11) in 13 ms on localhost (executor driver) (3/4)
20/12/24 18:19:51 INFO Executor: Finished task 1.0 in stage 4.0 (TID 10). 1285 bytes result sent to driver
20/12/24 18:19:51 INFO TaskSetManager: Finished task 1.0 in stage 4.0 (TID 10) in 15 ms on localhost (executor driver) (4/4)
20/12/24 18:19:51 INFO TaskSchedulerImpl: Removed TaskSet 4.0, whose tasks have all completed, from pool 
20/12/24 18:19:51 INFO DAGScheduler: ResultStage 4 (show at App.scala:60) finished in 0.017 s
20/12/24 18:19:51 INFO DAGScheduler: Job 4 finished: show at App.scala:60, took 0.026919 s
20/12/24 18:19:51 INFO SparkContext: Starting job: show at App.scala:60
20/12/24 18:19:51 INFO DAGScheduler: Got job 5 (show at App.scala:60) with 3 output partitions
20/12/24 18:19:51 INFO DAGScheduler: Final stage: ResultStage 5 (show at App.scala:60)
20/12/24 18:19:51 INFO DAGScheduler: Parents of final stage: List()
20/12/24 18:19:51 INFO DAGScheduler: Missing parents: List()
20/12/24 18:19:51 INFO DAGScheduler: Submitting ResultStage 5 (MapPartitionsRDD[8] at show at App.scala:60), which has no missing parents
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_6 stored as values in memory (estimated size 11.3 KB, free 4.5 GB)
20/12/24 18:19:51 INFO MemoryStore: Block broadcast_6_piece0 stored as bytes in memory (estimated size 4.7 KB, free 4.5 GB)
20/12/24 18:19:52 INFO BlockManagerInfo: Added broadcast_6_piece0 in memory on 192.168.2.164:40367 (size: 4.7 KB, free: 4.5 GB)
20/12/24 18:19:52 INFO SparkContext: Created broadcast 6 from broadcast at DAGScheduler.scala:1006
20/12/24 18:19:52 INFO DAGScheduler: Submitting 3 missing tasks from ResultStage 5 (MapPartitionsRDD[8] at show at App.scala:60) (first 15 tasks are for partitions Vector(5, 6, 7))
20/12/24 18:19:52 INFO TaskSchedulerImpl: Adding task set 5.0 with 3 tasks
20/12/24 18:19:52 INFO TaskSetManager: Starting task 0.0 in stage 5.0 (TID 13, localhost, executor driver, partition 5, PROCESS_LOCAL, 5030 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 1.0 in stage 5.0 (TID 14, localhost, executor driver, partition 6, PROCESS_LOCAL, 5036 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 2.0 in stage 5.0 (TID 15, localhost, executor driver, partition 7, PROCESS_LOCAL, 5089 bytes)
20/12/24 18:19:52 INFO Executor: Running task 0.0 in stage 5.0 (TID 13)
20/12/24 18:19:52 INFO Executor: Running task 1.0 in stage 5.0 (TID 14)
20/12/24 18:19:52 INFO Executor: Running task 2.0 in stage 5.0 (TID 15)
20/12/24 18:19:52 INFO Executor: Finished task 0.0 in stage 5.0 (TID 13). 1274 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 0.0 in stage 5.0 (TID 13) in 11 ms on localhost (executor driver) (1/3)
20/12/24 18:19:52 INFO Executor: Finished task 2.0 in stage 5.0 (TID 15). 1093 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 2.0 in stage 5.0 (TID 15) in 14 ms on localhost (executor driver) (2/3)
20/12/24 18:19:52 INFO Executor: Finished task 1.0 in stage 5.0 (TID 14). 1237 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 1.0 in stage 5.0 (TID 14) in 20 ms on localhost (executor driver) (3/3)
20/12/24 18:19:52 INFO TaskSchedulerImpl: Removed TaskSet 5.0, whose tasks have all completed, from pool 
20/12/24 18:19:52 INFO DAGScheduler: ResultStage 5 (show at App.scala:60) finished in 0.021 s
20/12/24 18:19:52 INFO DAGScheduler: Job 5 finished: show at App.scala:60, took 0.035748 s
20/12/24 18:19:52 INFO CodeGenerator: Code generated in 17.773644 ms
20/12/24 18:19:52 INFO SparkContext: Starting job: count at App.scala:62
20/12/24 18:19:52 INFO DAGScheduler: Got job 6 (count at App.scala:62) with 8 output partitions
20/12/24 18:19:52 INFO DAGScheduler: Final stage: ResultStage 6 (count at App.scala:62)
20/12/24 18:19:52 INFO DAGScheduler: Parents of final stage: List()
20/12/24 18:19:52 INFO DAGScheduler: Missing parents: List()
20/12/24 18:19:52 INFO DAGScheduler: Submitting ResultStage 6 (MapPartitionsRDD[5] at filter at App.scala:58), which has no missing parents
20/12/24 18:19:52 INFO MemoryStore: Block broadcast_7 stored as values in memory (estimated size 2.7 KB, free 4.5 GB)
20/12/24 18:19:52 INFO MemoryStore: Block broadcast_7_piece0 stored as bytes in memory (estimated size 1671.0 B, free 4.5 GB)
20/12/24 18:19:52 INFO BlockManagerInfo: Added broadcast_7_piece0 in memory on 192.168.2.164:40367 (size: 1671.0 B, free: 4.5 GB)
20/12/24 18:19:52 INFO SparkContext: Created broadcast 7 from broadcast at DAGScheduler.scala:1006
20/12/24 18:19:52 INFO DAGScheduler: Submitting 8 missing tasks from ResultStage 6 (MapPartitionsRDD[5] at filter at App.scala:58) (first 15 tasks are for partitions Vector(0, 1, 2, 3, 4, 5, 6, 7))
20/12/24 18:19:52 INFO TaskSchedulerImpl: Adding task set 6.0 with 8 tasks
```
```
+---+----------+----------+-------------+-----------+------------------------------------------------------------------------------------+
|id |firstName |lastName  |requestAmount|creditScore|Remarks                                                                             |
+---+----------+----------+-------------+-----------+------------------------------------------------------------------------------------+
|1  |Ram       |Ghadiyaram|680          |680        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
|4  |Trump     |Donald    |1000000      |788        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
|5  |Nick      |Suizo     |10           |788        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
|6  |Mauro     |Travieso  |15000        |690        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
|7  |Sreenath  |Mamilla   |10           |788        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
|8  |Naveed    |Farroqui  |10           |788        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
|9  |Ashish    |Anand     |1000         |788        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
|10 |Vasudha   |Nanduri   |1001         |788        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
|11 |Tathagatha|das       |1002         |788        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
|12 |Sean      |Owen      |1003         |788        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
|13 |Sandy     |Raza      |1004         |788        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
|14 |Holden    |Karau     |1005         |788        |Good Going!! your credit score =>680 check your score in https://www.creditkarma.com|
+---+----------+----------+-------------+-----------+------------------------------------------------------------------------------------+
```
```
20/12/24 18:19:52 INFO TaskSetManager: Starting task 0.0 in stage 6.0 (TID 16, localhost, executor driver, partition 0, PROCESS_LOCAL, 5036 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 1.0 in stage 6.0 (TID 17, localhost, executor driver, partition 1, PROCESS_LOCAL, 5040 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 2.0 in stage 6.0 (TID 18, localhost, executor driver, partition 2, PROCESS_LOCAL, 5035 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 3.0 in stage 6.0 (TID 19, localhost, executor driver, partition 3, PROCESS_LOCAL, 5078 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 4.0 in stage 6.0 (TID 20, localhost, executor driver, partition 4, PROCESS_LOCAL, 5040 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 5.0 in stage 6.0 (TID 21, localhost, executor driver, partition 5, PROCESS_LOCAL, 5030 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 6.0 in stage 6.0 (TID 22, localhost, executor driver, partition 6, PROCESS_LOCAL, 5036 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 7.0 in stage 6.0 (TID 23, localhost, executor driver, partition 7, PROCESS_LOCAL, 5089 bytes)
20/12/24 18:19:52 INFO Executor: Running task 2.0 in stage 6.0 (TID 18)
20/12/24 18:19:52 INFO Executor: Running task 0.0 in stage 6.0 (TID 16)
20/12/24 18:19:52 INFO Executor: Running task 1.0 in stage 6.0 (TID 17)
20/12/24 18:19:52 INFO Executor: Running task 3.0 in stage 6.0 (TID 19)
20/12/24 18:19:52 INFO Executor: Running task 4.0 in stage 6.0 (TID 20)
20/12/24 18:19:52 INFO Executor: Finished task 2.0 in stage 6.0 (TID 18). 746 bytes result sent to driver
20/12/24 18:19:52 INFO Executor: Finished task 0.0 in stage 6.0 (TID 16). 746 bytes result sent to driver
20/12/24 18:19:52 INFO Executor: Finished task 4.0 in stage 6.0 (TID 20). 746 bytes result sent to driver
20/12/24 18:19:52 INFO Executor: Finished task 3.0 in stage 6.0 (TID 19). 746 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 2.0 in stage 6.0 (TID 18) in 29 ms on localhost (executor driver) (1/8)
20/12/24 18:19:52 INFO Executor: Running task 6.0 in stage 6.0 (TID 22)
20/12/24 18:19:52 INFO TaskSetManager: Finished task 4.0 in stage 6.0 (TID 20) in 29 ms on localhost (executor driver) (2/8)
20/12/24 18:19:52 INFO TaskSetManager: Finished task 0.0 in stage 6.0 (TID 16) in 32 ms on localhost (executor driver) (3/8)
20/12/24 18:19:52 INFO TaskSetManager: Finished task 3.0 in stage 6.0 (TID 19) in 33 ms on localhost (executor driver) (4/8)
20/12/24 18:19:52 INFO Executor: Running task 7.0 in stage 6.0 (TID 23)
20/12/24 18:19:52 INFO Executor: Running task 5.0 in stage 6.0 (TID 21)
20/12/24 18:19:52 INFO Executor: Finished task 5.0 in stage 6.0 (TID 21). 746 bytes result sent to driver
20/12/24 18:19:52 INFO Executor: Finished task 6.0 in stage 6.0 (TID 22). 746 bytes result sent to driver
20/12/24 18:19:52 INFO Executor: Finished task 7.0 in stage 6.0 (TID 23). 746 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 5.0 in stage 6.0 (TID 21) in 49 ms on localhost (executor driver) (5/8)
20/12/24 18:19:52 INFO TaskSetManager: Finished task 6.0 in stage 6.0 (TID 22) in 50 ms on localhost (executor driver) (6/8)
20/12/24 18:19:52 INFO TaskSetManager: Finished task 7.0 in stage 6.0 (TID 23) in 50 ms on localhost (executor driver) (7/8)
20/12/24 18:19:52 INFO Executor: Finished task 1.0 in stage 6.0 (TID 17). 746 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 1.0 in stage 6.0 (TID 17) in 75 ms on localhost (executor driver) (8/8)
20/12/24 18:19:52 INFO TaskSchedulerImpl: Removed TaskSet 6.0, whose tasks have all completed, from pool 
20/12/24 18:19:52 INFO DAGScheduler: ResultStage 6 (count at App.scala:62) finished in 0.077 s
20/12/24 18:19:52 INFO DAGScheduler: Job 6 finished: count at App.scala:62, took 0.091405 s
```
**20/12/24 18:19:52 INFO App: Number of applicants APPROVED: 12**
```
Number of applicants APPROVED: 12
```
```
20/12/24 18:19:52 INFO App: notApprovedguys org.apache.spark.rdd.MapPartitionsRDD
20/12/24 18:19:52 INFO SparkContext: Starting job: show at App.scala:108
20/12/24 18:19:52 INFO DAGScheduler: Got job 7 (show at App.scala:108) with 1 output partitions
20/12/24 18:19:52 INFO DAGScheduler: Final stage: ResultStage 7 (show at App.scala:108)
20/12/24 18:19:52 INFO DAGScheduler: Parents of final stage: List()
20/12/24 18:19:52 INFO DAGScheduler: Missing parents: List()
20/12/24 18:19:52 INFO DAGScheduler: Submitting ResultStage 7 (MapPartitionsRDD[17] at show at App.scala:108), which has no missing parents
20/12/24 18:19:52 INFO MemoryStore: Block broadcast_8 stored as values in memory (estimated size 22.8 KB, free 4.5 GB)
20/12/24 18:19:52 INFO MemoryStore: Block broadcast_8_piece0 stored as bytes in memory (estimated size 7.3 KB, free 4.5 GB)
20/12/24 18:19:52 INFO BlockManagerInfo: Added broadcast_8_piece0 in memory on 192.168.2.164:40367 (size: 7.3 KB, free: 4.5 GB)
20/12/24 18:19:52 INFO SparkContext: Created broadcast 8 from broadcast at DAGScheduler.scala:1006
20/12/24 18:19:52 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 7 (MapPartitionsRDD[17] at show at App.scala:108) (first 15 tasks are for partitions Vector(0))
20/12/24 18:19:52 INFO TaskSchedulerImpl: Adding task set 7.0 with 1 tasks
20/12/24 18:19:52 INFO TaskSetManager: Starting task 0.0 in stage 7.0 (TID 24, localhost, executor driver, partition 0, PROCESS_LOCAL, 5036 bytes)
20/12/24 18:19:52 INFO Executor: Running task 0.0 in stage 7.0 (TID 24)
20/12/24 18:19:52 INFO Executor: Finished task 0.0 in stage 7.0 (TID 24). 1400 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 0.0 in stage 7.0 (TID 24) in 11 ms on localhost (executor driver) (1/1)
20/12/24 18:19:52 INFO TaskSchedulerImpl: Removed TaskSet 7.0, whose tasks have all completed, from pool 
20/12/24 18:19:52 INFO DAGScheduler: ResultStage 7 (show at App.scala:108) finished in 0.012 s
20/12/24 18:19:52 INFO DAGScheduler: Job 7 finished: show at App.scala:108, took 0.061074 s
20/12/24 18:19:52 INFO SparkContext: Starting job: show at App.scala:108
20/12/24 18:19:52 INFO DAGScheduler: Got job 8 (show at App.scala:108) with 4 output partitions
20/12/24 18:19:52 INFO DAGScheduler: Final stage: ResultStage 8 (show at App.scala:108)
20/12/24 18:19:52 INFO DAGScheduler: Parents of final stage: List()
20/12/24 18:19:52 INFO DAGScheduler: Missing parents: List()
20/12/24 18:19:52 INFO DAGScheduler: Submitting ResultStage 8 (MapPartitionsRDD[17] at show at App.scala:108), which has no missing parents
20/12/24 18:19:52 INFO MemoryStore: Block broadcast_9 stored as values in memory (estimated size 22.8 KB, free 4.5 GB)
20/12/24 18:19:52 INFO MemoryStore: Block broadcast_9_piece0 stored as bytes in memory (estimated size 7.3 KB, free 4.5 GB)
20/12/24 18:19:52 INFO BlockManagerInfo: Added broadcast_9_piece0 in memory on 192.168.2.164:40367 (size: 7.3 KB, free: 4.5 GB)
20/12/24 18:19:52 INFO SparkContext: Created broadcast 9 from broadcast at DAGScheduler.scala:1006
20/12/24 18:19:52 INFO DAGScheduler: Submitting 4 missing tasks from ResultStage 8 (MapPartitionsRDD[17] at show at App.scala:108) (first 15 tasks are for partitions Vector(1, 2, 3, 4))
20/12/24 18:19:52 INFO TaskSchedulerImpl: Adding task set 8.0 with 4 tasks
20/12/24 18:19:52 INFO TaskSetManager: Starting task 0.0 in stage 8.0 (TID 25, localhost, executor driver, partition 1, PROCESS_LOCAL, 5040 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 1.0 in stage 8.0 (TID 26, localhost, executor driver, partition 2, PROCESS_LOCAL, 5035 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 2.0 in stage 8.0 (TID 27, localhost, executor driver, partition 3, PROCESS_LOCAL, 5078 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 3.0 in stage 8.0 (TID 28, localhost, executor driver, partition 4, PROCESS_LOCAL, 5040 bytes)
20/12/24 18:19:52 INFO Executor: Running task 1.0 in stage 8.0 (TID 26)
20/12/24 18:19:52 INFO Executor: Running task 3.0 in stage 8.0 (TID 28)
20/12/24 18:19:52 INFO Executor: Running task 0.0 in stage 8.0 (TID 25)
20/12/24 18:19:52 INFO Executor: Running task 2.0 in stage 8.0 (TID 27)
20/12/24 18:19:52 INFO Executor: Finished task 1.0 in stage 8.0 (TID 26). 1245 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 1.0 in stage 8.0 (TID 26) in 11 ms on localhost (executor driver) (1/4)
20/12/24 18:19:52 INFO Executor: Finished task 3.0 in stage 8.0 (TID 28). 1245 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 3.0 in stage 8.0 (TID 28) in 12 ms on localhost (executor driver) (2/4)
20/12/24 18:19:52 INFO Executor: Finished task 2.0 in stage 8.0 (TID 27). 1245 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 2.0 in stage 8.0 (TID 27) in 13 ms on localhost (executor driver) (3/4)
20/12/24 18:19:52 INFO Executor: Finished task 0.0 in stage 8.0 (TID 25). 1407 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 0.0 in stage 8.0 (TID 25) in 17 ms on localhost (executor driver) (4/4)
20/12/24 18:19:52 INFO TaskSchedulerImpl: Removed TaskSet 8.0, whose tasks have all completed, from pool 
20/12/24 18:19:52 INFO DAGScheduler: ResultStage 8 (show at App.scala:108) finished in 0.015 s
20/12/24 18:19:52 INFO DAGScheduler: Job 8 finished: show at App.scala:108, took 0.028135 s
20/12/24 18:19:52 INFO SparkContext: Starting job: show at App.scala:108
20/12/24 18:19:52 INFO DAGScheduler: Got job 9 (show at App.scala:108) with 3 output partitions
20/12/24 18:19:52 INFO DAGScheduler: Final stage: ResultStage 9 (show at App.scala:108)
20/12/24 18:19:52 INFO DAGScheduler: Parents of final stage: List()
20/12/24 18:19:52 INFO DAGScheduler: Missing parents: List()
20/12/24 18:19:52 INFO DAGScheduler: Submitting ResultStage 9 (MapPartitionsRDD[17] at show at App.scala:108), which has no missing parents
20/12/24 18:19:52 INFO MemoryStore: Block broadcast_10 stored as values in memory (estimated size 22.8 KB, free 4.5 GB)
20/12/24 18:19:52 INFO MemoryStore: Block broadcast_10_piece0 stored as bytes in memory (estimated size 7.3 KB, free 4.5 GB)
20/12/24 18:19:52 INFO BlockManagerInfo: Added broadcast_10_piece0 in memory on 192.168.2.164:40367 (size: 7.3 KB, free: 4.5 GB)
20/12/24 18:19:52 INFO SparkContext: Created broadcast 10 from broadcast at DAGScheduler.scala:1006
20/12/24 18:19:52 INFO DAGScheduler: Submitting 3 missing tasks from ResultStage 9 (MapPartitionsRDD[17] at show at App.scala:108) (first 15 tasks are for partitions Vector(5, 6, 7))
20/12/24 18:19:52 INFO TaskSchedulerImpl: Adding task set 9.0 with 3 tasks
20/12/24 18:19:52 INFO TaskSetManager: Starting task 0.0 in stage 9.0 (TID 29, localhost, executor driver, partition 5, PROCESS_LOCAL, 5030 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 1.0 in stage 9.0 (TID 30, localhost, executor driver, partition 6, PROCESS_LOCAL, 5036 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 2.0 in stage 9.0 (TID 31, localhost, executor driver, partition 7, PROCESS_LOCAL, 5089 bytes)
20/12/24 18:19:52 INFO Executor: Running task 2.0 in stage 9.0 (TID 31)
20/12/24 18:19:52 INFO Executor: Running task 1.0 in stage 9.0 (TID 30)
20/12/24 18:19:52 INFO Executor: Running task 0.0 in stage 9.0 (TID 29)
20/12/24 18:19:52 INFO Executor: Finished task 1.0 in stage 9.0 (TID 30). 1407 bytes result sent to driver
20/12/24 18:19:52 INFO Executor: Finished task 2.0 in stage 9.0 (TID 31). 1536 bytes result sent to driver
20/12/24 18:19:52 INFO Executor: Finished task 0.0 in stage 9.0 (TID 29). 1245 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 2.0 in stage 9.0 (TID 31) in 10 ms on localhost (executor driver) (1/3)
20/12/24 18:19:52 INFO TaskSetManager: Finished task 1.0 in stage 9.0 (TID 30) in 11 ms on localhost (executor driver) (2/3)
20/12/24 18:19:52 INFO TaskSetManager: Finished task 0.0 in stage 9.0 (TID 29) in 11 ms on localhost (executor driver) (3/3)
20/12/24 18:19:52 INFO TaskSchedulerImpl: Removed TaskSet 9.0, whose tasks have all completed, from pool 
20/12/24 18:19:52 INFO DAGScheduler: ResultStage 9 (show at App.scala:108) finished in 0.012 s
20/12/24 18:19:52 INFO DAGScheduler: Job 9 finished: show at App.scala:108, took 0.022929 s
20/12/24 18:19:52 INFO SparkContext: Starting job: count at App.scala:110
20/12/24 18:19:52 INFO DAGScheduler: Got job 10 (count at App.scala:110) with 8 output partitions
20/12/24 18:19:52 INFO DAGScheduler: Final stage: ResultStage 10 (count at App.scala:110)
20/12/24 18:19:52 INFO DAGScheduler: Parents of final stage: List()
20/12/24 18:19:52 INFO DAGScheduler: Missing parents: List()
20/12/24 18:19:52 INFO DAGScheduler: Submitting ResultStage 10 (MapPartitionsRDD[14] at filter at App.scala:104), which has no missing parents
20/12/24 18:19:52 INFO MemoryStore: Block broadcast_11 stored as values in memory (estimated size 15.7 KB, free 4.5 GB)
20/12/24 18:19:52 INFO MemoryStore: Block broadcast_11_piece0 stored as bytes in memory (estimated size 6.7 KB, free 4.5 GB)
20/12/24 18:19:52 INFO BlockManagerInfo: Added broadcast_11_piece0 in memory on 192.168.2.164:40367 (size: 6.7 KB, free: 4.5 GB)
20/12/24 18:19:52 INFO SparkContext: Created broadcast 11 from broadcast at DAGScheduler.scala:1006
20/12/24 18:19:52 INFO DAGScheduler: Submitting 8 missing tasks from ResultStage 10 (MapPartitionsRDD[14] at filter at App.scala:104) (first 15 tasks are for partitions Vector(0, 1, 2, 3, 4, 5, 6, 7))
20/12/24 18:19:52 INFO TaskSchedulerImpl: Adding task set 10.0 with 8 tasks
20/12/24 18:19:52 INFO TaskSetManager: Starting task 0.0 in stage 10.0 (TID 32, localhost, executor driver, partition 0, PROCESS_LOCAL, 5036 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 1.0 in stage 10.0 (TID 33, localhost, executor driver, partition 1, PROCESS_LOCAL, 5040 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 2.0 in stage 10.0 (TID 34, localhost, executor driver, partition 2, PROCESS_LOCAL, 5035 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 3.0 in stage 10.0 (TID 35, localhost, executor driver, partition 3, PROCESS_LOCAL, 5078 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 4.0 in stage 10.0 (TID 36, localhost, executor driver, partition 4, PROCESS_LOCAL, 5040 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 5.0 in stage 10.0 (TID 37, localhost, executor driver, partition 5, PROCESS_LOCAL, 5030 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 6.0 in stage 10.0 (TID 38, localhost, executor driver, partition 6, PROCESS_LOCAL, 5036 bytes)
20/12/24 18:19:52 INFO TaskSetManager: Starting task 7.0 in stage 10.0 (TID 39, localhost, executor driver, partition 7, PROCESS_LOCAL, 5089 bytes)
20/12/24 18:19:52 INFO Executor: Running task 0.0 in stage 10.0 (TID 32)
20/12/24 18:19:52 INFO Executor: Running task 1.0 in stage 10.0 (TID 33)
```
```
+---+----------+-----------+-------------+-----------+--------------------------------------------------------------------------------------------------------+
|id |firstName |lastName   |requestAmount|creditScore|Remarks                                                                                                 |
+---+----------+-----------+-------------+-----------+--------------------------------------------------------------------------------------------------------+
|2  |Mohd      |Ismail     |12000        |679        |credit score <680 Need to improve your credit history!!!  check your score : https://www.creditkarma.com|
|3  |Phani     |Ramavajjala|100          |600        |credit score <680 Need to improve your credit history!!!  check your score : https://www.creditkarma.com|
|15 |Gobinathan|SP         |1005         |7          |credit score <680 Need to improve your credit history!!!  check your score : https://www.creditkarma.com|
|16 |Arindam   |SenGupta   |1005         |670        |credit score <680 Need to improve your credit history!!!  check your score : https://www.creditkarma.com|
|17 |NIKHIL    |POTLAPALLY |100          |670        |credit score <680 Need to improve your credit history!!!  check your score : https://www.creditkarma.com|
|18 |Phanindra |Ramavojjala|100          |671        |credit score <680 Need to improve your credit history!!!  check your score : https://www.creditkarma.com|
+---+----------+-----------+-------------+-----------+--------------------------------------------------------------------------------------------------------+
```
```
20/12/24 18:19:52 INFO Executor: Running task 3.0 in stage 10.0 (TID 35)
20/12/24 18:19:52 INFO Executor: Running task 7.0 in stage 10.0 (TID 39)
20/12/24 18:19:52 INFO Executor: Running task 6.0 in stage 10.0 (TID 38)
20/12/24 18:19:52 INFO Executor: Running task 5.0 in stage 10.0 (TID 37)
20/12/24 18:19:52 INFO Executor: Running task 4.0 in stage 10.0 (TID 36)
20/12/24 18:19:52 INFO Executor: Finished task 7.0 in stage 10.0 (TID 39). 1102 bytes result sent to driver
20/12/24 18:19:52 INFO Executor: Running task 2.0 in stage 10.0 (TID 34)
20/12/24 18:19:52 INFO Executor: Finished task 5.0 in stage 10.0 (TID 37). 1102 bytes result sent to driver
20/12/24 18:19:52 INFO Executor: Finished task 6.0 in stage 10.0 (TID 38). 1102 bytes result sent to driver
20/12/24 18:19:52 INFO Executor: Finished task 0.0 in stage 10.0 (TID 32). 1102 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 7.0 in stage 10.0 (TID 39) in 16 ms on localhost (executor driver) (1/8)
20/12/24 18:19:52 INFO Executor: Finished task 1.0 in stage 10.0 (TID 33). 1145 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 5.0 in stage 10.0 (TID 37) in 17 ms on localhost (executor driver) (2/8)
20/12/24 18:19:52 INFO TaskSetManager: Finished task 6.0 in stage 10.0 (TID 38) in 18 ms on localhost (executor driver) (3/8)
20/12/24 18:19:52 INFO TaskSetManager: Finished task 0.0 in stage 10.0 (TID 32) in 20 ms on localhost (executor driver) (4/8)
20/12/24 18:19:52 INFO TaskSetManager: Finished task 1.0 in stage 10.0 (TID 33) in 20 ms on localhost (executor driver) (5/8)
20/12/24 18:19:52 INFO Executor: Finished task 4.0 in stage 10.0 (TID 36). 1102 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 4.0 in stage 10.0 (TID 36) in 21 ms on localhost (executor driver) (6/8)
20/12/24 18:19:52 INFO Executor: Finished task 2.0 in stage 10.0 (TID 34). 1102 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 2.0 in stage 10.0 (TID 34) in 24 ms on localhost (executor driver) (7/8)
20/12/24 18:19:52 INFO Executor: Finished task 3.0 in stage 10.0 (TID 35). 1102 bytes result sent to driver
20/12/24 18:19:52 INFO TaskSetManager: Finished task 3.0 in stage 10.0 (TID 35) in 27 ms on localhost (executor driver) (8/8)
20/12/24 18:19:52 INFO TaskSchedulerImpl: Removed TaskSet 10.0, whose tasks have all completed, from pool 
20/12/24 18:19:52 INFO DAGScheduler: ResultStage 10 (count at App.scala:110) finished in 0.029 s
20/12/24 18:19:52 INFO DAGScheduler: Job 10 finished: count at App.scala:110, took 0.040574 s
```
**20/12/24 18:19:52 INFO App: Number of applicants NOT APPROVED: 6**
```
20/12/24 18:19:52 INFO SparkContext: Invoking stop() from shutdown hook
20/12/24 18:19:52 INFO SparkUI: Stopped Spark web UI at http://192.168.2.164:4040
20/12/24 18:19:52 INFO MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
```
```
Number of applicants NOT APPROVED: 6
```
```
20/12/24 18:19:52 INFO MemoryStore: MemoryStore cleared
20/12/24 18:19:52 INFO BlockManager: BlockManager stopped
20/12/24 18:19:52 INFO BlockManagerMaster: BlockManagerMaster stopped
20/12/24 18:19:52 INFO OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
20/12/24 18:19:52 INFO SparkContext: Successfully stopped SparkContext
20/12/24 18:19:52 INFO ShutdownHookManager: Shutdown hook called
20/12/24 18:19:52 INFO ShutdownHookManager: Deleting directory /tmp/spark-da1a36d1-9b36-41de-87a8-58c9c936f8a5

Process finished with exit code 0
```