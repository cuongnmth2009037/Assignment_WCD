package com.example.assignmentjava.assignmentjava.controller.category;

import com.example.assignmentjava.assignmentjava.entity.Category;
import com.example.assignmentjava.assignmentjava.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCategoryServlet extends HttpServlet {
    private MySqlCategoryModel mySqlCategoryModel;

    @Override
    public void init() throws ServletException {
        mySqlCategoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = mySqlCategoryModel.findById(id);
        req.setAttribute("category",category);
        req.getRequestDispatcher("/admin/category/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; chartset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Category category = new Category(name);
        if(mySqlCategoryModel.update(id, category)) {
            resp.sendRedirect("/category/list");
        }else {
            req.setAttribute("errors", category.getErrors());
            req.setAttribute("category", category);
            req.getRequestDispatcher("/admin/category/update.jsp").forward(req,resp);
        }
    }
}
