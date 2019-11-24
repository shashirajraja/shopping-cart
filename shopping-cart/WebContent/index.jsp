<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.shashi.dao.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ellison Electronics</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   <link rel="stylesheet" href="css/changes.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<%
	/* Checking the user credentials */
		String userName = (String)session.getAttribute("username");
		String password = (String)session.getAttribute("password");
		String userType = (String)session.getAttribute("usertype");
	
		boolean isValidUser = true;
		
		if(userType == null || userName == null || password==null || !userType.equals("customer")){
	
			isValidUser = false;
		}	
		
	%>


<%
	if(isValidUser) {
%>
<%@ include file="userHeader.html" %>

<%
	}
	else{
%>
<%@ include file="header.html" %>
<%
	}
%>

<!-- Start of Product Items List -->
<div class="products" style="background-color: #E6F9E6;">
<div class="row text-center" >

  <%
  
  	ProductDaoImpl prodDao = new ProductDaoImpl(); 
  	
  	List<ProductBean> products = new ArrayList<ProductBean>();
  	
  	products = prodDao.getAllProducts();
  	
  	for(ProductBean product : products){
  	
  		String addToCartUrl = null;
  		String buyNowUrl = null;
  		
  		if(isValidUser){
  			addToCartUrl = "./AddtoCart?uid="+userName+"&pid="+product.getProdId()+"";
  			buyNowUrl = "./BuyNow?uid="+userName+"&pid="+product.getProdId()+"";
  		}
  		else{
  			addToCartUrl = "login.html";
  			buyNowUrl = "login.html";
  		}
  		
  %>
  
  <div class="col-sm-4">
    <div class="thumbnail">
      <img src="./ShowImage?pid=<%=product.getProdId() %>" alt="Product" style="height:200px; max-width:200px; max-width:300px;">
      <p class="productname"><%=product.getProdName() %> ( <%=product.getProdId() %> ) </p>
      <p class="productinfo"><%=product.getProdInfo() %></p>
      <p class="price">Rs <%=product.getProdPrice() %> </p>
      <form method="post">
      	<button type="submit" formaction="<%= addToCartUrl%>">Add to Cart</button>&nbsp;&nbsp;&nbsp;
      	<button type="submit" formaction="<%= buyNowUrl%>">Buy Now</button>
      </form>
    </div>
  </div>
  
  <%
  
  	}
  
  %>
  
</div>
</div>
<!-- ENd of Product Items List -->


<%@ include file="footer.html" %>

</body>
</html>