package com.example.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kuanglifang
 * @date 2021/3/4 16:05
 */
@Data
@AllArgsConstructor
public class Ingredient {
    private String id;
    private String name;
    private Type type;

    public enum Type {
        /**
         * 材料类型
         */
        WRAP, PROTEIN, VEGGIES, CHEESES, SAUCE
    }
}
