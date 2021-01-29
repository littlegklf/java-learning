package com.example.demo.repository;

import com.example.demo.model.entity.OrderShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author kuanglifang
 * @date 2021/1/28 14:21
 */
public interface OrderShopRepository extends JpaRepository<OrderShopEntity, Integer>, JpaSpecificationExecutor<OrderShopEntity> {
}
