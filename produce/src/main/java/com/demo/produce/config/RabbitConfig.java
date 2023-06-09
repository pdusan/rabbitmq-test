package com.demo.produce.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.impl.AMQImpl.Exchange.Bind;

@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.host}")
    String host;

    @Value("${spring.rabbitmq.username}")
    String username;

    @Value("${spring.rabbitmq.password}")
    String password;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("test_exchange");
    }

    @Bean
    public Queue itemQueue() {
        return new Queue("item_queue_1");
    }

    @Bean
    public Queue itemQueue2() {
        return new Queue("item_queue_2");
    }

    @Bean
    public Queue stringQueue() {
        return new Queue("string_queue");
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(itemQueue()).to(topicExchange()).with("item.#");
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(itemQueue2()).to(topicExchange()).with("item.#");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(stringQueue()).to(topicExchange()).with("string.#");
    }

    @Bean
    CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}