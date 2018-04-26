package com.wushuaiping.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  spring cloud producer main run class
 * @auther: wushuaiping
 * @date: 2018/3/30 下午2:48
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AProducerApplication.class, args);
    }
}
