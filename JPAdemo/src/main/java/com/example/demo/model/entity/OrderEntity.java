package com.example.demo.model.entity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author kuanglifang
 * @date 2020/12/17 19:26
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Builder
@Table(name = "demo_order")
public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     * 订单编号
     */
    @Column(name = "order_number")
    private String orderNumber;
    /**
     * 订单状态
     */
    @Column(name = "order_status")
    private Integer orderStatus;
    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 收货人姓名
     */
    @Column(name = "location_consignee")
    private String locationConsignee;
    /**
     * 收货人手机
     */
    @Column(name = "location_consignee_mobile")
    private String locationConsigneeMobile;
    /**
     * 收货地址ID
     */
    @Column(name = "location_id")
    private Integer locationId;
    /**
     * 详细地址
     */
    @Column(name = "location_address")
    private String locationAddress;
    /**
     * 商品总金额
     */
    @Column(name = "total_money")
    private BigDecimal totalMoney;
    /**
     * 订单创建时间
     */
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
