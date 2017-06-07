package com.mhh.bean;

public class Admin {
	private String Ano;
	private String Aname;
	private String Password;
	public String getAno() {
		return Ano;
	}
	public void setAno(String ano) {
		Ano = ano;
	}
	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
/*
create table admin
( Ano char(12) primary key,
  Aname char(20),
  Password varchar(255)
		);
*/