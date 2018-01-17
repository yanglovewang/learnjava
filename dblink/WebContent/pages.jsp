<%@page import="javafx.css.PseudoClass"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<%

	final int e = 3;   //每页记录数
	int totalPages = 0; //总页面
	int currentPage = 1;//当前页面
	int totalCount = 0; //总页面
	int p = 0;          // 索引
	//点击浏览器页面后后台获取页面，设置当前页面
	String tempStr = request.getParameter("currentPage");
	if(tempStr != null ||tempStr != "") {
		currentPage = Integer.parseInt(tempStr);
	}
	
	//计算总记录数
	
	rs=stmt.executeQuery("select count(*) from products;");
	if(rs.next())
	  totalCount=rs.getInt(1);

	//计算总的页数
	totalPages=((totalCount%e==0)?(totalCount/e):(totalCount/e+1));
	if(totalPages==0) totalPages=1;

	//修正当前页面编号，确保：1<=currentPage<=totalPages
	if(currentPage>totalPages) 
	  currentPage=totalPages;
	else if(currentPage<1) 
	  currentPage=1;

	//计算当前页面所显示的第一条记录的索引
	p=(currentPage-1)*e;

	String sql="select prod_id,vend_id,prod_name,prod_price , prod_desc from products order by prod_id limit "+p+","+e;
	rs=stmt.executeQuery(sql);

%>

<%-- 显示页标签 --%>
页码：
<% for(int i=1;i<=totalPages;i++){
     if(i==currentPage){ 
%>
       <%=i%>
<%   }else{ %>
       <a href="dbaccess.jsp?currentPage=<%=i%>"><%=i %></a>
<%   } %>

<% } %>

&nbsp; 共<%=totalPages%>页,共<%=totalCount%>条记录

<table border="1" width=400>

<tr>
<td bgcolor="#D8E4F1"><b>编号</b></td>
<td bgcolor="#D8E4F1"><b>部门</b></td>
<td bgcolor="#D8E4F1"><b>名字</b></td>
<td bgcolor="#D8E4F1"><b>价格</b></td>
<td bgcolor="#D8E4F1"><b>描述</b></td>
</tr>

<%
while(rs.next()){

  String id=rs.getString(1);
  String name=rs.getString(2);
  String title=rs.getString(3);
  float price=rs.getFloat(4);
  String desc = rs.getString(5);
%>


<tr>
<td><%=id %></td>
<td><%=name %></td>
<td><%=title %></td>
<td><%=price %></td>
<td><%=desc %></td>
</tr>

<% 
} //#while 
%> 

</body>
</html>