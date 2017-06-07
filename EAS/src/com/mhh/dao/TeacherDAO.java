package com.mhh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mhh.bean.Teacher;
import com.mhh.bean.infoCourse;
import com.mhh.bean.Course;
import com.mhh.util.DbManager;

public class TeacherDAO {
	public Teacher tealogin(String tno,String password) throws SQLException{
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = DbManager.getConnection();
			if(conn==null){
				System.out.println("连接失败");
			}
			String  sql="select * from teacher where Tno=? and Password=?";
			st= conn.prepareStatement(sql);
			st.setString(1, tno);
			st.setString(2, password);
			rs= st.executeQuery();
			if(rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTno(rs.getString("Tno"));
				teacher.setTname(rs.getString("Tname"));
				teacher.setTitle(rs.getString("Title"));
				teacher.setTel(rs.getString("Tel"));
				teacher.setDno(rs.getString("Dno"));	
				return teacher;
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
	
	//查看此教师所教授的课程信息
	public List<Course> searchInfo(String tno) throws SQLException{
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = DbManager.getConnection();
			if(conn==null){
				System.out.println("连接失败");
			}
			String  sql="select * from course where Tno=?";
			st= conn.prepareStatement(sql);
			st.setString(1, tno);
			rs= st.executeQuery();
			List list = new ArrayList<Course>();
			while(rs.next()) {
				Course course = new Course();
				course.setCno(rs.getString("Cno"));
				course.setCname(rs.getString("Cname"));
				course.setCredit(rs.getString("Credit"));
				course.setCtime(rs.getDate("Ctime"));
				course.setCnum(rs.getInt("Cnum"));
				list.add(course);
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
	public boolean addSC(String Sno, String Cno, int Grade) throws SQLException {
		// TODO Auto-generated method stub
        Connection conn=null;
		
		PreparedStatement st=null;
		ResultSet rs=null;
		DbManager jdbc =new DbManager();
		try {
			conn = jdbc.getConnection();
			if(conn==null){
				System.out.println("连接失败");
			}
			String  sql="insert into sc (Sno, Cno,Grade) values(?,?,?)";
			st= conn.prepareStatement(sql);
			st.setString(1, Sno);
			st.setString(2, Cno);
			st.setInt(3, Grade);
			
			//System.out.println(classid+classname+classs);
			
			int ac = st.executeUpdate();
			System.out.println(ac);
			
			if (ac==1) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			System.out.println("执行SQL时，出错："+e.getMessage());
		}finally {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		}

		return false;
	}
	//查看授课学生
		public List seastudent(String tno) throws SQLException{
			Connection conn=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			try {
				conn = DbManager.getConnection();
				if(conn==null){
					System.out.println("连接失败");
				}
				//String  sql="select * from course where Tno=?";
				String  sql="select student.Sname,course.Cname,teacher.Tname,sc.Grade "
						+ "from student,course,teacher,sc where course.Tno=teacher.Tno and "
						+ "course.Cno=sc.Cno and sc.Sno=student.Sno and teacher.Tno=?";
				st= conn.prepareStatement(sql);
				st.setString(1, tno);
				rs= st.executeQuery();
				List list = new ArrayList();
				while (rs.next()) {
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
		
		
		
		public boolean alterPasswordtea(String tno,String password) throws SQLException{
			Connection conn=null;		
			PreparedStatement st=null;
			ResultSet rs=null;
			try {
				conn = DbManager.getConnection();
				if(conn==null){
					System.out.println("连接失败");
				}
				String  sql="update teacher set Password=? where Tno=?";
				st= conn.prepareStatement(sql);
				st.setString(1, password);
				st.setString(2, tno);
				
				int ac = st.executeUpdate();
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
		
		public String getpasswordtea(String tno) throws SQLException{
			Connection conn=null;		
			PreparedStatement st=null;
			ResultSet rs=null;
			try {
				conn = DbManager.getConnection();
				if(conn==null){
					System.out.println("连接失败");
				}
				String  sql="select * from teacher where Tno=?";
				st= conn.prepareStatement(sql);
				st.setString(1, tno);
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
