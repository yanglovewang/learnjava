<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@page import="java.io.*" %>
  <%@page import="java.util.*" %>
  <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<%
	Connection conn;
Statement stmt;
ResultSet rs;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "admin";
		conn = DriverManager.getConnection(url,username,password);
		stmt = conn.createStatement();
%>

<%@include file="pages.jsp"%>

<%
stmt.close();
conn.close();
	}catch(Exception e) {
		out.println(e.getMessage());
	}
%>

</body>
</html>