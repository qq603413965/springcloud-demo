package com.wushuaiping.springcloud.service;

import com.wushuaiping.springcloud.repository.model.User;

import java.util.List;

/**
 *
 * @auther: wushuaiping
 * @date: 2018/3/30 下午5:50
 * @description:
 */
public interface IUserService {

    List<User> queryAllUser();

    User queryUserById(Long id);

    User queryUserByUsername(String username);

    List<User> queryUsersByUsername(String username);

    void deleteUser(Long id);

    User saveUser(User user);

    User updateUser(User user);
}
