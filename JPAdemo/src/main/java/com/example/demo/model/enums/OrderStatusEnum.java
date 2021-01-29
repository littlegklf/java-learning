package com.example.demo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kuanglifang
 * @date 2021/1/28 14:06
 */
@AllArgsConstructor
public enum OrderStatusEnum {
    /**
     * 1 创建 2 已付款 3 正发货 4 已发货 5 已收货 6 已完成 -1 已取消
     */
    CREATE(1, "创建"),
    PAID(2, "已付款"),
    SENDING(3, "正发货"),
    SEND(4, "已发货"),
    RECEIVED(5, "已收货"),
    FINISH(6, "已完成"),
    CANCEL(-1, "已取消"),
    ;
    @Getter
    private final int code;
    @Getter
    private final String desc;
}
