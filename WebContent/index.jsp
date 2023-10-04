<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.shashi.service.impl.*, com.shashi.service.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*"%>
	<%
	/* Checking the user credentials */
	String userName = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");
	String userType = (String) session.getAttribute("usertype");

	boolean isValidUser = true;

	if (userType == null || userName == null || password == null || !userType.equals("customer")) {

		isValidUser = false;
	}

	ProductServiceImpl prodDao = new ProductServiceImpl();
	List<ProductBean> products = new ArrayList<ProductBean>();

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

	<% request.setAttribute("pageTitle", "Concordia Shopping"); %>
	<jsp:include page="header.jsp" />

	<div class="text-center"
		style="color: black; font-size: 20px; font-weight: bold;"><%=message%></div>
	<div class="text-center" id="message"
		style="color: black; font-size: 20px; font-weight: bold;"></div>
	<!-- Filter Section -->
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h3>Filter by Category:</h3>
				<select id="categoryFilter">
					<option value="all">All Categories</option>
					<option value="category1">Category 1</option>
					<option value="category2">Category 2</option>
					<!-- Add more categories as needed -->
				</select>
			</div>
			<div class="col-md-4">
				<h3>Filter by Price:</h3>
				<input type="number" id="minPrice" placeholder="Min Price">
				<input type="number" id="maxPrice" placeholder="Max Price">
			</div>
			<div class="col-md-4">
				<h3>Filter by Tags:</h3>
				<label><input type="checkbox" class="tagFilter" value="discounted"> Discounted</label>
				<label><input type="checkbox" class="tagFilter" value="used"> Used</label>
				<!-- Add more tags as needed -->
			</div>
		</div>
	</div>
	<!-- Start of Product Items List -->
	<div class="container">
		<div class="row text-center">

			<%
			for (ProductBean product : products) {
				int cartQty = new CartServiceImpl().getCartItemCount(userName, product.getProdId());
			%>
			<div class="col-sm-4" style='height: 350px;'>
				<div class="thumbnail">
					<img src="./ShowImage?pid=<%=product.getProdId()%>" alt="Product"
						style="height: 150px; max-width: 180px">
					<p class="productname"><%=product.getProdName()%>
					</p>
					<%
					String description = product.getProdInfo();
					description = description.substring(0, Math.min(description.length(), 100));
					%>
					<p class="productinfo"><%=description%>..
					</p>
					<p class="price">
						<%=product.getProdPrice()%> CAD$
					</p>
					<div>
						<span class="tag discounted">Discounted</span>
						<span class="tag used">Used</span>
						<style>
							/* Adding CSS for tags */
							.tag {
								display: inline-block;
								padding: 5px 10px;
								background-color: #FF5733; /* Background color for the tags */
								color: #FFFFFF; /* Text color for the tags */
								font-size: 12px;
								margin-right: 5px;
								margin-bottom: 10px;
								border-radius: 3px;
							}

							.tag.discounted {
								background-color: #FF5733; /* Customize the color for discounted items */
							}

							.tag.used {
								background-color: #3333FF; /* Customize the color for used items */
							}
						</style>
					</div>
					<form method="post">
						<%
						if (cartQty == 0) {
						%>
						<button type="submit"
							formaction="./AddtoCart?uid=<%=userName%>&pid=<%=product.getProdId()%>&pqty=1"
							class="btn btn-success">Add to Cart</button>
						&nbsp;&nbsp;&nbsp;
						<button type="submit"
							formaction="./AddtoCart?uid=<%=userName%>&pid=<%=product.getProdId()%>&pqty=1"
							class="btn btn-primary">Buy Now</button>
						<%
						} else {
						%>
						<button type="submit"
							formaction="./AddtoCart?uid=<%=userName%>&pid=<%=product.getProdId()%>&pqty=0"
							class="btn btn-danger">Remove From Cart</button>
						&nbsp;&nbsp;&nbsp;
						<button type="submit" formaction="cartDetails.jsp"
							class="btn btn-success">Checkout</button>
						<%
						}
						%>
					</form>
					<br />
				</div>
			</div>

			<%
			}
			%>

		</div>
	</div>
	<!-- ENd of Product Items List -->


	<%@ include file="footer.jsp"%>

</body>
</html>