## Apache HBase
### Use Case: HBase-Hive Integration
### Log file analysis
### Motivation: 
### - Being able to perform SQL operations on unstructured data that is stored into HBase table. 
### - Modification done on whichever table is directly reflected on the other one. 

Mauro Travieso Pena

---
* **Related Datasets:**

https://www.kaggle.com/shawon10/web-log-dataset?select=weblog.csv<br>
https://www.kaggle.com/souhagaa/nasa-access-log-dataset-1995<br>
https://www.kaggle.com/yburger/web-visitor-interests<br>


* ***Creating the tables and updating the .log data***

* **Creating the Hive Table**

After analizing the dataset, it could be possible to identify the fields that it contains:

```
CREATE EXTERNAL TABLE mpena_access (
    host STRING, 
    identity STRING, 
    user STRING, 
    time STRING, 
    request STRING, 
    status STRING, 
    size STRING, 
    referer STRING, 
    agent STRING) 
ROW FORMAT SERDE 'org.apache.hadoop.hive.contrib.serde2.RegexSerDe'
WITH SERDEPROPERTIES ( 
  "input.regex" = "([^ ]*) ([^ ]*) ([^ ]*) (-|\\[[^\\]]*\\]) ([^ \"]*|\"[^\"]*\") (-|[0-9]*) (-|[0-9]*)(?: ([^ \"]*|\"[^\"]*\") ([^ \"]*|\"[^\"]*\"))?", \
  "output.format.string" = "%1$s %2$s %3$s %4$s %5$s %6$s %7$s %8$s %9$s"
) 
STORED AS TEXTFILE;
```

* **Adding the .jar file associated with the SerDe properties**

```
$ find / -name 'hive-contrib*.jar'
```
```
/usr/hdp/3.1.4.0-315/hive/lib/hive-contrib-3.1.0.3.1.4.0-315.jar
```

*In the hive console*
```
ADD JAR file:///usr/hdp/3.1.4.0-315/hive/lib/hive-contrib-3.1.0.3.1.4.0-315.jar;
```

* **Uploading the .log file data into the hive table, taking into account the serde properties**
```
LOAD DATA INPATH 'hdfs:/wiki-access.log' INTO TABLE mpena_access;
```

***For tesing purposes and to check if the process was successful***
```
SELECT * FROM access LIMIT 20;
```
```
OK
222.64.164.118	-	-	[19/Jun/2005:06:44:17 +0200]	"GET /wximages/wxwidgets02-small.png HTTP/1.1"	200	12468	"http://blog.vckbase.com/bastet/"	"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; TencentTraveler)"
218.84.191.50	-	-	[19/Jun/2005:06:46:05 +0200]	"GET /wximages/wxwidgets02-small.png HTTP/1.1"	200	12468	"http://blog.vckbase.com/bastet/"	"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)"
202.201.245.20	-	-	[19/Jun/2005:06:47:37 +0200]	"GET /wximages/wxwidgets02-small.png HTTP/1.1"	200	12468	"http://blog.vckbase.com/bastet/"	"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)"
138.243.201.10	-	-	[19/Jun/2005:06:48:40 +0200]	"GET /wiki.pl?/WxWidgets_Bounties HTTP/1.1"	200	8837	"http://www.wxwidgets.org/toolbar.htm"	"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-GB; rv:1.7.7) Gecko/20050414 Firefox/1.0.3"
68.251.52.253	-	-	[19/Jun/2005:06:50:49 +0200]	"GET /wiki.pl?/WxWidgets_Compared_to_Other_toolkits HTTP/1.1"	200	19476	"http://www.google.com/search?q=wxWidget+designer"	"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.8) Gecko/20050511 Firefox/1.0.4"
68.251.52.253	-	-	[19/Jun/2005:06:50:49 +0200]	"GET /wxwiki.css HTTP/1.1"	200	19476	"http://www.google.com/search?q=wxWidget+designer"	"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.8) Gecko/20050511 Firefox/1.0.4"
68.251.52.253	-	-	[19/Jun/2005:06:50:49 +0200]	"GET /wximages/wxwidgets02-small.png HTTP/1.1"	200	12468	"http://wiki.wxwidgets.org-wiki.pl?WxWidgets?Compared?To?Other?Toolkits"	"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.8) Gecko/20050511 Firefox/1.0.4"
68.251.52.253	-	-	[19/Jun/2005:06:50:50 +0200]	"GET /favicon.ico HTTP/1.1"	200	3262	"http://wiki.wxwidgets.org-wiki.pl?WxWidgets_Compared_To_Other_Toolkits"	"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.8) Gecko/20050511 Firefox/1.0.4"
61.177.31.179	-	-	[19/Jun/2005:06:52:36 +0200]	"GET /wximages/wxwidgets02-small.png HTTP/1.1"	200	12468	"http://blog.vckbase.com/bastet"	"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"
216.148.248.43	-	-	[19/Jun/2005:06:53:14 +0200]	"GET / HTTP/1.0"	200	3368	"-"	"Mozilla/4.0 (compatible;)"
NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL
218.58.4.221	-	-	[19/Jun/2005:06:54:19 +0200]	"GET /wximages/wxwidgets02-small.png HTTP/1.1"	200	12468	"http://blog.vckbase.com/bastet/"	"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"
61.143.48.33	-	-	[19/Jun/2005:06:54:29 +0200]	"GET /wximages/wxwidgets02-small.png HTTP/1.1"	200	12468	"http://blog.vckbase.com/bastet/"	"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Alexa Toolbar; mxie; Maxthon; .NET CLR 1.1.4322)"
64.4.8.94	-	-	[19/Jun/2005:06:58:08 +0200]	"GET /robots.txt HTTP/1.1"	200	138	"-"	"msnbot/1.0 (+http://search.msn.com/msnbot.htm)"
221.232.64.93	-	-	[19/Jun/2005:06:59:55 +0200]	"GET /wximages/wxwidgets02-small.png HTTP/1.1"	304	-	"http://blog.vckbase.com/bastet/archive/2005/06/09/6274.html"	"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"
65.54.188.139	-	-	[21/Jun/2005:17:54:00 +0200]	"GET /wiki.pl?RecentChanges HTTP/1.0"	200	11622	"-"	"msnbot/1.0 (+http://search.msn.com/msnbot.htm)"
134.91.40.39	-	-	[21/Jun/2005:17:54:04 +0200]	"GET /wxwidgets02-small.png HTTP/1.1"	404	302	"http://wiki.wxwidgets.org/wiki.pl?WxListCtrl"	"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8b2) Gecko/20050616 Firefox/1.0+"
134.91.40.39	-	-	[21/Jun/2005:17:54:04 +0200]	"GET /wxListCtrl.png HTTP/1.1"	404	295	"http://wiki.wxwidgets.org/wiki.pl?WxListCtrl"	"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8b2) Gecko/20050616 Firefox/1.0+"
NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL	NULL
219.136.3.84	-	-	[21/Jun/2005:17:55:19 +0200]	"GET /wximages/wxwidgets02-small.png HTTP/1.1"	200	12468	"http://blog.vckbase.com/bastet/"	"Mozilla/4.0 (compatible; MSIE 5.01; Windows NT 5.0)"
Time taken: 3.535 seconds, Fetched: 20 row(s)
```

