package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.config.RabbitMqConfig;
import com.example.demo.entity.User;
import com.example.demo.service.RabbitMQService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class RabbitMQServiceImpl implements RabbitMQService {


    private static final Logger log = LoggerFactory.getLogger(RabbitMQServiceImpl.class);

    //日期格式化
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendMsg(String msg) throws Exception {

        try {
            String msgId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
            String sendTime = sdf.format(new Date());
            Map<String, Object> map = new HashMap<>();
            map.put("msgId", msgId);
            map.put("sendTime", sendTime);
            map.put("msg", msg);
            User user = new User();
            user.setName("jyz");
            user.setAddress(msg);
            user.setId(1L);
            String s = JSON.toJSONString(user);
            rabbitTemplate.convertAndSend(RabbitMqConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE, RabbitMqConfig.RABBITMQ_DEMO_DIRECT_ROUTING, s);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                if(b){
                    log.info("ok");
                } else {
                    log.error("error");
                }
            }
        });
    }


    //发布消息
    @Override
    public String sendMsgByFanoutExchange(String msg) throws Exception {
        Map<String, Object> message = getMessage(msg);
        log.info("msg:{}",msg);
        try {
            rabbitTemplate.convertAndSend(RabbitMqConfig.FANOUT_EXCHANGE_DEMO_NAME, "", message);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public String sendMsgByTopicExchange(String msg, String routingKey) throws Exception {
        Map<String, Object> message = getMessage(msg);
        try {
            //发送消息
            rabbitTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE_DEMO_NAME, routingKey, message);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //组装消息体
    private Map<String, Object> getMessage(String msg) {
        String msgId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        String sendTime = sdf.format(new Date());
        Map<String, Object> map = new HashMap<>();
        map.put("msgId", msgId);
        map.put("sendTime", sendTime);
        map.put("msg", msg);
        return map;
    }
}


