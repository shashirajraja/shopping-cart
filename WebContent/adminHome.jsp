<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.shashi.service.impl.*, com.shashi.service.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*"%>
	<%
	/* Checking the user credentials */
	String userType = (String) session.getAttribute("usertype");
	String userName = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");

	if (userType == null || !userType.equals("admin")) {

		response.sendRedirect("login.jsp?message=Access Denied, Login as admin!!");

	}

	else if (userName == null || password == null) {

		response.sendRedirect("login.jsp?message=Session Expired, Login Again!!");

	}
	%>

	<% request.setAttribute("pageTitle", "Admin Home"); %>
	<jsp:include page="header.jsp" />

	<div class="products" style="background-color: #E6F9E6;">

		<div class="tab" align="center">
			<form>
				<button type="submit" formaction="adminViewProduct.jsp">View
					products</button>
				<br>
				<br>
				<button type="submit" formaction="addProduct.jsp">Add
					products</button>
				<br>
				<br>
				<button type="submit" formaction="removeProduct.jsp">Remove
					Products</button>
				<br>
				<br>
				<button type="submit" formaction="updateProductById.jsp">Update
					Products</button>
				<br>
				<br>
			</form>
		</div>
	</div>

	<%@ include file="footer.html"%>
</body>
</html>