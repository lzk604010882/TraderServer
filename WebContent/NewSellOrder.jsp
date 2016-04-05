<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file="css/default.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Commodity Trading System-New Buy</title>
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
				<li><a href="Login.jsp">HOME</a></li>
				<li><a href="NewBuyOrder.jsp">New Buy Order</a></li>
				<li class="pure-menu-selected"><a href="NewSellOrder.jsp">New Sell Order</a></li>
				<li><a href="GetHistoryOrdersServlet">History Orders</a></li>
				<li><a href="GetBestOrdersServlet">Fill Orders</a></li>
				<li><a>Broker Information</a></li>
			</ul>
	</div>
	<div id="pagebody">
		<form method = "post" action="NewSellOrderServlet" class="pure-skin-mine pure-form">
		<div id="formdiv">
			<div id = "inputdiv">
			<span>
				<label>Commodity name</label>
				<label class="pure-radio">
					<input type="radio" name="commodityName" value="gold" >Gold
				</label>
				<label class="pure-radio">
					<input type="radio" name="commodityName" value="crude_oil" >Crude Oil
				</label>
			</span>
			<span>
				<label>Period</label>
				<select name="month" id="month" >
					<option value="1">Jan14</option>
					<option value="2">Fab14</option>
					<option value="3">Mar14</option>
					<option value="4">Apr14</option>
					<option value="5">May14</option>
					<option value="6">Jun14</option>
					<option value="7">Jul14</option>
					<option value="8">Aug14</option>
					<option value="9">Sep14</option>
					<option value="10">Oct14</option>
					<option value="11">Nov14</option>
					<option value="12">Dec14</option>
				</select>
			</span>
			
			</div>
			<input type="submit" value="Next" class="pure-button pure-skin-mine"/>
			<input type="reset" value="Reset" class="pure-button pure-skin-mine"/>
		</div>
		</form>
	</div>
	<div id = "pagefooter"></div>z
</div>
</body>
</html>