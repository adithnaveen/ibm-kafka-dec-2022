# ibm-kafka-dec-2022



### System Requirement 
- System with 8 GB 
- Hypervisor Support to test with docker 
- About 50 GB free space 
- Operating System Mac / Windows / Linux
- Open internet access 


### Step 1 
> Download and install jdk 11 for your respective OS(Mac/Win/Linux) - https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html

### Step 2 
> Download Kafka from - https://kafka.apache.org/downloads
> https://archive.apache.org/dist/kafka/3.1.0/kafka_2.12-3.1.0.tgz
> Extract with softwares like 7 zip / win zip etc 

* Note Windows Users: install wsl2 first -  https://docs.microsoft.com/en-us/windows/wsl/install
    -to check if the installation is successful 
    > wsl -l -v 
### Step 3 
> Add Kafka to system path - kafka_2.13-3.1.0/bin 

### to install Docker 
> https://www.docker.com/ 
* Note: Select approcpirate OS 



- Anthony Anu - working as SE, 4 years exp, willing to learning kafka testing, 
- Syanai - 11 yers exp, testing, currently selenium automation, c#, postman, enhance kafka application 
- yogesh - 6 years exp, function testing , AIP, DB, ETL testing, new to kafka testing, 
- Akshata Chavan - 7.5 exp, testing, API testing, virtualalization, new to kafka 
- Deepashree - 3 year exp, testing new to kafka 
- Latika - 15 year exp in testing, working on cloud testing, understna and learn kafka in project 
- Mandar Salunke - 7 years exp, SE Testing, selenium testing + ETL Testing, understand and learn kafka in project 
- Nagesh - Test arch working 8 year exp, working as manual, automation, performance, have worked with kafka earlier
    + do performance Testing with kakfa 
- Prasanthi - 10 years exp, testing new to ETl Testing, will be converted to MS in future 
-  Sathiyamoorthy - 3 year exp, UI automation, joined the sesion to enhance the skills 
- Venkatesan - 3.7 years exp, manual + automation, willing to learn kakfa 
- Richa Goswami-  having nearly 5yoe in testing domain. Looking forward to learn about Kafka,
- Yogesh - 


 
For Windows User 
> /Volumes/Kanchan/Softwares/kafka/kafka-3.1.0/bin/windows

> Highly cohesive - Loosely Coupled 

> json format
```
{
    firstName: "Latika", 
    lastName: "Yadav", 
    address: {
        hno: 123, 
        street: "Green Filed Blvd",
        city : "Virginia"
    }

}
```


- var response = restTemplate.exchange("http://ibm.com/retailproject/asia/product", HttpMethod.GET, entity, String.class).getBody();

404 


- ESB - Enterprise Service Bus 
    - Open MQ 
    - Rabbit MQ 
    - Mule Soft 
    - Tibco 
    - Kafka - LinkedIn 

- Apache 



- With ESB We should reduce complexity 
- When the request is made even when the receiver is not there immediately the message is kept, 
    such that when the receiver comes back he/she can take it 
- producer consumer problem 
- when the consumer is not there by default 1 week 3600*24*7
- In Kafka the data is immutable 
- Zookeeper 
    - ZooKeeper is a centralized service for maintaining configuration information, naming, providing distributed synchronization, and providing group services.




## to start zookder 

```
> cd <Home directory of Kafka>

> ./bin/kafka-server-start.sh ./config/zookeeper.properties 

- zookeeper to start at port 2181 

-- to start kafka 
> ./bin/kafka-server-start.sh ./config/server.properties

-- to create a topic 
> ./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic first-topic

-- to list the topics 
>  ./kafka-topics.sh --bootstrap-server localhost:9092 --list

-- describe the topic 
>  kafka-topics.sh --bootstrap-srever localhost:9092 --describe --topic first-topic 


-- to send messages with key, value pair 
key:value 


-- to have the kafka console with the formatter and with time stamp

> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic second-topic --formatter kafka.tools.DefaultMessageFormatter --property  print.timestamp=true --property print.key=true --property print.value=true --from-beginning


```
 


# Day 2 
    - Kafka is written with Scala 
        - so that way it is by default async + support reactive 
    - In DB you can Query, in kafka there is no query concept 
        - to send message you need kafka producer 
        - to receive message you need kafka consumer - for this need topic 
    - Kafka message by default kept for 1 week 
    - By default kafka shall have 1 partition 
    - Kafka 2.x - Zookeeper is mandatory 
    - Kafka 3.x - Zookeeper is option ( for production its mandatory)
        - KRaft which shall replace Zookeeper 
    - Kafka 4.x - Zookeeper  shall be removed 

