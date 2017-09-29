package com.mywork.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywork.core.dao.LoginLogDao;
import com.mywork.core.dao.UserDao;
import com.mywork.core.model.LoginLog;
import com.mywork.core.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	public boolean hashMathchUser(String loginName,String password){
		int matchCount = userDao.getMatchCount(loginName, password);
		return matchCount>0;
	}
	
	public User findUserByUserName(String loginName){
		return userDao.findUserByUserName(loginName);
	}
	
	public void loginSuccess(User user){
		user.setCredits(5+user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUid(user.getPid());
		loginLog.setIp(user.getLastIP());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
		
		
	}
	
	
	
	
}
