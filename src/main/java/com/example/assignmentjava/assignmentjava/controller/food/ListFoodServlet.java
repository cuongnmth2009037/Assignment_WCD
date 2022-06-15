package com.example.assignmentjava.assignmentjava.controller.food;

import com.example.assignmentjava.assignmentjava.entity.Category;
import com.example.assignmentjava.assignmentjava.entity.Food;
import com.example.assignmentjava.assignmentjava.model.CategoryModel;
import com.example.assignmentjava.assignmentjava.model.FoodModel;
import com.example.assignmentjava.assignmentjava.model.MySqlCategoryModel;
import com.example.assignmentjava.assignmentjava.model.MySqlFoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListFoodServlet extends HttpServlet {
    private FoodModel foodModel;

    @Override
    public void init() throws ServletException {
        foodModel = new MySqlFoodModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> foodList = foodModel.findAll();
        req.setAttribute("foodlist", foodList);
        req.getRequestDispatcher("/admin/food/list.jsp").forward(req,resp);
    }
}
