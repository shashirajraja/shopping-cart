<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.shashi.service.impl.*, com.shashi.beans.*,com.shashi.service.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #E6F9E6;">
	<%
	/* Checking the user credentials */
	String userType = (String) session.getAttribute("usertype");
	String userName = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");

	if (userType == null || !userType.equals("admin")) {

		response.sendRedirect("loginFirst.jsp");

	}

	if (userName == null || password == null) {

		response.sendRedirect("loginFirst.jsp");
	}
	%>

	<%@ include file="adminHeader.html"%>
	<div class="text-center"
		style="color: green; font-size: 24px; font-weight: bold;">Recent
		Orders</div>
	<div class="container">

		<table class="table table-hover">
			<thead
				style="background-color: #700fb7; color: white; font-size: 17px; font-weight: bold;">
				<tr>
					<th>TransactionId</th>
					<th>ProductId</th>
					<th>User Email Id</th>
					<th>Address</th>
					<th>Quantity</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody
				style="background-color: white; font-size: 15px; font-weight: bold;">

				<%
				OrderServiceImpl orderdao = new OrderServiceImpl();

				List<OrderBean> orders = new ArrayList<OrderBean>();
				orders = orderdao.getAllOrders();
				int count = 0;
				for (OrderBean order : orders) {
					String transId = order.getTransactionId();
					String prodId = order.getProductId();
					int quantity = order.getQuantity();
					int shipped = order.getShipped();
					String userId = new TransServiceImpl().getUserId(transId);
					String userAddr = new UserServiceImpl().getUserAddr(userId);
					if (shipped == 0) {
						count++;
				%>

				<tr>
					<td><%=transId%></td>
					<td><a href="./updateProduct.jsp?prodid=<%=prodId%>"><%=prodId%></a></td>
					<td><%=userId%></td>
					<td><%=userAddr%></td>
					<td><%=quantity%></td>
					<td>READY_TO_SHIP</td>
					<td><a
						href="ShipmentServlet?orderid=<%=order.getTransactionId()%>&amount=<%=order.getAmount()%>"
						class="btn btn-success">SHIP NOW</a></td>
				</tr>

				<%
				}
				}
				%>
				<%
				if (count == 0) {
				%>
				<tr style="background-color: grey; color: white;">
					<td colspan="7" style="text-align: center;">No Items Available
					</td>

				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>

	<%@ include file="footer.html"%>
</body>
</html>