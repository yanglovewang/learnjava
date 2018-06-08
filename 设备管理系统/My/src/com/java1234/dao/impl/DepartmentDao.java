package com.java1234.dao.impl;

import java.util.List;

import com.java1234.model.Department;
import com.java1234.model.PageBean;

public interface DepartmentDao {

	public Integer count();
	public List<Department> queryList(PageBean bean);
}
