package com.mhh.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import com.mhh.bean.Admin;
import com.mhh.bean.Student;
import com.mhh.bean.Teacher;
import com.mhh.bean.Course;
import com.mhh.util.DbManager;






public class AdminDAO {

	public Admin adminlogin(String ano,String password) throws SQLException{
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn = DbManager.getConnection();
			if(conn==null){
				System.out.println("连接失败");
			}
			String  sql="select * from admin where Ano=? and Password=?";
			st= conn.prepareStatement(sql);
			st.setString(1, ano);
			st.setString(2, password);
			rs= st.executeQuery();
			if(rs.next()) {
				Admin admin = new Admin();
				admin.setAno(rs.getString("Ano"));
				admin.setAname(rs.getString("Aname"));
				admin.setPassword(rs.getString("Password"));
				return admin;
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
	
	public List selectAll() throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		
		ResultSet rs=null;
		DbManager jdbc =new DbManager();
				try {
					conn = jdbc.getConnection();
					System.out.println("selectAll connection");
					String  sql="select * from admin";
					st= conn.createStatement();
					
					rs= st.executeQuery(sql);
					List list = new ArrayList();
					while(rs.next()){
                		Admin user=new Admin();
                		user.setAno(rs.getString("Ano"));
                		user.setAname(rs.getString("Aname"));
                		user.setPassword(rs.getString("Password"));
						list.add(user);
                	}
					return list;
					
					
				} catch (Exception e) {
					// TODO: handle exception
					throw new Exception("error selectAll");
				}finally {
					if(rs!=null) rs.close();
					if(st!=null) st.close();
					if(conn!=null) conn.close();	
				}
	}
	
	public List selectAllcourse() throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		
		ResultSet rs=null;
		DbManager jdbc =new DbManager();
				try {
					conn = jdbc.getConnection();
					System.out.println("selectAllcourse connection");
					String  sql="select * from course";
					st= conn.createStatement();
					
					rs= st.executeQuery(sql);
					List list = new ArrayList();
					while(rs.next()){
                		Course course=new Course();
                		course.setCno(rs.getString("Cno"));
                		course.setCname(rs.getString("Cname"));
                		course.setCredit(rs.getString("Credit"));
                		course.setCnum(rs.getInt("Cnum"));
                		course.setTno(rs.getString("Tno"));
                		course.setCtime(rs.getDate("Ctime"));
						list.add(course);
                	}
					return list;
					
					
				} catch (Exception e) {
					// TODO: handle exception
					throw new Exception("error selectAll");
				}finally {
					if(rs!=null) rs.close();
					if(st!=null) st.close();
					if(conn!=null) conn.close();	
				}
	}
	
