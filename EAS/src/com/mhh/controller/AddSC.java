package com.mhh.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhh.dao.TeacherDAO;

public class AddSC extends HttpServlet{
		/**
		 * Constructor of the object.
		 */
	public AddSC() {
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
	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		String mes=null;
		String mes1=null;
		String Sno = request.getParameter("Sno");	
		String Cno = request.getParameter("Cno");
		String chengji=request.getParameter("Grade");
		int Grade = 0;
		System.out.printf(Sno+Cno+Grade);
		if(Sno == null || Sno == ""||Cno == null || Cno == ""||chengji == null || chengji == ""){	//错误处理
			mes = "学号、课程号或成绩不能为空！";
			try {  
				request.setAttribute("message", mes);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}catch(Exception e){} 
		}
		else if(chengji != null || chengji != "")
		{
			Grade = Integer.valueOf(chengji);
			if(Grade<0||Grade>100){	//错误处理
				mes = "成绩输入有误！，";
				try {  
					request.setAttribute("message", mes);
					request.getRequestDispatcher("/message.jsp").forward(request, response);
					return;
				}catch(Exception e){} 
			}
		}
		//System.out.printf(Sno+Cno+Grade);
		
		TeacherDAO aDAO = new TeacherDAO();
		boolean ac = false;
		try {
			ac = aDAO.addSC(Sno, Cno, Grade);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(classid+classname+classschool+classmust);
		//由于上层返回的是bool，没有对具体错误进行判断
	//	if(Sno != null && Sno != ""&&Cno != null && Cno != ""&& chengji != null && chengji != "")
	//	{
			//System.out.println("哈哈");	
		if (ac) {
			mes="成功新增一条成绩数据";
		} else {
			mes="新增失败....../r/n【注意】："
					+ "/r/n1.学号，课程号必须存在！"
					+ "/r/n2.不能插入重复数据（该学生的该门成绩已存）！";
		}
		try {  
			request.setAttribute("message", mes);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}catch(Exception e){} 

	//	}
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
