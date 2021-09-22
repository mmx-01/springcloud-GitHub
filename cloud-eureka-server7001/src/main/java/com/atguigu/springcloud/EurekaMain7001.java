package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author LIMENGJIE
 * @ClassName EurekaMain7001
 * @Date 2021/9/22 4:41 下午 2021
 */
@SpringBootApplication
@EnableEurekaServer //表示是Eureka的Server端
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class , args);
    }
}
