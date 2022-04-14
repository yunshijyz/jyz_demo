package com.example.demo.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class ConfigBean {
    @Bean
    public Com_3 initCom_3() {
        return new Com_3();
    }

    @Bean
    @Lazy(value = false)
    public Com_4 initCom_4() {
        return new Com_4();
    }
}
