package com.venky.demos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class UserRecordProducerApplication {

    private static final Logger log = LoggerFactory.getLogger(UserRecordProducerApplication.class.getSimpleName());

    public static void main(String[] args) {

        log.info("My first Producer in Kafka");
        SpringApplication.run(UserRecordProducerApplication.class, args);

    }
}