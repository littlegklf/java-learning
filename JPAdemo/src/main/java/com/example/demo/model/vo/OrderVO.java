package com.example.demo.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author kuanglifang
 * @date 2020/12/30 16:28
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("订单信息出参")
public class OrderVO {
    @ApiModelProperty(value = "订单号")
    private String orderNumber;
    @ApiModelProperty(value = "联系人id")
    private Integer userId;
    @ApiModelProperty(value = "联系人名称")
    private String userName;
    @ApiModelProperty(value = "联系人电话")
    private String userMobile;
    @ApiModelProperty(value = "收货地址id")
    private Integer locationId;
    @ApiModelProperty(value = "收货地址")
    private String location;
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;
}
