package com.example.security.entity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class SysSecret {

    @Value("${token.secret}")
    private String secret;


}
