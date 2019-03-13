package com.dawei.boot.boothelloword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BootHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootHelloWorldApplication.class, args);
    }

}
