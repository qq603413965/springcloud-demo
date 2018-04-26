package com.wushuaiping.springcloud.dao;

import com.wushuaiping.springcloud.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @auther: wushuaiping
 * @date: 2018/3/30 下午5:40
 * @description:
 */
public interface UserJpaDao extends JpaRepository<User, Long> {

    /**
     * 查询所有数据
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 根据姓名精确匹配一个
     * @param name
     * @return
     */
    User findByName(String username);

    /**
     * 根据username模糊查询
     * @param username
     * @return
     */
    @Query("FROM user u WHERE u.name LIKE CONCAT('%', ':username', '%') ")
    List<User> findUser(@Param("username") String username);

    /**
     * 根据id删除一个用户
     * @param id
     */
    void deleteUserById(Long id);

    /**
     * 保存一个用户
     * @param user
     * @return
     */
    User save(User user);

    /**
     * 保存一个用户后刷新数据
     * @param user
     * @return
     */
    User saveAndFlush(User user);

}