***Performing SQL queries***
```
SELECT * FROM access WHERE status = 404 LIMIT 20;
```

OK<br>
134.91.40.39	-	-	[21/Jun/2005:17:54:04 +0200]	"GET /wxwidgets02-small.png HTTP/1.1"	**404**	302	"http://wiki.wxwidgets.org/wiki.pl?WxListCtrl"	"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8b2) Gecko/20050616 Firefox/1.0+"<br>
134.91.40.39	-	-	[21/Jun/2005:17:54:04 +0200]	"GET /wxListCtrl.png HTTP/1.1"	**404**	295	"http://wiki.wxwidgets.org/wiki.pl?WxListCtrl"	"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8b2) Gecko/20050616 Firefox/1.0+"<br>
219.66.165.205	-	-	[23/Jun/2005:07:46:24 +0200]	"GET /images/clear.gif HTTP/1.1"	**404**	297	"http://honyaku.yahoofs.jp"	"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; .NET CLR 1.0.3705)"<br>
83.197.182.95	-	-	[24/Jun/2005:23:27:24 +0200]	"GET /wiki_files/wxwidgets02-small.png HTTP/1.1"	**404**	313	"http://wiki.wxwidgets.org"	"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; .NET CLR 1.0.3705)"<br>
143.127.131.4	-	-	[24/Jun/2005:23:27:24 +0200]	"GET /_vti_bin/owssvr.dll?UL=1$ACT=4&BUILD=6254 HTTP/1.1"	**404**	300	"http://wiki.wxwidgets.org"	"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322)"<br>
143.127.131.4	-	-	[24/Jun/2005:23:27:24 +0200]	"GET /MSOffice/cltreq.asp?UL=1$ACT=4&BUILD=6254 HTTP/1.1"	**404**	300	"http://wiki.wxwidgets.org"	"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322)"<br>
66.249.71.29	-	-	[25/Jun/2005:16:00:11 +0200]	"GET /foo HTTP/1.1"	**404**	272	"-"	"Googlebot/2.1 (+http://www.google.com/bot.html)"<br>
69.247.69.152	-	-	[26/Jun/2005:02:38:38 +0200]	"GET /wiki_files/wxwidgets02-small.png HTTP/1.1"	**404**	309	"http://wiki.wxwidgets.org"	"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.7.8) Gecko/20050524 Fedora/1.0.4-4 Firefox/1.0.4"<br>
Time taken: 1.046 seconds, Fetched: 8 row(s)

