<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--head-->
   <title>继续修改客栈信息</title>
   
   <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
   <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
   <script src="jquery/jquery-2.1.3.min.js" charset="UTF-8"></script>
   <script src="bootstrap/js/bootstrap.min.js"></script>
   
   <link href="bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
   

<!--head-->
</head>
<!--body-->
  <body style="background-color:rgba(54, 105, 55, 0.75)">

  <jsp:useBean id="hostelPlan" type="hostel_world.model.HostelPlan" scope="session"></jsp:useBean>

  <nav class="navbar navbar-inverse" role="navigation">
	  <div class="navbar-header">
      <a class="navbar-brand" href="adminHomePage.action">HostelAdmin</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li class="active"><a href="adminHomePage.action">首页</a></li>
      </ul>
	  <ul class="nav navbar-nav navbar-right">
	  <li class="active"><a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user"><%=hostel.getHostelName()%></a></li>
	  <li><a href="#"><span class="glyphicon glyphicon-cog"></span></a><li>
	  <li><a href="adminLogout.action"><span class="glyphicon glyphicon-off"></span></a><li>
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
	<div class="col-xs-3">
	</div>
	<div class="col-xs-6" style="background-color:#FFFFFF">
	<p></p>
	<form role="form" action="resaveHostelPlan.action" method="post">
		<legend><strong>继续修改客栈信息</strong></legend>
		<div class="form-group">
			<label>客栈名称：</label>
			<input type="text" class="form-control" name="hostelPlan.hostelName" value='<jsp:getProperty name="hostelPlan" property="hostelName"/>' >
		</div>

		<div class="form-group">
			<label>联系电话：</label>
			<input type="text" class="form-control" name="hostelPlan.telephone" value='<jsp:getProperty name="hostelPlan" property="telephone"/>' >
		</div>

		<div class="form-group">
			<label>营业时间</label>
			<div class="input-group date form_date"  data-date="" data-date-format="dd M yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
				<input class="form-control" size="16"  name="time" type="text" value='<jsp:getProperty name="hostelPlan" property="time"/>' readonly>
				<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
				<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			</div>
		</div>

		<div class="form-group">
			<label>房屋简介：</label>
			<input type="text" class="form-control" name="hostelPlan.introduction" value='<jsp:getProperty name="hostelPlan" property="introduction"/>' >
		</div>

		<div class="form-group">
			<label>具体地址：</label>
			<input type="text" class="form-control" name="hostelPlan.address" value='<jsp:getProperty name="hostelPlan" property="address"/>' >
		</div>

		<input type="hidden" class="form-control" name="id" value='<jsp:getProperty name="hostelPlan" property="id"/>'/>
		<input type="hidden" class="form-control" name="sub" value=1 />
		<input type="hidden" class="form-control" name="name" value='<jsp:getProperty name="hostelPlan" property="name"/>'/>


		<button class="btn-block btn-lg btn-success" type="submit" onclick="sub()">确认修改</button>
	</form>
		<p></p>
		<br/>
	</div>
	<div class="col-xs-3">
	</div>
	</div>
	</div>
	
	<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
	<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		format:'yyyy-mm-dd HH:ii:00',
		forceParse: 0
    });

    function sub(){
        alert("修改计划成功，请等待经理审批！");
        }
	</script>
  </body>
  <!--body-->
</html>