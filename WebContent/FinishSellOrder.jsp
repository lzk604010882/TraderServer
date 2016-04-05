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
<title>Commodity Trading System-New Sell</title>
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
			<div>
			<%
				String period = (String)request.getAttribute("period");
				String commodity = (String)request.getAttribute("commodityName");
				
				
			%>
				<p><%=commodity%></p>
				<p><%=period %></p>
				<input type="text" name="commodityName" value=<%=commodity %> />
				<input type="text" name="period" value=<%=period %> />
				<input type="hidden" name="type" value="1"/>
			</div>
			<div>
				<label>Quantity</label>
				<input type="text" name="qty" />
				<p>Hint:Can only sell <%=request.getAttribute("stock")%> units top.</p>
			</div>
			<div>
				<label>Price</label>
				<input type="text" name="price" />
			</div>
			<div>
				<label>Broker</label>
				<select name="broker">
					<%
						int a = 3;
						String b = "broker1";
						int c = 10004;
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
			<input type="submit" value="Next" class="pure-button pure-skin-mine"/>
			<input type="reset" value="Reset" class="pure-button pure-skin-mine"/>
		</div>
		</form>
	</div>
	<div id = "pagefooter"></div>z
</div>
</body>
</html>