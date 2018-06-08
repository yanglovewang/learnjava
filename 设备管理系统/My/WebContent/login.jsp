<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.js"></script>
<%
	Cookie[] cookies = request.getCookies();
	for(int i = 0; i < cookies.length; i++) {
		String key = cookies[i].getName();
		if(key.equals("login")) {
			String[] user = cookies[i].getValue().split("-");
			String u = user[0];
			String p = user[1];
			System.out.print(u);
			pageContext.setAttribute("userName", u);
			pageContext.setAttribute("passWord", p);
		}
	}
%>
</head>
<body>
<div class="div-login">
<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/user/login.do">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">userName</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="userName" value="${userName}" id="input-userName" placeholder="userName" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" name="password" value="${passWord }" class="form-control" id="input-Password"  placeholder="Password">
    	<span id="span-ear" class="glyphicon glyphicon-eye-close"></span>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input name="remenber" type="checkbox"> Remember me
        </label>
         <label class="login-error" style="color: red;">
          ${error}
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button id="button-div-sub" type="submit" class="btn btn-default" onclick="return checkForm()">Sign in</button>
      <button id="button-clear" type="button" class="btn btn-default">clear</button><br/>
    </div>
  </div>
</form>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</html>