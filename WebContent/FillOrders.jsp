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
<title>Commodity Trading System-Confirm buy order</title>
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
		<%
			String buyOrderss = (String)request.getAttribute("buyOrders");
			String sellOrderss = (String)request.getAttribute("sellOrders");
				
			JSONArray buyOrders = JSONArray.fromObject(buyOrderss);
			JSONArray sellOrders = JSONArray.fromObject(sellOrderss);
			
			
		%>
		<script type="text/javascript" src="js/json2.js"></script>
		<script type="text/javascript">
			function fillOrder(orders, type){
				var commodity = document.getElementById("commodity");
				var period = document.getElementById("period");
				var type = document.getElementById("type");
				var price = document.getElementById("price");
				var qty = document.getElementById("qty");
				var broker = document.getElementById("broker");
				var orderj = JSON.parse(orders);
				commodity.innerHTML = orderj.commodityName;
				period.innerHTML = orderj.period;
				type.innerHTML = type;
				price.innerHTML = orderj.price;
				qty.innerHTML = orderj.initQty - orderj.dealtQty;
				broker.innerHTML = orderj.brokerID;
			}

			function getOrders(cname){
				href = "GetBestOrdersServlet?commodityName=" + cname;
				document.location.href = href;
			}

			
		</script>
		<div id="formdiv">
			<div id = "inputdiv">
				<p>Commodity</p>
				<select id="commodityname" onchange="getOrders(this.value)">
					<option value="gold" selected>Gold</option>
					<option value="crude_oil">Crude Oil</option>
				</select>
				<p>Buy orders:</p>
				<table class="pure-table pure-table-horizontal" width = "700">
					<thead>
						<tr>
						<th>Period</th>
						<th>Quantity</th>
						<th>Broker</th>
						<th>Price</th>
						</tr>
					</thead>
					<tbody>
						<%
							for(int i = 0; i < buyOrders.size(); i++){
								JSONObject order = buyOrders.getJSONObject(i);
						%>		
							<tr>
								<td><%=order.getString("period") %></td>
								<td><%=order.getInt("initQty")-order.getInt("dealtQty") %></td>
								<td><%=order.getInt("brokerID") %></td>
								<td><a onclick="fillOrder(<%=order.toString() %>, '0')"><%=order.getDouble("price") %></a></td>
							</tr>
						<%		
							}
						%>
					</tbody>
				</table>
				<p>Sell orders:</p>
				<table class="pure-table pure-table-horizontal" width = "700">
					<thead>
						<tr>
						<th>Period</th>
						<th>Quantity</th>
						<th>Broker</th>
						<th>Price</th>
						</tr>
					</thead>
					<tbody>
						<%
							for(int i = 0; i < sellOrders.size(); i++){
								JSONObject order = sellOrders.getJSONObject(i);
						%>		
							<tr>
								<td><%=order.getString("period") %></td>
								<td><%=order.getInt("initQty")-order.getInt("dealtQty") %></td>
								<td><%=order.getInt("brokerID") %></td>
								<td><a onclick="fillOrder(<%=i %>, '1')"><%=order.getDouble("price") %></a></td>
							</tr>
						<%		
							}
						%>
					</tbody>
				</table>
				
			</div>
		
		</div>
	</div>
	</div>
	<div id = "pagefooter"></div>
</body>
</html>