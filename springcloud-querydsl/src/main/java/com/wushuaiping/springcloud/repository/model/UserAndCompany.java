package com.wushuaiping.springcloud.repository.model;

import lombok.*;

/**
 * @another: wushuaiping
 * @date: 2018/4/3 下午8:57
 * @description:
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAndCompany {

    private Long companyId;

    private Long userId;

    private String companyName;

    private String username;

}
