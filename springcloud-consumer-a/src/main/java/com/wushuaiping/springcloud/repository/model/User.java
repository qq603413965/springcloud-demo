package com.wushuaiping.springcloud.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * @auther: wushuaiping
 * @date: 2018/3/30 下午5:31
 * @description:
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue // 这个注解是为了拿到插入数据后，需要拿到该数据插入后的值。
    private Long    id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore // 获取时过滤该字段
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
