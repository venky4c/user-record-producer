package com.venky.demos.controller;

import com.venky.demos.model.UserEvent;
import com.venky.demos.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class InventoryMovementController {

    Logger log = LoggerFactory.getLogger(InventoryMovementController.class.getSimpleName());
    private final KafkaProducerService service;
    //public InventoryMovementController(KafkaProducerService service){
//        this.service = service;
//    }

    @PostMapping("/{userId}/events")
    public ResponseEntity<String> triggerEvent(@PathVariable("userId") String userId,
                                       @RequestBody UserEvent event){
        log.info("Inside the controller >>>>>>>>>>>>>>>");
        service.sendUserEvent(userId, event);
        return ResponseEntity.ok("Successfully pub msg to Kafka >>>>>>>>>!!!!!!!!!!!!");
    }

}
