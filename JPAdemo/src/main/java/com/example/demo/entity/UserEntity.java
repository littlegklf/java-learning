package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author kuanglifang
 * @date 2020/12/16 15:00
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Builder
@Table(name = "demo_user")
public class UserEntity implements Serializable {

     /**
     * 自增主键
     */
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * 姓名
     */
    @Column(name = "userName")
    private String userName;
    /**
     * 密码
     */
    @Column(name = "userPassword")
    private String userPassword;
    /**
     * 性别
     */
    @Column(name = "sex")
    private Integer sex;
    /**
     * 联系电话
     */
    @Column(name = "mobile")
    private String mobile;
    /**
     * 真实姓名
     */
    @Column(name = "trueName")
    private String trueName;
    /**
     * 地址
     */
    @Column(name = "location")
    private String location;
    /**
     * 地址id
     */
    @Column(name = "locationId")
    private Integer locationId;
}
