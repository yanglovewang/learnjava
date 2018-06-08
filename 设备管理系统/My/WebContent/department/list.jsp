<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="input-group">
	      <input type="text" name="searchName" class="form-control" placeholder="Search for...">
	      <span class="input-group-btn">
	        <button class="btn btn-default" type="submit">Go!</button>
	      </span>
  </div><!-- /input-group -->
  <div class="departamentTable" style="margin-left: 25%;margin-top: 20px">
  	<table class="table table-bordered" style="height: 140px;">
  		<tr>
	  		<td>编号</td>
	  		<td>部门名称</td>
	  		<td>部门地址</td>
  		</tr>
  		<c:forEach var="department" items="${depserLisr }" varStatus="status">
  		<tr>
  			<td>${status.index+1 }</td>
	  		<td>${department.deptName }</td>
	  		<td>${department.remark }</td>
  		</tr>
  		</c:forEach>
	</table>
	<nav >
		<ul class="pagination">
			${pageStr }
		</ul>
	</nav>
  </div>