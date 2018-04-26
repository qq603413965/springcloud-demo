package com.wushuaiping.springcloud.remote;

import com.wushuaiping.springcloud.callback.HelloRemoteHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * remote invoke interface
 *  invoke server name a eureka-produce the method
 * @auther: wushuaiping
 * @date: 2018/3/30 下午3:21
 * @description:
 */
@FeignClient(serviceId = "eureka-producer", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    /**
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
}
