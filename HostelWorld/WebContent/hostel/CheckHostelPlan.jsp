<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>审批客栈</title>
   <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
   <link href="bootstrap/css/other.css" rel="stylesheet"/>
   <script src="jquery/jquery-2.1.3.min.js"></script>
   <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
  <body style="background-color:rgba(54, 105, 55, 0.75)">
  
  <jsp:useBean id="hostelList" type="hostel_world.model.list.HostelList" scope="session"></jsp:useBean>
  <jsp:useBean id="hostel" class="hostel_world.model.Hostel" scope="page"></jsp:useBean>
  
	<nav class="navbar navbar-inverse" role="navigation">
	  <div class="navbar-header">
      <a class="navbar-brand" href="managerHomePage.action">HostelAdmin</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li class="active"><a href="managerHomePage.action">首页</a></li>
      </ul>
	  <ul class="nav navbar-nav navbar-right">
	  <li class="active"><a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user"></span>Manager</a></li>
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
	<div class="col-xs-2">
	</div>
	<!--结束-->
	
	<!--右边部分-->
	<div class="col-xs-10">	
		<div class="page-header">
		<h1>审核开店申请

		</h1>
		</div>
	<br/>
<%
	for(int i=0;i<hostelList.getHostelList().size();i++){
		pageContext.setAttribute("hostel", hostelList.getHostelList(i));
%>
	<div class="row" >
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><jsp:getProperty name="hostel" property="hostelName"/></h3>
			</div>
			<div class="panel-body">
				<div class="col-xs-4">
				<img src='<jsp:getProperty name="hostel" property="pictureurl"/>' alt="picture" style="width:320px;height:450px">
				</div>
				<div class="col-xs-8">
				<ul>
					<li class="list-group-item">客栈名：<jsp:getProperty name="hostel" property="hostelName"/></li>
					<li class="list-group-item">电话：<jsp:getProperty name="hostel" property="telephone"/></li>
					<li class="list-group-item">地址：<jsp:getProperty name="hostel" property="address"/></li>
					<li class="list-group-item">开店时间：<jsp:getProperty name="hostel" property="time"/></li>
					<li class="list-group-item">客栈简介：<jsp:getProperty name="hostel" property="introduction"/></li>

				</ul>
				<br/>
				
				<form class="form-horizontal" role="form" action="checkHostel.action" method="post">
					<div class="form-group">
						<div class="col-xs-offset-3 col-xs-6">
							<input type="hidden" class="form-control" name="hostelId" value='<jsp:getProperty name="hostel" property="id"/>'/>
							<input type="hidden" class="form-control" name="sub" id="sb" value=1 />
							<button type="submit" class="btn btn-success btn-bg btn-block" onclick="pass()">确认通过</button>
						</div>
					</div>
				</form>
				<form class="form-horizontal" role="form" action="checkHostel.action" method="post">
					<div class="form-group">
						<div class="col-xs-offset-3 col-xs-6">
							<input type="hidden" class="form-control" name="hostelId" value='<jsp:getProperty name="hostel" property="id"/>'/>
							<input type="hidden" class="form-control" name="sub" id="sb" value=0 />
							<button type="submit" class="btn btn-danger btn-bg btn-block" onclick="unpass()">否决</button>
						</div>
					</div>
				</form>
				
				</div>
			</div>
		</div>
	</div>
	<br/>
<%
	}
%>

	<script type="text/javascript">
		function unpass(){
			alert("该客栈申请未通过！");
		}

		function pass(){
			alert("该客栈申请已通过！");
		}
	</script>
  </body>
</html>