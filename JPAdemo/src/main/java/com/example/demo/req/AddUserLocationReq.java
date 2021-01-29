package com.example.demo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kuanglifang
 * @date 2021/1/5 11:24
 */
@ApiModel("添加用户地址入参")
@Data
public class AddUserLocationReq {
    @ApiModelProperty(value = "地址",required = true)
    private String locationAddress;
}
