package com.boot.projectEx.model;

import java.util.Date;

public class MemberVO {
	private String memerId;
	private String memerPwd;
	private String memerName;
	private String memerEmail;
	private Date memerJoinDate;
	
	public MemberVO(){}

	public String getMemerId() {
		return memerId;
	}

	public void setMemerId(String memerId) {
		this.memerId = memerId;
	}

	public String getMemerPwd() {
		return memerPwd;
	}

	public void setMemerPwd(String memerPwd) {
		this.memerPwd = memerPwd;
	}

	public String getMemerName() {
		return memerName;
	}

	public void setMemerName(String memerName) {
		this.memerName = memerName;
	}

	public String getMemerEmail() {
		return memerEmail;
	}

	public void setMemerEmail(String memerEmail) {
		this.memerEmail = memerEmail;
	}

	public Date getMemerJoinDate() {
		return memerJoinDate;
	}

	public void setMemerJoinDate(Date memerJoinDate) {
		this.memerJoinDate = memerJoinDate;
	}
}
