package com.mywork.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.mywork.core.model.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate  jdbcTemplate;

	/**
	 * 通过用户名和密码获取用户数
	 * @return
	 */
	public int getMatchCount(String loginName,String password){
		String sqlStr = " select count(*) from t_user where" +
				        " loginname= ? and password= ? ";
		return jdbcTemplate.queryForInt(sqlStr,new Object[]{loginName,password});
	}
	
	/**
	 * 根据用户名获取User对象
	 * @return
	 */
	public User findUserByUserName(final String loginName){
		final User user = new User();
		String sqlStr = " select pid,credits,last_ip from t_user where loginname=? ";
		 jdbcTemplate.query(sqlStr, new Object[]{loginName}, 
				 new RowCallbackHandler(){
					public void processRow(ResultSet rs) throws SQLException {
						user.setPid(rs.getInt("pid"));
						user.setLoginName(loginName);
						user.setCredits(rs.getInt("credits"));
						user.setLastIP(rs.getString("last_ip"));
					}
		         }
		 );
		 return user;
	}
	
	/**
	 * 更新用户信息
	 */
	public void updateLoginInfo(User user){
		String sqlStr=" update t_user set credits=?," +
				      "last_visit = ? ,last_ip = ? where pid=? ";
		jdbcTemplate.update(sqlStr, 
				new Object[]{user.getCredits(),user.getLastVisit(),
				user.getLastIP(),user.getPid()});
	}
	
}
