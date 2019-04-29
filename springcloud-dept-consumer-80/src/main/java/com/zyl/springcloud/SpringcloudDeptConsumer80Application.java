package com.zyl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringcloudDeptConsumer80Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudDeptConsumer80Application.class, args);
	}

}
