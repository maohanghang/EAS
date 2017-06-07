package com.mhh.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhh.dao.AdminDAO;

public class AddTeacher extends HttpServlet{
		/**
		 * Constructor of the object.
		 */
	public AddTeacher() {
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
		
		String Tno = request.getParameter("Tno");	
		String Tname =request.getParameter("Tname");
		String Title =request.getParameter("Title");
		String Tel = request.getParameter("Tel");;
		String Dno = request.getParameter("Dno");
		String Password = request.getParameter("Password");
		
		String mes=null;
		if(Tno == null || Tno == ""){	//������
			mes = "��ʦ�Ų���Ϊ��";
			try {
				request.setAttribute("message", mes);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}catch(Exception e){} 
			
		}
		
		AdminDAO aDAO = new AdminDAO();
		boolean ac = false;
		try {
			ac = aDAO.addTeacher(Tno, Tname, Title, Tel, Dno, Password);
			
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
			mes="�ɹ�����һ����ʦ����";
		} else {
			mes="����ʧ�ܡ���\r\nע���ʦ��Ψһ�Ҳ�Ϊ�գ�ϵ�ű�����ڣ�";
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
