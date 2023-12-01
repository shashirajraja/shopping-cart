<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.shashi.service.impl.*, com.shashi.service.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Product for sale</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/changes.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #E6F9E6;">
	<%
	/* Checking the user credentials */
	String utype = (String) session.getAttribute("usertype");
	String uname = (String) session.getAttribute("username");
	String pwd = (String) session.getAttribute("password");
	String prodid = request.getParameter("prodid");
	ProductBean product = new ProductServiceImpl().getProductDetails(prodid);
	if (prodid == null || product == null) {
		response.sendRedirect("updateProductById.jsp?message=Please Enter a valid product Id");
		return;
	} else if (utype == null || !utype.equals("admin")) {
		response.sendRedirect("login.jsp?message=Access Denied, Login as admin!!");
		return;
	} else if (uname == null || pwd == null) {
		response.sendRedirect("login.jsp?message=Session Expired, Login Again!!");
		return;
	}
	%>

	<jsp:include page="header.jsp" />

	<%
	String message = request.getParameter("message");
	%>
	<div class="container">
		<div class="row"
			style="margin-top: 5px; margin-left: 2px; margin-right: 2px;">
			<form action="adminViewProduct.jsp?prodid=<%=product.getProdId()%>" method="post"
				class="col-md-6 col-md-offset-3"
				style="border: 2px solid black; border-radius: 10px; background-color: #FFE5CC; padding: 10px;">
				<div style="font-weight: bold;" class="text-center">
					<div class="form-group">
						<img src="./ShowImage?pid=<%=product.getProdId()%>"
							alt="Product Image" height="100px" />
						<h2 style="color: green;">Enter discount amount</h2>
					</div>

					<%
					if (message != null) {
					%>
					<p style="color: blue;">
						<%=message%>
					</p>
					<%
					}
					%>
				</div>
				
				<div class="row">
					<div class="col-md-6 form-group">
						<input type="text" id="dollarDiscount" name="dollarDiscount" oninput="updateDiscountedPrice()"><label>$</label> 
					</div>
					<div class="col-md-6 form-group">
						<input type="text" id="percentageDiscount" name="percentageDiscount" oninput="updateDiscountedPrice()"><label>%</label> 
					</div>
				</div>
				
				<div class="row text-center">
					<div class="col-md-4" style="margin-bottom: 2px;">
						<button class="btn btn-danger" onclick="window.location.href='adminViewProduct.jsp'">Cancel</button>
					</div>
					<div class="col-md-4">
						<button type="submit" class="btn btn-success">OK</button>
					</div>
				</div>
				
				<div class="row text-center">
					<div class="col-md-12">
						<label>Original Price: $<span id="originalPrice"><%=product.getProdPrice()%></span></label>
						<br>
						<label>Price after discount: $<span id="discountedPrice"><%=product.getProdPrice()%></span></label>
					</div>
				</div>

				<!-- Add a hidden field to store the updated price -->
				<input type="hidden" id="updatedPrice" name="updatedPrice" value="<%=product.getProdPrice()%>">
			
			</form>
		</div>
	</div>

	<%@ include file="footer.html"%>

	<script>
		function updateDiscountedPrice() {
			var dollarDiscount = parseFloat($('#dollarDiscount').val());
			var percentageDiscount = parseFloat($('#percentageDiscount').val());
			var originalPrice = parseFloat('<%=product.getProdPrice()%>');

			// Calculate the discounted price
			var discountedPrice;

			if (!isNaN(percentageDiscount) && percentageDiscount >= 0) {
			    // Calculate based on percentage discount
			    discountedPrice = originalPrice - (originalPrice * percentageDiscount / 100);
			} else if (!isNaN(dollarDiscount) && dollarDiscount >= 0) {
			    // Calculate based on dollar discount
			    discountedPrice = originalPrice - dollarDiscount;
			} else {
			    // If neither percentage nor dollar discount is provided or invalid, set discounted price to original price
			    discountedPrice = originalPrice;
			}

			// Update the displayed discounted price
			$('#discountedPrice').text(discountedPrice.toFixed(2));

			// Directly update the displayed price on the page
	        	$('#originalPrice').text(discountedPrice.toFixed(2));
			
	        	// Update the hidden field with the updated price
	        	$('#updatedPrice').val(discountedPrice.toFixed(2));
		}
	</script>
</body>
</html>
