package com.mhh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhh.bean.Teacher;
import com.mhh.dao.TeacherDAO;

public class TeacherLogin extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public TeacherLogin() {
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
		String username=request.getParameter("teacherid");
		String password=request.getParameter("password");
    	TeacherDAO tdao = new TeacherDAO();
		Teacher teacher = new Teacher();
		try {
			teacher = tdao.tealogin(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (teacher!=null) {
			request.getSession().setAttribute("teacher", teacher);
			
			response.sendRedirect(request.getContextPath()+"/teacher/index.jsp");
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
