<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>登录</title>
   <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
   <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
   <script src="jquery/jquery-2.1.3.min.js"></script>
   <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
  <body style="background-color:rgba(54, 105, 55, 0.75)">
	<nav class="navbar navbar-inverse" role="navigation">
	  <div class="navbar-header">
      <a class="navbar-brand" href="#">HostelWorld</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li class="active"><a href="#">首页</a></li>
      </ul>
	  <ul class="nav navbar-nav navbar-right">
	  <li class="active"><a class="navbar-brand" href="login.action"><span class="glyphicon glyphicon-log-in"></span>注册会员</a></li>
		  <li class="active"><a class="navbar-brand" href="enterHostelRegister.action"><span class="glyphicon glyphicon-log-in"></span>注册客栈</a></li>
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
	<form role="form" action="login.action" method="post" name="form_">
		<legend><strong>登录</strong></legend>
		<div class="form-group">
			<label>选择身份：</label>
			<select class="form-control" name="identity">
				<option value="1">会员</option>
				<option value="2">客栈</option>
			</select>
		</div>
		<div class="form-group">
		<label>用户名：</label>
		<input type="text" class="form-control" id="name" placeholder="your name" name="name">
		</div>
		<div class="form-group">
		<label>密码：</label>
		<input type="password" class="form-control" id="password" placeholder="password" name="password" />
		</div>
		<input type="hidden" class="form-control" name="sub" value=1 />
		<button class="btn-block btn-lg btn-success" type="submit" onclick="pass()">登录</button>
		<button class="btn-block btn-lg btn-danger" type="submit" onclick="unpass()">创建会员账号</button>
		<button class="btn-block btn-lg btn-danger" type="submit" onclick="unHostelPass()">创建客栈账号</button>
	</form>
		<p></p>
		<br/>
	</div>
	<div class="col-xs-4">
	</div>
	</div>
	</div>
	
	<script type="text/javascript">
		function unpass(){
			document.form_.sub.value=0;
		}

		function pass(){
			document.form_.sub.value=1;
		}

		function unHostelPass(){
			document.form_.sub.value=2;
		}
	</script>
	
	
  </body>
</html>