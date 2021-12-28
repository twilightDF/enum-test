package com.twilight.common.inter;

import java.util.Map;

public interface RabbitMQService {
    String sendMsg(String msg);

    String sendMsgFanoutExchange(String msg);

    String sendMsgTopicExchange(String msg,String routingKey);

    String sendMsgByHeadersExchange(String msg, Map<String,Object> map);
}
