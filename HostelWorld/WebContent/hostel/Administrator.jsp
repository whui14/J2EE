<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:useBean id="hostel" type="hostel_world.model.Hostel" scope="session"></jsp:useBean>
   <title><%=hostel.getHostelName()%></title>
   <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
   <link href="bootstrap/css/other.css" rel="stylesheet"/>
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
         <li class="active"><a href="adminHomePage.action">首页</a></li>
      </ul>
	  <ul class="nav navbar-nav navbar-right">
	  <li class="active"><a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user"></span> <%=hostel.getHostelName()%></a></li>
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
	<!--开始-->
	<div class="col-xs-4">
		<div class="page-header">
			<h1>
			Administrator
			</h1>
		</div>
	<!--导航开始-->
	<ul class="nav nav-pills nav-stacked">
		<li><a href="enterCreatePlan.action">发布计划</a></li>
		<li><a href="hostelInfo.action">修改客栈信息</a></li>
		<li><a href="currentFilm.action">入/离店登记</a></li>
		<li><a href="enterSearch.action">查看会员的信息</a></li>
		<li><a href="enterQuestion.action">查看本店统计信息</a></li>
		<li><a href="enterDown.action">房屋关闭计划</a></li>
	</ul>
	<!--导航结束-->
	
	</div>
	<!--结束-->
	<!--右边部分-->
	<div class="col-xs-6">	

	
	<img src="images/admin2.jpg" alt="post"/>

	
	</div>
	<!--右边部分-->
	</div>
  </body>
</html>