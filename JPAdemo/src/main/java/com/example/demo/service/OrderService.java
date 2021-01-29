package com.example.demo.service;

import com.example.demo.model.req.AddOrderReq;
import com.example.demo.model.vo.OrderShopInfoVO;
import com.example.demo.model.vo.OrderSumVO;
import com.example.demo.model.vo.OrderVO;

import java.util.List;

/**
 * @author kuanglifang
 * @date 2020/12/25 15:41
 */
public interface OrderService {
    /**
     * 添加订单
     *
     * @param req
     */
    void addOrder(AddOrderReq req);

    /**
     * 根据订单号查订单数据
     *
     * @param orderNumber
     * @return
     */
    OrderVO getOrder(String orderNumber);

    /**
     * 删除订单
     *
     * @param orderNumber
     */
    void deleteOrder(String orderNumber);

    /**
     * 查询全部用户的订单数据
     *
     * @return
     */
    List<OrderSumVO> getOrderSumAll();

    /**
     * 查询某个用户的订单总数
     *
     * @param userId
     * @return
     */
    Long getOrderSumByUser(Integer userId);

    /**
     * 查询用户购买的商品信息
     *
     * @param userId
     * @return
     */
    List<OrderShopInfoVO> getShopInfoByUserId(Integer userId);
}
