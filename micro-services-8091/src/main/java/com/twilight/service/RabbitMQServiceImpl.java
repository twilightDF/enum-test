package com.twilight.service;

import com.twilight.common.config.RabbitMQConfig;
import com.twilight.common.inter.RabbitMQService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class RabbitMQServiceImpl implements RabbitMQService {
    //日期格式化
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendMsg(String msg) {
    Map<String, Object> map = getMessage(msg);
        try{
            rabbitTemplate.convertAndSend(RabbitMQConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE,
                                          RabbitMQConfig.RABBITMQ_DEMO_DIRECT_ROUTING,
                                          map);
            return "ok";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public String sendMsgFanoutExchange(String msg) {
        Map<String, Object> message = getMessage(msg);
        try{
            rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE_DEMO_NAME,"",message);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public String sendMsgTopicExchange(String msg,String routingKey) {
        Map<String, Object> message = getMessage(msg);
        try{
            rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE_DEMO_NAME,routingKey,message);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public String sendMsgByHeadersExchange(String msg, Map<String, Object> map) {

        try{
            MessageProperties messageProperties = new MessageProperties();
            //消息持久化
            messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            messageProperties.setContentType("UTF-8");
            //添加消息
            messageProperties.getHeaders().putAll(map);
            Message message = new Message(msg.getBytes(), messageProperties);
            rabbitTemplate.convertAndSend(RabbitMQConfig.HEADER_EXCHANGE_DEMO_NAME,null,message);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }


    public Map<String,Object> getMessage(String msg){
        String msgId = UUID.randomUUID().toString().replace("-","").substring(0,32);
        String sendTime = sdf.format(new Date());
        Map<String,Object> map = new HashMap();
        map.put("msgId",msgId);
        map.put("sendTime",sendTime);
        map.put("msg",msg);
        return map;
    }
}
