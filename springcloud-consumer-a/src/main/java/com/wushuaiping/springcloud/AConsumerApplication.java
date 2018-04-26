package com.wushuaiping.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * spring cloud consumer main run class
 * @auther: wushuaiping
 * @date: 2018/3/30 下午3:10
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AConsumerApplication.class, args);
    }
}
