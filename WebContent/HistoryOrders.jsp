<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="TraderServer.model.Order" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@include file="css/default.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Commodity Trading System-History orders</title>
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
				<li class="pure-menu-selected"><a href="GetHistoryOrdersServlet">History Orders</a></li>
				<li><a href="GetBestOrdersServlet">Fill Orders</a></li>
				<li><a>Broker Information</a></li>
			</ul>
	</div>
	<div id="pagebody">
		<div id="formdiv">
			<div id = "inputdiv">
				<table class="pure-table pure-table-horizontal" width = "800">
					<thead>
						<tr>
						<th>Order Type</th>
						<th>CommodityName</th>
						<th>Period</th>
						<th>BrokerID</th>
						<th>Initial Quantity</th>
						<th>Dealt Quantity</th>
						<th>Price</th>
						<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Order>orders = (List<Order>)request.getAttribute("orders");
							for(int i = 0; i < orders.size(); i ++){
								String type = "";
								String status = "";
								if( orders.get(i).getType() == 0)
									type = "Buy";
								else
									type = "Sell";
								if(orders.get(i).getStatus() == 0)
									status = "not dealt";
								if(orders.get(i).getStatus() == 1)
									status = "partly dealt";
								if(orders.get(i).getStatus() == 2)
									status = "dealt";
								
						%>		
							<tr>
								<td><%=type %></td>
								<td><%=orders.get(i).getCommodityName() %></td>
								<td><%=orders.get(i).getPeriod() %></td>
								<td><%=orders.get(i).getBrokerID() %></td>
								<td><%=orders.get(i).getInitQty() %></td>
								<td><%=orders.get(i).getDealtQty() %></td>
								<td><%=orders.get(i).getPrice() %></td>
								<td><%=status %></td>
								
							</tr>
						<%
						
							}
						%>				
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div id = "pagefooter"></div>
</div>
</body>
</html>