package com.example.assignmentjava.assignmentjava.constant;

public class SqlConstant {
    public  static final String FOOD_INSERT = "INSERT INTO foods (name, categoryId, description, avatar, price, startDate," +
            "createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
    public static final String FOOD_UPDATE = "UPDATE foods SET name = ?, categoryId = ?, description = ?, avatar = ?, price = ?, startDate = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ? WHERE id = ?";
    public static final String FOOD_DELETE = "DELETE FROM foods WHERE id = ?";
    public static final String FOOD_UPDATE_STATUS = "UPDATE foods SET status = ? WHERE id = ?";
    public static final String FOOD_FIND_BY_ID = "SELECT * FROM foods WHERE id = ? AND status = ?";
    public static final String FOOD_FIND_ALL = "SELECT * FROM foods WHERE status = ?";


    public  static final String CATEGORY_INSERT = "INSERT INTO categories (name, createdAt, updatedAt, createdBy, updatedBy, status) VALUES (?,?,?,?,?,?);";
    public static final String CATEGORY_UPDATE = "UPDATE products SET name = ?, createdAt = ?, updatedAt = ?, createdBy = ?, updatedBy = ?, status = ? WHERE id = ?";
    public static final String CATEGORY_DELETE = "DELETE FROM categories SET status = ?  WHERE id = ?";
    public static final String CATEGORY_FIND_BY_ID = "SELECT * FROM categories WHERE id = ? AND status = ?";
    public static final String CATEGORY_FIND_ALL = "SELECT * FROM categories WHERE status = ?";

    public  static final String ACCOUNT_INSERT = "INSERT INTO accounts (username, password, roleId," +
            "createdAt, updatedAt, status) VALUES (?,?,?,?,?,?);";
    public static final String ACCOUNT_FIND_BY_USERNAME = "SELECT * FROM accounts WHERE username = ? AND status = ?";

}
