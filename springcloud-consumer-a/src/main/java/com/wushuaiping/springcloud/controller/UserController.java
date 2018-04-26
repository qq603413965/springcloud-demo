package com.wushuaiping.springcloud.controller;

import com.wushuaiping.springcloud.repository.model.User;
import com.wushuaiping.springcloud.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther: wushuaiping
 * @date: 2018/4/2 上午9:55
 * @description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> userList(){
        return userService.queryAllUser();
    }

}
