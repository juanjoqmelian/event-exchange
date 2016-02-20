package com.dragosolutions.microservices.event;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EventsTopic {

    public static final String EVENTS_TOPIC = "events-topic";

    private ConnectionFactory connectionFactory;


    public EventsTopic() {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
    }

    public void run() throws IOException, TimeoutException {
        Connection connection = connectionFactory.newConnection();
        System.out.println(String.format("Connected to %s ", connection.getAddress()));
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EVENTS_TOPIC, "topic");
        System.out.println(String.format("Topic with name %s declared.", EVENTS_TOPIC));
    }


    public static void main(String[] args) {

        try {
            new EventsTopic().run();
        } catch (TimeoutException | IOException e) {
            e.printStackTrace();
        }
    }
}
