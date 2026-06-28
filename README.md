# user-record-producer
<p align="center">
  <img src="src/main/resources/assets/kafka101.png" alt="Java, Spring Boot, and Kafka Banner" width="100%">
</p>



A Kafka project that uses various concepts of Kafka to act as a reference for implementation of different concepts and config properties defined in Apache Kafka.

Published data to Kafka Producer. Salient features are:

a. Used Ubuntu on WSL2 on the Docker desktop to link to Conduktor where the bootstrap servers are hosted.

b. Used java 17 feature of 'record' as the value-serializer from 'org.springframework.kafka.support.serializer.JacksonJsonSerializer' instead of plain StringSerializer

c. Used lombok for Dependency Injection in place of constructor DI via the RequiredArgsConstructor
Learnt that - Lombok only targets final fields for @RequiredArgsConstructor. Removing final from userTopic stops Lombok from expecting a String bean in the constructor.

tbd - how to apply this same Strategy Pattern to the Consumer side to handle changing processing requirements?