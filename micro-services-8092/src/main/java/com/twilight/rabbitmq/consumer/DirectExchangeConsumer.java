package com.twilight.rabbitmq.consumer;

import com.twilight.common.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC))
public class DirectExchangeConsumer {

    @RabbitHandler
    public void process(Map map){
        System.out.println(map.toString());
    }
}
