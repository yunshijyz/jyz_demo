package com.example.demo.entity.enums;

import lombok.Getter;

@Getter
public enum OrderTypeEnum {

    BUY(1),

    TRYOUT(2),

    RENEW(3),

    ;

    private int code;

    OrderTypeEnum(int code){
       this.code = code;
    }



}
