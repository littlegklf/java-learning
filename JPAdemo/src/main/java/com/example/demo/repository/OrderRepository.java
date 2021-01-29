package com.example.demo.repository;

import com.example.demo.model.entity.OrderEntity;
import com.example.demo.model.entity.ShopEntity;
import com.example.demo.repository.customer.CustomerOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author kuanglifang
 * @date 2020/12/25 15:36
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>, JpaSpecificationExecutor<OrderEntity>, CustomerOrderRepository {
    /**
     * 根据订单号查订单信息
     *
     * @param orderNumber
     * @return
     */
    Optional<OrderEntity> findByOrOrderNumber(String orderNumber);

    /**
     * 检查订单编号是否存在
     *
     * @param orderNumber
     * @return
     */
    boolean existsByOrderNumber(String orderNumber);
}
