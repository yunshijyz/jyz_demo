package com.example.security.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtUtil {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${token.secret}")
    private String secret;

    @Value("${token.header}")
    private String header;

    @Value("${token.expireTime}")
    private int expireTime;


    private static final long MILLIS_SECOND = 1000;

    private static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;



    public String getJwtToken(){
       JwtBuilder jwtBuilder = Jwts.builder();

       jwtBuilder
               //声明标识 {"jti":"jwt"}
               .setId("jwt")
               //主体 {"sub":"jyz"}
               .setSubject("jyz")
               //时间 {"ita":""}
               .setIssuedAt(new Date())
               //签名 参数1：算法 ;参数2：盐
               .signWith(SignatureAlgorithm.HS256,secret);

       String token = jwtBuilder.compact();

       return token;
    }


    public void claimToken(String token){

        String[] split = token.split("\\.");
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));

        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));

    }


}
