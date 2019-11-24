<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ellison Electronics</title>
<link href="../css/changes.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="header.html" %>
	
  <div class="products" style="background-color: #E6F9E6;">
	
	<div class="tab" align="center" style="color:brown;">
			<%=request.getAttribute("message") %>
	</div>
	<br>
	
  	<div class="tab"  align="center">
    
    <div style="margin: 5px">
      
        <form action="./RegisterSrv" method="post">
          <table border="0">
            <tr><td>Name: </td><td><input type="text" name="username"style="font-size: 15px;font-weight: normal; width:100%" required></td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr><td>Mobile No.&nbsp;</td><td><input type="Phone" name="mobile"style="font-size: 15px;font-weight: normal;" required></td></tr>
            <tr><td><br></td><td><br></td></tr>            
            <tr><td>Email Id</td><td><input type="email" name="email"style="font-size: 15px;font-weight: normal;" required></td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr><td>Address</td><td><textarea name="address"style="font-size: 15px;font-weight: normal;width: 100%; height: 80px" required></textarea></td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr><td>PinCode</td><td><input type="text" name="pincode"style="font-size: 15px;font-weight: normal;" required></td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr><td>Password</td><td><input type="password" name="password"style="font-size: 15px;font-weight: normal;" required></td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr colspan="2" align="center"><td>&nbsp;</td><td><input type="submit" name="submit" value="Register"></td></tr>

          </table>
        
        </form>
    </div>  
  </div>
  <div class="tab" style="margin-top: 10px;text-align: center">
      <a href="login.html">Registered User Login Here</a>

  </div>
  
</div>
	
	
	
	<%@ include file="footer.html" %>
</body>
</html>