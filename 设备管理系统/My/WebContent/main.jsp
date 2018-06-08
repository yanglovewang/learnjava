<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
 if(session.getAttribute("currentUser") == null) {
	 response.sendRedirect(request.getContextPath()+"/login.jsp");
 }

String mainPage = (String)request.getAttribute("mainPage");
if(mainPage == null) {
	mainPage = "/common/default.jsp";
}

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.js"></script></head>
<body>
<div class="container">
	<div class="row">
	  <div class="col-sm-12">
	  	<jsp:include page="/common/head.jsp"></jsp:include>
	  </div>  
	</div>
	<div class="row" style="margin-top: 60px">
	  <div class="col-sm-3">
	  	<jsp:include page="/common/menu.jsp"></jsp:include>
	  </div>
	  <div class=".col-sm-9">
	  	<div style="margin-left: 25%">
	  		<ol class="breadcrumb">
			  <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="${pageContext.request.contextPath}/main.jsp">主页</a></li>
			  <li class="active">${modeName }</li>
			</ol>
	  	</div>
	  	<jsp:include page="<%=mainPage %>"></jsp:include>
	  </div>
	</div>
		<div class="row">
	  <div class="col-sm-12">.col-md-12</div>  
	</div>
</div>
</body>
</html>