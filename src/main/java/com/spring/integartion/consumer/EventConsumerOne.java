package com.spring.integartion.consumer;

import com.spring.integartion.model.Event;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class EventConsumerOne {
    @ServiceActivator(inputChannel = "eventChannel")
    public void reciveEvent(Message<Event> message){
        System.out.println("ConsumeOne 1 "+message.getPayload());
    }
}
