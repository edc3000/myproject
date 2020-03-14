package com.scauly.SpringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class upLoad_APP {
    public static void main(String[] args) {
        SpringApplication.run(upLoad_APP.class, args);
    }

}
