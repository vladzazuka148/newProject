package com.example.demo.kafka.properties;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "my-topic3" , groupId = "group-id")
    void listaner(String data){
            System.out.println("i am listaner 3 and i catch your message look :" + data);
    }

    @KafkaListener(topics = "my-topic4" , groupId = "group-id")
    void listener1(String data){
            System.out.println("i am listaner 4 and i catch your message look :" + data);
    }
}
