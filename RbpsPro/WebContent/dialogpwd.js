$(function() {
		$("#tree").tree({
			data : [ {
				"id" : 2,
				"text" : "权限管理",
				"state" : "closed",
				"iconCls" : "icon-permission",
				"attributes" : {
					"authPath" : ""
				},
				"children" : [ {
					"id" : 12,
					"text" : "用户管理",
					"state" : "open",
					"iconCls" : "icon-userManage",
					"attributes" : {
						"authPath" : "userManage.html"
					}
				}, {
					"id" : 13,
					"text" : "角色管理",
					"state" : "open",
					"iconCls" : "icon-roleManage",
					"attributes" : {
						"authPath" : "roleManage.html"
					}
				}, {
					"id" : 14,
					"text" : "菜单管理",
					"state" : "open",
					"iconCls" : "icon-menuManage",
					"attributes" : {
						"authPath" : "menuManage.html"
					}
				} ]
			}, {
				"id" : 3,
				"text" : "学生管理",
				"state" : "closed",
				"iconCls" : "icon-student",
				"attributes" : {
					"authPath" : ""
				},
				"children" : [ {
					"id" : 5,
					"text" : "住宿管理",
					"state" : "open",
					"iconCls" : "icon-item",
					"attributes" : {
						"authPath" : "zsgl.html"
					}
				}, {
					"id" : 6,
					"text" : "学生信息管理",
					"state" : "open",
					"iconCls" : "icon-item",
					"attributes" : {
						"authPath" : "xsxxgl.html"
					}
				}, {
					"id" : 7,
					"text" : "学籍管理",
					"state" : "open",
					"iconCls" : "icon-item",
					"attributes" : {
						"authPath" : "xjgl.html"
					}
				}, {
					"id" : 8,
					"text" : "奖惩管理",
					"state" : "open",
					"iconCls" : "icon-item",
					"attributes" : {
						"authPath" : "jcgl.html"
					}
				} ]
			}, {
				"id" : 4,
				"text" : "课程管理",
				"state" : "closed",
				"iconCls" : "icon-course",
				"attributes" : {
					"authPath" : ""
				},
				"children" : [ {
					"id" : 9,
					"text" : "课程设置",
					"state" : "open",
					"iconCls" : "icon-item",
					"attributes" : {
						"authPath" : "kcsz.html"
					}
				}, {
					"id" : 10,
					"text" : "选课情况",
					"state" : "open",
					"iconCls" : "icon-item",
					"attributes" : {
						"authPath" : "xkqk.html"
					}
				}, {
					"id" : 11,
					"text" : "成绩录入",
					"state" : "open",
					"iconCls" : "icon-item",
					"attributes" : {
						"authPath" : "cjlr.html"
					}
				} ]
			}, {
				"id" : 15,
				"text" : "修改密码",
				"state" : "open",
				"iconCls" : "icon-modifyPassword",
				"attributes" : {
					"authPath" : ""
				}
			}, {
				"id" : 16,
				"text" : "安全退出",
				"state" : "open",
				"iconCls" : "icon-exit",
				"attributes" : {
					"authPath" : ""
				}
			} ],
			onClick : function(node) {
				if(node.id != 2 && node.id != 3 && node.id != 4 && node.id != 15 && node.id != 16) {
					if($("#tabs").tabs("exists", node.text)) {
						$("#tabs").tabs("select", node.text)
					} else {
						openTab(node)
					}
				} else if(node.id == 15) {
					modifyPwd()
				} else if(node.id == 16) {
					loginOut()
				} 
			} //end onClick()
		})// end $("#tree").tree
		$("#tree").tree("expandAll")
		var openTab = function(node) {
			console.log(node.id)
			$("#tabs").tabs("add", {
				title: node.text,
				selected: true,
				closable: true,
				iconCls: node.iconCls,
				content: "<iframe frameborder=0 scrolling='auto' style='width:100%; height:100%' src="+node.attributes.authPath+"></iframe>",
			})
		} // end openTab()
		var modifyPwd = function() {
			$("#dialog").dialog({
				 title: 'My Dialog',    
				    width: 400,    
				    height: 200,    
				    closed: false,            
				    modal: true,  
			})
		}
	}) //end $(function)
	
	var modifyPwd = function() {
	$(".form-modify-pwd").form("submit", {
		url: "MainServlet?action=modifyPwd",
		onSubmit: function() {
			var oldPwd = $("#id-input-oldPwd").val()
			var newPwd = $("#id-input-newPwd").val()
			var reNewPwd = $("#id-input-reNewPwd").val()
			if(!$(this).form("validate")) {
				return false
			}
			if(newPwd != reNewPwd) {
				$.messager.alert("提示", "密码两次输入不一致")
				return false
			}
			
		},
		success: function(data) {
			var data = eval('(' + data + ')'); 
			$.messager.alert("提示", data.message)
		},
	}) // end $(".form-modify-pwd").form
}// end modifyPwd

var cancelModifyPwd = function() {
	$("#id-input-oldPwd").val("")
	$("#id-input-newPwd").val("")
	$("#id-input-reNewPwd").val("")
	$("#dialog").dialog("close")
} // end cancelModifyPwd

var loginOut = function() {
	
}
	
	