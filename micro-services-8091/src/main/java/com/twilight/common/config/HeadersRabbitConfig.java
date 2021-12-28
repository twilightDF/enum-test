package com.twilight.common.config;

import com.rabbitmq.client.AMQP;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class HeadersRabbitConfig implements BeanPostProcessor {

    @Resource
    private RabbitAdmin admin;

    @Bean
    public HeadersExchange rabbitHeaderExchange(){
        return new HeadersExchange(RabbitMQConfig.HEADER_EXCHANGE_DEMO_NAME,true,false);
    }

    @Bean
    public Queue headerQueueA(){
        return new Queue(RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_A,true,false,false);
    }

    @Bean
    public Queue headerQueueB(){
        return new Queue(RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_B,true,false,false);
    }

    @Bean
    public Binding bindHeadersA(){
        Map<String,Object> map = new HashMap<>();
        map.put("headers_A","java");
        map.put("headers_B","rabbit");

        //全匹配
        return BindingBuilder
                .bind(headerQueueA())
                .to(rabbitHeaderExchange())
                .whereAll(map).match();
    }

    @Bean
    public Binding bindHeadersB(){
        Map<String, Object> map = new HashMap<>();
        map.put("key_one","coke");
        map.put("key_two","sky");

        //部分匹配
        return BindingBuilder
                .bind(headerQueueB())
                .to(rabbitHeaderExchange())
                .whereAny(map).match();
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        admin.declareExchange(rabbitHeaderExchange());
        admin.declareQueue(headerQueueA());
        admin.declareQueue(headerQueueB());
        return null;
    }
}
