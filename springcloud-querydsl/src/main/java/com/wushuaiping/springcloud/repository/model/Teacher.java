package com.wushuaiping.springcloud.repository.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @another: wushuaiping
 * @date: 2018/4/9 上午9:47
 * @description:
 */

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // 默认为fetch = lazy， 如果设置为EAGER，查询该Teacher的时候，会把关联的Student也会查询出来放到内存中。
    @OneToMany//(fetch = FetchType.EAGER)
    private List<Student> students;
}
