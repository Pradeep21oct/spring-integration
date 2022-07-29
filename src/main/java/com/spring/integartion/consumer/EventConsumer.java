package com.spring.integartion.consumer;

import com.spring.integartion.model.Event;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class EventConsumer {
    @ServiceActivator(inputChannel = "eventChannel")
    public void reciveEvent1(Message<Event> message){
        System.out.println("ConsumeOne 1 "+message.getPayload());
    }
    @ServiceActivator(inputChannel = "eventChannel")
    public void reciveEvent2(Message<Event> message){


        System.out.println("ConsumeTwo 2 "+message.getPayload().toString().toUpperCase(Locale.ROOT));
    }
}
