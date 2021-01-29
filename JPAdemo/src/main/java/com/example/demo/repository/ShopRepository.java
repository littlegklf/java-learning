package com.example.demo.repository;

import com.example.demo.model.entity.ShopEntity;
import com.example.demo.repository.customer.CustomerShopRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author kuanglifang
 * @date 2020/12/21 20:18
 */
public interface ShopRepository extends JpaRepository<ShopEntity, Integer>, JpaSpecificationExecutor<ShopEntity>, CustomerShopRepository {
}
