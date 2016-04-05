<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file="css/default.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Commodity Trading System-Login</title>
</head>
<body class="pure-skin-mine">
<div id="page" >
	<div id="pageheader">
	
		<div id="pagetitle">
			Commodity Trading System
		</div>
		
	</div>
	<div id="pagemenu" class="pure-menu pure-menu-open pure-menu-horizontal">
			<ul>
				<li class="pure-menu-selected"><a>HOME</a></li>
			</ul>
	</div>
	<div id="pagebody">
		<form method = "post" action="LoginServlet" class="pure-skin-mine pure-form">
		<div id="formdiv">
			<div id = "inputdiv">
			<legend>Username:</legend>
			<input name="username" class="pure-skin-mine" type="text">
			<legend>Password:</legend>
			<input name="password" type="password" class="pure-skin-mine">
			</div>
			<input type="submit" value="Sign in" class="pure-button pure-skin-mine"/>
			<input type="button" value="Sign up" class="pure-button pure-skin-mine"/>
		</div>
		</form>
	</div>
	<div id = "pagefooter"></div>
</div>
</body>
</html>