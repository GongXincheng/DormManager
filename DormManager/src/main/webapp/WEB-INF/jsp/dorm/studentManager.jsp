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
			  <a href="/page/dorm/index.html" class="list-group-item">首页</a>
			  <a href="${pageContext.request.contextPath}/dorm/allStuList.html" class="list-group-item active">学生查看</a>
			  <a href="${pageContext.request.contextPath}/dorm/recordList.html" class="list-group-item">缺勤记录</a>
			  <a href="/page/dorm/rePassword.html" class="list-group-item">修改密码</a>
			</div>
		</div>
		<div class="col-md-10">
			<div class="panel panel-default table-responsive">
			  <div class="panel-heading">
			    <h3 class="panel-title" style="font-weight: bold;">学生管理</h3>
			  </div>
			  	<div id="panel-menu" style="margin:13px;">
		  			<div id="left" class="col-md-5">
		  				<!-- <button type="button" class="btn  btn-success" onclick="showAddModel('',1)" data-toggle="modal" data-target="#addModal">添加</button> -->
		  			</div>
			  		<div id="right" class="col-md-7" >
				  		<form action="${pageContext.request.contextPath}/dorm/allStuList.html" method="post" class="form-inline  form-group-sm" style="margin-left: 30px;">
				  			<div class="form-group">
				  			 	<span style="font-size: 15px;color: #0000FF;margin-right: 10px;">${buildName==null ? '未分配' : buildName}</span>
				  			 </div>
				  			 <div class="form-group" style="margin-right: 10px;">
				  			 	<select class="form-control" name="con_chooseId" id="con_chooseId">
								  <option value="1">姓名</option>
								  <option value="2">学号</option>
								  <option value="3">寝室</option>
								</select>
				  			 </div>
				  			 <div class="form-group" style="margin-right: 10px;">
				  			 	<input type="text" autocomplete="off" name="con_value" id="con_value" class="form-control">
				  			 </div>
				  			  <div class="form-group">
				  			 	<button class="btn btn-sm btn-info" type="reset" id="btnReset">重置</button>
				  			 	<button class="btn btn-primary btn-sm">查询</button>
				  			 </div>
				  		</form>
			  		</div>
			  	</div>
			  	<table class="table table-striped table-bordered" style="text-align: center; border-top: 1px solid #ccc;">
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>宿舍楼</th>
						<th>寝室</th>
						<th>电话</th>
						<th>操作</th>
					</tr>	
					<c:if test="${page.rows.size() == 0}">
						<tr>
							<td colspan="7" style="text-align: center;"><span style="display: block;margin: 30px 0;color: red; font-weight: bold;">暂无管理的宿舍楼或暂无学生</span></td>
						</tr>
					</c:if>
					<c:forEach items="${page.rows}" var="stu">
						<tr>
							<td>${stu.stunum}</td>
							<td>${stu.name}</td>
							<td>${stu.sex}</td>
							<td>${buildName}</td>
							<td>${stu.dormname}</td>
							<td>${stu.tel}</td>
							<td>
								<a class="btn btn-info btn-xs" type="button" data-toggle="modal" data-target="#addModal" onclick="showAddModel(${stu.studentid},2)" >添加缺勤记录</a>
							</td>
						</tr>	  
					</c:forEach>
				</table>
			</div><!-- panel -->
			<!-- 分页 -->
			<div style="margin-top: -20px;">
				<c:if test="${page.rows.size() != 0}">
					<gxc:page url="${pageContext.request.contextPath}/dorm/allStuList.html"></gxc:page>
				</c:if>
			</div>
		</div><!-- col-md-10 -->
	</div>
	
	
	<!-- 添加缺勤记录 Modal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="addModalLabel" style="font-weight: bold;">添加缺勤记录</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal" id="addRecordForm">
			  <div class="form-group">
			    <label for="studentnumber" class="col-sm-2 control-label"><span style="color:red;">*</span>学号</label>
			    <div class="col-sm-10">
			      <input type="text" readonly  class="form-control" id="studentnumber" autocomplete="off"  name="studentnumber" placeholder="学号">
			    </div>
			  </div>
			  <!-- 日期 -->
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label"><span style="color:red;">*</span>日期</label>
			    <div class="col-sm-10">
			      <input type="date" readonly class="form-control" name="date" id="date" placeholder="日期">
			    </div>
			  </div>
			  <!-- 备注 -->
			  <div class="form-group">
			    <label for="datail" class="col-sm-2 control-label"><span style="color:red;">*</span>备注</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" autocomplete="off" name="datail" id="datail" placeholder="备注">
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary"  id="btnAdd">添加</button>
	      </div>
	    </div>
	  </div>
	</div><!-- 添加缺勤记录 Modal -->
	
	
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
	
	<!-- 用于数据回显 -->
	<input type="hidden" id="hide_conValue" value="${condiBean.con_value}">
	<input type="hidden" id="hide_chooseId" value="${condiBean.con_chooseId==null ? 1 : condiBean.con_chooseId }">
</body>

<script type="text/javascript">

$(function(){
	//数据回显
	var con_value = $("#hide_conValue").val();
	var con_chooseId = $("#hide_chooseId").val();
	$("#con_value").val(con_value);
	$("#con_chooseId").val(con_chooseId);
	
	//重置按钮
	$("#btnReset").click(function(){
		$("#con_value").val("");
		$("#con_chooseId").val(1);
	});
	
	//添加按钮
	$("#btnAdd").click(function(){
		var studentnumber = $("#studentnumber").val();
		var datail = $("#datail").val();
		if(isStrNull(datail)){
			showMyModal("提示","请填写备注信息！");
			return;
		}
		if(isStrNull(studentnumber)){
			showMyModal("提示","请填写学号！");
			return;
		}
		//发送Ajax添加缺勤记录																 
		$.post("${pageContext.request.contextPath}/dorm/addRecord.action",$("#addRecordForm").serialize(),function(data){
			if(data.status == 200){
				setTimeout(function(){
					$("#addModal").modal('hide');
				},150);
				showMyModal("提示",data.msg);
			}else{
				showMyModal("提示",data.msg);
			}
		})
	});
	
	//添加Modal隐藏触发事件
	$("#addModal").on("hide.bs.modal",function(){
		$("#datail").val("");
	});
	
})

//添加前UI
function showAddModel(studentId, num){
	if(num==1){
		$("#studentnumber").removeAttr("readonly");
	}else{
		$("#studentnumber").attr("readonly","readonly");
	}
	$.post("${pageContext.request.contextPath}/dorm/addRecordUI.action",{studentId:studentId},function(data){
		if(data.status == 200){
			$("#studentnumber").val(data.data.stuNum);
			$("#date").val(data.data.nowDate);
		}else{
			showMyModal("提示",data.msg);
		}
	});
}
</script>
</html>