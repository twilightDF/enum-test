package com.twilight.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TopicRabbitConfig implements BeanPostProcessor {

    @Resource
    private RabbitAdmin admin;


    @Bean
    public TopicExchange rabbitTopicExchange(){
        return new TopicExchange(RabbitMQConfig.TOPIC_EXCHANGE_DEMO_NAME,true,false);
    }

    @Bean
    public Queue topicExchangeQueueA(){
        return new Queue(RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_A,true,false,false);
    }

    @Bean
    public Queue topicExchangeQueueB(){
        return new Queue(RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_B,true,false,false);
    }

    @Bean
    public Queue topicExchangeQueueC(){
        return new Queue(RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_C,true,false,false);
    }

    @Bean
    public Binding bindTopicA(){
        return BindingBuilder
                .bind(topicExchangeQueueA())
                .to(rabbitTopicExchange())
                .with("a.*");
    }

    @Bean
    public Binding bindTopicB(){
        return BindingBuilder
                .bind(topicExchangeQueueB())
                .to(rabbitTopicExchange())
                .with("a.*");
    }

    @Bean
    public Binding bindTopicC(){
        return BindingBuilder
                .bind(topicExchangeQueueC())
                .to(rabbitTopicExchange())
                .with("rabbit.#");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        admin.declareExchange(rabbitTopicExchange());
        admin.declareQueue(topicExchangeQueueA());
        admin.declareQueue(topicExchangeQueueB());
        admin.declareQueue(topicExchangeQueueC());
        return null;
    }
}
