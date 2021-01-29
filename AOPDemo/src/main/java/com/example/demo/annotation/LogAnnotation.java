package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author kuanglifang
 * @date 2020/12/22 10:29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String value() default "";
}
