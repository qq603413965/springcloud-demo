package com.wushuaiping.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wushuaiping
 * @date: 2018/3/30 下午2:54
 * @description:
 */

@RestController
public class ProducerController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name){
        return "hello【" + name + "】, this is producer a";
    }
}