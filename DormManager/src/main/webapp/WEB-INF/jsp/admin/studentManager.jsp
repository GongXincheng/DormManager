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
			  <a href="${pageContext.request.contextPath}/admin/dormMngList.html" class="list-group-item">宿舍管理员管理</a>
			  <a href="${pageContext.request.contextPath}/admin/studentList.html" class="list-group-item active">学生管理</a>
			  <a href="${pageContext.request.contextPath}/admin/dormBuildList.html" class="list-group-item">宿舍楼管理</a>
			  <a href="${pageContext.request.contextPath}/admin/recordList.html" class="list-group-item">缺勤管理</a>
			  <a href="/page/admin/rePassword.html" class="list-group-item">修改密码</a>
			</div>
		</div>
		<div class="col-md-10">
			<div class="panel panel-default table-responsive">
			  <div class="panel-heading">
			    <h3 class="panel-title" style="font-weight: bold;">学生管理</h3>
			  </div>
			  	<div id="panel-menu" style="margin:13px;">
		  			<div id="left" class="col-md-6">
		  				<!-- 添加按钮 -->
		  				<button type="button" class="btn  btn-success" 
		  					data-toggle="modal" data-target="#addModal">添加</button>
		  			</div>
			  		<div id="right" class="col-md-6">
				  		<form action="${pageContext.request.contextPath}/admin/studentList.html" method="post" class="form-inline  form-group-sm">
				  			<div class="form-group">
				  			 	<select class="form-control" name="con_dormBuildid">
				  			 		<option selected value="">全部宿舍楼</option>
				  			 		
				  			 	  <c:forEach items="${dormBuildList}" var="dormBuild">
									  <option value="${dormBuild.dormbuildid}" <c:if test="${condition.con_dormBuildid == dormBuild.dormbuildid }">selected</c:if>>${dormBuild.dormbuildname}</option>
								  </c:forEach>
								  
								</select>
				  			 </div>
				  			 <div class="form-group">
				  			 	<select class="form-control" name="con_chooseId">
								  <option value="1" <c:if test="${condition.con_chooseId==1 }">selected</c:if>>姓名</option>
								  <option value="2" <c:if test="${condition.con_chooseId==2 }">selected</c:if>>学号</option>
								  <option value="3" <c:if test="${condition.con_chooseId==3 }">selected</c:if>>寝室</option>
								</select>
				  			 </div>
				  			 <div class="form-group">
				  			 	<input type="text" name="con_value" value="${condition.con_value}" autocomplete="off" class="form-control">
				  			 </div>
				  			  <div class="form-group">
				  			 	<button class="btn btn-primary btn-sm" type="submit">查询</button>
				  			 </div>
				  		</form>
			  		</div>
			  	</div>
			  	<table class="table table-striped table-bordered" style="text-align: center; border-top: 1px solid #ccc;">
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>电话</th>
						<th>宿舍楼Id</th>
						<th>学号</th>
						<th>操作</th>
					</tr>	
					<c:if test="${page.rows.size() == 0}">
						<tr>
							<td colspan="7" style="text-align: center;"><span style="display: block;margin: 30px 0;color: red; font-weight: bold;">无查询结果</span></td>
						</tr>
					</c:if>
					<c:forEach items="${page.rows}" var="stu">
						<tr>
							<td>${stu.studentid }</td>
							<td>${stu.name }</td>
							<td>${stu.sex }</td>
							<td>${stu.tel }</td>
							<td>${stu.dormbuildid }</td>
							<td>${stu.stunum }</td>
							<td>
								<button class="btn btn-primary btn-xs" type="button" onclick="editUI(${stu.studentid })" data-toggle="modal" data-target="#editModal">修改</button>
								<span style="margin: 0 5px;">|</span> 
								<button class="btn btn-danger btn-xs" type="button" onclick="deleteMsg(this,${stu.studentid },'${stu.name }')" data-toggle="modal" data-target="#deleteModal">删除</button>
							</td>
						</tr>	  
					</c:forEach>
				</table>
			</div><!-- panel -->
			<!-- 分页 -->
			<div style="margin-top: -20px;">
				<gxc:page url="${pageContext.request.contextPath}/admin/dormMngList.html"></gxc:page>
			</div>
		</div><!-- col-md-10 -->
	</div>
	
	
	<!-- 添加学生 Modal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="addModalLabel" style="font-weight: bold;">添加学生</h4>
	      </div>
	      <div class="modal-body">
	     	 <!-- 添加学生信息Form -->
	        <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/addStudent.html" method="post" id="addForm">
			  <div class="form-group">
			    <label for="add_stunum" class="col-sm-2 control-label"><span style="color:red;">*</span>学号</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="add_stunum" name="stunum" placeholder="学号">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="add_password" class="col-sm-2 control-label"><span style="color:red;">*</span>密码</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" name="password" id="add_password" placeholder="密码">
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
			      <select class="form-control" id="add_sex" name="sex">
					  <option value="" selected>-- 请选择 --</option>
					  <option value="男">男</option>
					  <option value="女">女</option>
					</select>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="add_dormbuildid" class="col-sm-2 control-label"><span style="color:red;">*</span>宿舍楼</label>
			    <div class="col-sm-10">
			      <select class="form-control" id="add_dormbuildid" name="dormbuildid">
					   <c:forEach items="${dormBuildList}" var="dormBuild">
						  <option value="${dormBuild.dormbuildid}">${dormBuild.dormbuildname}</option>
					  </c:forEach>
					</select>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="add_dormname" class="col-sm-2 control-label"><span style="color:red;">*</span>寝室</label>
			    <div class="col-sm-10">
			      <input type="text" autocomplete="off" class="form-control" name="dormname" id="add_dormname" placeholder="寝室">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="add_tel" class="col-sm-2 control-label"><span style="color:red;">*</span>联系电话</label>
			    <div class="col-sm-10">
			      <input type="text" autocomplete="off" class="form-control" name="tel" id="add_tel" placeholder="联系电话">
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
	</div><!-- 添加学生 Modal -->
	
	
	<!-- 修改学生 Modal -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="editModalLabel" style="font-weight: bold;">修改学生</h4>
	      </div>
	      <div class="modal-body">
	         <form class="form-horizontal" id="editForm" method="post">
	          <input type="hidden" name="studentid" id="edit_studentid">
			  <div class="form-group">
			    <label for="edit_stunum" class="col-sm-2 control-label"><span style="color:red;">*</span>学号</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="edit_stunum" readonly name="stunum" placeholder="学号">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="edit_password" class="col-sm-2 control-label"><span style="color:red;">*</span>密码</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" name="password" id="edit_password" placeholder="密码">
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
			      <select class="form-control" id="edit_sex" name="sex">
					  <option value="" selected>-- 请选择 --</option>
					  <option value="男">男</option>
					  <option value="女">女</option>
					</select>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="edit_dormbuildid" class="col-sm-2 control-label"><span style="color:red;">*</span>宿舍楼</label>
			    <div class="col-sm-10">
			      <select class="form-control" id="edit_dormbuildid" name="dormbuildid">
					   <c:forEach items="${dormBuildList}" var="dormBuild">
						  <option value="${dormBuild.dormbuildid}">${dormBuild.dormbuildname}</option>
					  </c:forEach>
					</select>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="edit_dormname" class="col-sm-2 control-label"><span style="color:red;">*</span>寝室</label>
			    <div class="col-sm-10">
			      <input type="text" autocomplete="off" class="form-control" name="dormname" id="edit_dormname" placeholder="寝室">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="edit_tel" class="col-sm-2 control-label"><span style="color:red;">*</span>联系电话</label>
			    <div class="col-sm-10">
			      <input type="text" autocomplete="off" class="form-control" name="tel" id="edit_tel" placeholder="联系电话">
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="btnUpdate">保存</button>
	      </div>
	    </div>
	  </div>
	</div><!-- 添加学生 Modal -->
	
	<!-- 删除提示框 -->
	<div class="modal fade bs-example-modal-sm" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel">
	  <div class="modal-dialog modal-sm" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="deleteModalLabel" style="font-weight: bold;">提示</h4>
	      </div>
	      <div class="modal-body" style="text-align: center;" id="del_modal_body">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-danger" id="btnDelete" data-toggle="modal" data-target="#deleteModal">删除</button>
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
	//1、点击添加按钮
	$("#btnAdd").click(function(){
		//获取值，并验证
		var stunum = $("#add_stunum").val().trim();
		var password = $("#add_password").val().trim();
		var rePassword = $("#add_rePassword").val().trim();
		var name = $("#add_name").val().trim();
		var sex = $("#add_sex").val().trim();
		var dormbuildid = $("#add_dormbuildid").val().trim();
		var dormname = $("#add_dormname").val().trim();
		var tel = $("#add_tel").val().trim();
		//格式验证
		//学号正则表达式匹配
		var stuNumReg = /^[0-9]{1,11}$/;
		if (!stuNumReg.test(stunum)) { 
			showMyModal("提示","学号格式不正确(1~11位数字)");
			return;
		}
		if(isStrNull(stunum) || isStrNull(password) || isStrNull(rePassword) || isStrNull(name)){
			showMyModal("提示","请正确填写！");
			return;
		}
		if(isStrNull(dormname) || isStrNull(tel) || isStrNull(sex)){
			showMyModal("提示","请正确填写！");
			return;
		}
		if(password!=rePassword){
			showMyModal("提示","密码不一致！");
			return;
		}
		//手机号 正则表达式匹配
		var reg_tel = /^[1][3,4,5,7,8][0-9]{9}$/;
		if(!reg_tel.test(tel)){
			showMyModal("提示","请输入正确格式的手机号");
			return;
		}
		
		//添加前判断该学号是否已经存在
		$.post("${pageContext.request.contextPath}/admin/hasStudent.action",{stuNum:stunum},function(data){
			if(data.status == 201){
				//如果学号已经存在
				showMyModal("提示",data.msg);
				return;
			}else{
				//Ajax添加
				$.post("${pageContext.request.contextPath}/admin/addStudent.action",$("#addForm").serialize(),function(data){
					if(data.status == 200){
						showMyModal("提示",data.msg);
						setTimeout(function(){
							location.href = "${pageContext.request.contextPath}/admin/studentList.html";
						}, 1000);
					}else{
						showMyModal("提示",data.msg);
					}
				});
			}
		});
	});//$("#btnAdd").click
	
	//3、确定更新学生信息
	$("#btnUpdate").click(function(){
		//获取值，并验证
		var stunum = $("#edit_stunum").val().trim();
		var password = $("#edit_password").val().trim();
		var rePassword = $("#edit_rePassword").val().trim();
		var name = $("#edit_name").val().trim();
		var sex = $("#edit_sex").val().trim();
		var dormbuildid = $("#edit_dormbuildid").val().trim();
		var dormname = $("#edit_dormname").val().trim();
		var tel = $("#edit_tel").val().trim();
		//格式验证
		//学号正则表达式匹配
		var stuNumReg = /^[0-9]{1,11}$/;
		if (!stuNumReg.test(stunum)) { 
			showMyModal("提示","学号格式不正确(1~11位数字)");
			return;
		}
		if(isStrNull(stunum) || isStrNull(password) || isStrNull(rePassword) || isStrNull(name)){
			showMyModal("提示","请正确填写！");
			return;
		}
		if(isStrNull(dormname) || isStrNull(tel) || isStrNull(sex)){
			showMyModal("提示","请正确填写！");
			return;
		}
		if(password!=rePassword){
			showMyModal("提示","密码不一致！");
			return;
		}
		//手机号 正则表达式匹配
		var reg_tel = /^[1][3,4,5,7,8][0-9]{9}$/;
		if(!reg_tel.test(tel)){
			showMyModal("提示","请输入正确格式的手机号");
			return;
		}
		
		//更新操作
		$.post("${pageContext.request.contextPath}/admin/updateStudent.action",$("#editForm").serialize(),function(data){
			if(data.status == 200){
				showMyModal("提示",data.msg);
				setTimeout(function(){
					location.href = "${pageContext.request.contextPath}/admin/studentList.html";	
				}, 1000);
			}else{
				showMyModal("提示",data.msg);
			}
		});
	});
	
	//5、确定删除
	$("#btnDelete").click(function(){
		//alert(del_id);
		//Ajax删除
		$.post("${pageContext.request.contextPath}/admin/deleteStudent/"+del_id+".action",{},function(data){
			if(data.status == 200){
				$(del_element).parent().parent().remove();
				showMyModal("提示",data.msg);
			}else{
				showMyModal("提示",data.msg);
			}
		});
	});
	
	//当AddModel框隐藏时,清空
	$("#addModal").on("hide.bs.modal",function(){
		$("#add_stunum").val("");
		$("#add_password").val("");
		$("#add_rePassword").val("");
		$("#add_name").val("");
		$("#add_sex").val("");
		$("#add_dormname").val("");
		$("#add_tel").val("");
	});
	
}); //$(function(){})

//2、编辑前UI
function editUI(stuId){
	$.post("${pageContext.request.contextPath}/admin/findStudent.action",{stuId:stuId},function(data){
		if(data.status == 200){
			$("#edit_studentid").val(data.data.studentid);
			$("#edit_stunum").val(data.data.stunum);
			$("#edit_password").val(data.data.password);
			$("#edit_rePassword").val(data.data.password);
			$("#edit_name").val(data.data.name);
			$("#edit_sex").val(data.data.sex);
			$("#edit_dormbuildid").val(data.data.dormbuildid);
			$("#edit_dormname").val(data.data.dormname);
			$("#edit_tel").val(data.data.tel);
		}else{
			showMyModal("提示",data.msg);
			return;
		}
	});
}

//4、删除前 Modal
var del_element = null;
var del_id = null;
var del_name = null;
function deleteMsg(element,id,name){
	$("#del_modal_body").text("确定删除：" + name + "？");
	del_element = element;
	del_id = id;
	del_name = name;
}

</script>
</html>