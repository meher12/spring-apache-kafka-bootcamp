# Java Spring & Apache Kafka Bootcamp - From Fundamentals to Advanced

Welcome to the **Java Spring & Apache Kafka Bootcamp - From Fundamentals to Advanced** project!

This bootcamp is designed to provide a comprehensive understanding of Java Spring and Apache Kafka, covering the core
concepts to advanced techniques.
Whether you're a beginner looking to learn these technologies from scratch or an experienced developer seeking to
enhance your skills, this bootcamp
has got you covered.

## Features

- In-depth explanation of Java Spring fundamentals, including dependency injection, inversion of control, and Spring
  MVC.
- Hands-on projects and exercises to reinforce your learning and practical skills.
- Introduction to Apache Kafka and its role in building scalable, event-driven applications.
- Building real-world applications using Java Spring and Apache Kafka together.
- Detailed tutorials and guides to help you navigate through the bootcamp materials.

## Prerequisites

To get the most out of this bootcamp, it is recommended to have prior knowledge of Java programming. Familiarity with
basic concepts like object-oriented programming and Java syntax will be beneficial. Some understanding of web
development and REST APIs will also be helpful.

## Getting Started

To start learning with the **Java Spring & Apache Kafka Bootcamp - From Fundamentals to Advanced**, clone or download
this repository to your local machine. Follow the instructions provided in the individual modules and projects to
progress through the bootcamp. Feel free to reach out if you have any questions or need assistance.

Let's embark on this learning journey together and become proficient in Java Spring and Apache Kafka!

## Apache Kafka

Apache Kafka is an open-source distributed event streaming platform for real-time data streaming.

### Key Features and Concepts

- **Event Streaming Platform**: Apache Kafka enables real-time data streaming.

- **Topics**: Organize data streams into topics, allowing producers to publish messages and consumers to subscribe and
  consume those messages.

- **Publish-Subscribe Model**: Follows the publish-subscribe messaging pattern, enabling parallel processing and
  scaling.

- **Brokers**: Operates in a distributed architecture with multiple brokers forming a cluster, providing fault tolerance
  and scalability.

- **Partitions**: Divide topics into ordered and immutable partitions, allowing for parallelism and scalability across
  brokers.

- **Replication**: Replicate partitions across brokers for data durability and fault tolerance.

- **Producers**: Publish messages to Kafka topics, choosing the partition to write to.

- **Consumers**: Subscribe to Kafka topics and read messages, where multiple consumers can be part of a consumer group
  for scaling.

- **Streams**: Kafka Streams is a client library for stream processing and real-time analytics on data streams.

### Use Cases

Apache Kafka is commonly used for real-time data streaming applications, such as:

- Log aggregation
- Event sourcing
- Messaging systems
- Data pipelines
- Stream processing

To get started with Apache Kafka, refer to the
official [Apache Kafka documentation](https://kafka.apache.org/documentation/) for installation instructions, tutorials,
and detailed guides.Consumer is Real Time Indeed
### Kafka Basic Concepts:
<div style="center">
<img src="storageroomstructure.jpg" width="400px"/>
</div>

## 01 - Start Writing Codes
* We can use application.properties or application.yml,
I prefer yml format for readability it's optional
1. Part 1: Setup kafka Producer and Consumer
2. Docker Compose commands:
   * Start containers
     ```
        docker-compose -f docker-compose-core.yml -p core up -d
        docker-compose -f docker-compose-connect.yml -p connect up -d
        docker-compose -f docker-compose-connect-sample.yml -p connect-sample up -d
        docker-compose -f docker-compose-full.yml -p full up -d
        docker-compose -f docker-compose-full-sample.yml -p full-sample up -d
     ```
   * Stop containers :
      - docker-compose -f [script-file] -p [project] down
        ``` 
         docker-compose -f docker-compose-core.yml -p core down
         docker-compose -f docker-compose-connect.yml -p connect down
         docker-compose -f docker-compose-connect-sample.yml -p connect-sample down
         docker-compose -f docker-compose-full.yml -p full down
         docker-compose -f docker-compose-full-sample.yml -p full-sample down
        ```
   * The command ***"docker exec -it kafka bash"*** is used to start an interactive bash shell session
inside a running Docker container named "kafka"
3. Hello kafka - Topic & Partition
   - Create hello topic:
   ```kafka-topics.sh --bootstrap-server localhost:9092 --create --partitions 1 --replication-factor 1 --topic t-hello```
   - Describe Topic:
     ```kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic t-hello```
   - List Topics:
   ```kafka-topics.sh --bootstrap-server localhost:9092 --list```
4. Hello kafka - Producer/Consumer
5. Consumer is Real Time Indeed:
   - Create Topic t-fixedrate:
    ```kafka-topics.sh --bootstrap-server localhost:9092 --create --partitions 1 --replication-factor 1 --topic t-fixedrate```
6. Fixing Consumer - Consumer Offset on First Run
         <div style="center">
           <img src="consumerOffset.jpg" width="500px"/>
         </div>
   1. Create t-fixedrate-2 Topic
   2. In application.yml add ```auto-offset-reset: earliest``` 
   * Now we can get all data in the consumer from First Run
7. Producing Message With Key:
   ```kafka-topics.sh --bootstrap-server localhost:9092 --create --partitions 3 --replication-factor 1 --topic t-multi-partitions```
   * In each terminal :
   ```
     kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic t-multi-partitions --offset earliest --partition 0
     kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic t-multi-partitions --offset earliest --partition 1
     kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic t-multi-partitions --offset earliest --partition 2
   ```
8. Multiple Consumers for Each Topic: ****concurrency = "4"****
   * Kafka Consumer ***Concurrency***: Creating multiple instances of a Kafka consumer application and assigned to different partitions within a consumer group,
allowing independent processing of messages from each partition and achieving parallel processing
## 02 -  Working with JSON Message
1. Adding jackson dependencies
2. Producing JSON Message:
   1. Create t-employee topic
   ```kafka-topics.sh --bootstrap-server localhost:9092 --create --partitions 1 --replication-factor 1 --topic t-employee```
   2. Create EmployeeJsonProducer class and check it by using:
   ```kafka-console-consumer.sh --bootstrap-server localhost:9092 --offset earliest --partition 0 --topic t-employee```
   3. Customize JSON Format
      1. Create t-employee-2 topic
      2. Customize JSON Format:
         * @JsonNaming(value = PropertyNamingStrategy.class): is a Jackson library annotation for Java that allows you to customize how Java class field/property names are mapped to JSON representation
during serialization and deserialization. It provides flexibility to convert names between Java objects and JSON formats.
      3. To check "Employee2JsonProducer.class"  it by using ```kafka-console-consumer.sh --bootstrap-server localhost:9092 --offset earliest --partition 0 --topic t-employee-2```
3. Consuming JSON Message:
   1. Create ObjectMapper Bean, Employee class, add jackson: date-format: yyyy-MMM-dd to application.yml file
   