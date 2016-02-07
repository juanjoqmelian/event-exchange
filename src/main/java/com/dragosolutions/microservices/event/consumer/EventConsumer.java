package com.dragosolutions.microservices.event.consumer;


import com.dragosolutions.microservices.event.Event;

public interface EventConsumer {

    void consume(Event event);
}
