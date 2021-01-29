package com.example.demo.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author kuanglifang
 * @date 2020/12/25 15:48
 */
@ApiModel("订单信息入参")
@Data
public class AddOrderReq {
    @ApiModelProperty(value = "用户id", required = true)
    private Integer userId;
    @ApiModelProperty(value = "商品信息", required = true)
    private List<PurchaseShopReq> shop;
    @ApiModelProperty(value = "地址id", required = true)
    private Integer locationId;
}
