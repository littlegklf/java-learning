package com.example.spring.repository;

import com.example.spring.model.Ingredient;

/**
 * @author kuanglifang
 * @date 2021/3/5 14:10
 */
public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);
}
