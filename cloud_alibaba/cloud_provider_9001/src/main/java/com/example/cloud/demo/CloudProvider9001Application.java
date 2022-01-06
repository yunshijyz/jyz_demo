package com.example.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudProvider9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProvider9001Application.class, args);
    }

}
