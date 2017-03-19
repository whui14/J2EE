<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>客栈注册</title>
   <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
   <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
   <script src="jquery/jquery-2.1.3.min.js"></script>
   <script src="bootstrap/js/bootstrap.min.js"></script>
   
   <link href="bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
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
	  <li class="active"><a class="navbar-brand" href="logout.action"><span class="glyphicon glyphicon-log-in"></span>登录</a></li>
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
	<form role="form" action="hostelRegister.action" method="post"  enctype="multipart/form-data">

		<legend><strong>输入客栈注册信息</strong></legend>
		<div class="form-group">
		<label>用户名：</label>
		<input type="text" class="form-control" name="hostel.name" placeholder="小于14字符"/>
		</div>
		<div class="form-group">
		<label>密码：</label>
		<input type="password" class="form-control" name="hostel.password" placeholder="password"/>
		</div>
		
		<div class="form-group">
		<label>确认密码：</label>
		<input type="password" class="form-control" name="repassword" placeholder="repeat password"/>
		</div>
		<div class="form-group">
			<label>客栈名称：</label>
			<input type="text" class="form-control" name="hostel.hostelName" placeholder="小于14字符"/>
		</div>
		<div class="form-group">
			<label>联系电话：</label>
			<input type="text" class="form-control" name="hostel.telephone" placeholder="telephone"/>
		</div>

		<div class="form-group">
        <label>营业时间</label>
        <div class="input-group date form_date"  data-date="" data-date-format="dd M yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
        <input class="form-control" size="16"  name="birthday" type="text" value="" readonly>
        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
		<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        </div>
        </div>

		<div class="form-group">
			<label>房屋简介：</label>
			<input type="text" class="form-control" name="hostel.introduction" placeholder="introduction"/>
		</div>
		<div class="form-group">
			<label>具体地址：</label>
			<input type="text" class="form-control" name="hostel.address" placeholder="address"/>
		</div>

		<div class="form-group">
			<label>上传房间照片：</label>
			<input type="file" class="form-control" name="uploadFile" />
		</div>

		<%--<div style="color:red">--%>
			<%--<s:fielderror />--%>
		<%--</div>--%>


		<button class="btn-block btn-lg btn-success" >注册</button>
	</form>
		<p></p>
		<br/>
	</div>
	<div class="col-xs-4">
	</div>
	</div>
	</div>
	
	<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
	<script type="text/javascript">
	$('.form_date').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		format:'yyyy-mm-dd',
		forceParse: 0
    });
</script>
  </body>
</html>