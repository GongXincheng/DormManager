<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://gxc.cn/common/" prefix="gxc" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
<title>Index</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript"> new WOW().init(); </script>
<style type="text/css">
#nav a{
	font-weight: bold;
}
table tr th{
	text-align: center;
}
#nav-page{
	text-align: center;
}
</style>
</head>

<body>
	<jsp:include page="../common/top.jsp"></jsp:include>
	
	<div class="container">
		<div class="col-md-2">
			<div class="list-group" id="nav">
			  <a href="/page/admin/index.html" class="list-group-item">首页</a>
			  <a href="${pageContext.request.contextPath}/admin/dormMngList.html" class="list-group-item active">宿舍管理员管理</a>
			  <a href="${pageContext.request.contextPath}/admin/studentList.html" class="list-group-item">学生管理</a>
			  <a href="${pageContext.request.contextPath}/admin/dormBuildList.html" class="list-group-item">宿舍楼管理</a>
			  <a href="${pageContext.request.contextPath}/admin/recordList.html" class="list-group-item">缺勤管理</a>
			  <a href="/page/admin/rePassword.html" class="list-group-item">修改密码</a>
			</div>
		</div>
		<div class="col-md-10">
			<div class="panel panel-default table-responsive">
			  <div class="panel-heading">
			    <h3 class="panel-title" style="font-weight: bold;">宿舍管理员管理</h3>
			  </div>
			  	<div id="panel-menu" style="margin:13px;">
		  			<div id="left" class="col-md-7">
		  				<button type="button" class="btn  btn-success" data-toggle="modal" data-target="#addModal">添加</button>
		  			</div>
			  		<div id="right" class="col-md-5">
				  		<form action="${pageContext.request.contextPath}/admin/dormMngList.html" method="post" class="form-inline form-group-sm">
				  			 <div class="form-group">
				  			 	<select class="form-control" name="conditionId">
								  <option value="1" <c:if test="${conditionId==1}">selected</c:if> >姓名</option>
								  <option value="2" <c:if test="${conditionId==2}">selected</c:if> >用户名</option>
								</select>
				  			 </div>
				  			 <div class="form-group">
				  			 	<input type="text" name="conditionValue" class="form-control" value="${conditionValue}">
				  			 </div>
				  			  <div class="form-group">
				  			 	<button class="btn btn-primary btn-sm">查询</button>
				  			 </div>
				  		</form>
			  		</div>
			  	</div>
			  	<table class="table table-striped table-bordered" style="text-align: center; border-top: 1px solid #ccc;">
					<thead>
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>电话</th>
							<th>宿舍楼</th>
							<th>用户名</th>
							<th>操作</th>
						</tr>	
					</thead>
					<tbody>
					
				<c:if test="${page.rows.size() == 0}">
					<tr>
						<td colspan="7" style="text-align: center;"><span style="display: block;margin: 30px 0;color: red; font-weight: bold;">无查询结果</span></td>
					</tr>
				</c:if>
				<c:forEach items="${page.rows}" var="dormMng">
					<tr>
						<td>${dormMng.dormmanid }</td>
						<td>${dormMng.name}</td>
						<td>${dormMng.sex }</td>
						<td>${dormMng.tel }</td>
						<td>${dormMng.bordbuildid==null ? '未分配' : dormMng.bordbuildid }</td>
						<td>${dormMng.username }</td>
						<td>
							<button class="btn btn-primary btn-xs" type="button" onclick="editMngBtn(${dormMng.dormmanid})" data-toggle="modal" data-target="#editModal">修改</button>
							<span style="margin: 0 5px;">|</span> 
							<button class="btn btn-danger btn-xs" type="button" onclick="dormDelete(this,${dormMng.dormmanid},'${dormMng.name}')">删除</button>
						</td>
					</tr>	  
				</c:forEach>
					</tbody>
				</table>
			</div><!-- panel -->
			<!-- 分页 -->
			<div style="margin-top: -20px;">
				<gxc:page url="${pageContext.request.contextPath}/admin/dormMngList.html"></gxc:page>
			</div>
		</div><!-- col-md-8 -->
	</div>
	
	
	<!-- 添加宿舍管理员 Modal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="addModalLabel" style="font-weight: bold;">添加管理员</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal" id="addDormForm" action="${pageContext.request.contextPath}/admin/addDormMsg.html" method="post">
	          <input type="hidden" name="dormmanid" id="add_dormmanid">
			  <div class="form-group">
			    <label for="add_username" class="col-sm-2 control-label"><span style="color:red;">*</span>用户名</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="add_username" name="username" autocomplete="off" placeholder="用户名">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="add_password" class="col-sm-2 control-label"><span style="color:red;">*</span>密码</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="add_password" name="password" placeholder="密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="add_rePassword" class="col-sm-2 control-label"><span style="color:red;">*</span>重复密码</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="add_rePassword" placeholder="重复密码">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="add_name" class="col-sm-2 control-label"><span style="color:red;">*</span>姓名</label>
			    <div class="col-sm-10">
			      <input type="text" autocomplete="off" class="form-control" id="add_name" name="name" placeholder="姓名">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="add_sex" class="col-sm-2 control-label"><span style="color:red;">*</span>性别</label>
			    <div class="col-sm-10">
			      <select class="form-control" name="sex" id="add_sex">
					  <option value="" selected>-- 请选择 --</option>
					  <option value="男">男</option>
					  <option value="女">女</option>
					</select>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="add_tel" class="col-sm-2 control-label"><span style="color:red;">*</span>联系电话</label>
			    <div class="col-sm-10">
			      <input type="text" autocomplete="off" class="form-control" id="add_tel" name="tel" placeholder="联系电话">
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="btnAdd">添加</button>
	      </div>
	    </div>
	  </div>
	</div><!-- 添加宿舍管理员 Modal -->
	
	
	<!-- 修改宿舍管理员 Modal -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="editModalLabel" style="font-weight: bold;">修改管理员</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal" id="editDormForm" action="${pageContext.request.contextPath}/admin/updateDormMsg.html" method="post">
	          <input type="hidden" name="dormmanid" id="edit_dormmanid">
			  <div class="form-group">
			    <label for="edit_username" class="col-sm-2 control-label"><span style="color:red;">*</span>用户名</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="edit_username" name="username" readonly autocomplete="off" placeholder="用户名">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="edit_password" class="col-sm-2 control-label"><span style="color:red;">*</span>密码</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="edit_password" name="password" placeholder="密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="edit_rePassword" class="col-sm-2 control-label"><span style="color:red;">*</span>重复密码</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="edit_rePassword" placeholder="重复密码">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="edit_name" class="col-sm-2 control-label"><span style="color:red;">*</span>姓名</label>
			    <div class="col-sm-10">
			      <input type="text" autocomplete="off" class="form-control" id="edit_name" name="name" placeholder="姓名">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="edit_sex" class="col-sm-2 control-label"><span style="color:red;">*</span>性别</label>
			    <div class="col-sm-10">
			      <select class="form-control" name="sex" id="edit_sex">
					  <option value="0" selected>-- 请选择 --</option>
					  <option value="男">男</option>
					  <option value="女">女</option>
					</select>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="edit_tel" class="col-sm-2 control-label"><span style="color:red;">*</span>联系电话</label>
			    <div class="col-sm-10">
			      <input type="text" autocomplete="off" class="form-control" id="edit_tel" name="tel" placeholder="联系电话">
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="btnEdit">保存</button>
	      </div>
	    </div>
	  </div>
	</div><!-- 修改宿舍管理员 Modal -->
	
	<!-- 删除提示框 -->
	<div class="modal fade bs-example-modal-sm" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel">
	  <div class="modal-dialog modal-sm" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="deleteModalLabel" style="font-weight: bold;">提示</h4>
	      </div>
	      <div class="modal-body" style="text-align: center;" id="modal-body-msg">
	      	
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-danger" id="btnDelete">删除</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal提示框 -->
	<div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modal_title">
	  <div class="modal-dialog modal-sm" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="modal_title" style="font-weight: bold;"></h4>
	      </div>
	      <div class="modal-body" style="text-align: center;" id="modal_message">
	      	
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-info" data-dismiss="modal">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
<script type="text/javascript">
$(function(){
	//3、删除操作
	$("#btnDelete").click(function(){
		$("#deleteModal").modal('hide');
		$.post("${pageContext.request.contextPath}/admin/deleteDorm.action",{dormId:dormId},function(data){
			if(data.state = 200){
				showMyModal("提示",data.msg);
				//删除当前行
				deleteEle.parent().parent().remove();
				deleteEle = null; 
				dormId = null; 
				dormName = null;
				
			}else{
				showMyModal("提示",data.msg);
				deleteEle = null; 
				dormId = null; 
				dormName = null;
			}
		});
	});
	
	//4、确定修改
	$("#btnEdit").click(function(){
		var username = $("#edit_username").val().trim();
		var password = $("#edit_password").val().trim();
		var rePassword = $("#edit_rePassword").val().trim();
		var name = $("#edit_name").val().trim();
		var sex = $("#edit_sex").val().trim();
		var tel = $("#edit_tel").val().trim();
		
		//判断是否为空
		if(isStrNull(username) || isStrNull(password) || isStrNull(rePassword) || isStrNull(name) || isStrNull(sex) || isStrNull(tel)){
			showMyModal("提示","请正确填写！");
			return;
		}
		//重复密码是否相同
		if(password != rePassword){
			showMyModal("提示","密码输入不一致");
			$("#add_rePassword").val("");
			$("#add_rePassword").focus();
			return;
		}
		var reg_tel = /^[1][3,4,5,7,8][0-9]{9}$/;
		if(!reg_tel.test(tel)){
			showMyModal("提示","请输入正确格式的手机号");
			return;
		}
		
		//Ajax更新用户
		$.post("${pageContext.request.contextPath}/admin/updateDormMsg.action",$("#editDormForm").serialize(),function(data){
			if(data.status == 200){
				showMyModal("提示",data.msg);
				setTimeout(function(){
					location.href = "${pageContext.request.contextPath}/admin/dormMngList.html";	
				}, 1000);
			}else{
				showMyModal("提示",data.msg);
			}
		});
	});
	
	//5、添加
	$("#btnAdd").click(function(){
		var username = $("#add_username").val().trim();
		var password = $("#add_password").val().trim();
		var rePassword = $("#add_rePassword").val().trim();
		var name = $("#add_name").val().trim();
		var sex = $("#add_sex").val().trim();
		var tel = $("#add_tel").val().trim();
		//alert(username + "___" + password + "___" + rePassword + "___" + name + "___" + sex + "___" + tel);
		//判断是否为空
		if(isStrNull(username) || isStrNull(password) || isStrNull(rePassword) || isStrNull(name) || isStrNull(sex) || isStrNull(tel)){
			showMyModal("提示","请正确填写！");
			return;
		}
		//重复密码是否相同
		if(password != rePassword){
			showMyModal("提示","密码输入不一致");
			$("#add_rePassword").val("");
			$("#add_rePassword").focus();
			return;
		}
		var reg_tel = /^[1][3,4,5,7,8][0-9]{9}$/;
		if(!reg_tel.test(tel)){
			showMyModal("提示","请输入正确格式的手机号");
			return;
		}
		
		//判断用户名是否已经存在
		$.post("${pageContext.request.contextPath}/admin/hasDormMsg.action",{username:username},function(data1){
			if(data1.status == 201){
				showMyModal("提示",data1.msg);
				return;
			}
			else{
				//Ajax保存用户
				$.post("${pageContext.request.contextPath}/admin/addDormMsg.action",
						{   username:username,
							password:password,
							name:name,
							sex:sex,
							tel:tel
						},
						function(data){
							if(data.status == 200){
								showMyModal("提示",data.msg);
								setTimeout(function(){
									location.href = "${pageContext.request.contextPath}/admin/dormMngList.action";	
								}, 1000);
							}else{
								showMyModal("提示",data.msg);
							}
				});
			}
		});
	});
	
	//当AddModel框隐藏时,清空
	$("#addModal").on("hide.bs.modal",function(){
		$("#add_username").val("");
		$("#add_password").val("");
		$("#add_rePassword").val("");
		$("#add_name").val("");
		$("#add_sex").val("");
		$("#add_tel").val("");
	});
	
});


//1、修改宿舍管理员前 UI
function editMngBtn(id){
	//发送Ajax获取宿舍管理员信息
	$.post("${pageContext.request.contextPath}/admin/dormMng/"+id+".action",{dormmanid:id},function(data){
		if(data.status==200){
			$("#edit_dormmanid").val(data.data.dormmanid);
			$("#edit_username").val(data.data.username);
			$("#edit_password").val(data.data.password);
			$("#edit_rePassword").val(data.data.password);
			$("#edit_name").val(data.data.name);
			$("#edit_sex").val(data.data.sex);
			$("#edit_tel").val(data.data.tel);
		}else{
			alert("网络连接失败！");
		}
	});
}

//2、删除提示
var deleteEle = null; 
var dormId = null; 
var dormName = null;
function dormDelete(element,dormManId,dormManName){
	deleteEle = $(element);
	dormId = dormManId;
	dormName = dormManName;
	$("#modal-body-msg").text("确定删除：" + dormManName + "？");
	$("#deleteModal").modal('show');
}


</script>
</html>