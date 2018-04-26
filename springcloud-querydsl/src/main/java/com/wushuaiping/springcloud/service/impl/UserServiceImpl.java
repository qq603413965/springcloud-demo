package com.wushuaiping.springcloud.service.impl;

import com.wushuaiping.springcloud.repository.UserRepository;
import com.wushuaiping.springcloud.repository.model.User;
import com.wushuaiping.springcloud.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @another: wushuaiping
 * @date: 2018/4/3 下午5:00
 * @description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        this.saveUser(user);
    }

    @Override
    public User queryUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public List<User> queryAllUser() {
        return userRepository.findAll();
    }
}
