<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://gxc.cn/common/" prefix="gxc" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
<title>Index</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js"></script>
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
			  <a href="${pageContext.request.contextPath}/admin/dormBuildList.html" class="list-group-item">宿舍楼管理</a>
			  <a href="${pageContext.request.contextPath}/admin/recordList.html" class="list-group-item  active">缺勤管理</a>
			  <a href="/page/admin/rePassword.html" class="list-group-item">修改密码</a>
			</div>
		</div>
		<div class="col-md-10">
			<div class="panel panel-default table-responsive">
			  <div id="panel-menu" style="margin:15px;">
			  		<!-- 条件查询 -->
					<form action="${pageContext.request.contextPath}/admin/recordList.html" method="POST" id="searchRecordForm" class="form-inline form-group-sm">
						<div class="form-group col-md-3" style="margin-left: -15px;">
			                <div class="input-group date form_date" >
			                    <input class="form-control" value="<fmt:formatDate value="${conditionBean.startDate }" type="date" pattern="yyyy-MM-dd"/>" size="10" id="startDate" type="text" name="startDate" placeholder="起始日期" readonly>
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
			            </div>
			            <div class="form-group  col-md-3 " style="margin-left: -15px;">
			                <div class="input-group date form_date" >
			                    <input class="form-control" value="<fmt:formatDate value="${conditionBean.endDate }" type="date" pattern="yyyy-MM-dd"/>" size="10" id="endDate" type="text" name="endDate" placeholder="终止日期" readonly>
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
			            </div>
						<div class="form-group">
							<select class="form-control" name="dormBuildId">
								<option selected value="">全部宿舍楼</option>
								<c:forEach items="${dormBuildList}" var="dormBuild">
									<option value="${dormBuild.dormbuildid }" <c:if test="${conditionBean.dormBuildId == dormBuild.dormbuildid}">selected</c:if>   >${dormBuild.dormbuildname }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group" style="margin-left: 5px">
							<select class="form-control" name="conditionId">
								<option value="1" <c:if test="${conditionBean.conditionId == 1}">selected</c:if> >姓名</option>
								<option value="2" <c:if test="${conditionBean.conditionId == 2}">selected</c:if> >学号</option>
								<option value="3" <c:if test="${conditionBean.conditionId == 3}">selected</c:if> >寝室</option>
							</select>
						</div>
			            <div class="form-group" style="margin-left: 5px">
			            	<input type="text" class="form-control" name="conditionValue" value="${conditionBean.conditionValue}" placeholder="条件内容">
			            </div>
			             <div class="form-group" style="margin-left: 10px;">
						      <button type="reset" class="btn btn-info btn-sm" id="btnReSet">重置</button>
						      <button type="button" class="btn btn-success btn-sm" id="btnSearch">查询</button>
						  </div>
					</form>
			  	</div>
			</div>
		
			<div class="panel panel-default table-responsive">
			  <div class="panel-heading" style="padding: 15px 20px;">
			    <h3 class="panel-title" style="font-weight: bold;">缺勤记录</h3>
			  </div>
			  	<table class="table table-striped table-bordered" style="text-align: center; ">
					<thead>
						<tr>
						<th>日期</th>
						<th>学号</th>
						<th>姓名</th>
						<th>宿舍楼</th>
						<th>寝室</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody>
						<c:if test="${page.rows.size() == 0}">
							<tr>
								<td colspan="7" style="text-align: center;"><span style="display: block;margin: 30px 0;color: red; font-weight: bold;">暂无缺勤记录</span></td>
							</tr>
						</c:if>
						<c:forEach items="${page.rows }" var="record">
							<tr>
								<td>
									<fmt:formatDate value="${record.date }" type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${record.studentnumber }</td>
								<td>${record.studentname }</td>
								<td>${record.dormbuildid }</td>
								<td>${record.dormname }</td>
								<td>${record.datail }</td>
								<td>
									<button class="btn btn-danger btn-xs" type="button" 
									 data-toggle="modal" data-target="#deleteModal" onclick="deleteShowModal(this,${record.recordid})">删除</button>
								</td>
							</tr>	  
						</c:forEach>
					</tbody>	
				</table>
			</div><!-- panel -->
			<!-- 分页 -->
			<div style="margin-top: -20px;">
				<gxc:page url="${pageContext.request.contextPath}/admin/recordList.html"></gxc:page>
			</div>
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
	      	确定要删除这条记录吗？
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <!-- data-toggle="modal" data-target="#deleteModal" -->
	        <button type="button" class="btn btn-danger"  id="btnDelete">删除</button>
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
	//1、日期插件
	$('.form_date').datetimepicker({
	    language:  'zh-CN',
	    weekStart: 1,
	    format: 'yyyy-mm-dd',//显示格式
	    todayBtn:  1,
		autoclose: 1,//选择后自动关闭
		todayHighlight: 1,//今天高亮
		startView: 2,
		minView: 2,
		forceParse: 0
	});
	
	//2、点击查询
	$("#btnSearch").click(function(){
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		//alert($("#startDate").val()); alert($("#endDate").val());
		//发送ajax检测日期
		$.post("${pageContext.request.contextPath}/checkDate.action",
				{	startDate:startDate,
					endDate:endDate
				},
				function(data){
					if(data.status == 201){
						showMyModal("提示",data.msg);
					}else{
						//提交表单
						$("#searchRecordForm").submit();
					}
				}
		);
	});
	
	//3、重置按钮
	$("#btnReSet").click(function(){
		$("#endDate").val("");
		$("#startDate").val("");
	});
	
	//5、删除
	$("#btnDelete").click(function(){
		$.post("${pageContext.request.contextPath}/admin/deleteRecord/"+deleteId+".action",{},function(data){
			if(data.status == 200){
				$(deleteElement).parent().parent().remove();
				setTimeout(function(){
					$("#deleteModal").modal('hide');
				}, 100)
				showMyModal("提示",data.msg);
				deleteElement = null;
				deleteId = null;
			}
			else{
				setTimeout(function(){
					$("#deleteModal").modal('hide');
				}, 100)
				showMyModal("提示",data.msg);
				deleteElement = null;
				deleteId = null;
			}
		});
	});
});

//4、删除框
var deleteElement = null;
var deleteId = null;
function deleteShowModal(element,id){
	deleteElement = element;
	deleteId = id;
}
</script>
</html>