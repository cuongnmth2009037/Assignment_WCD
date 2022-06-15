package com.example.assignmentjava.assignmentjava.model;

import com.example.assignmentjava.assignmentjava.constant.SqlConstant;
import com.example.assignmentjava.assignmentjava.entity.Category;
import com.example.assignmentjava.assignmentjava.entity.entityEnum.ObjectStatus;
import com.example.assignmentjava.assignmentjava.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlCategoryModel implements CategoryModel{
    @Override
    public boolean save(Category category) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.CATEGORY_INSERT);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getCreatedAt().toString());
            preparedStatement.setString(3, category.getUpdatedAt().toString());
            if (category.getDeletedAt() != null){
                preparedStatement.setString(4, category.getDeletedAt().toString());
            }else {
                preparedStatement.setString(4, null);
            }
            preparedStatement.setInt(5, category.getCreatedBy());
            preparedStatement.setInt(6, category.getUpdatedBy());
            preparedStatement.setInt(7, category.getDeletedBy());
            preparedStatement.setInt(8, category.getStatus().getValue());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(int id, Category category) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.CATEGORY_UPDATE);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getCreatedAt().toString());
            preparedStatement.setString(3, category.getUpdatedAt().toString());
            if (category.getDeletedAt() != null){
                preparedStatement.setString(4, category.getDeletedAt().toString());
            }else {
                preparedStatement.setString(4, null);
            }
            preparedStatement.setInt(5, category.getCreatedBy());
            preparedStatement.setInt(6, category.getUpdatedBy());
            preparedStatement.setInt(7, category.getDeletedBy());
            preparedStatement.setInt(8, category.getStatus().getValue());
            preparedStatement.setInt(9,id);
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
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.CATEGORY_DELETE);
            preparedStatement.setInt(1, ObjectStatus.DELETED.getValue());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.CATEGORY_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, ObjectStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
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
                Category category = new Category();
                category.setId(id);
                category.setName(name);
                category.setCreatedAt(createdAt);
                category.setUpdatedAt(updatedAt);
                category.setDeletedAt(deletedAt);
                category.setCreatedBy(createdBy);
                category.setUpdatedBy(updatedBy);
                category.setDeletedBy(deletedBy);
                category.setStatus(status);
                return category;
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.CATEGORY_FIND_ALL);
            preparedStatement.setInt(1, ObjectStatus.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if(rs.getTimestamp("deletedAt") != null) {
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy = rs.getInt("updatedBy");
                int deletedBy = rs.getInt("deletedBy");
                ObjectStatus status = ObjectStatus.of(rs.getInt("status"));
                Category category = new Category();
                category.setId(id);
                category.setName(name);
                category.setCreatedAt(createdAt);
                category.setUpdatedAt(updatedAt);
                categories.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return categories;
    }
}
