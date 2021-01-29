package com.example.demo.repository.customer;

import com.example.demo.model.entity.QOrderEntity;
import com.example.demo.model.vo.OrderSumVO;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kuanglifang
 * @date 2021/1/5 16:18
 */
@Component
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository {

    @Autowired
    private JPAQueryFactory queryFactory;

    private QOrderEntity qOrderEntity = QOrderEntity.orderEntity;

    @Override
    public List<OrderSumVO> orderAmountAll() {
        QueryResults<OrderSumVO> results = queryFactory.select(Projections.bean(OrderSumVO.class,
                qOrderEntity.userId.as(OrderSumVO.Fields.userId),
                qOrderEntity.userId.count().as(OrderSumVO.Fields.amount)))
                .from(qOrderEntity)
                .groupBy(qOrderEntity.userId)
                .fetchResults();
        return results.getResults();
    }

    @Override
    public Long orderAmountByUser(Integer userId) {
        return queryFactory.from(qOrderEntity).where(qOrderEntity.userId.eq(userId)).fetchCount();
    }
}
