package com.example.demo.test;

import com.example.demo.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMqConfig.TOPIC_EXCHANGE_QUEUE_A))
public class TopicExchangeConsumerA {


    @RabbitHandler
    public void process(Map<String,Object> map){
        System.out.println("队列[" + RabbitMqConfig.TOPIC_EXCHANGE_QUEUE_A + "]收到消息：" + map.toString());
    }
}
