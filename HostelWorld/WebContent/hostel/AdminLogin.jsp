<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>经理登录</title>
   <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
   <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
   <script src="jquery/jquery-2.1.3.min.js"></script>
   <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
  <body style="background-color:rgba(54, 105, 55, 0.75)">
	<nav class="navbar navbar-inverse" role="navigation">
	  <div class="navbar-header">
      <a class="navbar-brand" href="#">HostelAdmin</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li class="active"><a href="#">首页</a></li>
         <%--<li><a href="#">电影</a></li>--%>
      </ul>
	  <ul class="nav navbar-nav navbar-right">
	  <li class="active"><a class="navbar-brand" href="#"><span class="glyphicon glyphicon-log-in"></span>AdminLogin</a></li>
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
	<div class="col-xs-4" style="background-color:#FFFFFF">
	<p></p>
	<form role="form" action="adminLogin.action" method="post">
		<legend><strong>Hostel Administer</strong></legend>
		<div class="form-group">
		<div class="form-group">
		<label>身份：</label>
			<label >经理</label>
		<%--<select class="form-control" name="identity">--%>
		<%--<option value="1">管理员</option>--%>
		<%--<option value="2">经理</option>--%>
		</select>
		</div>
		<div class="form-group">
		<label>请输入密码：</label>
		<input type="password" class="form-control" id="password" name="password" placeholder="password"/>
		</div>
		<button class="btn-block btn-lg btn-danger" type="submit">登录</button>
	</form>
		<p></p>
		<br/>
	</div>
	<div class="col-xs-4">
	</div>
	</div>
	</div>
  </body>
</html>