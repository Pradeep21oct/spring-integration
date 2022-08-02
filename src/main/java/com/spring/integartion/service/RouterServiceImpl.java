package com.spring.integartion.service;

import com.spring.integartion.gateway.EventGateway;
import com.spring.integartion.gateway.RouterChannelGateway;
import com.spring.integartion.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class RouterServiceImpl implements RouterService {
    private RouterChannelGateway eventGateway;
@Autowired
    public RouterServiceImpl(RouterChannelGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public void publishTo(Event event){
        Message<Event> message= MessageBuilder.withPayload(event).build();
        eventGateway.routeMessage(message);

    }
}
