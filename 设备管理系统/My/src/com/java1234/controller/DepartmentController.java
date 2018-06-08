package com.java1234.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java1234.model.Department;
import com.java1234.model.PageBean;
import com.java1234.service.impl.DepartmentService;
import com.java1234.util.PageUtil;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Resource
	private DepartmentService depser;
	@RequestMapping("/list")
	public ModelAndView departmentList(@RequestParam(value="page",required=false)String page, 
			HttpServletRequest request) {
		if(page == null) {
			page = "1";
		}
		Integer pg = Integer.parseInt(page);
		PageBean bean = new PageBean();
		bean.setPage(pg);
		List<Department> list = depser.find(bean);
		String pageStr = PageUtil.getPagation(request.getContextPath()+"/department/list.do", depser.count()-1, pg, 3);
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		request.setAttribute("depserLisr", list);
		request.setAttribute("mainPage", "department/list.jsp");
		request.setAttribute("modeName", "部门管理");
		session.setAttribute("pageStr", pageStr);
		mv.setViewName("main");
		return mv;
	}
	
	//分页列表测试
	private void testList() {
		System.out.println(depser.count());
		PageBean pageBean = new PageBean(1, 3);
		List<Department> list = depser.find(pageBean);
		for (Department item : list) {
			System.out.println(item.toString());
		}
	}
}
