package com.mhh.bean;

import java.util.Date;

public class Course {
	private String Cno;
	private String Cname;
	private String Credit;
	private Date Ctime;
	private int Cnum;
	private String Tno;
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getCredit() {
		return Credit;
	}
	public void setCredit(String credit) {
		Credit = credit;
	}
	public Date getCtime() {
		return Ctime;
	}
	public void setCtime(Date ctime) {
		Ctime = ctime;
	}
	public int getCnum() {
		return Cnum;
	}
	public void setCnum(int cnum) {
		Cnum = cnum;
	}
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	
}
