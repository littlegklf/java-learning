package com.example.demo.controller;

import com.example.demo.model.ServerResponse;
import com.example.demo.model.req.AddOrderReq;
import com.example.demo.model.req.QueryOrderReq;
import com.example.demo.model.vo.OrderShopInfoVO;
import com.example.demo.service.OrderService;
import com.example.demo.model.vo.OrderSumVO;
import com.example.demo.model.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kuanglifang
 * @date 2020/12/21 20:06
 */
@RestController
@RequestMapping("order")
@Api(tags = "订单管理")
public class OrderController {

    @Resource
    private OrderService orderService;

    @ApiOperation(value = "添加订单", notes = "添加订单")
    @PostMapping("/")
    public ServerResponse addOrder(@RequestBody @Validated AddOrderReq req) {
        orderService.addOrder(req);
        return ServerResponse.ok();
    }

    @ApiOperation(value = "动态查订单", notes = "动态查订单")
    @GetMapping("/list")
    public ServerResponse getOrder(@RequestBody @Validated QueryOrderReq req) {
        return ServerResponse.ok();
    }

    @ApiOperation(value = "删除订单", notes = "删除订单")
    @DeleteMapping("/{orderNumber}")
    public ServerResponse updateOrder(@PathVariable("orderNumber") String orderNumber) {
        orderService.deleteOrder(orderNumber);
        return ServerResponse.ok();
    }

    @ApiOperation(value = "根据订单号查找订单", notes = "根据订单号查找订单")
    @GetMapping("/{orderNumber}")
    public ServerResponse<OrderVO> getOrder(@PathVariable("orderNumber") String orderNumber) {
        return ServerResponse.ok(orderService.getOrder(orderNumber));
    }

    @ApiOperation(value = "每个用户的订单数量", notes = "每个用户的订单数量")
    @GetMapping("/order-sum")
    public ServerResponse<List<OrderSumVO>> getOrderSumAll() {
        return ServerResponse.ok(orderService.getOrderSumAll());
    }

    @ApiOperation(value = "用户的订单数量", notes = "某个用户的订单数量")
    @GetMapping("/{userId}/sum")
    public ServerResponse<Long> getOrderSumByUserId(@PathVariable("userId") Integer userId) {
        return ServerResponse.ok(orderService.getOrderSumByUser(userId));
    }

    @ApiOperation(value = "用户购买的商品信息", notes = "用户购买的商品信息")
    @GetMapping("/{userId}/shop")
    public ServerResponse<List<OrderShopInfoVO>> getShopInfoByUserId(@PathVariable("userId") Integer userId) {
        return ServerResponse.ok(orderService.getShopInfoByUserId(userId));
    }
}
