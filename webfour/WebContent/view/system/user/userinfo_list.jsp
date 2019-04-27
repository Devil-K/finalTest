<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
	//获取绝对路径路径 
	String path = request.getContextPath();

			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
	%>   
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>	   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>用户管理-用户查询</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript"
	src="resource/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	//绑定全选按钮选中事件
	$("#all").click(function(){
		//获取所有多选框的checked属性
		var allChecked=this.checked;
		//获取所有name属性为ids的input标签
		$("input[name=ids]").each(function(){
			this.checked=allChecked;
		});
	});
	
	//绑定点击删除按钮事件
	$("#del").click(function(){
		//获取所有已经选中的name属性为ids的input标签
		var cks=$("input[name=ids]:checked");
		
		if(cks.length<1){
			alert("请选择要删除的用户");
			return;
		}
		//confirm(arg) 点击确定时返回true,点击取消返回false
		if(confirm("确认要删除吗？")){
			//修改form表单的action属性
			$("#f1").prop("action","system/deleteUsers");
			//jquery提交form表单
			$("#f1").submit();
		}
		
		
	});
	
})

</script>	
</head>
<body>
<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>用户查询</li>
		</ul>
	</div>
	<form action="system/queryUsers" id="f1" class="form-inline" method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group" >
				<label>用户编号:</label> 
				<input type="text" class="form-control" name="userId" value="${user.userId==0?'':user.userId }" placeholder="请输入用户编号" />
				<label>用户姓名:</label>
				<input type="text" class="form-control" name="userName" value="${user.userName }"  placeholder="请输入用户姓名" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="view/system/user/userinfo_add.jsp" class="btn btn-success">添加用户</a>
			<input type="button" class="btn btn-warning" id="del" value="删除用户">
		</div>
		<div class="row" style="padding: 15px;">
			<d:table class="table table-hover table-condensed" name="users" pagesize="15" requestURI="system/queryUsers">
				<d:column property="ck" title="<input type='checkbox'  id='all'  />"></d:column>
				<d:column property="userId" title="用户编号"></d:column>
				<d:column property="userName" title="用户姓名"></d:column>
				<d:column property="userSex" title="用户性别"></d:column>
				<d:column property="userAge" title="用户年龄"></d:column>
				<d:column property="userPhone" title="用户电话"></d:column>
				<d:column property="roleName" title="用户角色"></d:column>
				<d:column property="userAccount" title="用户账户"></d:column>
				<d:column property="userPwd" title="用户密码"></d:column>
				<d:column property="userSalary" title="用户薪资"></d:column>
				
				<d:column value="修改" href="system/updateUser" paramId="userId" paramProperty="userId"></d:column>
				<d:column  title="操作"></d:column>
			</d:table>
		</div>
	</form>
</body>
</html>