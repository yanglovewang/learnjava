package com.java1234.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.java1234.model.Department;
import com.java1234.model.PageBean;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Resource
	private JdbcTemplate JdbcTemplate;
	@Override
	public Integer count() {
		StringBuffer sb = new StringBuffer("select count(*) from t_department");
		Integer num = JdbcTemplate.queryForObject(sb.toString(), Integer.class);
		return num;
	}

	@Override
	public List<Department> queryList(PageBean bean) {
		StringBuffer sb = new StringBuffer("select deptName, remark FROM t_department");
		final List<Department> list = new ArrayList<Department>();
		if(bean.getPageSize() > 0) {
			sb.append(" LIMIT ?, ?");
			JdbcTemplate.query(sb.toString(), new Object[]{
					bean.getStart(), 
					bean.getPageSize(),
					}, 
					new RowCallbackHandler() {
						@Override
						public void processRow(ResultSet rs) throws SQLException {
							Department dep = new Department();
							dep.setDeptName(rs.getString("deptName"));
							dep.setRemark(rs.getString("remark"));
							list.add(dep);
						}
					});
		}
		return list;
	}

}
