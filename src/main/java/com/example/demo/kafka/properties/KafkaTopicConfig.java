package com.example.demo.kafka.properties;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Getter
@Setter
@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic myTopic1(){
        return TopicBuilder.name("my-topic-transaction")
                .build();
    }

}