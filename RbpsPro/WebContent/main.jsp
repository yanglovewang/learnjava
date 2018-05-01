<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script src="dialogpwd.js"></script>
<link rel="stylesheet" type="text/css" href="main.css">
</style>
</head>

<!-- body -->
<body class="easyui-layout">
	<div data-options="region:'north',title:'North Title',split:true"
		style="height: 100px;"></div>
	<div data-options="region:'south',title:'South Title',split:true"
		style="height: 100px;"></div>
	<div data-options="region:'west',title:'West',split:true"
		style="width: 200px;">
		<ul id="tree"></ul>
	</div>
	<div data-options="region:'center'" style=" background: #eee;">
		<div id="tabs" class="easyui-tabs" fit="true" >
			<div title="首页" style="padding: 20px; display: none; width:100%; height:100%;">首页</div>		
		</div> 	
	</div>
	<!-- modify pwd -->
	<div id="dialog" buttons="#id-modify-buttons" >
		<form id="" class="form-modify-pwd" method="post">
			<table class="table-modify-pwd">
				<tr>
					<td>旧密码</td>
					<td><input type="text" id="id-input-oldPwd" name="oldPwd" class="easyui-validatebox" required="required" ></td>
				</tr>
				<tr>
					<td>新密码</td>
					<td><input type="password" id="id-input-newPwd" name="newPwd" class="easyui-validatebox" required="required"></td>
				</tr>
				<tr>
					<td>重复新密码</td>
					<td><input type="password" id="id-input-reNewPwd" name="reNewPwd" class="easyui-validatebox" required="required"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="id-modify-buttons">
		<a id="btn" href="javascript:modifyPwd()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a>
		<a id="btn" href="javascript:cancelModifyPwd()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">取消</a>
	</div> 
</body>
</html>