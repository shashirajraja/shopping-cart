<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.shashi.service.impl.*, com.shashi.service.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*"%>
	<%
	/* Checking the user credentials */
	String userName = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");

	if (userName == null || password == null) {

		response.sendRedirect("login.jsp?message=Session Expired, Login Again!!");
	}

	String sAmount = request.getParameter("amount");

	double amount = 0;

	if (sAmount != null) {
		amount = Double.parseDouble(sAmount);
	}
	%>
	<% request.setAttribute("pageTitle", "Payments"); %>
	<jsp:include page="header.jsp" />

	<div class="container">
		<div class="row"
			style="margin-top: 5px; margin-left: 2px; margin-right: 2px;">
			<form action="./OrderServlet" method="post"
				class="col-md-6 col-md-offset-3"
				style="border: 2px solid black; border-radius: 10px; background-color: #FFE5CC; padding: 10px;">
				<div style="font-weight: bold;" class="text-center">
					<div class="form-group">
						<img src="images/profile.jpg" alt="Payment Proceed" height="100px" />
						<h2 style="color: green;">Credit Card Payment</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 form-group">
						<label for="last_name">Name of Card Holder</label> <input
							type="text" placeholder="Enter Card Holder Name"
							name="cardholder" class="form-control" id="last_name" required>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 form-group">
						<label for="last_name">Enter Credit Card Number</label> <input
							type="number" placeholder="4242-4242-4242-4242" name="cardnumber"
							class="form-control" id="last_name" required>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 form-group">
						<label for="last_name">Expiry Month</label> <input type="number"
							placeholder="MM" name="expmonth" class="form-control" size="2"
							max="12" min="00" id="last_name" required>
					</div>
					<div class="col-md-6 form-group">
						<label for="last_name">Expiry Year</label> <input type="number"
							placeholder="YYYY" class="form-control" size="4" id="last_name"
							name="expyear" required>
					</div>
				</div>
				<div class="row text-center">
					<div class="col-md-6 form-group">
						<label for="last_name">Enter CVV</label> <input type="number"
							placeholder="123" class="form-control" size="3" id="last_name"
							name="expyear" required> <input type="hidden"
							name="amount" value="<%=amount%>">

					</div>
					<div class="col-md-6 form-group">
						<label>&nbsp;</label>
						<button type="submit" class="form-control btn btn-success">
							Pay :Rs
							<%=amount%></button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- ENd of Product Items List -->


	<%@ include file="footer.jsp"%>

</body>
</html>