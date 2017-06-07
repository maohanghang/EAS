package com.mhh.bean;

import java.util.Date;

public class Student {
	private String Sno;
	private String Sname;
	private String Ssex;
	private Date  Sbirth;
	private String Classno;
	private String Password;
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSsex() {
		return Ssex;
	}
	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	public Date getSbirth() {
		return Sbirth;
	}
	public void setSbirth(Date sbirth) {
		Sbirth = sbirth;
	}
	public String getClassno() {
		return Classno;
	}
	public void setClassno(String classno) {
		Classno = classno;
	}
	
}
