package com.example.demo.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * 使用QueryDSL的功能时，会依赖使用到JPAQueryFactory，而JPAQueryFactory在这里依赖使用EntityManager，
 * 所以在主类中做如下配置，使得Spring自动帮我们注入EntityManager与自动管理JPAQueryFactory
 *
 * @author kuanglifang
 * @date 2021/1/5 17:32
 */
@Configuration
public class QueryDslConfig {

    /**
     * 让spring管理JPAQueryFactory
     **/
    @Bean
    public JPAQueryFactory queryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}
