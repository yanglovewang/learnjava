package Aservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author yangchengju
 *@2018年1月14日
 *
 *遍历cookie 
 *获取某个cookie；
 *杀死cookie
 *
 */
@WebServlet("/HelloHttpServlet")
public class HelloCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloCookie() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("html/text;charset=utf-8");
		Cookie[] cookies = request.getCookies();
		response.addCookie(new Cookie("name" , "value"));
		for(int i=0;i<cookies.length;i++) {
			if(cookies[i].getName().equals("name")){
				System.out.println("name = " + cookies[i].getValue());
				cookies[i].setMaxAge(0);
				System.out.println("cookie iskill");
			}
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
