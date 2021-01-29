package com.example.demo.entity;

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
    private Long id;
    @Column(name = "orderNumber")
    private String orderNumber;
    @Column(name = "userId")
    private Long userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userMobile")
    private String userMobile;
    @Column(name = "locationId")
    private Integer locationId;
    @Column(name = "location")
    private String location;
    @Column(name = "shopId")
    private Long shopId;
    @Column(name = "shopName")
    private String shopName;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "totalMoney")
    private BigDecimal totalMoney;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
}
