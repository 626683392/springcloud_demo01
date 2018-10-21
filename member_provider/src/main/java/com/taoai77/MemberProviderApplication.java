package com.taoai77;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
public class MemberProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberProviderApplication.class, args);
    }
}
