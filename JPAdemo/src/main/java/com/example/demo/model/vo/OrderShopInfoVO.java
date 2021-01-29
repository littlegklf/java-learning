package com.example.demo.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

/**
 * @author kuanglifang
 * @date 2021/1/28 15:17
 */
@Data
@FieldNameConstants
public class OrderShopInfoVO {
    @ApiModelProperty(value = "商品名称")
    private String name;
    @ApiModelProperty(value = "商品id")
    private Integer shopId;
    @ApiModelProperty(value = "商品购买数量")
    private Integer amount;
    @ApiModelProperty(value = "商品金额")
    private BigDecimal money;
}
