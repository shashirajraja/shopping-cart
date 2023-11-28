<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.shashi.service.impl.*, com.shashi.service.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Concordia Cart</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/changes.css?cache_num=<%=Math.random()%>">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	</head>

	<body>
	
		<%
		/* Checking the user credentials */
		String userName = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
	
		if (userName == null || password == null) {
			response.sendRedirect("login.jsp?message=Session Expired, Login Again!!");
		}
	
		ProductServiceImpl prodDao = new ProductServiceImpl();
		List<ProductBean> products = new ArrayList<ProductBean>();
		
		List<ProductBean> mostSellingProd = new ArrayList<ProductBean>();
		mostSellingProd = prodDao.getMostSellingProducts();
		boolean mostFlag = false;
	
		String search = request.getParameter("search");
		String type = request.getParameter("type");
		String message = "All Products";

		if (search != null) {
			products = prodDao.searchAllProducts(search);
			message = "Showing Results for '" + search + "'";
		} else if (type != null) {
			products = prodDao.getAllProductsByType(type);
			message = "Showing Results for '" + type + "'";
		} else {
			products = prodDao.getAllProducts();
		}

		if (products.isEmpty()) {
			message = "No items found for the search '" + (search != null ? search : type) + "'";
			products = prodDao.getAllProducts();
		}
		%>
	
		<jsp:include page="header.jsp" />
	
		<div class="text-center" style="color: black; font-size: 14px; font-weight: bold;"><%=message%></div>

		<!-- Start of Product Items List -->
		<div class="container">
			<div class="row text-center">
	
				<%
				for (ProductBean product : products) {
					for (ProductBean mostProd : mostSellingProd) {
						if (product.getProdId().equals(mostProd.getProdId()))	
							mostFlag = true;
					}
					int cartQty = new CartServiceImpl().getCartItemCount(userName, product.getProdId());
				%>

				<div class="col-sm-4" style='height: 350px;'>
					<div class="thumbnail">
					
						<%
							if (mostFlag == true) {	
						%>
						<p id="best-selling" style="padding: 0 0.5em 0 0.5em; color: #000000; font-weight: bold;">BEST SELLING!</p>
						<%
							} 
						%>
						
						<img src="./ShowImage?pid=<%=product.getProdId()%>" alt="Product" style="height: 150px; max-width: 180px">
						
						<p class="productname"><%=product.getProdName()%></p>
						
						<%
						String description = product.getProdInfo();
						description = description.substring(0, Math.min(description.length(), 100));
						%>
						
						<p class="productinfo"><%=description%>..</p>
						
						<p class="price">$<%=product.getProdPrice()%></p>
						
						<form method="post">
							<% if (cartQty == 0) { %>

							<button type="submit"
									formaction="./AddtoCart?uid=<%=userName%>&pid=<%=product.getProdId()%>&pqty=1"
									class="btn btn-success"
							>
							Add to Cart
							</button>
							&nbsp;&nbsp;&nbsp;
							<button type="submit"
									formaction="./AddtoCart?uid=<%=userName%>&pid=<%=product.getProdId()%>&pqty=1"
									class="btn btn-primary"
							>
							Buy Now
							</button>
							
							<% } else { %>
							
							<button type="submit"
									formaction="./AddtoCart?uid=<%=userName%>&pid=<%=product.getProdId()%>&pqty=0"
									class="btn btn-danger"
							>
							Remove From Cart
							</button>
							&nbsp;&nbsp;&nbsp;
							<button type="submit" formaction="cartDetails.jsp" class="btn btn-success">Checkout</button>
							
							<% } %>
						</form>
						<br />
					</div>
				</div>
				<% mostFlag = false; } %>
			</div>
		</div>
		
		<!-- ENd of Product Items List -->
	
		<%@ include file="footer.html"%>
	
	</body>
</html>