package com.wushuaiping.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka server register center main run class
 *
 * @auther: wushuaiping
 * @date: 2018/3/30 下午2:42
 * @description:
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegisterCenterApplication.class, args);
    }
}
