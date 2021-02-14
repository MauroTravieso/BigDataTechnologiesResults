## Apache Flume
### Use Case: Create Flume Agent for data ingestion and fanning it out
### Log file ingestion
### Motivation: 
### - Being able to ingest data to be displayed in memory (console) and persisted in HDFS. 


Mauro Travieso Pena

---
[*] Create an HDFS directory which contains the HDFS sink output
```
$ hdfs dfs -mkdir /user/mpena/Flume
$ hdfs dfs -mkdir /user/mpena/Flume/flume_fan-out_Import
```

[*] In the local file system, for the source, create the corresponding directories which contain the Flume Agent .conf file as well as the spooldir 
```
$ mkdir /home/mpena/Flume/Flume_Lab
$ mkdir /home/mpena/Flume/Flume_Lab/conf
$ mkdir /home/mpena/Desktop/Flume/Flume_Lab/spooldir
```

[*] Copy the file logFile.txt into Flume_Lab/spooldir

[*] Create the Flume Agent configuration file named myFlume_fan-out.conf inside Flume_Lab/conf with the following set of commands

```
$ vi /home/mpena/Desktop/Flume/Flume_Lab/conf/myFlume_fan-out.conf
```
```
# Components of the Flume Agent
agent1.sources = source1
agent1.sinks = sink1a sink1b
agent1.channels = channel1a channel1b

# Binding the Source and the Sink to the corresponding channel 
agent1.sources.source1.channels = channel1a channel1b
agent1.sinks.sink1a.channel = channel1a
agent1.sinks.sink1b.channel = channel1b

# Source configuration
agent1.sources.source1.type = spooldir
agent1.sources.source1.spoolDir = /home/mpena/Desktop/Flume/Flume_Lab/spooldir/

# Sink1a configuration
agent1.sinks.sink1a.type = hdfs
agent1.sinks.sink1a.hdfs.path = hdfs://localhost/user/mpena/Flume/flume_fan-out_Import/
agent1.sinks.sink1a.hdfs.filePrefix = events
agent1.sinks.sink1a.hdfs.fileSuffix = .log
agent1.sinks.sink1a.hdfs.fileType = DataStream

# Sink1b configuration
agent1.sinks.sink1b.type = logger

# Channel configuration
agent1.channels.channel1a.type = file
agent1.channels.channel1b.type = memory
```

[*] To start the Flume Agent
```
$ flume-ng agent -n agent1 -c /home/mpena/Flume/Flume_Lab/conf/ -f /home/mpena/Flume/Flume_Lab/conf/myFlume_fan-out.conf
```

[*] To check if the files were created successfully:
```
$ hdfs dfs -ls /user/mpena/Flume/flume_fan-out_Import
$ hdfs dfs -cat /user/mpena/Flume/flume_fan-out_Import/events*
```

[*] To test:

When the spooldir/logFile.txt is modified (updated with new data), it is observed that the Flume Agent starts and updates the checkpoint metadata.

As a result, any modification done to the 'logFile.txt' file is directly reflected in the console output, as well as in HDFS as soon as it happens.