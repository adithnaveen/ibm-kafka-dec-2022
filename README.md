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
 