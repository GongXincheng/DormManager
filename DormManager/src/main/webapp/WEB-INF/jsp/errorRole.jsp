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
	<jsp:include page="common/top.jsp"></jsp:include>
	
	<div class="container">
		<div class="col-md-2">
			<div class="list-group" id="nav">
			 	<c:if test="${sessionScope.loginRole == 1 }">
					<a href="/page/admin/index.html" class="list-group-item active">首页</a>
					<a href="${pageContext.request.contextPath}/admin/dormMngList.html" class="list-group-item">宿舍管理员管理</a>
					<a href="${pageContext.request.contextPath}/admin/studentList.html" class="list-group-item">学生管理</a>
					<a href="${pageContext.request.contextPath}/admin/dormBuildList.html" class="list-group-item">宿舍楼管理</a>
					<a href="${pageContext.request.contextPath}/admin/recordList.html" class="list-group-item">缺勤管理</a>
					<a href="/page/admin/rePassword.html" class="list-group-item">修改密码</a>
			 	</c:if>
			 	<c:if test="${sessionScope.loginRole == 2 }">
					<a href="/page/dorm/index.html" class="list-group-item active">首页</a>
					<a href="${pageContext.request.contextPath}/dorm/allStuList.html" class="list-group-item">学生查看</a>
					<a href="${pageContext.request.contextPath}/dorm/recordList.html" class="list-group-item">缺勤记录</a>
					<a href="${pageContext.request.contextPath}/page/dorm/rePassword.html" class="list-group-item">修改密码</a>
			 	</c:if>
			 	<c:if test="${sessionScope.loginRole == 3 }">
					<a href="/page/student/index.html" class="list-group-item active">首页</a>
					<a href="${pageContext.request.contextPath}/stu/recordList.html" class="list-group-item">缺勤记录</a>
					<a href="/page/student/rePassword.html" class="list-group-item">修改密码</a>
					<a href="/user/exitSystem.html" class="list-group-item">退出系统</a>
			 	</c:if>
			</div>
		</div>
		<div class="col-md-10 wow fadeInUp" style="text-align: center; margin-top: 10%; color: red; font-weight: bold; font-size: 35px;">
			暂无权限访问
		</div>
	</div>
</body>
</html>