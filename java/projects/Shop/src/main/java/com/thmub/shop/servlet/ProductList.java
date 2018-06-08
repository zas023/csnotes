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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product")
public class ProductList extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        List<Product> list = new ArrayList<Product>();
        try {
            list = ProductDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        req.setAttribute("products ", list);
//        req.setAttribute("title", "产品列表");
//        req.getRequestDispatcher("/WEB-INF/view/product.jsp").forward(req, resp);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=gb2312");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>产品列表</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border = 1px align = \"center\">");
        out.println("<tr>");
        out.println(" <th>产品编号</th>");
        out.println("<th>产品名称</th>");
        out.println("<th>产品数量</th>");
        out.println("<th>操作</th>");
        out.println("</tr>");
        for (Product product:list){
            out.println("<tr>");
            out.println("<th>"+product.getId()+"</th>");
            out.println("<th>"+product.getName()+"</th>");
            out.println("<th>"+product.getNumber()+"</th>");
            out.println("<th>");
            out.println("<a href=\"/product/edit?id="+product.getId()+"\">修改</a>");
            out.println("<a href=\"/product/delete?id="+product.getId()+"\" onclick=\"confirm('确定删除该条记录?')\">删除</a>");
            out.println("</tr>");
        }
        out.println("<tr><th><a href=\"/product/edit?id=0\">添加</a></th></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
