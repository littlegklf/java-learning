package com.example.demo.repository;

import com.example.demo.model.entity.LocationEntity;
import com.example.demo.repository.customer.CustomerLocationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author kuanglifang
 * @date 2021/1/5 11:46
 */
public interface LocationRepository extends JpaRepository<LocationEntity, Integer>, JpaSpecificationExecutor<LocationEntity>, CustomerLocationRepository {
}
