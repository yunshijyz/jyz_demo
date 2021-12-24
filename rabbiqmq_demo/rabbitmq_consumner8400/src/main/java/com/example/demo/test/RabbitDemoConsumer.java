package com.example.demo.test;


import com.alibaba.fastjson.JSON;
import com.example.demo.config.RabbitMqConfig;
import com.example.demo.entity.User;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMqConfig.RABBITMQ_DEMO_TOPIC))
public class RabbitDemoConsumer {


    @RabbitHandler
    public void process(String map){
        User user = JSON.parseObject(map, User.class);
        System.out.println("消费信息:"+user);
    }


}
