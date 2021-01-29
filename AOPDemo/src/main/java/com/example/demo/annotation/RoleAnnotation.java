package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author kuanglifang
 * @date 2020/12/16 11:05
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RoleAnnotation {
    String value() default "";
}
