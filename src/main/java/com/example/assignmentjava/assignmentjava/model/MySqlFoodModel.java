package com.example.assignmentjava.assignmentjava.model;

import com.example.assignmentjava.assignmentjava.constant.SqlConstant;
import com.example.assignmentjava.assignmentjava.entity.Food;
import com.example.assignmentjava.assignmentjava.entity.entityEnum.ObjectStatus;
import com.example.assignmentjava.assignmentjava.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlFoodModel implements FoodModel {

    @Override
    public boolean save(Food food) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FOOD_INSERT);
            preparedStatement.setString(1, food.getName());
            preparedStatement.setInt(2, food.getCategoryId());
            preparedStatement.setString(3, food.getDescription());
            preparedStatement.setString(4, food.getAvatar());
            preparedStatement.setDouble(5, food.getPrice());
            preparedStatement.setString(6, food.getStartDate().toString());
            preparedStatement.setString(7, food.getCreatedAt().toString());
            preparedStatement.setString(8, food.getUpdatedAt().toString());
            if (food.getDeletedAt() != null){
                preparedStatement.setString(9, food.getDeletedAt().toString());
            }else {
                preparedStatement.setString(9, null);
            }
            preparedStatement.setInt(10, food.getCreatedBy());
            preparedStatement.setInt(11, food.getUpdatedBy());
            preparedStatement.setInt(12, food.getDeletedBy());
            preparedStatement.setInt(13, food.getStatus().getValue());
            return preparedStatement.executeUpdate() > 0;

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(int id, Food food) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FOOD_UPDATE);
            preparedStatement.setString(1, food.getName());
            preparedStatement.setInt(2, food.getCategoryId());
            preparedStatement.setString(3, food.getDescription());
            preparedStatement.setString(4, food.getAvatar());
            preparedStatement.setDouble(5, food.getPrice());
            preparedStatement.setString(6, food.getStartDate().toString());
            preparedStatement.setString(7, food.getCreatedAt().toString());
            preparedStatement.setString(8, food.getUpdatedAt().toString());
            if (food.getDeletedAt() != null){
                preparedStatement.setString(9, food.getDeletedAt().toString());
            }else {
                preparedStatement.setString(9, null);
            }
            preparedStatement.setInt(10, food.getCreatedBy());
            preparedStatement.setInt(11, food.getUpdatedBy());
            preparedStatement.setInt(12, food.getDeletedBy());
            preparedStatement.setInt(13, food.getStatus().getValue());
            preparedStatement.setInt(14, id);
            return preparedStatement.executeUpdate() > 0;

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FOOD_DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Food findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FOOD_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, ObjectStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                int categoryId = rs.getInt("categoryId");
                String description = rs.getString("description");
                String avatar = rs.getString("avatar");
                Double price = rs.getDouble("price");
                LocalDateTime startDate = rs.getTimestamp("startDate").toLocalDateTime();
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if (rs.getTimestamp("deletedAt") != null){
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy  = rs.getInt("updatedBy");
                int deletedBy  = rs.getInt("deletedBy");
                ObjectStatus status = ObjectStatus.values()[rs.getInt("status")];
                Food food = new Food();
                food.setId(id);
                food.setName(name);
                food.setCategoryId(categoryId);
                food.setDescription(description);
                food.setAvatar(avatar);
                food.setPrice(price);
                food.setStartDate(startDate);
                food.setCreatedAt(createdAt);
                food.setUpdatedAt(updatedAt);
                food.setDeletedAt(deletedAt);
                food.setCreatedBy(createdBy);
                food.setUpdatedBy(updatedBy);
                food.setDeletedBy(deletedBy);
                food.setStatus(status);
                return food;
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Food> findAll() {
        List<Food> foods = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FOOD_FIND_ALL);
            preparedStatement.setInt(1, ObjectStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int categoryId = rs.getInt("categoryId");
                String description = rs.getString("description");
                String avatar = rs.getString("avatar");
                Double price = rs.getDouble("price");
                LocalDateTime startDate = rs.getTimestamp("startDate").toLocalDateTime();
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if (rs.getTimestamp("deletedAt") != null){
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy  = rs.getInt("updatedBy");
                int deletedBy  = rs.getInt("deletedBy");
                ObjectStatus status = ObjectStatus.values()[rs.getInt("status")];
                Food food = new Food();
                food.setId(id);
                food.setName(name);
                food.setCategoryId(categoryId);
                food.setDescription(description);
                food.setAvatar(avatar);
                food.setPrice(price);
                food.setStartDate(startDate);
                food.setCreatedAt(createdAt);
                food.setUpdatedAt(updatedAt);
                food.setDeletedAt(deletedAt);
                food.setCreatedBy(createdBy);
                food.setUpdatedBy(updatedBy);
                food.setDeletedBy(deletedBy);
                food.setStatus(status);
                foods.add(food);
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return foods;
    }
}
