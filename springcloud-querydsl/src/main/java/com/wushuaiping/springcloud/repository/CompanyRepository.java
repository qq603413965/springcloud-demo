package com.wushuaiping.springcloud.repository;

import com.wushuaiping.springcloud.repository.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @another: wushuaiping
 * @date: 2018/4/3 下午8:30
 * @description:
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByName(String name);

    List<Company> findAll();

}
