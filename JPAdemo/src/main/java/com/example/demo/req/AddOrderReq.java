package com.example.demo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kuanglifang
 * @date 2020/12/25 15:48
 */
@ApiModel("订单信息入参")
@Data
public class AddOrderReq {
    @ApiModelProperty(value = "用户id",required = true)
    private Long userId;
    @ApiModelProperty(value = "商品id",required = true)
    private Long shopId;
    @ApiModelProperty(value = "购买数量",required = true)
    private Integer amount;
    @ApiModelProperty(value = "地址id",required = true)
    private Integer locationId;
    @ApiModelProperty(value = "详细地址",required = true)
    private String locationAddress;
}
