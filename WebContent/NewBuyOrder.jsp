<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.sf.json.*" %>
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
				<li  class="pure-menu-selected"><a>New Buy Order</a></li>
				<li><a href="NewSellOrder.jsp">New Sell Order</a></li>
				<li><a href="GetHistoryOrdersServlet">History Orders</a></li>
				<li><a href="GetBestOrdersServlet">Fill Orders</a></li>
				<li><a>Broker Information</a></li>
			</ul>
	</div>
	<div id="pagebody">
		<form method = "post" action="ConfirmOrderServlet" class="pure-skin-mine pure-form">
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
				<select name="period" id="month">
					<option value="Jan14">Jan14</option>
					<option value="Fab14">Fab14</option>
					<option value="Mar14">Mar14</option>
					<option value="Apr14">Apr14</option>
					<option value="May14">May14</option>
					<option value="Jun14">Jun14</option>
					<option value="Jul14">Jul14</option>
					<option value="Aug14">Aug14</option>
					<option value="Sep14">Sep14</option>
					<option value="Oct14">Oct14</option>
					<option value="Nov14">Nov14</option>
					<option value="Dec14">Dec14</option>
				</select>
			</span>
			<div>
				<label>Quantity</label>
				<input type="text" name="qty" />
			</div>
			<div>
				<label>Price</label>
				<input type="text" name="price" />
			</div>
			<div>
				<label>Broker</label>
				<select name="broker">
					<%
						int a = 2;
						String b = "broker1";
						int c = 10002;
						String d = "broker2";
						//String brokers = (String)request.getAttribute("brokers");
						//JSONArray brokersj = JSONArray.fromObject(brokers);
						//for(int i = 0; i < brokersj.size();i ++){
							//JSONObject broker = brokersj.getJSONObject(i);
					%>
						<option value=<%=a %>><%=b %></option>
						<option value=<%=c %>><%=d %></option>
					<%
						//}
					%>
				</select>
			</div>
			</div>
			<input type="hidden" value="0" name="type" />
			<input type="submit" value="Next" class="pure-button pure-skin-mine"/>
			<input type="reset" value="Reset" class="pure-button pure-skin-mine"/>
		</div>
		</form>
	</div>
	<div id = "pagefooter"></div>z
</div>
</body>
</html>