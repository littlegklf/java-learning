package com.example.demo.repository.customer;

import com.example.demo.model.vo.OrderSumVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kuanglifang
 * @date 2020/12/25 15:37
 */
@Component
public interface CustomerOrderRepository {
    /**
     * 查找用户的订单数量
     *
     * @return
     */
    List<OrderSumVO> orderAmountAll();

    /**
     * 查找某个用户的订单数量
     *
     * @param userId
     * @return
     */
    Long orderAmountByUser(Integer userId);
}
