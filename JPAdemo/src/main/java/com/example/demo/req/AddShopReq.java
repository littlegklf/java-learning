package com.example.demo.req;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author kuanglifang
 * @date 2020/12/21 20:10
 */
@Data
@Api(value = "添加商品入参")
public class AddShopReq {
    @ApiModelProperty(value = "商品名称", required = true)
    @NotBlank(message = "商品数量不能为空")
    private String name;
    @ApiModelProperty(value = "价格", required = true)
    @NotNull(message = "商品价格不能为空")
    private BigDecimal price;
    @ApiModelProperty(value = "数量", required = true)
    @NotNull(message = "商品数量不能为空")
    private Integer count;
}
