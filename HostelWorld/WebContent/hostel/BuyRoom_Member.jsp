<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>房间预订</title>
   <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
   <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
   <script src="jquery/jquery-2.1.3.min.js"></script>
   <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
  <body style="background-color:rgba(54, 105, 55, 0.75)">

  <jsp:useBean id="roomPlan" class="hostel_world.model.RoomPlan" scope="session"></jsp:useBean>
  <jsp:useBean id="user" class="hostel_world.model.User" scope="session"></jsp:useBean>
   <%--<jsp:useBean id="ticketManage" class="hostel_world.model.TicketManage" scope="session"></jsp:useBean>--%>

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
	  <li class="active"><a class="navbar-brand" href="personInfo.action"><span class="glyphicon glyphicon-user"></span> Administrator</a></li>
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
	<div class="col-xs-4" style="background-color:#FFFFFF">
	<p></p>
	<form role="form" method="post" action="afterCountMoney.action">
		<legend><strong>房间预定</strong></legend>
		<div class="well-sm well">
		<p><label>房型名称：</label><jsp:getProperty name="roomPlan" property="title"/></p>
		<%--<p><label>住宿时间：</label><jsp:getProperty name="roomPlan" property="airTime"/></p>--%>
		<p><label>房间单价：</label><span><jsp:getProperty name="roomPlan" property="price"/>￥</span></p>
		<p><label>购买房间数：</label><%=session.getAttribute("roomCount") %>间</p>
			<p><label>购买天数：</label><%=session.getAttribute("days") %>天</p>
		<p><label>总价：</label><%=session.getAttribute("total")%>￥</p>
		<p><label>会员昵称：</label><jsp:getProperty name="user" property="name"/></p>
		<p><label>享受折扣：</label><%=session.getAttribute("count")%>折</p>
		<p><label>折扣后价格：</label><%=session.getAttribute("afterCount")%>￥</p>
		</div>
		
		<br/>
		<br/>
		<button class="btn-block btn-lg btn-success" type="submit" onclick="buy()" >确认提交</button>
	</form>
		<p></p>
		<br/>
	</div>
	<div class="col-xs-4">
	</div>
	</div>
	</div>
  </body>
  <script>
  function buy(){
	  alert("购票成功");
	  }
  </script>
</html>