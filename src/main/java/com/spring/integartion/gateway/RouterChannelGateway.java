package com.spring.integartion.gateway;

import com.spring.integartion.model.Event;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "routerChannelGateway",defaultRequestChannel = "filterChannel")
public interface RouterChannelGateway {
    @Gateway
    void routeMessage(Message<Event> message);
}
