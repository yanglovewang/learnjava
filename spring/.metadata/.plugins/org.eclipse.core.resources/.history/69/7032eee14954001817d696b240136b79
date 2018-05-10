package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;

public class UserTest {
	
	public void fun(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) ac.getBean("user");
		User user2 = (User) ac.getBean("user");
		System.out.println(user == user2 );
		System.out.println(user);
		
	}
	
	public static void main(String[] args) {
		new UserTest().fun();
	}
}
