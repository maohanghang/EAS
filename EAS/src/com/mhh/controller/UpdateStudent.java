package com.mhh.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhh.dao.AdminDAO;

public class UpdateStudent extends HttpServlet{
		/**
		 * Constructor of the object.
		 */
	public UpdateStudent() {
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
		
		String Sno = request.getParameter("sno");	
		Sno = Sno.replace("ѧ�ţ� ", "");
		String Sname =request.getParameter("sname");
		String Ssex =request.getParameter("ssex");
		//double Credit = Double.valueOf(request.getParameter("credit"));
		java.sql.Date Sbrith = Date.valueOf(request.getParameter("sbrith"));
		
		String Classno = request.getParameter("classno");
		
		String mes=null;
		
		AdminDAO aDAO = new AdminDAO();
		boolean ac = false;
		try {
			ac = aDAO.updateStudent(Sno, Sname, Ssex, Sbrith, Classno);
			//System.out.println(Ano+"----");
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(classid+classname+classschool+classmust);
		//�����ϲ㷵�ص���bool��û�жԾ����������ж�
		if (ac) {
			mes="�ɹ��޸�һ��ѧ������";
		} else {
			mes="�޸�ʧ�ܡ���";
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
