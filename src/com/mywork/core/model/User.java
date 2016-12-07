package com.mywork.core.model;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {

	private int pid;
	private String loginName;
	private String passWord;
	private int credits; //信用积分
	private String lastIP;
	private Date lastVisit;
	
	public User(){}
	
	public User(int pid, String loginName, String passWord, int credits,
			String lastIP, Date lastVisit) {
		super();
		this.pid = pid;
		this.loginName = loginName;
		this.passWord = passWord;
		this.credits = credits;
		this.lastIP = lastIP;
		this.lastVisit = lastVisit;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getLastIP() {
		return lastIP;
	}
	public void setLastIP(String lastIP) {
		this.lastIP = lastIP;
	}
	public Date getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
	
	
	
}
