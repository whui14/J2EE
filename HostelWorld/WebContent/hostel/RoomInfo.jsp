<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>房间详情</title>
   <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
   <%--<link href="bootstrap/css/other.css" rel="stylesheet"/>--%>
   <script src="jquery/jquery-2.1.3.min.js"></script>
   <script src="bootstrap/js/bootstrap.min.js"></script>
	<link href="bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">



</head>
  <body style="background-color:rgba(54, 105, 55, 0.75)">
  <jsp:useBean id="hostel" class="hostel_world.model.Hostel" scope="session"></jsp:useBean>
  <jsp:useBean id="roomList" type="hostel_world.model.list.RoomList" scope="session"></jsp:useBean>
  <jsp:useBean id="roomPlan" class="hostel_world.model.RoomPlan" scope="page"></jsp:useBean>
  <jsp:useBean id="user" type="hostel_world.model.User" scope="session"></jsp:useBean>
  
	<nav class="navbar navbar-inverse" role="navigation">
	  <div class="navbar-header">
      <a class="navbar-brand" href="memHomePage.action">HostelWorld</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li class="active"><a href="memHomePage.action">首页</a></li>
         <li><a href="memberInfo.action">账号信息</a></li>
         <%--<li><a href="enterAnswer.action">参与活动</a></li>--%>
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
	<!--开始-->
	<div class="col-xs-4">
		<div class="page-header">
			<h1 style="color:#e9f1e8;">
				客栈房间详情

			</h1>
   <h1>
   </h1>
	</div>
	<div class="panel panel-primary" >
	<div class="panel-heading">
	<h3 class="panel-title"><jsp:getProperty name="hostel" property="hostelName"/></h3>
	</div>
	<div class="panel-body">
	<img src='<jsp:getProperty name="hostel" property="pictureurl"/>' alt="post" style="width:300px;height:300px">
	<br/>
	<br/>
	<p>客栈名称：<jsp:getProperty name="hostel" property="hostelName"/></p>
	<br/>
	<p>地址：<jsp:getProperty name="hostel" property="address"/></p>
	<br/>
	<p>简介：<jsp:getProperty name="hostel" property="introduction"/></p>
	<br/>
	<p>联系电话：<jsp:getProperty name="hostel" property="telephone"/></p>
	<br/>
	</div>
	<div class="panel-footer"></div>
	</div>
	</div>
	<!--结束-->
	<!--右边部分-->
	<div class="col-xs-6">	
	<div class="page-header">
   <%--<h2  style="color:#e9f1e8;"><jsp:getProperty name="hostel" property="hostelName"/>--%>
      <%--&lt;%&ndash;<small>（2017）</small>&ndash;%&gt;--%>
   <%--</h2>--%>
	</div>

<% 
	for(int i=0;i<roomList.getRoomList().size();i++){
		pageContext.setAttribute("roomPlan", roomList.getRoomList(i));
%>

		<%
			int b=roomPlan.getBreakfast();
			String info="有   ";
			if(b==0){
				info="无   ";
			}
			session.putValue("breakfast", info);


			int c=roomPlan.getCancel();
			String cancel="可以取消   ";
			if(c==0){
				cancel="不可取消   ";
			}
			session.putValue("cancel", cancel);

		%>

	<div class="well">
		<p style="color:#366937;"><img src='<jsp:getProperty name="roomPlan" property="posturl"/>' alt="post" style="width:90px;height:90px"> 房型名称：<jsp:getProperty name="roomPlan" property="title"/> 均价：<jsp:getProperty name="roomPlan" property="price"/>￥ </p>
		<p>	早餐：<%= session.getAttribute("breakfast")%>   床型：<jsp:getProperty name="roomPlan" property="type"/>   人数上限：<jsp:getProperty name="roomPlan" property="person"/>人   取消政策：<%= session.getAttribute("cancel")%> </p>

		<form class="form-horizontal" role="form" action="buyRoom.action" method="post">
			<p>预住天数：<input type="text" class="form-control" name="days" placeholder="请直接输入数字"/></p>

			<label>预购房间数：</label>
			<input type="text" class="form-control" name="roomCount" placeholder="请直接输入数字"/>
			<label>开始时间：</label>
			<div class="input-group date form_date"  data-date="" data-date-format="dd M yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
				<input class="form-control" size="16"  name="start" type="text" value="" readonly>
				<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
				<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			</div>
			<label>结束时间：</label>
			<div class="input-group date form_date"  data-date="" data-date-format="dd M yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
				<input class="form-control" size="16"  name="end" type="text" value="" readonly>
				<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
				<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			</div>

			<div class="form-group">
				<div class="col-xs-offset-9 col-xs-3">
					<input type="hidden" class="form-control" name="planId" value='<jsp:getProperty name="roomPlan" property="id"/>'  />

					<p style="color:#366937;">    (    在 线 付    )</p>
					<button type="submit" class="btn btn-primary btn-bg btn-block">预定</button>

				</div>
			</div>
		</form>
	</div>
<%
	}
%>
	
	</div>
	<!--右边部分-->
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