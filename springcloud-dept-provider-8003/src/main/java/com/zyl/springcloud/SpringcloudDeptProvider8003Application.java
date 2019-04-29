package com.zyl.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient// 服务发现
@EnableEurekaClient
@MapperScan("com.zyl.springcloud.dao")
@SpringBootApplication
public class SpringcloudDeptProvider8003Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDeptProvider8003Application.class, args);
    }

}
