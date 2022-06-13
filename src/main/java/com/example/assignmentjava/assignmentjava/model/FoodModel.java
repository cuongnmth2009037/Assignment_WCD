package com.example.assignmentjava.assignmentjava.model;

import com.example.assignmentjava.assignmentjava.entity.Food;

import java.util.List;

public interface FoodModel {
    boolean save(Food food);
    boolean update(int id, Food food);
    boolean delete(int id);
    Food findById(int id);
    List<Food> findAll();
}
