package com.taoai77;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
@EnableFeignClients//开启feigh调用
@SpringCloudApplication//组合注解，默认带有@EnableCircuitBreaker注解和@SpringBootApplication注解
public class OrderConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerApplication.class, args);
    }
}
