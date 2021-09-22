package com.atguigu.springcloud.config;

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
    public RestTemplate getRestTemplate () {
        return new RestTemplate();
    }
}
