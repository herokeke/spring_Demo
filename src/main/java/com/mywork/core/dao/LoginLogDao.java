package com.mywork.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mywork.core.model.LoginLog;

@Repository
public class LoginLogDao {
	
	@Autowired
	private JdbcTemplate  jdbcTemplate;

	public void insertLoginLog(LoginLog loginLog){
		String strSql=" INSERT INTO t_login_log(userid,ip,last_datetime) VALUES(?,?,?) ";
		Object[] obj = new Object[]{loginLog.getUid(),loginLog.getIp(),loginLog.getLoginDate()};
		jdbcTemplate.update(strSql,obj);
		
	}
}
