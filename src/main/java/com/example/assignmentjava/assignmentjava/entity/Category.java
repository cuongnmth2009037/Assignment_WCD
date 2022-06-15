package com.example.assignmentjava.assignmentjava.entity;

import com.example.assignmentjava.assignmentjava.entity.base.BaseEntity;
import com.example.assignmentjava.assignmentjava.entity.entityEnum.ObjectStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Category extends BaseEntity {
    private int id;
    private String name;
    private ObjectStatus objectStatus;
    private HashMap<String,String> errors;


    public Category() {
        this.name = "";
        errors = new HashMap<>();
    }


    public Category(LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ObjectStatus status, int id, String name, ObjectStatus objectStatus) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status);
        this.id = id;
        this.name = name;
        this.objectStatus = objectStatus;
        errors = new HashMap<>();
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        errors = new HashMap<>();
    }

    public Category(String name) {
        this.name = name;
        errors = new HashMap<>();
    }

    public Category(int id, String name, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ObjectStatus status) {
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
