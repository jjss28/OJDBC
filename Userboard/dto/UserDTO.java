package Userboard.dto;

import java.sql.Date;

public class UserDTO {
	private int mno;
	private String name;
	private String id;
	private String pw;
	private Date regidate;
	
	public int getMno() {
		return mno;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

}
