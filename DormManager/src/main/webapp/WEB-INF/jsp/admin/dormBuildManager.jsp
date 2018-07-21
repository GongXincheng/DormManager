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
			  <a href="${pageContext.request.contextPath}/admin/studentList.html" class="list-group-item">学生管理</a>
			  <a href="${pageContext.request.contextPath}/admin/dormBuildList.html" class="list-group-item  active" >宿舍楼管理</a>
			  <a href="${pageContext.request.contextPath}/admin/recordList.html" class="list-group-item">缺勤管理</a>
			  <a href="/page/admin/rePassword.html" class="list-group-item">修改密码</a>
			</div>
		</div>
		<div class="col-md-10">
			<div class="panel panel-default table-responsive">
			  <div class="panel-heading">
			     <h3 class="panel-title" style="font-weight: bold;">宿舍楼管理</h3>
			  </div>
			  	<div id="panel-menu" style="margin:13px;">
		  			<div id="left" class="col-md-7">
		  				<button type="button" class="btn  btn-success"
		  				 		data-toggle="modal" data-target="#addModal">添加</button>
		  			</div>
			  		<div id="right" class="col-md-5">
				  		<!-- 条件查询 -->
				  		<form action="${pageContext.request.contextPath}/admin/dormBuildList.html" method="post" class="form-inline">
				  			 <div class="form-group">
				  			 	<label for="condition">名称：</label>
				  			 	<input type="text" name="condition" id="condition" value="${condition }" class="form-control">
				  			 </div>
				  			  <div class="form-group">
				  			 	<button class="btn btn-primary btn-sm" type="submit">查询</button>
				  			 </div>
				  		</form>
			  		</div>
			  	</div>
			  	<table class="table table-striped table-bordered" style="text-align: center; border-top: 1px solid #ccc;">
					<thead>
						<tr>
							<th>编号</th>
							<th>名称</th>
							<th>简介</th>
							<th>操作</th>
						</tr>	
					</thead>
					<tbody>
					
						<c:if test="${page.rows.size()==0 }">
							<tr>
								<td colspan="4" style="text-align: center;"><span style="display: block;margin: 30px 0;color: red; font-weight: bold;">无查询结果</span></td>
							</tr>
						</c:if>
						<c:forEach items="${page.rows}" var="dormBuild">
							<tr>
								<td>${dormBuild.dormbuildid }</td>
								<td>${dormBuild.dormbuildname }</td>
								<td>${dormBuild.dormbuilddetail}</td>
								<td>
									<a class="btn btn-warning btn-xs" type="button" href="${pageContext.request.contextPath}/admin/dbAddDormMng/${dormBuild.dormbuildid }.html">管理员</a>
									<span style="margin: 0 5px;">|</span> 
									<button class="btn btn-primary btn-xs" type="button" 
											onclick="editUI(${dormBuild.dormbuildid})"  data-toggle="modal" data-target="#editModal">修改</button>
									<span style="margin: 0 5px;">|</span> 
									<button class="btn btn-danger btn-xs" type="button" 
										onclick="deleteModalShow(this,${dormBuild.dormbuildid},'${dormBuild.dormbuildname}');">删除</button>
								</td>
							</tr>	  
						</c:forEach>
					</tbody>
				</table>
			</div><!-- panel -->
			<!-- 分页 -->
			<div style="margin-top: -20px;">
				<gxc:page url="${pageContext.request.contextPath}/admin/dormBuildList.html"></gxc:page>
			</div>
		</div><!-- col-md-8 -->
	</div>
	
	
	<!-- 添加宿舍楼 Modal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="addModalLabel" style="font-weight: bold;">添加宿舍楼</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal">
			  <div class="form-group">
			    <label for="add_dormbuildname" class="col-sm-2 control-label"><span style="color:red;">*</span>名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="add_dormbuildname" name="dormbuildname" placeholder="名称">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="add_dormbuilddetail" class="col-sm-2 control-label"><span style="color:red;">*</span>简介</label>
			    <div class="col-sm-10">
			    	<textarea class="form-control" id="add_dormbuilddetail" name="dormbuilddetail" placeholder="简介" rows="3"></textarea>
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
	</div><!-- 添加宿舍楼 Modal -->
	
	
	<!-- 修改宿舍楼 Modal -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="editModalLabel" style="font-weight: bold;">修改宿舍楼</h4>
	      </div>
	      <div class="modal-body">
	         <form class="form-horizontal">
	         <input name="dormbuildid" id="edit_dormbuildid" type="hidden">
			  <div class="form-group">
			    <label for="edit_dormbuildname" class="col-sm-2 control-label"><span style="color:red;">*</span>名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="edit_dormbuildname" name="dormbuildname" placeholder="名称">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="edit_dormbuilddetail" class="col-sm-2 control-label"><span style="color:red;">*</span>简介</label>
			    <div class="col-sm-10">
			    	<textarea class="form-control" id="edit_dormbuilddetail" name="dormbuilddetail" placeholder="简介" rows="3"></textarea>
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
	</div><!-- 添加宿舍楼 Modal -->
	
	<!-- 删除提示框 -->
	<div class="modal fade bs-example-modal-sm" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel">
	  <div class="modal-dialog modal-sm" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="deleteModalLabel" style="font-weight: bold;">删除</h4>
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
	
	//1、添加宿舍楼按钮
	$("#btnAdd").click(function(){
		//获取值并验证
		var dormbuildname = $("#add_dormbuildname").val().trim();
		var dormbuilddetail = $("#add_dormbuilddetail").val().trim();
		if(isStrNull(dormbuilddetail) || isStrNull(dormbuildname)){
			showMyModal("提示","请正确输入!");
			return;
		}
		//判断该宿舍楼名称是否已经存在
		$.post("${pageContext.request.contextPath}/admin/hasDormBuild.action",{dormBuildName:dormbuildname},function(data1){
			if(data1.status == 201){
				showMyModal("提示",data1.msg);
				return;
			}else{
				//Ajax添加
				$.post("${pageContext.request.contextPath}/admin/addDormBuild.action",
						{   dormbuildname:dormbuildname,
							dormbuilddetail:dormbuilddetail},
						function(data){
							if(data.status == 200){
								showMyModal("提示",data.msg);
								setTimeout(function(){
									location.href = "${pageContext.request.contextPath}/admin/dormBuildList.html";
								}, 1000);
							}
							else{
								showMyModal("提示",data.msg);
							}
						});
			}
		})
	});
	
	//3、更新操作
	$("#btnUpdate").click(function(){
		//获取值并验证
		var dormbuildid = $("#edit_dormbuildid").val().trim();
		var dormbuildname = $("#edit_dormbuildname").val().trim();
		var dormbuilddetail = $("#edit_dormbuilddetail").val().trim();
		if(isStrNull(dormbuilddetail) || isStrNull(dormbuildname) || isStrNull(dormbuildid)){
			showMyModal("提示","请正确输入!");
			return;
		}
		//更新操作
		$.post("${pageContext.request.contextPath}/admin/UpdataDormBuild.action",
				{
					dormbuildid:dormbuildid,
					dormbuildname:dormbuildname,
					dormbuilddetail:dormbuilddetail	
				},
				function(data){
					if(data.status == 200){
						showMyModal("提示",data.msg);
						setTimeout(function(){
							location.href = "${pageContext.request.contextPath}/admin/dormBuildList.html";
						}, 1000);
					}
					else{
						showMyModal("提示",data.msg);
					}
				}
		);
	});
	
	
	//5、删除操作
	$("#btnDelete").click(function(){
		$.post("${pageContext.request.contextPath}/admin/deleteDormBuild/"+deleteId+".action",{},function(data){
			if(data.status == 200){
				$(deleteElement).parent().parent().remove();
				showMyModal("提示",data.msg);
			}
			else{
				showMyModal("提示",data.msg);
			}
		});	
	});
	
	//当AddModel框隐藏时,清空
	$("#addModal").on("hide.bs.modal",function(){
		$("#add_dormbuildname").val("");
		$("#add_dormbuilddetail").val("");
	});
	
});

//4、删除前
var deleteElement = null;
var deleteId = null;
var deleteName = null;
function deleteModalShow(element,id,name){
	//alert(element+"_____"+id+"_____"+name+"____");
	$("#del_modal_body").text("确定删除：" + name + "？");
	$("#deleteModal").modal('show');
	deleteElement = element;
	deleteId = id;
	deleteName = name;
}

//2、修改前UI
function editUI(dormbuildid){
	$.post("${pageContext.request.contextPath}/admin/dormBuildInfo.action",{dormBuildId:dormbuildid},function(data){
		if(data.status == 200){
			$("#edit_dormbuildid").val(data.data.dormbuildid);
			$("#edit_dormbuildname").val(data.data.dormbuildname);
			$("#edit_dormbuilddetail").val(data.data.dormbuilddetail);
		}else{
			showMyModal("提示",data.msg);
		}
	});
}
</script>
</html>