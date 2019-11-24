<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Denied</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<%@ include file="header.html" %>
	
	<!-- <div class="product">
	
		<div class="tab" align="center" style="color:red">
			
			<h1>Login Credentials Failed, Please Login First!</h1>
		
		</div>
	</div>
	 -->
<div class="products" style="background-color: #E6F9E6;">

	<p class="tab"  align="center" style="color:brown;" id="message">Login Credential Failed, Please Login First!</p><br>
  <div class="tab"  align="center">
    
    <div style="margin: 5px">
      
        <form action="./LoginSrv" method="post">
          Username: <input type="text" name="username"style="font-size: 15px;font-weight: normal;" placeholder="Enter Email-Id" required><br/><br/>
          Password: <input type="password" name="password"style="font-size: 15px;font-weight: normal;" placeholder="Enter Password" required><br/><br/>
          Login As: <select name="usertype" style="font-size: 16px;" required>
                      <option value="customer">Customer</option>
                      <option value="admin">Admin</option>
                    </select> 
                    &nbsp;&nbsp;
                    <input type="submit" value=" Login ">
        </form>
    </div>  
  </div>
  <div class="tab" style="margin-top: 10px;text-align: center">
      <a href="register.html">New User ? Register Here</a>

  </div>
</div>
	
	<%@ include file="footer.html" %>

</body>
</html>