package com.example.kfaka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class KfakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KfakaApplication.class, args);
    }
}
