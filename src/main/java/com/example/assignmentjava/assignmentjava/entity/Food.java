package com.example.assignmentjava.assignmentjava.entity;

import com.example.assignmentjava.assignmentjava.entity.base.BaseEntity;
import com.example.assignmentjava.assignmentjava.entity.entityEnum.FoodStatus;
import com.example.assignmentjava.assignmentjava.entity.entityEnum.ObjectStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Food extends BaseEntity {
    private int id;
    private String name;
    private int categoryId;
    private String description;
    private String avatar;
    private double price;
    private LocalDateTime startDate;
    private ObjectStatus objectStatus;
    private HashMap<String,String> errors;


    public Food() {
        this.name = "";
        this.description = "";
        this.avatar = "";
        this.price =0.0;
        errors = new HashMap<>();
    }

    public Food(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ObjectStatus status, int id, String name, int categoryId, String description, String avatar, double price, LocalDateTime startDate, FoodStatus foodStatus) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status);
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.avatar = avatar;
        this.price = price;
        this.startDate = startDate;
        errors = new HashMap<>();
    }

    public Food(int id, String name, int categoryId, String description, String avatar, double price, LocalDateTime startDate, ObjectStatus objectStatus) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.avatar = avatar;
        this.price = price;
        this.startDate = startDate;
        this.objectStatus = objectStatus;
        errors = new HashMap<>();
    }



    public Food(String name, int categoryId, String description, String avatar, Double price, String startDate) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public ObjectStatus getObjectStatus() {
        return objectStatus;
    }

    public void setObjectStatus(ObjectStatus objectStatus) {
        this.objectStatus = objectStatus;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }
    public boolean isValid() {
        return this.checkValid();
    }

    public boolean checkValid() {
        if(name == "" || name == null) {
            errors.put("name", "Please enter name");
        }
        return errors.size() == 0;
    }
}
