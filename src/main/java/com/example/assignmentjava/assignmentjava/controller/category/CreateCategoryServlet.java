package com.example.assignmentjava.assignmentjava.controller.category;

import com.example.assignmentjava.assignmentjava.entity.Category;
import com.example.assignmentjava.assignmentjava.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCategoryServlet extends HttpServlet {
    private MySqlCategoryModel mySqlCategoryModel;

    @Override
    public void init() throws ServletException {
        mySqlCategoryModel = new MySqlCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/category/create-category.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; chartset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        Category category = new Category(name);
        if(category.isValid()) {
            mySqlCategoryModel.save(category);
            resp.sendRedirect("/product/list");
        }else {
            req.setAttribute("errors", category.getErrors());
            req.setAttribute("product", category);
            req.getRequestDispatcher("/category/create.jsp").forward(req,resp);
        }
    }
}
