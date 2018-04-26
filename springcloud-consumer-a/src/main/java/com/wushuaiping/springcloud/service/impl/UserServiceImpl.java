package com.wushuaiping.springcloud.service.impl;

import com.wushuaiping.springcloud.repository.model.User;
import com.wushuaiping.springcloud.dao.UserJpaDao;
import com.wushuaiping.springcloud.service.IUserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther: wushuaiping
 * @date: 2018/4/2 上午9:50
 * @description:
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserJpaDao userJpaDao;

    @Resource
    private JpaRepository jpaRepository;

    @Override
    public List<User> queryAllUser() {
        return userJpaDao.findAll();
    }

    @Override
    public User queryUserById(Long id) {
        return userJpaDao.findById(id);
    }

    @Override
    public User queryUserByUsername(String username) {
        return userJpaDao.findByName(username);
    }

    @Override
    public List<User> queryUsersByUsername(String username) {
        return userJpaDao.findUser(username);
    }

    @Override
    public void deleteUser(Long id) {
        jpaRepository.delete(id);
    }

    @Override
    public User saveUser(User user) {
        return (User) jpaRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.saveUser(user);
    }
}
