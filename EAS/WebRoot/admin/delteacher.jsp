<%@page import="com.mhh.bean.*"%>
<%@page import="com.mhh.dao.*"%>
<%@page import="com.mhh.util.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.*"%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

	request.setCharacterEncoding("utf-8");
	String Tno = request.getParameter("Tno");
//	String username = request.getParameter("username");
//	String name = request.getParameter("name");
	System.out.println(Tno);
	AdminDAO aDAO = new AdminDAO();
    boolean ac = aDAO.deleteteacher(Tno);     
    if(ac)
    	System.out.println("删除成功！");
    else
    System.out.println("删除失败！");
    	
    
%>