<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/changes.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body style="background: linear-gradient(104.9deg, rgb(255, 95, 162) 2.3%, rgb(254, 201, 154) 92.7%);
">

	<%@ include file="header.jsp"%>
	<%
	String message = request.getParameter("message");
	%>
	<div class="container">
		<div class="row"
			style="margin-top: 5px; margin-left: 2px; margin-right: 2px;">

			<form action="./RegisterSrv" method="post"
				class="col-md-6 col-md-offset-3"
				style="border: 2px solid black; border-radius: 10px; background-color: #fdfdcb; padding: 10px;">
				<div style="font-weight: bold;" class="text-center">
					<h2 style="color: hotpink;">Registration Form</h2>
					<%
					if (message != null) {
					%>
					<p style="color:#FF00BF;">
						<%=message%>
					</p>
					<%
					}
					%>
				</div>
				<div></div>
				<div class="row">
					<div class="col-md-6 form-group">
						<label for="first_name" style="color: hotpink;">Name</label> <input type="text"
							name="username" class="form-control" id="first_name"
							name="first_name" required>
					</div>
					<div class="col-md-6 form-group">
						<label for="last_name" style="color: hotpink;">Email</label> <input type="email"
							name="email" class="form-control" id="last_name" name="last_name"
							required>
					</div>
				</div>
				<div class="form-group">
					<label for="last_name" style="color: hotpink;">Address</label>
					<textarea name="address" class="form-control" id="last_name"
						name="last_name" required></textarea>
				</div>
				<div class="row">
					<div class="col-md-6 form-group">
						<label for="last_name" style="color: hotpink;">Mobile</label> <input type="number"
							name="mobile" class="form-control" id="last_name"
							name="last_name" required>
					</div>
					<div class="col-md-6 form-group">
						<label for="last_name" style="color: hotpink;">Pin Code</label> <input type="number"
							name="pincode" class="form-control" id="last_name"
							name="last_name" required>
					</div>

				</div>
				<div class="row">
					<div class="col-md-6 form-group">
						<label for="last_name" style="color: hotpink;">Password</label> <input type="password"
							name="password" class="form-control" id="last_name"
							name="last_name" required>
					</div>
					<div class="col-md-6 form-group">
						<label for="last_name" style="color: hotpink;">Confirm Password</label> <input
							type="password" name="confirmPassword" class="form-control"
							id="last_name" name="last_name" required>
					</div>
				</div>
				<div class="row text-center">
					<div class="col-md-6" style="margin-bottom: 2px;">
						<button type="Reset" class="btn btn-danger" style="background-color: #ff347f; color: black;">Reset</button>
					</div>
					<div class="col-md-6">
						<button type="submit" class="btn btn-success" style="background-color: #ff347f; color: black;">Register</button>
					</div>
				</div>
			</form>
		</div>
	</div>


	<%@ include file="footer.html"%>
</body>
</html>
