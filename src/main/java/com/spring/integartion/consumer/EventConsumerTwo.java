package com.spring.integartion.consumer;

import com.spring.integartion.model.Event;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class EventConsumerTwo {
    @ServiceActivator(inputChannel = "eventChannel")
    public void reciveEvent(Message<Event> message){


        System.out.println("ConsumeTwo 2 "+message.getPayload().toString().toUpperCase(Locale.ROOT));
    }
}