```
SELECT host, referer, COUNT(*) FROM access WHERE status = 404 GROUP BY host, referer;
```
```
Hadoop job information for Stage-1: number of mappers: 1; number of reducers: 1
2020-12-30 11:42:28,192 Stage-1 map = 0%,  reduce = 0%
2020-12-30 11:42:38,302 Stage-1 map = 100%,  reduce = 0%, Cumulative CPU 7.77 sec
2020-12-30 11:42:46,851 Stage-1 map = 100%,  reduce = 100%, Cumulative CPU 10.82 sec
MapReduce Total cumulative CPU time: 10 seconds 820 msec
Ended Job = job_1609348898618_0001
MapReduce Jobs Launched: 
Stage-Stage-1: Map: 1  Reduce: 1   Cumulative CPU: 10.82 sec   HDFS Read: 15953 HDFS Write: 258 SUCCESS
Total MapReduce CPU Time Spent: 10 seconds 820 msec
OK
134.91.40.39	"http://wiki.wxwidgets.org/wiki.pl?WxListCtrl"	2
143.127.131.4	"http://wiki.wxwidgets.org"	2
219.66.165.205	"http://honyaku.yahoofs.jp"	1
66.249.71.29	"-"	1
69.247.69.152	"http://wiki.wxwidgets.org"	1
83.197.182.95	"http://wiki.wxwidgets.org"	1
Time taken: 40.16 seconds, Fetched: 6 row(s)
```

* ***HBase - Hive integration***

***To generate the HBase table 'mpena_log' with the corresponding rowkey and host/url 404 status***
```
CREATE TABLE mpena_hbase_table_access(host STRING, referer STRING, count INT)
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
WITH SERDEPROPERTIES ("hbase.columns.mapping" = ":key, cf1:referer, cf1:count")
TBLPROPERTIES ("hbase.table.name" = "mpena_log");  
```

***To fetch the data from Hive table and put into the HBase table***
```
INSERT OVERWRITE TABLE mpena_hbase_table_access
SELECT ost, referer, COUNT(*)
FROM access 
WHERE status = 404
GROUP BY host, referer;
```   
```
Hadoop job information for Stage-0: number of mappers: 1; number of reducers: 1
2020-12-30 11:44:08,402 Stage-0 map = 0%,  reduce = 0%
2020-12-30 11:44:14,823 Stage-0 map = 100%,  reduce = 0%, Cumulative CPU 3.8 sec
2020-12-30 11:44:26,322 Stage-0 map = 100%,  reduce = 100%, Cumulative CPU 13.74 sec
MapReduce Total cumulative CPU time: 13 seconds 740 msec
Ended Job = job_1609348898618_0002
MapReduce Jobs Launched: 
Stage-Stage-0: Map: 1  Reduce: 1   Cumulative CPU: 13.74 sec   HDFS Read: 24042 HDFS Write: 0 SUCCESS
Total MapReduce CPU Time Spent: 13 seconds 740 msec
OK
Time taken: 32.088 seconds
```

* ***In HBase shell***
```
hbase(main):001:0> list
```
```
hbase(main):002:0> describe 'mpena_log'
```
```
Table log is ENABLED                                                            
log                                                                             
COLUMN FAMILIES DESCRIPTION                                                     
{NAME => 'cf1', BLOOMFILTER => 'ROW', VERSIONS => '1', IN_MEMORY => 'false', KEE
P_DELETED_CELLS => 'FALSE', DATA_BLOCK_ENCODING => 'NONE', TTL => 'FOREVER', COM
PRESSION => 'NONE', MIN_VERSIONS => '0', BLOCKCACHE => 'true', BLOCKSIZE => '655
36', REPLICATION_SCOPE => '0'}                                                  
1 row(s) in 0.1600 seconds
```
```
hbase(main):003:0> scan 'mpena_log', {LIMIT=>20}
```
```
ROW                   COLUMN+CELL                                               
 134.91.40.39         column=cf1:count, timestamp=1609350266011, value=2        
 134.91.40.39         column=cf1:referer, timestamp=1609350266011, value="http:/
                      /wiki.wxwidgets.org/wiki.pl?WxListCtrl"                   
 143.127.131.4        column=cf1:count, timestamp=1609350266011, value=2        
 143.127.131.4        column=cf1:referer, timestamp=1609350266011, value="http:/
                      /wiki.wxwidgets.org"                                      
 219.66.165.205       column=cf1:count, timestamp=1609350266011, value=1        
 219.66.165.205       column=cf1:referer, timestamp=1609350266011, value="http:/
                      /honyaku.yahoofs.jp"                                      
 66.249.71.29         column=cf1:count, timestamp=1609350266011, value=1        
 66.249.71.29         column=cf1:referer, timestamp=1609350266011, value="-"    
 69.247.69.152        column=cf1:count, timestamp=1609350266011, value=1        
 69.247.69.152        column=cf1:referer, timestamp=1609350266011, value="http:/
                      /wiki.wxwidgets.org"                                      
 83.197.182.95        column=cf1:count, timestamp=1609350266011, value=1        
 83.197.182.95        column=cf1:referer, timestamp=1609350266011, value="http:/
                      /wiki.wxwidgets.org"                                      
6 row(s) in 0.0930 seconds
```

[*] **Important to notice:** Any modification done on whichever table is directly reflected on the other one immediately when properly integrated. 
---