package com.example.spring.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author kuanglifang
 * @date 2021/3/5 11:26
 *
 * @NotBlank 字段不能为空
 * @CreditCardNumber 校验是否是合法的信用卡号
 * @Size(min = 5) 字段长度至少是5
 * @Digits(integer = 3, fraction = 0) 字段包含3位数字
 * 在controller层 需要在入参时添加@Validated 或@Valid 校验才会生效
 */
@Data
public class Order {
    @NotBlank(message = "不满足校验规则时展示的信息")
    @Size(min = 5)
    private String name;
    private String street;
    @CreditCardNumber
    private String ccNumber;
    @Digits(integer = 3, fraction = 0)
    private String ccCvv;
}
