package com.thmub.shop.servlet;

import com.thmub.shop.bean.Product;
import com.thmub.shop.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/product/edit")
public class ProductEdit extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        int id= Integer.parseInt(req.getParameter("id"));
        Product product = null;
        try {
            product=ProductDao.get(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=gb2312");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        if (product==null)
            out.println("<title>添加产品</title>");
        else
            out.println("<title>编辑产品</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"/product/add\" method=\"get\">");
        if (product==null){
            out.println("<p>产品编号: <input type=\"text\" name=\"id\" value=\"0\"></p>");
            out.println("<p>产品名称: <input type=\"text\" name=\"name\"></p>");
            out.println("<p>产品数量: <input type=\"text\" name=\"number\"></p>");
        }else {
            out.println("<p>产品编号: <input type=\"text\" name=\"id\" value="+product.getId()+"></p>");
            out.println("<p>产品名称: <input type=\"text\" name=\"name\" value="+product.getName()+"></p>");
            out.println("<p>产品数量: <input type=\"text\" name=\"number\" value="+product.getNumber()+"></p>");
        }
        out.println("<input type=\"submit\" value=\"提交\" />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();

        resp.sendRedirect("/product");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
