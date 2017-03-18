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
   <jsp:useBean id="hostel" type="hostel_world.model.Hostel" scope="session"></jsp:useBean>
    
	<nav class="navbar navbar-inverse" role="navigation">
	  <div class="navbar-header">
      <a class="navbar-brand" href="memHomePage.action">HostelWorld</a>
   </div>
   <div>
	   <ul class="nav navbar-nav">
		   <li class="active"><a href="adminHomePage.action">首页</a></li>
	   </ul>
	   <ul class="nav navbar-nav navbar-right">
		   <li class="active"><a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user"></span><%=hostel.getHostelName()%></a></li>
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
	<div class="col-xs-2">
	</div>
	<!-- Tab的使用范围-->
	
	<div class="col-xs-8">
		<form role="form" action="enterHostelModify.action" name="form_" method="post">
			<input type="hidden" class="form-control" name="sub" value=1 />
    <div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">我的客栈信息</h3>
	</div>
	<div class="panel-body">
		<div class="well well-sm">
		<p>客栈名称：&nbsp&nbsp&nbsp&nbsp&nbsp<jsp:getProperty name="hostel" property="hostelName"/></p>
		</div>
		<div class="well well-sm">
		<p>ID：&nbsp&nbsp&nbsp&nbsp&nbsp<jsp:getProperty name="hostel" property="id"/></p>
		</div>
     	<div class="well well-sm">
		<p>联系电话：&nbsp&nbsp&nbsp&nbsp&nbsp<jsp:getProperty name="hostel" property="telephone"/></p>
		</div>
		<div class="well well-sm">
		<p>营业时间：&nbsp&nbsp&nbsp&nbsp&nbsp<jsp:getProperty name="hostel" property="time"/></p>
		</div>
		<div class="well well-sm">
		<p>房屋简介：&nbsp&nbsp&nbsp&nbsp&nbsp<jsp:getProperty name="hostel" property="introduction"/></p>
		</div>
		<div class="well well-sm">
		<p>具体地址：&nbsp&nbsp&nbsp&nbsp&nbsp<jsp:getProperty name="hostel" property="address"/></p>
		</div>

		<%
		if (hostel.getPass() == 1){
		%>
		<button class="btn-block btn-lg btn-success" type="submit" onclick="change()">修改客栈信息</button>
		<%
		}
		else if(hostel.getPass() == 4){
		%>
		<p>客栈信息修改审核中，请耐心等待</p>
		<%
			}
			else if(hostel.getPass() == -2){
			%>
		<p>客栈信息修改审核未通过</p>
		<button class="btn-block btn-lg btn-danger" type="submit" onclick="pass()">取消修改</button>
		<button class="btn-block btn-lg btn-success" type="submit" onclick="unpass()">继续修改</button>
		<%
			}
		%>
		</form>

	</div>
   </div>   

	</div>
	<!-- Tab的结束范围。 -->
	</div>
	</div>
   <script type="text/javascript">
	   function unpass(){
		   document.form_.sub.value=0;
	   }

	   function pass(){
		   document.form_.sub.value=1;
	   }
	   function change(){
		   document.form_.sub.value=2;
	   }


   </script>
  </body>
</html>