package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author kuanglifang
 * @date 2021/1/28 10:56
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Builder
@Table(name = "demo_order_shop")
public class OrderShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     * 商品id
     */
    @Column(name = "shop_id")
    private Integer shopId;
    /**
     * 订单编号
     */
    @Column(name = "order_number")
    private String orderNumber;
    /**
     * 商品购买数量
     */
    @Column(name = "amount")
    private Integer amount;
    /**
     * 商品金额
     */
    @Column(name = "money")
    private BigDecimal money;
    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
