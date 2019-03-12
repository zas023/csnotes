package com.thmub.shop.servlet;

import com.thmub.shop.bean.Product;
import com.thmub.shop.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/add")
public class ProductAdd extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        int id = Integer.parseInt(req.getParameter("id"));
        int number = Integer.parseInt(req.getParameter("number"));
        String name=req.getParameter("name");
        try {
            Product product = ProductDao.get(id);
            if(null==product)
                ProductDao.add(new Product(id,name,number));
            else{
                product.setName(name);
                product.setNumber(number);
                ProductDao.update(product,id);
            }
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
