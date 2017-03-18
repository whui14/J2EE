<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>MEMBER</title>
   <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
   <link href="bootstrap/css/other.css" rel="stylesheet"/>
   <script src="jquery/jquery-2.1.3.min.js"></script>
   <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
  <body style="background-color:rgba(54, 105, 55, 0.75)">
       <jsp:useBean id="user" type="hostel_world.model.User" scope="session"></jsp:useBean>
       
	<nav class="navbar navbar-inverse" role="navigation">
	  <div class="navbar-header">
      <a class="navbar-brand" href="memHomePage.action">HostelWorld</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li class="active"><a href="memHomePage.action">首页</a></li>
         <li><a href="memberInfo.action">账号信息</a></li>
         <li><a href="enterAnswer.action">参与活动</a></li>
         <li><a href="enterRecharge.action">充值</a></li>
      </ul>
	  <ul class="nav navbar-nav navbar-right">
	  <li class="active"><a class="navbar-brand" href="personInfo.action"><span class="glyphicon glyphicon-user"></span><jsp:getProperty name="user" property="name"/></a></li>
	  <li><a href="userSet.action"><span class="glyphicon glyphicon-cog"></span></a><li>
	  <li><a href="logout.action"><span class="glyphicon glyphicon-off"></span></a><li>
	  <li><a>&nbsp </a></li>
	  </ul>
	</div>
	</nav>
	<div   style="height:130px;background:url('images/bg.jpg')">
	</div>
	<div class="container">
	<div class="row" style="height:40px">
	</div >
	<div class="row">
	<div class="col-xs-4">
	</div>
	<!-- Tab的使用范围-->
	<div class="col-xs-4" style="background-color:#FFFFFF">
			<p></p>
	<form role="form" method="post" action="#">
		<legend><strong>用户设置</strong></legend>
		<p></p>
		<br/>
		<button class="btn-block btn btn-success" type="submit"><span class="glyphicon glyphicon-edit"></span>修改密码</button>
		<button class="btn-block btn btn-danger" onclick="clear()"><span class="glyphicon glyphicon-remove-circle"></span>注销会员</button>
	</form>
		<p></p>
		<br/>
	</div>
	<!-- Tab的结束范围。 -->
	</div>
	</div>
	<script  type="text/javascript">
		function clear(){
			alert("注销成功");
			}
	</script>
  </body>
</html>ml>