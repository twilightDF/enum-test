package com.twilight.rabbitmq.consumer;

import com.twilight.common.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_B))
public class FanoutExchangeConsumerB {
    @RabbitHandler
    public void process(Map<String,Object> map){
        System.out.println("队列B收到消息：" + map.toString());
    }
}
