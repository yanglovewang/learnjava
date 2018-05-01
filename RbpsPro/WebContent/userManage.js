$(function() {
	$("#id-userManage-grid").datagrid({
		data : {
			"rows" : [ {
				"userId" : 1,
				"userName" : "marry",
				"password" : "123456",
				"userType" : 2,
				"roleId" : 2,
				"userDescription" : "好",
				"roleName" : "宿舍管理员",
				"authIds" : "1,3,5,6,7,8,15,16",
				"roleDescription" : "管理学生宿舍信息"
			}, {
				"userId" : 28,
				"userName" : "java",
				"password" : "123",
				"userType" : 2,
				"roleId" : 2,
				"userDescription" : "hao 管理",
				"roleName" : "宿舍管理员",
				"authIds" : "1,3,5,6,7,8,15,16",
				"roleDescription" : "管理学生宿舍信息"
			}, {
				"userId" : 29,
				"userName" : "java",
				"password" : "123",
				"userType" : 2,
				"roleId" : 2,
				"userDescription" : "hao 管理",
				"roleName" : "宿舍管理员",
				"authIds" : "1,3,5,6,7,8,15,16",
				"roleDescription" : "管理学生宿舍信息"
			}, {
				"userId" : 30,
				"userName" : "ww",
				"password" : "1234",
				"userType" : 2,
				"roleId" : 2,
				"userDescription" : "12",
				"roleName" : "宿舍管理员",
				"authIds" : "1,3,5,6,7,8,15,16",
				"roleDescription" : "管理学生宿舍信息"
			}, {
				"userId" : 33,
				"userName" : "111",
				"password" : "21",
				"userType" : 2,
				"roleId" : 2,
				"userDescription" : "21",
				"roleName" : "宿舍管理员",
				"authIds" : "1,3,5,6,7,8,15,16",
				"roleDescription" : "管理学生宿舍信息"
			}, {
				"userId" : 34,
				"userName" : "lisi",
				"password" : "123456",
				"userType" : 2,
				"roleId" : 2,
				"userDescription" : "略",
				"roleName" : "宿舍管理员",
				"authIds" : "1,3,5,6,7,8,15,16",
				"roleDescription" : "管理学生宿舍信息"
			}, {
				"userId" : 35,
				"userName" : "21",
				"password" : "21",
				"userType" : 2,
				"roleId" : 2,
				"userDescription" : "21",
				"roleName" : "宿舍管理员",
				"authIds" : "1,3,5,6,7,8,15,16",
				"roleDescription" : "管理学生宿舍信息"
			}, {
				"userId" : 3,
				"userName" : "java",
				"password" : "javacc",
				"userType" : 2,
				"roleId" : 3,
				"userDescription" : "guanli元",
				"roleName" : "辅导员",
				"authIds" : "",
				"roleDescription" : "负责学生的生活，学习及心里问题"
			}, {
				"userId" : 31,
				"userName" : "xiaoli",
				"password" : "123456",
				"userType" : 2,
				"roleId" : 3,
				"userDescription" : "这是一个宿舍管理员",
				"roleName" : "辅导员",
				"authIds" : "",
				"roleDescription" : "负责学生的生活，学习及心里问题"
			}, {
				"userId" : 15,
				"userName" : "zhangsan",
				"password" : "javacc",
				"userType" : 2,
				"roleId" : 18,
				"userDescription" : "",
				"roleName" : "辅导员",
				"authIds" : "",
				"roleDescription" : "略"
			} ],
			"total" : 11
		}
	})// end $("#id-userManage-grid").datagrid
	
})// end $(function())

var addUser = function() {
	$('#id-div-addDialog').dialog({    
	    title: 'My Dialog',    
	    width: 500,       
	    closed: false,    
	    cache: false,        
	    modal: true   
	});
	}

var closeAddUserDialog = function() {
	$('#id-div-addDialog').dialog({
		closed: true,
	})
}
