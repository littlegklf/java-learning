package com.example.demo.service.impl;

import com.example.demo.exceptions.GlobalRuntimeException;
import com.example.demo.manager.OrderManager;
import com.example.demo.model.entity.LocationEntity;
import com.example.demo.model.entity.OrderEntity;
import com.example.demo.model.entity.OrderShopEntity;
import com.example.demo.model.enums.OrderStatusEnum;
import com.example.demo.model.enums.ResponseCode;
import com.example.demo.model.req.AddOrderReq;
import com.example.demo.model.req.PurchaseShopReq;
import com.example.demo.model.vo.*;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.OrderShopRepository;
import com.example.demo.service.OrderService;
import com.example.demo.service.ShopService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * @author kuanglifang
 * @date 2020/12/25 15:42
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepository orderRepository;
    @Resource
    private UserService userService;
    @Resource
    private ShopService shopService;
    @Resource
    private OrderShopRepository orderShopRepository;
    @Resource
    private LocationRepository locationRepository;
    @Resource
    private OrderManager orderManager;

    @Override
    public void addOrder(AddOrderReq req) {
        UserVO userInfo = userService.findById(req.getUserId());
        Optional<LocationEntity> optional = locationRepository.findById(req.getLocationId());
        if (!optional.isPresent()) {
            throw new GlobalRuntimeException(ResponseCode.PARAMETER_ERROR.getCode(), "收货地址不存在");
        }
        LocationEntity locationEntity = optional.get();
        String orderNumber = "OD" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddmmHHss")) + new Random().nextInt(10);
        boolean exists = orderRepository.existsByOrderNumber(orderNumber);
        if (exists) {
            log.error("自动生成的订单编号已经存在 请重新生成");
            throw new GlobalRuntimeException(ResponseCode.INTERNAL_ERROR);
        }
        //计算商品总金额
        BigDecimal totalMoney = BigDecimal.ZERO;
        for (PurchaseShopReq shopReq : req.getShop()) {
            ShopVO shopInfo = shopService.getShopInfo(shopReq.getShopId());
            BigDecimal money = shopInfo.getPrice().multiply(BigDecimal.valueOf(shopReq.getAmount()));
            totalMoney = totalMoney.add(money);
            OrderShopEntity orderShopEntity = OrderShopEntity.builder().orderNumber(orderNumber).shopId(shopReq.getShopId())
                    .amount(shopReq.getAmount()).createdAt(LocalDateTime.now()).money(money)
                    .build();
            orderShopRepository.save(orderShopEntity);
        }
        OrderEntity entity = OrderEntity.builder().orderNumber(orderNumber)
                .userId(req.getUserId()).locationConsignee(userInfo.getUserName())
                .locationConsigneeMobile(userInfo.getMobile()).locationAddress(locationEntity.getLocationAddress())
                .locationId(req.getLocationId()).orderStatus(OrderStatusEnum.CREATE.getCode()).createdAt(LocalDateTime.now())
                .totalMoney(totalMoney)
                .build();
        orderRepository.save(entity);
    }

    @Override
    public OrderVO getOrder(String orderNumber) {
        OrderEntity entity = orderRepository.findByOrOrderNumber(orderNumber).orElseThrow(() -> new GlobalRuntimeException(ResponseCode.PARAMETER_ERROR.getCode(), "该订单号不存在"));
        return OrderVO.builder().orderNumber(entity.getOrderNumber()).userId(entity.getUserId())
                .userName(entity.getLocationConsignee()).userMobile(entity.getLocationConsigneeMobile())
                .location(entity.getLocationAddress()).createdAt(entity.getCreatedAt()).build();
    }

    @Override
    public void deleteOrder(String orderNumber) {
        OrderEntity entity = orderRepository.findByOrOrderNumber(orderNumber).orElseThrow(() -> new GlobalRuntimeException(ResponseCode.PARAMETER_ERROR.getCode(), "该订单号不存在"));
        orderRepository.delete(entity);
    }

    @Override
    public List<OrderSumVO> getOrderSumAll() {
        return orderRepository.orderAmountAll();
    }

    @Override
    public Long getOrderSumByUser(Integer userId) {
        return orderRepository.orderAmountByUser(userId);
    }

    @Override
    public List<OrderShopInfoVO> getShopInfoByUserId(Integer userId) {
        return orderManager.getOrderShopInfo(userId);
    }
}
