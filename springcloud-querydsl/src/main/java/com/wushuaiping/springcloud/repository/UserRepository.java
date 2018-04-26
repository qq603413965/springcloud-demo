package com.wushuaiping.springcloud.repository;


import com.wushuaiping.springcloud.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author: Shuaiping Wu
 * @Date: 2018/4/3 下午4:49
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findById(Long id);

    List<User> findAll();
}
