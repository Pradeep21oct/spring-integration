package com.spring.integartion.service;

import com.spring.integartion.model.Event;

@FunctionalInterface
public interface RouterService {
     void publishTo(Event event);
}
