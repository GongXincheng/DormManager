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
table tr th{
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
			  <a href="${pageContext.request.contextPath}/admin/studentList.html" class="list-group-item">学生管理</a>
			  <a href="${pageContext.request.contextPath}/admin/dormBuildList.html" class="list-group-item active">宿舍楼管理</a>
			  <a href="${pageContext.request.contextPath}/admin/recordList.html" class="list-group-item">缺勤管理</a>
			  <a href="/page/admin/rePassword.html" class="list-group-item">修改密码</a>
			</div>
		</div>
		<div class="col-md-10">
			<div class="panel panel-default table-responsive">
			  <div class="panel-heading">
			    <h3 class="panel-title" style="font-weight: bold;">宿舍楼管理设置</h3>
			  </div>
			  	<div id="panel-menu" style="margin:13px;">
		  			<div id="left" class="col-md-9">
		  				<a type="button" class="btn  btn-success" href="${pageContext.request.contextPath}/admin/dormBuildList.html">返回</a>
		  			</div>
			  		<div id="right" class="col-md-3 form-group-sm">
				  		<form action="${pageContext.request.contextPath}/admin/setDormMng.html" method="post" class="form-inline">
					  		<!-- 当前宿舍楼id -->
					  		<input type="hidden" name="bordbuildid" value="${currentDBId}" id="cond_dormBuildId">
				  			 <div class="form-group">
				  			 	<select class="form-control" name="dormmanid" id="cond_dormMngId">
				  			 		<c:forEach items="${noWorkList}" var="noWork">
					  			 		<option value="${noWork.dormmanid }">${noWork.name}</option>
				  			 		</c:forEach>
				  			 	</select>
				  			 </div>
				  			  <div class="form-group">
				  			 	<button class="btn btn-primary btn-sm" type="submit">添加</button>
				  			 </div>
				  		</form>
			  		</div>
			  	</div>
			  	<table class="table table-striped table-bordered" style="text-align: center; border-top: 1px solid #ccc;">
					<thead>
						<tr>
						<th>姓名</th>
						<th>性别</th>
						<th>电话</th>
						<th>用户名</th>
						<th>操作</th>
					</tr>
					</thead>	
					<tbody>
						<c:if test="${mngList.size() == 0}">
						<tr>
							<td colspan="7" style="text-align: center;"><span style="display: block;margin: 30px 0;color: red; font-weight: bold;">暂无管理员</span></td>
						</tr>
					</c:if>
					<c:forEach items="${mngList}" var="dormMng">
						<tr>
							<td>${dormMng.name }</td>
							<td>${dormMng.sex }</td>
							<td>${dormMng.tel }</td>
							<td>${dormMng.username }</td>
							<td>
								<button class="btn btn-danger btn-xs" type="button" 
									onclick="deleteModalShow(this,${dormMng.dormmanid},'${dormMng.name}')" 
									data-toggle="modal" data-target="#deleteModal">删除</button>
							</td>
						</tr>	  
					</c:forEach>
					</tbody>
				</table>
			</div><!-- panel -->
		</div><!-- col-md-10 -->
	</div>
	
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

	//2、确定删除
	$("#btnDelete").click(function(){
		$.post("${pageContext.request.contextPath}/admin/delMngFromDormBuild.action",{id:del_id},function(data){
			if(data.status == 200){
				$(del_element).parent().parent().remove();
				showMyModal("提示",data.msg);
				setTimeout(function(){
					location.href = "${pageContext.request.contextPath}/admin/dbAddDormMng/"+$("#cond_dormBuildId").val()+".html";
				}, 1000)
			}else{
				showMyModal("提示",data.msg);
			}
		});
	});
	
});

//1、删除前Modal
var del_element = null;
var del_id = null;
var del_name = null;
function deleteModalShow(element,id,name){
	$("#del_modal_body").text("确定删除：" + name + "？");
	del_element = element;
	del_id = id;
	del_name = name;
}
</script>
</html>