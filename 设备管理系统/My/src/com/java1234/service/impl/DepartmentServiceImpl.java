package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.impl.DepartmentDao;
import com.java1234.model.Department;
import com.java1234.model.PageBean;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Resource
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> find(PageBean pageBean) {
		return departmentDao.queryList(pageBean);
	}

	@Override
	public int count() {
		return departmentDao.count();
	}

}
