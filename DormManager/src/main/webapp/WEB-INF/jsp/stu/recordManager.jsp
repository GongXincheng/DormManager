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
			  <a href="/page/stu/index.html" class="list-group-item">首页</a>
			  <a href="${pageContext.request.contextPath}/stu/recordList.html" class="list-group-item active">缺勤记录</a>
			  <a href="/page/stu/rePassword.html" class="list-group-item">修改密码</a>
			  <a href="/user/exitSystem.html" class="list-group-item">退出系统</a>
			</div>
		</div>
		<div class="col-md-10">
			<div class="panel panel-default">
			  <div id="panel-menu" style="margin:15px;">
			  		<!-- 条件查询 -->
					<form action="${pageContext.request.contextPath}/stu/recordList.html" id="searchForm" method="POST" class="form-inline form-group-sm">
						<div class="form-group col-md-3" style="margin-left: -10px;">
			                <div class="input-group date form_date" >
			                    <input class="form-control" value="<fmt:formatDate value="${conditionBean.startDate }" type="date" pattern="yyyy-MM-dd"/>" size="16" type="text" id="startDate" name="startDate" placeholder="起始日期" readonly>
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
			            </div>
			            <div class="form-group  col-md-3 " style="margin-left: -10px;">
			                <div class="input-group date form_date" >
			                    <input class="form-control" size="16" value="<fmt:formatDate value="${conditionBean.endDate }" type="date" pattern="yyyy-MM-dd"/>" type="text" name="endDate" id="endDate" placeholder="终止日期" readonly>
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
			            </div>
			             <div class="form-group" style="margin-left: 10px;">
						      <button type="button" class="btn btn-success btn-sm" id="btnSearch">搜索</button>
						  </div>
					</form>
			  	</div>
			</div>
		
			<div class="panel panel-default table-responsive">
			  <div class="panel-heading">
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
					</tr>
					</thead>
					<tbody>
						<c:if test="${page.rows.size() == 0}">
							<tr>
								<td colspan="6" style="text-align: center;"><span style="display: block;margin: 30px 0;color: red; font-weight: bold;">暂无缺勤记录</span></td>
							</tr>
						</c:if>
						<c:forEach items="${page.rows}" var="record">
							<tr>
								<td>
									<fmt:formatDate value="${record.date }" type="date" pattern="yyyy-MM-dd"/>
								</td>
								<td>${record.studentnumber }</td>
								<td>${record.studentname }</td>
								<td>${record.dormbuildid}</td>
								<td>${record.dormname }</td>
								<td>${record.datail }</td>
							</tr>	  
						</c:forEach>
					</tbody>	
				</table>
			</div><!-- panel -->
			<!-- 分页 -->
			<div style="margin-top: -20px;">
				<gxc:page url="${pageContext.request.contextPath}/stu/recordList.html"></gxc:page>
			</div>
		</div><!-- col-md-10 -->
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
	//日期插件
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
	
	//搜索
	$("#btnSearch").click(function(){
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		$.post("${pageContext.request.contextPath}/checkDate.action",
				{	startDate:startDate,
					endDate:endDate },
				function(data){
					if(data.status == 201){
						showMyModal("提示",data.msg);
					}else{
						$("#searchForm").submit();
					}
				}
		);
	});
});
</script>
</html>