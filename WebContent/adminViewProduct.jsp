<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.shashi.service.impl.*, com.shashi.service.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*"%>

<!DOCTYPE html>
<html>

	<head>
		<title>View Products</title>
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
		String userType = (String) session.getAttribute("usertype");
	
		if (userType == null || !userType.equals("admin")) {
			response.sendRedirect("login.jsp?message=Access Denied, Login as admin!!");
		}
	
		else if (userName == null || password == null) {
			response.sendRedirect("login.jsp?message=Session Expired, Login Again!!");
		}
		
		ProductServiceImpl prodDao = new ProductServiceImpl();
		List<ProductBean> products = new ArrayList<ProductBean>();
		
		List<ProductBean> leastSellingProd = new ArrayList<ProductBean>();
		leastSellingProd = prodDao.getLeastSellingProducts();
		boolean leastFlag = false;
		
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
						for (ProductBean leastProd : leastSellingProd) {
							if (product.getProdId().equals(leastProd.getProdId()))	
								leastFlag = true;
						}
						for (ProductBean mostProd : mostSellingProd) {
							if (product.getProdId().equals(mostProd.getProdId()))	
								mostFlag = true;
						}
						
				%>
					<div class="col-sm-4" style='height: 400px;'>
		
						<div class="thumbnail">
							
							<%
							if (mostFlag == true) {	
							%>
							<p id="best-selling" style="padding: 0 0.5em 0 0.5em; color: #000000; font-weight: bold;">Selling Rank: Best</p>
							<p id="suggested-discount" style="padding: 0 0.5em 0 0.5em; color: #000000; font-weight: bold;">Suggested Discount: <%=prodDao.getSuggestedDiscount(product.getProdPrice(), product.getAmountSold()) %>%</p>
							<%
								} else if (leastFlag == true) {
							%>
							<p id="least-selling" style="padding: 0 0.5em 0 0.5em; color: #000000; font-weight: bold;">Selling Rank: Least</p>
							<p id="suggested-discount" style="padding: 0 0.5em 0 0.5em; color: #000000; font-weight: bold;">Suggested Discount: <%=prodDao.getSuggestedDiscount(product.getProdPrice(), product.getAmountSold()) %>%</p>
							<%
								}
							%>
							
						
							<img src="./ShowImage?pid=<%=product.getProdId()%>" alt="Product" style="height: 150px; max-width: 180px;">

							<!-- Have a low stock message when the stock reaches less than or equal to 5 units -->							
 							<% if (product.getProdQuantity() <= ProductBean.prodLowStockTheshold) { %>
								<span id="low-stock">
									<span style="padding: 0 0.5em 0 0.5em; color: #912338; font-weight: bold;">LOW STOCK</span>
									<span class="badge" style="background-color: #912338;"><%=product.getProdQuantity()%></span>
								</span>							
							<% } %>
							
							<p class="productname"><%=product.getProdName()%> (<%=product.getProdId()%>)</p>
							
							<%
							String description = product.getProdInfo();
							description = description.substring(0, Math.min(description.length(), 100));
							%>
							
							<p class="productinfo"><%=description%></p>
							
							<p class="price">$<%=product.getProdPrice()%></p>
							
							<form method="post">
								<button type="submit" 
										formaction="./RemoveProductSrv?prodid=<%=product.getProdId()%>"
										class="btn btn-danger"
								>
								Remove Product
								</button>
								&nbsp;&nbsp;&nbsp;
								<button type="submit"
										formaction="updateProduct.jsp?prodid=<%=product.getProdId()%>"
										class="btn btn-primary"
								>
								Update Product
								</button>
							</form>
							<br />
						</div>
					</div>
				<% leastFlag = false; mostFlag = false;} %>
			</div>
		</div>

		<!-- ENd of Product Items List -->
	
		<%@ include file="footer.html"%>
	
	</body>
</html>