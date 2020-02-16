package com.scauly.SpringCloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.scauly.SpringCloud"})
@ComponentScan("com.scauly.SpringCloud")
public class FundConsumer9002_App {
    public static void main(String[] args)
    {
        SpringApplication.run(FundConsumer9002_App.class, args);
    }
}
