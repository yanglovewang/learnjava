package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bean.User;

@RunWith(SpringJUnit4ClassRunner.class) //帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml")
public class testJunit {
	
	//将容器中user属性注册到私有变量中
	@Resource(name="user")
	private User u;
	@Test
	public void fun1() {
		System.out.println(u);
	}

}