package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kuanglifang
 * @date 2020/12/16 20:30
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户信息出参")
public class UserVO {
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "密码")
    private String userPassword;
    @ApiModelProperty(value = "性别")
    private Integer sex;
    @ApiModelProperty(value = "联系电话")
    private String mobile;
    @ApiModelProperty(value = "真实姓名")
    private String trueName;
    @ApiModelProperty(value = "地址")
    private String location;
    @ApiModelProperty(value = "地址id")
    private Integer locationId;
}
