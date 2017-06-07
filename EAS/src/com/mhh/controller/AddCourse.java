package com.mhh.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhh.dao.AdminDAO;


public class AddCourse extends HttpServlet{
		/**
		 * Constructor of the object.
		 */
	public AddCourse() {
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
	
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		String Cno = request.getParameter("Cno");	
		String Cname =request.getParameter("Cname");
		double Credit = Double.valueOf(request.getParameter("Credit"));
		java.sql.Date Ctime = Date.valueOf(request.getParameter("Ctime"));
		int Cnum = Integer.valueOf(request.getParameter("Cnum"));
		String Tno = request.getParameter("Tno");
		
		String mes=null;
		
		if(Cno == null || Cno == ""){	//错误处理
			mes = "课程号不能为空";
			try {
				request.setAttribute("message", mes);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}catch(Exception e){}  
			
		}
		
		AdminDAO aDAO = new AdminDAO();
		boolean ac = false;
		try {
			ac = aDAO.addCourse(Cno, Cname, Credit, Ctime, Cnum, Tno);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(classid+classname+classschool+classmust);
		if (ac) {
			mes="成功新增一条课程数据";
		} else {
			mes="新增失败。。\r\n注意课程号唯一且不为空，教师号必须存在！";
		}
		try {
			request.setAttribute("message", mes);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}catch(Exception e){}  
		
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