- Port Numbers 
    - Zookeeper - 2181 
    - Kafka - 9092 


- Implementation of Kafka with Partition, and Consumer Groups 
- Rebalancing 
- implementing Kafka with Programming Language Java 
    - Eclipse 
- Start Kafka with KRaft without zookeeper 

- in kafka the security is dont in flight this does not happen with encryption (Private-Public)
    - the data is hashed 
    - Murmur2 
        - Utils.toPositive(Utils.murmur2(keyBytes)) % numPartitions;



- The message can be of 
    - int 
    - float / Double 
    - json 
    - string 
    - avro 
    - protobuf ..... 


```

-- to create a topic 
> ./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic fourth-topic --partitions 3 

- start the producer 
> kafka-console-producer.sh --bootstrap-server localhost:9092 --topic fourth-topic

-start the consumer (without group)
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic fourth-topic

-start the consumer (with group)
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic fourth-topic --group first-application
(At this time all the messages are given to first-application group)

- open another terminal and start the consumer with the same group and you will the messages getting balanced between 2 consumers 
- all this is happening since you have 3 parititions 
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic fourth-topic --group first-application

(when you have more than 1 consumer in the same group balances the messages )
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic fourth-topic --group second-application

> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic fourth-topic --group second-application

- you can get to know how many messages are sent to each partition and how many are read by below command 
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group second-application

- stop the consumer group second-application with ctrl+c 

> send some message now with kafka producer 

then you will see lag value which means those many messages are not read 
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group second-application


- you can get the offset values of different topics from below command (please change last number)
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group console-consumer-59382

```





One Instance  (x)
    Second Instance  (x)
    Third Instance (x)
    Fourth Instance (x) - delayed OLAP 





GROUP                         TOPIC           PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID                                           HOST            CLIENT-ID
third-topic-first-application third-topic     0          5               5               0               console-consumer-232d9508-d4c4-49bd-9e8c-56abacc04ef6 /127.0.0.1      console-consumer
third-topic-first-application third-topic     1          3               3               0               console-consumer-232d9508-d4c4-49bd-9e8c-56abacc04ef6 /127.0.0.1      console-consumer
third-topic-first-application third-topic     2          4               4               0               console-consumer-2b08ac78-3e35-4c39-a4bd-968d75d1a190 /127.0.0.1      console-consumer


after reset 





GROUP                         TOPIC           PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID     HOST            CLIENT-ID
third-topic-first-application third-topic     0          0               5               5               -               -               -
third-topic-first-application third-topic     1          0               3               3               -               -               -
third-topic-first-application third-topic     2          0               4               4               -               -               -

- i dont want to reset all the messages instead by 2 messages 



-- to reset the offsets 
>  kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group third-topic-first-application --reset-offsets --to-earliest --execute --topic third-topic

-- to reset offset by two (back) -2
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group third-topic-first-application --reset-offsets --shift-by -2 --execute --topic third-topic

-- describe the group you should see the lag of two 
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group third-topic-first-application


> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group third-topic-first-application --reset-offsets --shift-by 2 --execute --topic third-topic



- Cluster - group of broker (it can 1 broker but in reality it should be min 2)
- Brocker - Kafka (1 instace )

> kafka-topics.sh --bootstrap-server localhost:9092 --topic partition-with-replica --create --partitions 3 (this will work)
> kafka-topics.sh --bootstrap-server localhost:9092 --topic partition-with-replica --create --partitions 3 --replication-factor 3 (will not work)


## Working with Java 
1. Java (done)
2. Eclipse (Done)
3. Maven (implicitly available) - Dependency Mechanism 
    3.1 Kafka Client - pom.xml 
    3.2 logger - slf4j + simple 
4. PROGRAM 
    4.1 Consifugation - bootstrap.servers:9092 - and letting know what kind of values are sent 
    3.2 producer configuration (topic)
    3.3 Generate kafka record 
    3.4 producer.send(record,callback)
    3.5 make sure you flush and close to persist the message to kafka 


public interface Callback {
    void onCompletion(RecordMetadata metadata, Exception exception);
}

Tomorrow 

- how to de/serialize json 
- staring kafka with KRaft 
- integrating kafka with spring boot application 
- clurering - multi node single zookeeper 
- clurering - multi node multiple zookeeper 
- Dockerizing Kafka + testing with CLI 
- show consuming large data with wiki or similar (case study)
- some GUI  

