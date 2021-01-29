package com.example.demo.repository;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.customer.CustomerUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author kuanglifang
 * @date 2020/12/16 20:12
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity>, CustomerUserRepository {
    /**
     * 根据用户名查用户
     *
     * @param userName
     * @return
     */
    Optional<UserEntity> findByUserName(String userName);
}
