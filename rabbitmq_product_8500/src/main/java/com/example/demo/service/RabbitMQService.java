package com.example.demo.service;

public interface RabbitMQService {

    public String sendMsg(String msg) throws Exception;

    public String sendMsgByFanoutExchange(String msg) throws Exception;

    public String sendMsgByTopicExchange(String msg, String routingKey) throws Exception;

}
