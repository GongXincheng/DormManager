<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
nav.navbar.navbar-default {
    padding: 6px 0px;
}
</style>

<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="javascript:void(0);" style="font-weight: bold;font-size: 20px;color:#111; letter-spacing: 2px;">宿舍管理系统</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="javascript:void(0);" style="font-weight: bold; font-size: 15px;">${loginUser.name}</a></li>
        <li>
        	<button class="btn btn-info" type="button" id="btnExit"  style="margin-left:15px; margin-top: 7px">退出登录</button>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<script>
//退出按钮
$("#btnExit").click(function(){
	location.href = "/user/exitSystem.html";
});
</script>