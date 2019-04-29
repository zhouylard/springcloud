package com.zyl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringcloudDeptConsumer91FeignHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDeptConsumer91FeignHystrixApplication.class, args);
    }

}
