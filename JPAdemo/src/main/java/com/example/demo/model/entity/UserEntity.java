package com.example.demo.model.entity;

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
@Builder
@Table(name = "demo_user")
public class UserEntity implements Serializable {

    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
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
}
