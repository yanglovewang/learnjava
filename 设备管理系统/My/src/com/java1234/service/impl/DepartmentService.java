package com.java1234.service.impl;

import java.util.List;

import com.java1234.model.Department;
import com.java1234.model.PageBean;

public interface DepartmentService {

public List<Department> find(PageBean pageBean);
	
	public int count();
}
