package com.twilight.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilight.common.inter.RabbitMQService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 *  https://developer.aliyun.com/article/769883
 */
@RestController()
@RequestMapping("/mall/rabbitmq")
public class RabbitMQController {

    @Resource
    private RabbitMQService rabbitMQService;

    @PostMapping("/sendMsg")
    public String sendMsg(String msg){
        return rabbitMQService.sendMsg(msg);
    }

    @PostMapping("/publish")
    public String publish(String msg){
        return rabbitMQService.sendMsgFanoutExchange(msg);
    }

    @PostMapping("/topicSend")
    public String topicSend(String msg,String routingKey){
        return rabbitMQService.sendMsgTopicExchange(msg,routingKey);
    }

    @PostMapping("/headersSend")
    @SuppressWarnings("unchecked")
    public String headersSend(String msg, String json) throws JsonProcessingException {

        //此处用body传参，代替从header中获取匹配参数
//        HttpHeaders headers = request.getHeaders();
//        Map<String, String> stringStringMap = headers.toSingleValueMap();

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(json,Map.class);//将json转为对应的对象
        return rabbitMQService.sendMsgByHeadersExchange(msg,map);

    }
}
