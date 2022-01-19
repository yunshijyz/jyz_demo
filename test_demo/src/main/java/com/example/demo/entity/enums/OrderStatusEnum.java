package com.example.demo.entity.enums;


import lombok.Getter;

@Getter
public enum OrderStatusEnum {


    PENDING_PAYMENT(1,"待付款"),

    PAID(2,"已支付"),

    CANCELLED(3,"已取消"),

    REFUNDED(4,"已退款"),

    ;

    private int code;

    private String info;

    OrderStatusEnum(int code, String info){
        this.code = code;
        this.info = info;
    }



}
