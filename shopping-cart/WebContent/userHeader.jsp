<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.shashi.service.impl.*, com.shashi.service.*"%>
<!DOCTYPE html>
<html>
<head>
<title>User Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/changes.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<%
	int notf = new CartServiceImpl().getCartCount((String) session.getAttribute("username"));
	%>
	<!--Company Header Starting  -->
	<div class="container-fluid text-center"
		style="margin-top: 45px; background-color: #33cc33; color: white; padding: 5px;">
		<h2>Ellison Electronics</h2>
		<h6>We specialize in Electronics</h6>
		<form class="form-inline" action="userHome.jsp" method="get">
			<div class="input-group">
				<input type="text" class="form-control" size="50" name="search"
					placeholder="Search Items" required>
				<div class="input-group-btn">
					<input type="submit" class="btn btn-danger" value="Search" />
				</div>
			</div>
		</form>
		<p align="center"
			style="color: blue; font-weight: bold; margin-top: 5px; margin-bottom: 5px;"
			id="message"></p>
	</div>
	<!-- Company Header Ending -->

	<!-- Starting Navigation Bar -->
	<nav class="navbar navbar-default navbar-fixed-top">

		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="userHome.jsp"><span
					class="glyphicon glyphicon-home">&nbsp;</span>Shopping Center</a>
			</div>

			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="userHome.jsp"><span
							class="glyphicon glyphicon-home">Products</span></a></li>
					<li><a href="orderDetails.jsp">Orders</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Category <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="userHome.jsp?type=mobile">Mobiles</a></li>
							<li><a href="userHome.jsp?type=tv">Tvs</a></li>
							<li><a href="userHome.jsp?type=laptop">Laptops</a></li>
						</ul></li>
					<!--         <li><a href="./ProfileSrv">Profile</a></li> -->
					<%
					if (notf == 0) {
					%>
					<li><a href="cartDetails.jsp"> <span
							class="glyphicon glyphicon-shopping-cart"></span>Cart
					</a></li>

					<%
					} else {
					%>
					<li><a href="cartDetails.jsp"
						style="margin: 0px; padding: 0px;" id="mycart"><i
							data-count="<%=notf%>"
							class="fa fa-shopping-cart fa-3x icon-white badge"
							style="background-color: #333; margin: 0px; padding: 0px; padding-bottom: 0px; padding-top: 5px;">
						</i></a></li>
					<%
					}
					%>

					<li><a href="userProfile.jsp">Profile</a></li>
					<li><a href="./LogoutSrv">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>


</body>
</html>