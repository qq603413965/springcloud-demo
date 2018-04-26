package com.wushuaiping.springcloud.service;

import com.wushuaiping.springcloud.repository.model.User;

import java.util.List;

/**
 * @another: wushuaiping
 * @date: 2018/4/3 下午5:00
 * @description:
 */
public interface UserService {

    void saveUser(User user);

    void deleteUserById(Long id);

    void updateUser(User user);

    User queryUserById(Long id);

    List<User> queryAllUser();
}
