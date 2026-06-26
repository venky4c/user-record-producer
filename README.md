# user-record-producer
a humble kafka producer that uses java record to publish to kafka

Published data to Kafka Producer using
a. Conduktor io platform which was hosted on the remote. Used Ubuntu on WSL2 to link to Conduktor via the Docker desktop
b. java 17 feature of 'record' as the value-serializer from 'org.springframework.kafka.support.serializer.JacksonJsonSerializer' instead of plain StringSerializer
c. used lombok for Dependency Injection in place of constructor DI via the RequiredArgsConstructor
