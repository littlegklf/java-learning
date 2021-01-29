package com.example.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author kuanglifang
 * @date 2020/12/21 21:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopVO {
    @ApiModelProperty(value = "商品名称")
    private String name;
    @ApiModelProperty(value = "价格")
    private BigDecimal price;
    @ApiModelProperty(value = "数量")
    private Integer count;
}
