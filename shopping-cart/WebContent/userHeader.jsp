<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.shashi.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>Ellison Electronics</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/changes.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<%
		 
		int notf = new CartDaoImpl().getCartCount((String)session.getAttribute("username"));
	
	%>
<!--Company Header Starting  -->
<div class="jumbotron text-center">
  <h1>Ellison Electronics</h1>
  <p>We specialize in Electronics</p>
  <form class="form-inline">
    <div class="input-group">
      <input type="text" class="form-control" size="50" placeholder="Search Items" required>
      <div class="input-group-btn">
        <button type="button" class="btn btn-danger">Search</button>
      </div>
    </div>
  </form>
  <p  align="center" style="color:blue;font-weight:bold;margin-top:15px;margin-bottom:-15px;" id="message"></p>
</div>
<!-- Company Header Ending -->

<!-- Starting Navigation Bar -->
<nav class="navbar navbar-default navbar-fixed-top">
	
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-home">&nbsp;</span>Shopping Center</a>  
	</div>      
	
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
              <li><a href="userHome.jsp"><span class="glyphicon glyphicon-home">Home</span></a></li>
<!--         <li><a href="./ProfileSrv">Profile</a></li> -->
			<% 
				if(notf == 0) {
				
			%>
			
			<li> <a href="cartDetails.jsp" style="margin:0px;padding:0px;" id="mycart"><i class="fa fa-shopping-cart fa-3x icon-white" style="background-color:#333;margin:0px;padding:0px; margin-top:5px;" > 
 </i>Cart</a></li>
			
			<%
				}
				else{
			%>
         <li> <a href="cartDetails.jsp" style="margin:0px;padding:0px;" id="mycart"><i data-count="<%=notf %>" class="fa fa-shopping-cart fa-3x icon-white badge" style="background-color:#333;margin:0px;padding:0px; margin-top:5px;" > 
 </i>Cart</a></li>
 				<% 
 					} 
 				%>
 
 		
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
            <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="userHome.jsp">Mobiles</a></li>
            <li><a href="userHome.jsp">Tvs</a></li>
            <li><a href="userHome.jsp">Laptops</a></li>
          </ul>
        </li>
        <li><a href="userHome.jsp">Profile</a></li>
        <li><a href="./LogoutSrv">Logout</a></li>
<!--         <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
 -->      </ul>
    </div>
  </div>
</nav>


</body>
</html>