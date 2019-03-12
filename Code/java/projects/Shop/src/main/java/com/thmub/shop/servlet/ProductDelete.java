package com.thmub.shop.servlet;

import com.thmub.shop.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/delete")
public class ProductDelete extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        int id= Integer.parseInt(req.getParameter("id"));
        try {
            ProductDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/product");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
