package com.wushuaiping.springcloud.contoller;

import com.wushuaiping.springcloud.repository.model.User;
import com.wushuaiping.springcloud.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @another: wushuaiping
 * @date: 2018/4/3 下午5:11
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/all")
    @ResponseBody
    public List<User> getUser() {
        return userService.queryAllUser();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Long id) {
        return userService.queryUserById(id);
    }
}
