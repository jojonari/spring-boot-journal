package com.fast87.journal.config;

import com.fast87.journal.redis.Consumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * Created by jojonari on 2017. 7. 15..
 */
@Configuration
public class RedisConfig {
//    @Value("${topic}")
//    String topic;
//
//    @Bean
//    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.addMessageListener(listenerAdapter, new PatternTopic(topic));
//        return container;
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(Consumer consumer){
//        return new MessageListenerAdapter(consumer, "messageHandler");
//    }

}
