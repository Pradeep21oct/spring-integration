package com.spring.integartion.consumer;

import com.spring.integartion.model.Event;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class RouterConsumer {
    @ServiceActivator(inputChannel = "queueChannel2")
    public void reciveEvent1(Message<Event> message){
        System.out.println(" queueChannel2 ConsumeOne  "+message.getPayload());
    }
    @ServiceActivator(inputChannel = "queueChannel3")
    public void reciveEvent2(Message<Event> message){


        System.out.println("queueChannel3  "+message.getPayload().toString().toUpperCase(Locale.ROOT));
    }
}
