<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</style>
</head>

<body>
	<jsp:include page="../common/top.jsp"></jsp:include>
	
	<div class="container">
		<div class="col-md-2">
			<div class="list-group" id="nav">
			   <a href="/page/dorm/index.html" class="list-group-item">首页</a>
			  <a href="${pageContext.request.contextPath}/dorm/allStuList.html" class="list-group-item">学生查看</a>
			  <a href="${pageContext.request.contextPath}/dorm/recordList.html" class="list-group-item">缺勤记录</a>
			  <a href="javascript:void(0);" class="list-group-item active">修改密码</a>
			</div>
		</div>
		<div class="col-md-10">
			<div class="panel panel-default table-responsive" style="padding-bottom: 30px;">
			  <div class="panel-heading">
			    <h3 class="panel-title" style="font-weight: bold;">修改密码</h3>
			  </div>
			  
			  <div style="margin-top: 5%;">
			  	<div class="col-md-2"></div>
			  	<div class="col-md-8">
			  		<form action="${pageContext.request.contextPath}/dorm/changePassword.html" method="post" class="form-horizontal">
		  			  <div class="form-group">
					    <label for="oldPassword" class="col-sm-2 control-label"><span style="color:red;">*</span>原密码</label>
					    <div class="col-sm-10">
					      <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="原密码">
					    </div>
					  </div>
		  			  <div class="form-group">
					    <label for="newPassword" class="col-sm-2 control-label"><span style="color:red;">*</span>新密码</label>
					    <div class="col-sm-10">
					      <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="新密码">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="rePassword" class="col-sm-2 control-label"><span style="color:red;">*</span>重复密码</label>
					    <div class="col-sm-10">
					      <input type="password" class="form-control" id="rePassword" placeholder="重复密码">
					    </div>
					  </div>
					  <div class="form-group" style="margin-top: 20px;">
						  <div class="col-sm-10" align="center">
						    <button type="button" id="btnUpdatePassword" class="btn btn-success btn-primary">提交</button>
						  </div>
					  </div>
			  		</form>
			  	</div>
			  	<div class="col-md-2"></div>
			  </div>
			</div><!-- panel -->
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
	$("#btnUpdatePassword").click(function(){
		var oldPassword = $("#oldPassword").val().trim();
		var newPassword = $("#newPassword").val().trim();
		var rePassword = $("#rePassword").val().trim();
		if(isStrNull(oldPassword) || isStrNull(newPassword) || isStrNull(rePassword)){
			showMyModal("提示","请正确输入!");
			return;
		}
		if(newPassword != rePassword){
			showMyModal("提示","密码不一致!");
			return;
		}
		
		$.post("${pageContext.request.contextPath}/dorm/changePassword.action",
				{oldPassword:oldPassword,newPassword:newPassword},
				function(data){
					if(data.status == 201){
						showMyModal("提示",data.msg);
						return;
					}else{
						showMyModal("提示",data.msg);
						setTimeout(function(){
							location.href = "${pageContext.request.contextPath}/user/exitSystem.html";
						}, 1500);
					}
				}
		);
	});
})
</script>
</html>