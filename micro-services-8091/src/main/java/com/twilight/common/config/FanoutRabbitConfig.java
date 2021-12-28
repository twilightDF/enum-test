package com.twilight.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Configuration
@Component
public class FanoutRabbitConfig implements BeanPostProcessor {

    @Resource
    private RabbitAdmin admin;

    @Bean
    public Queue fanoutExchangeQueueA(){
        //队列A
        return new Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_A,true,false,false);
    }

    @Bean
    public Queue fanoutExchangeQueueB(){
        //队列B
        return new Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_B,true,false,false);
    }

    @Bean
    public FanoutExchange rabbitmqDemoFanoutExchange(){
        //创建FanoutExchange类型交换机
        return new FanoutExchange(RabbitMQConfig.FANOUT_EXCHANGE_DEMO_NAME,true,false);
    }

    @Bean
    public Binding bindFanoutA(){
        //绑定A队列到FanoutExchange交换机
        return BindingBuilder
                .bind(fanoutExchangeQueueA())
                .to(rabbitmqDemoFanoutExchange());
    }

    @Bean
    public Binding bindFanoutB(){
        //绑定B队列到FanoutExchange交换机
        return BindingBuilder
                .bind(fanoutExchangeQueueB())
                .to(rabbitmqDemoFanoutExchange());
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //启动项目即创建交换机和队列
        admin.declareExchange(rabbitmqDemoFanoutExchange());
        admin.declareQueue(fanoutExchangeQueueB());
        admin.declareQueue(fanoutExchangeQueueA());
        return null;
    }




}
