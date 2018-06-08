package com.java1234.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java1234.model.User;
import com.java1234.service.impl.LoginService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private LoginService loginService;
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request, HttpServletResponse response) {
		User u = loginService.queryUser(user);
		if(u.getId() == null) {
			request.setAttribute("error", "用户名或者密码出错");
			return "login";
		} else {
			String remenber = request.getParameter("remenber");
			remenber(request, remenber, response);
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", u);
			return "redirect:/main.jsp";
		}
		
	}
	private void remenber(HttpServletRequest request, String remenber, HttpServletResponse response) {
		if(remenber != null) {
			String u = request.getParameter("userName");
			String p = request.getParameter("password");
			Cookie cookie = new Cookie("login", u+"-"+p);
			cookie.setMaxAge(30*24*60*60);
			response.addCookie(cookie);
			
		}
		
	}
}
