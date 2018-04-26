package com.wushuaiping.springcloud.controller;

import com.wushuaiping.springcloud.remote.HelloRemote;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther: wushuaiping
 * @date: 2018/3/30 下午3:24
 * @description:
 */
@RestController
@RequestMapping("/hello")
public class ConsumerController {

    @Resource
    private HelloRemote helloRemote;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable("name") String name){
        return helloRemote.hello(name);
    }
}
