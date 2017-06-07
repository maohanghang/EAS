package com.mhh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhh.dao.AdminDAO;


public class AddClass extends HttpServlet{
		/**
		 * Constructor of the object.
		 */
	public AddClass() {
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
		String Classno = request.getParameter("Classno");	
		String Totalcredit=request.getParameter("Totalcredit");
		String Tno = request.getParameter("Tno");
		String Dno =request.getParameter("Dno");
		String mes=null;
		
		if(Classno == null || Classno == ""){	//错误处理
			mes = "班级号不能为空";
			try {
				request.setAttribute("message", mes);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}catch(Exception e){} 
			
		}
		
		AdminDAO aDAO = new AdminDAO();
		boolean ac = false;
		try {
			ac = aDAO.addClass(Classno, Double.valueOf(Totalcredit).doubleValue(), Tno, Dno);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(classid+classname+classschool+classmust);
		if (ac) {
			mes="成功新增一条班级数据";
		} else {
			mes="新增失败。。";
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
