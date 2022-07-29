package com.spring.integartion.service;

import com.spring.integartion.model.Event;
@FunctionalInterface
public interface EventService {
     void publishTo(Event event);
}
