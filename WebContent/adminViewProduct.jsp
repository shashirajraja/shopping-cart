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
	<!-- Start of Product Items List -->
	<div class="container" style="background-color: #E6F9E6;">
		<div class="row text-center">

			<%
			for (ProductBean product : products) {
			%>
			<div class="col-sm-4" style='height: 350px;'>
				<div class="thumbnail">
					<img src="./ShowImage?pid=<%=product.getProdId()%>" alt="Product"
						style="height: 150px; max-width: 180px;">
					<p class="productname"><%=product.getProdName()%>
						(
						<%=product.getProdId()%>
						)
					</p>
					<p class="productinfo"><%=product.getProdInfo()%></p>
					<p class="price">
						Rs
						<%=product.getProdPrice()%>
					</p>
					<form method="post">
						<button type="submit"
							formaction="./RemoveProductSrv?prodid=<%=product.getProdId()%>"
							class="btn btn-danger">Remove Product</button>
						&nbsp;&nbsp;&nbsp;
						<button type="submit"
							formaction="updateProduct.jsp?prodid=<%=product.getProdId()%>"
							class="btn btn-primary">Update Product</button>
					</form>
				</div>
			</div>

			<%
			}
			%>

		</div>
	</div>
	<!-- ENd of Product Items List -->

	<!-- Notification Modal -->
	<div class="modal fade" id="notificationModal" tabindex="-1" role="dialog" aria-labelledby="notificationModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
							aria-hidden="true">&times;</span></button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="text-center" style="font-size: 20px;">
							<strong>Attention Needed</strong>
						</div>
					</div>
					<div class="row">
						<div class="text-center" style="font-size: 24px; color: #DC1717">
							<strong>LOW ON STOCK PRODUCTS</strong>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<div class="text-center">
						<a href="adminStock.jsp">
							<button type="button" class="btn btn-primary">
								View Products
							</button>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		<%
		if (userType != null && userType.equals("admin")) {
			List<ProductBean> lowStockProduct = prodDao.getLowStockProduct();

			if (!lowStockProduct.isEmpty()) {
		%>
		$('#notificationModal').modal('show');
		<%
			}
		}
		%>
	</script>

	<%@ include file="footer.html"%>

</body>
</html>