package com.mhh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhh.bean.Admin;
import com.mhh.dao.AdminDAO;

public class AdminLogin extends HttpServlet{
	/**
	 * Constructor of the object.
	 */
public AdminLogin() {
	super();
}

/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html");
	String username=request.getParameter("adminid");
	String password=request.getParameter("password");
	AdminDAO adao = new AdminDAO();
	Admin admin = new Admin();
	try {
		admin = adao.adminlogin(username,password);
		System.out.println("admin login");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (admin!=null) {
		request.getSession().setAttribute("admin", admin);
		
		response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
		return;
	}
	request.setAttribute("message", "用户名或者密码错误");
	request.getRequestDispatcher("/message.jsp").forward(request, response);
}

/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doGet(request, response);
}

}
