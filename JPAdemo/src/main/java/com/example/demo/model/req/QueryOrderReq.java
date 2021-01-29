package com.example.demo.model.req;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kuanglifang
 * @date 2021/1/28 16:43
 */
@Data
public class QueryOrderReq {
    private String orderNumber;
    private Integer userId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
