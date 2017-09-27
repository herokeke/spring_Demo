package test.mywork.core.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mywork.core.model.User;
import com.mywork.core.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring_Demo/WEB-INF/applicationContext.xml"})
public class TestUserService {

	@Autowired
	private UserService userService;
	
	@Test
	public void hashMathchUser(){
		boolean flag =  userService.hashMathchUser("Demo", "123");
		assertTrue(flag);
	}
	@Test
	public void findUserByUserName(){
		User user = userService.findUserByUserName("Demo");
		assertEquals(user.getLoginName(),"Demo");
	}
	
	@Test
	public void loginSuccess(){
		User user = new User(1,"Demo","123",5,"localhost",new Date());
		userService.loginSuccess(user);
	}
}
