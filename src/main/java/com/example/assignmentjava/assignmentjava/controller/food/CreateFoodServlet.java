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

public class CreateFoodServlet extends HttpServlet {
   private CategoryModel categoryModel;
   private FoodModel foodModel;

    public CreateFoodServlet() {
        this.categoryModel = new MySqlCategoryModel();
        this.foodModel = new MySqlFoodModel();
    }
    private MySqlFoodModel mySqlFoodModel;

    @Override
    public void init() throws ServletException {
        mySqlFoodModel = new MySqlFoodModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = this.categoryModel.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/admin/food/create-food.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; chartset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String description = req.getParameter("description");
        String avatar = req.getParameter("avatar");
        Double price = 0.0;
        if(req.getParameter("price") != null && req.getParameter("price") != "") {
            price = Double.parseDouble(req.getParameter("price"));
        }
        String startDate = req.getParameter("startDate");
        Food food = new Food(name,categoryId,description,avatar,price,startDate);
        if(food.isValid()) {
            mySqlFoodModel.save(food);
            resp.sendRedirect("/food/list");
        }else {
            req.setAttribute("errors", food.getErrors());
            req.setAttribute("food", food);
            req.getRequestDispatcher("/admin/food/create-food.jsp").forward(req,resp);
        }
    }
}
