package com.venky.demos.strategy;

import com.venky.demos.model.UserEvent;

public interface DeliveryStrategy {
    void processAndSend(String userId, UserEvent event);
}
