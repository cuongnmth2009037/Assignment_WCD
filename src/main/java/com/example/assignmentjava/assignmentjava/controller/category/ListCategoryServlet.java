package com.example.assignmentjava.assignmentjava.controller.category;

import com.example.assignmentjava.assignmentjava.entity.Category;
import com.example.assignmentjava.assignmentjava.model.CategoryModel;
import com.example.assignmentjava.assignmentjava.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("categorylist", categoryList);
        req.getRequestDispatcher("/admin/category/list.jsp").forward(req,resp);
    }
}
