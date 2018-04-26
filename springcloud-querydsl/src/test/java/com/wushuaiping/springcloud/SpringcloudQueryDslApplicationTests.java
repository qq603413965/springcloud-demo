package com.wushuaiping.springcloud;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wushuaiping.springcloud.repository.CompanyRepository;
import com.wushuaiping.springcloud.repository.model.*;
import com.wushuaiping.springcloud.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SpringcloudQueryDslApplicationTests {

	@Autowired
	private UserService userService;

	@Mock
	private CompanyRepository companyRepository;

	@PersistenceContext
	private EntityManager entityManager;

	private JPAQueryFactory jpaQueryFactory;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testAdd(){
		for (int i = 0; i <= 20; i++){
			User user = new User();
			user.setUsername(i+"号");
			user.setPassword(i+"234567890");
			if (i % 2 == 0){
			    user.setCompanyId(1L);
            }else {
			    user.setCompanyId(2L);
            }
			userService.saveUser(user);
		}
	}

    /**
     * 查询一个用户
     */
	@Test
	public void testGet(){
        QUser user = QUser.user;
        jpaQueryFactory = new JPAQueryFactory(entityManager);
		User user1 = jpaQueryFactory.selectFrom(user).where(user.id.eq(1L)).fetchOne();
        System.out.println(user1.toString());
    }

    @Test
	public void testGetUserAndCompany(){
        UserAndCompany.UserAndCompanyBuilder builder = UserAndCompany.builder();
        List<UserAndCompany> userAndCompanies = new ArrayList<>();
		QUser qUser = QUser.user;
		QCompany qCompany = QCompany.company;
		jpaQueryFactory = new JPAQueryFactory(entityManager);
		List<User> fetch = (List<User>) jpaQueryFactory.from(qUser, qCompany).fetch();
		fetch.forEach(user -> {
			Long companyId = user.getCompanyId();
			if (companyId != null){
				Company company = (Company) jpaQueryFactory.from(qCompany).where(qCompany.id.eq(companyId)).fetchOne();
                builder.companyId(companyId);
				builder.companyName(company.getName());
				builder.userId(user.getId());
				builder.username(user.getUsername());
                userAndCompanies.add(builder.build());
			}
		});
		userAndCompanies.forEach(item -> System.out.println(item));
	}

	@Test
	public void testCheckUser(){
		QUser qUser = QUser.user;
		QCompany qCompany = QCompany.company;
		jpaQueryFactory = new JPAQueryFactory(entityManager);
		// 第一种查询方式
		User user = jpaQueryFactory.selectFrom(qUser)
                .where(qUser.username.eq("哈哈"),
                        qUser.password.eq("1234567890"))
                .fetchOne();
		// 第二种查询方式
		User user1 = jpaQueryFactory.selectFrom(qUser)
                .where(qUser.username.eq("哈哈")
                        .and(qUser.password.eq("1234567890")))
                .fetchOne();

		// 使用or
		List<User> users = jpaQueryFactory.selectFrom(qUser)
                .where(qUser.username.eq("哈哈")
                        .or(qUser.username.eq("1号")))
                .fetch();
		// left join
        List<Tuple> list = jpaQueryFactory.select(qUser, qCompany)
                .from(qUser)
                .leftJoin(qCompany)
                .on(qUser.companyId.eq(qCompany.id))
                .where(qCompany.id.eq(1L))
                .orderBy(qUser.id.desc()).offset(10).limit(19)
                .fetch();
        list.forEach(item -> {
            Company company = item.get(qCompany);
            User user2 = item.get(qUser);
        });
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Test
	public void testNPlusOne(){
        jpaQueryFactory = new JPAQueryFactory(entityManager);
        QTeacher qTeacher = QTeacher.teacher;
        List<Teacher> fetch = jpaQueryFactory.select(qTeacher).from(qTeacher).fetch();
        fetch.forEach(teacher -> {
            System.out.println(teacher.toString());
        });
    }

    @Test
    public void testMock(){
        Company company = new Company();
        company.setId(1L);
        company.setName("娃哈哈");
        when(companyRepository.findByName("a")).thenReturn(company);
    }
}
