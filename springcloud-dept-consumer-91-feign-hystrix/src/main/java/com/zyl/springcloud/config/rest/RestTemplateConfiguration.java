package com.zyl.springcloud.config.rest;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 1.restful调用
 * 2.负载均衡，Ribbon，默认算法为轮询
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced //SpringCloud Ribbon是基于Nefflix Ribbon实现的一套客户端负载均衡工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 通过IRule来自定义Ribbon负载均衡的算法
     * @return
     */
    @Bean
    public IRule getIRule(){
//        return new RoundRobinRule();// 默认轮询
//        return new RandomRule();// 随机
        return new RetryRule();// 服务正常时和轮询一样；服务异常时，会尝试几次就放弃异常服务
    }
}
