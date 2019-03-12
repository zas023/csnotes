package com.thmub.shop.servlet;

import com.thmub.shop.bean.UserBean;
import com.thmub.shop.dao.UserDao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserLogin extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");

		String password = request.getParameter("password");

		

		UserBean user = new UserBean();

		user.setValidUserName("admin"); // 设置合法用户的信息

		user.setValidUserPassword("admin");

		

		response.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=gb2312");

		PrintWriter out = response.getWriter();

		//if(user.isValidUser(name, password))
		try {
			if(UserDao.isValidUser(name, password))
			{  // 调用JavaBean的方法来验证用户

				out.println("登录成功！");

			}else{

				out.println("用户名或者密码错误，<a href='login.jsp'>请重试。</a>");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);

	}



}
