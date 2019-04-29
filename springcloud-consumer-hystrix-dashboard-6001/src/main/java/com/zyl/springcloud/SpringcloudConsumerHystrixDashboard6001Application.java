package com.zyl.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@EnableHystrixDashboard
@SpringBootApplication
public class SpringcloudConsumerHystrixDashboard6001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerHystrixDashboard6001Application.class, args);
    }

}
