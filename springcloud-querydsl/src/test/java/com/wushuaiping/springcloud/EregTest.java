package com.wushuaiping.springcloud;

import com.wushuaiping.springcloud.repository.model.User;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @another: wushuaiping
 * @date: 2018/4/17 上午9:26
 * @description:
 */

public class EregTest {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
       /* Map<Integer, List<User>> map = new HashMap<>();
        for (int i = 0; i < 20; i++){
            User user = new User();
            List<User> users = new ArrayList<>();
            if (i % 2 == 0){
                user.setCompanyId(1L);
            }
            user.setCompanyId(2L);
            user.setId(Long.valueOf(i));
            user.setUsername("员工"+i);
            user.setPassword("123123"+i);
            users.add(user);
            map.put(i,  users);
        }
        map.entrySet().stream().map(entry -> entry.getValue().stream().map(User :: getUsername).reduce((t, u) -> t + "," + u).);
        map.entrySet().stream().map(entry -> entry.getKey() + ":" + "1");*/
    }

}
