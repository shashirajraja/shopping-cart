<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoping</title>
<link href="../css/changes.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.html" %>
	
  <div class="products">
	
	<div class="tab" align="center" style="color:brown;">
			<%=request.getAttribute("message") %>
	</div>
	<br>
	
  	<div class="tab"  align="center">
    
      <div style="margin: 5px">
      
        <form action="adminlog" method="post">
          Username: <input type="text" name="username"style="font-size: 15px;font-weight: normal;" placeholder="Enter Email-Id"><br/><br/>
          Password: <input type="password" name="password"style="font-size: 15px;font-weight: normal;" placeholder="Enter Password"><br/><br/>
          Login As: <select name="usertype" style="font-size: 16px;">
                      <option value="Customer">Customer</option>
                      <option value="Admin">Admin</option>
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