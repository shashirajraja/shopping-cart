<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>Shoping Center</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   <link rel="stylesheet" href="css/changes.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<!--Company Header Starting  -->
<div class="jumbotron text-center">
  <h1>Shopping Center</h1>
  <p>We specialize in Electronics</p>
  <form class="form-inline">
    <div class="input-group">
      <input type="text" class="form-control" size="50" placeholder="Search Items" required>
      <div class="input-group-btn">
        <button type="button" class="btn btn-danger">Search</button>
      </div>
    </div>
  </form>
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
      <a class="navbar-brand" href="index.html"><span class="glyphicon glyphicon-home">&nbsp;</span>Shopping Center</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="./LogoutSrv">Logout</a></li>
<!--         <li><a href="./ProfileSrv">Profile</a></li>
 -->        <li><a href="cart.jsp"> <span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;Cart</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
            <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="mobile.jsp">Mobiles</a></li>
            <li><a href="tv.jsp">Tvs</a></li>
            <li><a href="laptop.jsp">Laptops</a></li>
          </ul>
        </li>
        <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
      </ul>
    </div>
  </div>
</nav>
<!-- End of Navigation Bar -->
</body>
</html>