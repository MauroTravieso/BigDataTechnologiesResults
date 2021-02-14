# Hadoop MapReduce

## MapReduce Hands-on Labs - Homework

#### Mauro Travieso 

---

### Tasks:

* 1.- A file has the following lines of words.
* 2.- Use MapReduce to identify word count for each word in the file.
* 3.- Use one Input Split for each line shown (total input splits = 5).
* 4.- Refer to word count example in-class slides before getting started.
* 5.- Use Pen/Pencil on paper and scan, rough sketch is good enough.

### Text to be processed: 

How many cookies could a good <br>
cook cook If a good cook could <br>
cook cookies? A good cook could <br>
cook as much cookies as a good <br>
cook who could cook cookies. <br>

### Processing every record in the unstructured file (ignoring upercase and punctuation):

| Line No. | Content of the record |
| -------- | --------------------- |
| Line 1 | how many cookies could a good |
| Line 2 | cook cook if a good cook could |
| Line 3 | cook cookies a good cook could |
| Line 4 | cook as much cookies as a good |
| Line 5 | cook who could cook cookies |

* **Mapper input (input split)**

| Input split 1 | Input split 2 | Input split 3 | Input split 4 | Input split 5 |
| --- | --- | --- | --- | --- |
| how many cookies could a good | cook cook if a good cook could | cook cookies a good cook could | cook as much cookies as a good | cook who could cook cookies |

* **Mapper (input split) output**

| Input split 1 | Input split 2 | Input split 3 | Input split 4 | Input split 5 |
| --- | --- | --- | --- | --- |
| (how,1)<br> (many,1)<br> (cookies,1)<br> (could,1)<br> (a,1)<br> (good,1) | (cook,1)<br> (cook,1)<br> (if,1)<br> (a,1)<br> (good,1)<br> (cook,1)<br> (could,1) | (cook,1)<br> (cookies,1)<br> (a,1)<br> (good,1)<br> (cook,1)<br> (could,1) | (cook,1)<br> (as,1)<br> (much,1)<br> (cookies,1)<br> (as,1)<br> (a,1)<br> (good,1) | (cook,1)<br> (who,1)<br> (could,1)<br> (cook,1)<br> (cookies,1) |

* **Mapper output file**

| Input split 1 | Input split 2 | Input split 3 | Input split 4 | Input split 5 |
| --- | --- | --- | --- | --- |
| (a,1)<br> (cookies,1)<br> (could,1)<br> (good,1)<br> (how,1)<br> (many,1)<br> | (a,1)<br> (cook,1)<br> (cook,1)<br> (cook,1)<br> (could,1)<br> (good,1)<br> (if,1) | (a,1)<br> (cook,1)<br> (cook,1)<br> (cookies,1)<br> (could,1)<br> (good,1)<br> | (a,1)<br> (as,1)<br> (as,1)<br> (cook,1)<br> (cookies,1)<br> (good,1)<br> (much,1)<br> | (cook,1)<br> (cook,1)<br> (cookies,1)<br> (could,1)<br> (who,1)<br> |

* ***Shuffle & Sort phase***

* **Reducer input**

| Without combiner | With combiner |
| --- | --- |
| (a, [1,1,1,1])<br> (as, [1,1])<br> (cook, [1,1,1,1,1,1,1,1])<br> (cookies, [1,1,1,1])<br> (could, [1,1,1,1])<br> (good, [1,1,1,1])<br> (how, [1])<br> (if, [1])<br> (many, [1])<br> (much, [1])<br> (who, [1]) |  (a, [1,1,1,1])<br> (as, [2])<br> (cook, [3, 2, 1, 2])<br> (cookies, [1,1,1,1])<br> (could, [1,1,1,1])<br> (good, [1,1,1,1])<br> (how, [1])<br> (if, [1])<br> (many, [1])<br> (much, [1])<br> (who, [1]) |

* **Reducer output** (it is the same with combiner or not, however the network overheat -shuffle & sort- is more without the combiner)

| Without combiner | With combiner |
| --- | --- |
| (a, 4)<br> (as, 2)<br> (cook, 8)<br> (cookies, 4)<br> (could, 4)<br> (good, 4)<br> (how, 1)<br> (if, 1)<br> (many, 1)<br> (much, 1)<br> (who, 1) |  (a, 4)<br> (as, 2)<br> (cook, 8)<br> (cookies, 4)<br> (could, 4)<br> (good, 4)<br> (how, 1)<br> (if, 1)<br> (many, 1)<br> (much, 1)<br> (who, 1) |
