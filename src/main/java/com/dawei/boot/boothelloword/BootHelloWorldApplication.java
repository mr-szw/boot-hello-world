package com.dawei.boot.boothelloword;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
//Mybatis 扫包
//@MapperScan(basePackages = "com.dawei.boot.boothelloword.mapper")
@EnableEurekaClient
@EnableFeignClients
public class BootHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootHelloWorldApplication.class, args);
    }

}
