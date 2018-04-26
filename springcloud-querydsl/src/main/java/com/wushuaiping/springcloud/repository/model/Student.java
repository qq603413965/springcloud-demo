package com.wushuaiping.springcloud.repository.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
