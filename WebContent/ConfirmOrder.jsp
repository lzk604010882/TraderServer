<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<li><a href="GetMarketDepthServlet?commodityName=gold">MarketDepth </a></li>
				<li><a href="GetHistoryOrdersServlet">History Orders</a></li>
				<li><a href="GetBestOrdersServlet">Fill Orders</a></li>
				<li><a>Broker Information</a></li>
			</ul>
	</div>
	<div id="pagebody">
		<form method = "post" action="SendOrderServlet" class="pure-skin-mine pure-form">
		<div id="formdiv">
			<div id = "inputdiv">
				<table class="pure-table pure-table-horizontal" id="orderinfo">
					<thead>
						<tr>
						<th><%=request.getAttribute("commodityName") %></th>
						<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Period:</td>
							<td><%=request.getAttribute("period") %></td>
						</tr>
						<tr>
							<td>Price:</td>
							<td><%=request.getAttribute("price") %></td>
						</tr>
						<tr>
							<td>Quantity:</td>
							<td><%=request.getAttribute("qty") %></td>
						</tr>
						<tr>
							<td>Broker:</td>
							<td><%=request.getAttribute("broker") %></td>
						</tr>
					</tbody>
				</table>
			</div>
			<input type="hidden" name="commodityName" value=<%=request.getAttribute("commodityName") %> />
			<input type="hidden" name="price" value=<%=request.getAttribute("price") %> />
			<input type="hidden" name="qty" value=<%=request.getAttribute("qty") %> />
			<input type="hidden" name="broker" value=<%=request.getAttribute("broker") %> />
			<input type="hidden" name="period" value=<%=request.getAttribute("period") %> />
			<input type="hidden" name="type" value=<%=request.getAttribute("type") %> />
			<input type="submit" value="Confirm" class="pure-button pure-skin-mine"/>
			<input type="button" value="Back" class="pure-button pure-skin-mine"/>
		</div>
		</form>
	</div>
	<div id = "pagefooter"></div>
</div>
</body>
</html>