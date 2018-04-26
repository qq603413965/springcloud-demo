package com.wushuaiping.springcloud.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * remote invoke interface
 *  invoke server name a eureka-produce the method
 * @auther: wushuaiping
 * @date: 2018/3/30 下午3:21
 * @description:
 */
@FeignClient("eureka-producer")
public interface HelloRemote {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    String hello(@PathVariable("name") String name);
}
