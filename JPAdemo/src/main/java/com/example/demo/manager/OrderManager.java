package com.example.demo.manager;

import com.example.demo.model.entity.*;
import com.example.demo.model.vo.OrderShopInfoVO;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kuanglifang
 * @date 2021/1/28 10:42
 */
@Component
@Slf4j
public class OrderManager {
    @Resource
    private JPAQueryFactory queryFactory;

    public List<OrderShopInfoVO> getOrderShopInfo(Integer userId) {
        QOrderEntity orderEntity = QOrderEntity.orderEntity;
        QOrderShopEntity orderShopEntity = QOrderShopEntity.orderShopEntity;
        QShopEntity shopEntity = QShopEntity.shopEntity;
        return queryFactory.select(Projections.bean(OrderShopInfoVO.class,
                orderShopEntity.shopId.as(OrderShopInfoVO.Fields.shopId), orderShopEntity.amount.as(OrderShopInfoVO.Fields.amount),
                shopEntity.name.as(OrderShopInfoVO.Fields.name), orderShopEntity.money.as(OrderShopInfoVO.Fields.money)))
                .from(orderEntity)
                .leftJoin(orderShopEntity)
                .on(orderEntity.orderNumber.eq(orderShopEntity.orderNumber))
                .leftJoin(shopEntity)
                .on(orderShopEntity.shopId.eq(shopEntity.id))
                .where(orderEntity.userId.eq(userId))
                .fetch();
    }

    /**
     * 另一种方法
     */

    public List<OrderShopInfoVO> getOrderShopInfo2(Integer userId) {
        QOrderEntity orderEntity = QOrderEntity.orderEntity;
        QOrderShopEntity orderShopEntity = QOrderShopEntity.orderShopEntity;
        QShopEntity shopEntity = QShopEntity.shopEntity;
        Predicate predicate = orderEntity.orderNumber.eq(orderShopEntity.orderNumber)
                .and(orderShopEntity.shopId.eq(shopEntity.id))
                .and(orderEntity.userId.eq(userId));
        return queryFactory.select(Projections.bean(OrderShopInfoVO.class,
                orderShopEntity.shopId.as(OrderShopInfoVO.Fields.shopId), orderShopEntity.amount.as(OrderShopInfoVO.Fields.amount),
                shopEntity.name.as(OrderShopInfoVO.Fields.name), orderShopEntity.money.as(OrderShopInfoVO.Fields.money)))
                .from(orderEntity, orderShopEntity, shopEntity)
                .where(orderEntity.orderNumber.eq(orderShopEntity.orderNumber)
                        .and(orderShopEntity.shopId.eq(shopEntity.id))
                        .and(orderEntity.userId.eq(userId)))
                .fetch();
    }
}
