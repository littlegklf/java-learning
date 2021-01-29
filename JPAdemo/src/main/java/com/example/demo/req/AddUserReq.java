package com.example.demo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kuanglifang
 * @date 2020/12/17 13:53
 */
@ApiModel("添加用户入参")
@Data
public class AddUserReq {
    @ApiModelProperty(value = "用户名",required = true)
    private String userName;
    @ApiModelProperty(value = "密码",required = true)
    private String userPassword;
    @ApiModelProperty(value = "性别",required = true)
    private Integer sex;
    @ApiModelProperty(value = "联系电话",required = true)
    private String mobile;
    @ApiModelProperty(value = "真实姓名",required = true)
    private String trueName;
}
