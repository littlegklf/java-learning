package com.example.demo.vo;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * @author kuanglifang
 * @date 2021/1/5 15:49
 */
@Data
@FieldNameConstants
public class OrderSumVO {
    private Long userId;
    private Long amount;
}