	public List selectAllstudent() throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		
		ResultSet rs=null;
		DbManager jdbc =new DbManager();
				try {
					conn = jdbc.getConnection();
					String  sql="select * from student";
					st= conn.createStatement();
					
					rs= st.executeQuery(sql);
					List list = new ArrayList();
					while(rs.next()){
                		Student student=new Student();
						
						
                		//student.setId(rs.getInt("id"));
                		student.setSno(rs.getString("Sno"));
                		student.setSname(rs.getString("Sname"));
                		student.setClassno(rs.getString("Classno"));
                		student.setSbirth(rs.getDate("Sbirth"));
                		student.setSsex(rs.getString("Ssex"));
						list.add(student);
                	}
					return list;
					
					
				} catch (Exception e) {
					// TODO: handle exception
					throw new Exception("error selectAllstudent");
				}finally {
					if(rs!=null) rs.close();
					if(st!=null) st.close();
					if(conn!=null) conn.close();	
				}
	}
	
	public List selectAllteacher() throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		
		ResultSet rs=null;
		DbManager jdbc =new DbManager();
				try {
					conn = jdbc.getConnection();
					String  sql="select * from teacher";
					st= conn.createStatement();
					
					rs= st.executeQuery(sql);
					List list = new ArrayList();
					while(rs.next()){
                		Teacher teacher=new Teacher();
						
						
                		teacher.setDno(rs.getString("Dno"));
                		teacher.setTno(rs.getString("Tno"));
                		teacher.setTname(rs.getString("Tname"));
                		teacher.setTitle(rs.getString("Title"));
                		//teacher.setTeachersex(rs.getString("teachersex"));
                		teacher.setTel(rs.getString("Tel"));
						list.add(teacher);
                	}
					return list;
					
					
				} catch (Exception e) {
					// TODO: handle exception
					throw new Exception("error selectAllstudent");
				}finally {
					if(rs!=null) rs.close();
					if(st!=null) st.close();
					if(conn!=null) conn.close();	
				}
	}
	
	public boolean addClass(String Classno, double TotalCredit, String Tno, String Dno) throws SQLException {
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
			String  sql="insert into class (Classno, TotalCredit, Tno, Dno) values(?,?,?,?)";
			st= conn.prepareStatement(sql);
			st.setString(1, Classno);
			st.setDouble(2, TotalCredit);
			st.setString(3, Tno);
			st.setString(4, Dno);
			
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
	
	public boolean addCourse(String Cno, String Cname, double Credit, java.sql.Date Ctime, int Cnum, String Tno) throws SQLException {
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
			String  sql="insert into course (Cno, Cname, Credit, Ctime, Cnum, Tno) values(?,?,?,?,?,?)";
			st= conn.prepareStatement(sql);
			st.setString(1, Cno);
			st.setString(2, Cname);
			st.setDouble(3, Credit);
			st.setDate(4, (java.sql.Date) Ctime);
			st.setInt(5, Cnum);
			st.setString(6, Tno);
			
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
	
	public boolean addStudent(String Sno, String Sname, String Ssex, Date Sbirth, String Classno, String Password) throws SQLException {
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
			String  sql="insert into student (Sno, Sname, Ssex, Sbirth, Classno, Password) values(?,?,?,?,?,?)";
			st= conn.prepareStatement(sql);
			st.setString(1, Sno);
			st.setString(2, Sname);
			st.setString(3, Ssex);
			st.setDate(4, Sbirth);
			st.setString(5, Classno);
			st.setString(6, Password);
			
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
	
	public boolean addTeacher(String Tno, String Tname, String Title, String Tel, String Dno, String Password) throws SQLException {
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
			String  sql="insert into teacher (Tno, Tname, Title, Tel, Dno, Password) values(?,?,?,?,?,?)";
			st= conn.prepareStatement(sql);
			st.setString(1, Tno);
			st.setString(2, Tname);
			st.setString(3, Title);
			st.setString(4, Tel);
			st.setString(5, Dno);
			st.setString(6, Password);
			
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
	
	public boolean addAdmin(String Ano, String Aname, String Password) throws SQLException {
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
			String  sql="insert into admin (Ano, Aname, Password) values(?,?,?)";
			st= conn.prepareStatement(sql);
			st.setString(1, Ano);
			st.setString(2, Aname);
			st.setString(3, Password);
			
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
	
	public boolean deleteAdmin(String Ano) throws SQLException {
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
			String  sql="delete from admin where Ano = ?";
			st= conn.prepareStatement(sql);
			st.setString(1, Ano);
			
			
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
	
	
	public boolean deletecourse(String Cno) throws SQLException {
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
			String  sql="delete from course where Cno = ?";
			st= conn.prepareStatement(sql);
			st.setString(1, Cno);
			
			
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
	
	
	public boolean deletestudent(String Sno) throws SQLException {
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
			String  sql="delete from student where Sno = ?";
			st= conn.prepareStatement(sql);
			st.setString(1, Sno);
			
			
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
	
	public boolean deleteteacher(String Tno) throws SQLException {
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
			String  sql="delete from teacher where Tno = ?";
			st= conn.prepareStatement(sql);
			st.setString(1, Tno);
			
			
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
	
	public boolean updateAdmin(String Ano, String Aname, String Password) throws SQLException {
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
			String  sql="update admin set Aname=?, Password=? where Ano=?";
			st= conn.prepareStatement(sql);
			st.setString(1, Aname);
			st.setString(2, Password);
			st.setString(3, Ano);
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
	
	public boolean updateCourse(String Cno, String Cname, double Credit, java.sql.Date Ctime, int Cnum, String Tno) throws SQLException {
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
			String  sql="update course set Cname=?,  Credit=?, Ctime=?, Cnum=?, Tno=? where Cno=?";
			st= conn.prepareStatement(sql);
			st.setString(1, Cname);
			st.setDouble(2, Credit);
			st.setDate(3, (java.sql.Date) Ctime);
			st.setInt(4, Cnum);
			st.setString(5, Tno);
			st.setString(6, Cno);
			
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
	
	public boolean updateStudent(String Sno, String Sname, String Ssex, java.sql.Date Sbrith, String Classno) throws SQLException {
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
			String  sql="update student set Sname=?,  Ssex=?, Sbirth=?, Classno=? where Sno=?";
			st= conn.prepareStatement(sql);
			st.setString(1, Sname);
			st.setString(2, Ssex);
			st.setDate(3, (java.sql.Date) Sbrith);
			st.setString(4, Classno);
			st.setString(5, Sno);
			
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
	
	public boolean updateTeacher(String Tno, String Tname, String Title, String Tel, String Dno) throws SQLException {
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
			String  sql="update teacher set Tname=?,  Title=?, Tel=?, Dno=? where Tno=?";
			st= conn.prepareStatement(sql);
			st.setString(1, Tname);
			st.setString(2, Title);
			st.setString(3, Tel);
			st.setString(4, Dno);
			st.setString(5, Tno);
			
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
	
	public static void main(String args[]) throws Exception{
		AdminDAO a = new AdminDAO();
		//boolean i = a.deleteAdmin("201408010201");
		//System.out.println(i);
	}
	
}
