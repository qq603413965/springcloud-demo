package com.wushuaiping.springcloud.callback;

import com.wushuaiping.springcloud.remote.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther: wushuaiping
 * @date: 2018/3/30 下午4:14
 * @description:
 */

@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(@RequestParam("name") String name) {
        return "this is hystrix: " + name;
    }
}
