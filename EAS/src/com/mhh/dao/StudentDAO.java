package com.mhh.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mhh.bean.infoCourse;
import com.mhh.bean.Student;
import com.mhh.util.DbManager;

public class StudentDAO {
	
	public Student stulogin(String sno,String password) throws SQLException{
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = DbManager.getConnection();
			if(conn==null){
				System.out.println("连接失败");
			}
			String  sql="select * from student where Sno=? and Password=?";
			st= conn.prepareStatement(sql);
			st.setString(1, sno);
			st.setString(2, password);
			rs= st.executeQuery();
			if (rs.next()) {

				Student student = new Student();
				student.setSno(rs.getString("Sno"));
				student.setSname(rs.getString("Sname"));
				student.setSsex(rs.getString("Ssex"));
				student.setSbirth(rs.getDate("Sbirth"));
				student.setClassno(rs.getString("Classno"));
				student.setPassword(rs.getString("Password"));
				return student;
			}					
		} catch (SQLException e) {
			System.out.println("执行SQL时，出错："+e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		}
		return null;
	}
	
	public List getCourseInfo(String sname) throws SQLException{
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = DbManager.getConnection();
			if(conn==null){
				System.out.println("连接失败");
			}
			String  sql="select student.Sname,course.Cname,teacher.Tname,sc.Grade "
					+ "from student,course,teacher,sc where course.Tno=teacher.Tno and "
					+ "course.Cno=sc.Cno and sc.Sno=student.Sno and student.Sname=?";
			st= conn.prepareStatement(sql);
			st.setString(1, sname);
			rs= st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				System.out.println("MHH");
				infoCourse info = new infoCourse();
				info.setSname(rs.getString("Sname"));
				info.setCname(rs.getString("Cname"));
				info.setTname(rs.getString("Tname"));
				info.setGrade(rs.getInt("Grade"));
				list.add(info);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("执行SQL时，出错："+e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		}
		return null;
	}
	
	public List getClassmateInfo(String Classno) throws SQLException{
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = DbManager.getConnection();
			if(conn==null){
				System.out.println("连接失败");
			}
			String  sql="select Sno, Sname, Ssex, Sbirth, Classno from student where Classno = ?";
			st= conn.prepareStatement(sql);
			st.setString(1, Classno);
			rs= st.executeQuery();
			List list = new ArrayList();
			while (rs.next()) {
				Student student = new Student();
				student.setSno(rs.getString("Sno"));
				student.setSname(rs.getString("Sname"));
				student.setSsex(rs.getString("Ssex"));
				student.setSbirth(rs.getDate("Sbirth"));
				student.setClassno(rs.getString("Classno"));
				list.add(student);
				/*System.out.println("MHH");
				infoCourse info = new infoCourse();
				info.setSname(rs.getString("Sname"));
				info.setCname(rs.getString("Cname"));
				info.setTname(rs.getString("Tname"));
				info.setGrade(rs.getInt("Grade"));
				list.add(info);*/
			}
			return list;
		} catch (SQLException e) {
			System.out.println("执行SQL时，出错："+e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		}
		return null;
	}
	
	public boolean alterPassword(String sno,String password) throws SQLException{
		Connection conn=null;		
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = DbManager.getConnection();
			if(conn==null){
				System.out.println("连接失败");
			}
			String  sql="update student set Password=? where Sno=?";
			st= conn.prepareStatement(sql);
			st.setString(1, password);
			st.setString(2, sno);
			int ac = st.executeUpdate();
			System.out.println(ac);
			if (ac==1) {
				return true;
			} else {
				return false;
			}
		}
		catch (SQLException e) {
			System.out.println("执行SQL时，出错："+e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		}
		return false;
	}
	
	public String getpassword(String sno) throws SQLException{
		Connection conn=null;		
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = DbManager.getConnection();
			if(conn==null){
				System.out.println("连接失败");
			}
			String  sql="select * from student where Sno=?";
			st= conn.prepareStatement(sql);
			st.setString(1, sno);
			rs= st.executeQuery();
			if (rs.next()) {
				return rs.getString("Password");
			}
		}
		catch (SQLException e) {
			System.out.println("执行SQL时，出错："+e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		}
		return null;
	}
	
}
