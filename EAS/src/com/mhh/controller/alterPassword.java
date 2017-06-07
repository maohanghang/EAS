package com.mhh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhh.dao.StudentDAO;

public class alterPassword extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public alterPassword() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String sno = (String)request.getSession().getAttribute("sno");
		//System.out.println(sno);
		String oldpassword=request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String confirmpassword=request.getParameter("confirmpassword");
		StudentDAO server =new StudentDAO();
		String oldpassword1 = null;
		try {
			oldpassword1 = server.getpassword(sno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mes=null;
		boolean ac=false;
		if(!newpassword.equals(confirmpassword)){
			mes="两次输入的密码不一致";
		}
		else if(!oldpassword.equals(oldpassword1)){
			mes="原密码错误";
		}
		else{
			try {
				ac=server.alterPassword(sno, newpassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ac) {
			mes="插入成功！";
		} else {
			mes="插入失败！";
		}
		request.setAttribute("message", mes);
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

