package com.dragosolutions.microservices.event.publisher;


import com.dragosolutions.microservices.event.Event;

public interface EventPublisher {

    void publish(Event event);
}
