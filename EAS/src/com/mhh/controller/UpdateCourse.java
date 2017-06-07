package com.mhh.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhh.dao.AdminDAO;

public class UpdateCourse extends HttpServlet{
		/**
		 * Constructor of the object.
		 */
	public UpdateCourse() {
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
		
		String Cno = request.getParameter("cno");	
		Cno = Cno.replace("课程号： ", "");
		String Cname =request.getParameter("cname");
		double Credit = Double.valueOf(request.getParameter("credit"));
		java.sql.Date Ctime = Date.valueOf(request.getParameter("ctime"));
		int Cnum = Integer.valueOf(request.getParameter("cnum"));
		String Tno = request.getParameter("tno");
		
		String mes=null;
		/*if(Ano == null || Ano == ""){	//错误处理
			mes = "管理员编号不能为空";
			request.setAttribute("message", mes);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}*/
		
		AdminDAO aDAO = new AdminDAO();
		boolean ac = false;
		try {
			ac = aDAO.updateCourse(Cno, Cname, Credit, Ctime, Cnum, Tno);
			//System.out.println(Ano+"----");
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(classid+classname+classschool+classmust);
		//由于上层返回的是bool，没有对具体错误进行判断
		if (ac) {
			mes="成功修改一条课程数据";
		} else {
			mes="修改失败。。";
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
