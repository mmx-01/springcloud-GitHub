package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author LIMENGJIE
 * @ClassName ApplicationContextConfig
 * @Date 2021/9/18 5:08 下午 2021
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //该注解的含义为：为Template赋予负载均衡的功能！！
    public RestTemplate getRestTemplate () {
        return new RestTemplate();
    }
}
