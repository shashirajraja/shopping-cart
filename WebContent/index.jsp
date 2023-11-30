<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.shashi.service.impl.*, com.shashi.service.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Ellison Electronics</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/changes.css">
<style>
    body {
        background-color: #510400;
    }
    .product-status {
        padding: 5px;
        margin-top: 5px;
        background-color: #f2f2f2; 
        box-shadow: 0 2px 4px rgba(0,0,0,0.1); 
        border-radius: 4px; 
        text-align: center;
        font-weight: bold;
    }
    .thumbnail {
        position: relative;
        padding: 10px;
        background-color: #fff; /* White background for product thumbnail */
        border: 1px solid #ddd; /* Thin border */
        border-radius: 4px; /* Slightly rounded corners for the thumbnail */
        margin-bottom: 20px; /* Spacing between thumbnails */
        box-shadow: 0 2px 4px rgba(0,0,0,0.2); /* Shadow for the thumbnail */
    }
    .product-status {
        position: absolute;
        top: 10px;
        left: 10px;
        padding: 5px 10px;
        background-color: #f2f2f2; /* Light grey background */
        box-shadow: 0 2px 4px rgba(0,0,0,0.1); /* Subtle shadow */
        border-radius: 4px; /* Slightly rounded corners */
        text-align: center;
        font-weight: bold;
        font-size: 0.8em;
    }
    .used-product {
        background-color: #ffdede; /* Light red for used products */
    }
    .new-product {
        background-color: #defde0; /* Light green for new products */
    }
    .custom-product {
    top:50px;
    margin-top: 20px;
        background-color: #e0eaff; /* Light blue for custom products */
    }
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body style="background: linear-gradient(104.9deg, rgb(255, 95, 162) 2.3%, rgb(254, 201, 154) 92.7%);
">

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

	<jsp:include page="header.jsp" />

	<div class="text-center"
		style="color: black; font-size: 14px; font-weight: bold;"><%=message%></div>
	<div class="text-center" id="message"
		style="color: black; font-size: 14px; font-weight: bold;"></div>
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
						Rs
						<%=product.getProdPrice()%>
					</p>
					
					
					
					<form method="post">
						<%
						if (cartQty == 0) {
						%>
						<button type="submit"
							formaction="./AddtoCart?uid=<%=userName%>&pid=<%=product.getProdId()%>&pqty=1"
							class="btn btn-success" style="background-color: #FFC0CB; color: black;">Add to Cart</button>
						&nbsp;&nbsp;&nbsp;
						
						<%
						} else {
						%>
						<button type="submit"
							formaction="./AddtoCart?uid=<%=userName%>&pid=<%=product.getProdId()%>&pqty=0"
							class="btn btn-danger" style="background-color: #F9629F; color: black;">Remove From Cart</button>
						&nbsp;&nbsp;&nbsp;
						<button type="submit" formaction="cartDetails.jsp"
							class="btn btn-success" style="background-color: #FFC0CB; color: black;">Checkout</button>
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


	<%@ include file="footer.html"%>

</body>
</html>
