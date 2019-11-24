<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.shashi.dao.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Online Shopping Card</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   <link rel="stylesheet" href="css/changes.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
</head>
<body>

	<%
	/* Checking the user credentials */
		String userName = (String)session.getAttribute("username");
		String password = (String)session.getAttribute("password");
	
		if(userName == null || password==null){
	
			response.sendRedirect("loginFirst.jsp");
		}	
		
		String sAmount = request.getParameter("amount");
		
		double amount = 0;
		
		if(sAmount != null){
			amount = Double.parseDouble(sAmount);
		}
		
		
		
	%>



<%@ include file="userHeader.jsp" %>

	<!-- <script>document.getElementById('mycart').innerHTML='<i data-count="20" class="fa fa-shopping-cart fa-3x icon-white badge" style="background-color:#333;margin:0px;padding:0px; margin-top:5px;"></i>'</script>
 -->
<!-- Start of Product Items List -->

<div class="products" style="background-color: #E6F9E6;">
	<p class="tab"  align="center" style="color:brown;" id="message">Credit Card Payment</p>

  <div class="tab"  align="center">
    
    <div style="margin: 5px">
      
        <form action="./OrderServlet" method="post">
          <table border="0">
            <tr><td>Name on Card: </td><td><input type="text" name"cardname" style="font-size: 15px;font-weight: normal;" placeholder="John More Doe" required>
</td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr><td>Credit Card Number:</td><td><input type="number" name="ccnum"style="font-size: 15px; font-weight: normal;" placeholder="1111-2222-3333-4444" required></td></tr>
            <tr><td><br></td><td><br></td></tr>            
            <tr><td>Exp Month: </td><td><input type="number" name="expm"style="font-size: 15px; font-weight: normal;" placeholder="12" maxlength="2" required></td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr><td> CVV:</td><td><input type="number" name="cvv"style="font-size: 15px; font-weight: normal;" placeholder="325" maxlength="3" required></td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr><td>Exp Year: </td><td><input type="number" name="expyr"style="font-size: 15px; font-weight: normal;" placeholder="2026" maxlength="4" required></td></tr>
            <tr><td><br></td><td><input type="hidden" name="amount" value="<%=amount%>"/><br></td></tr>
            <tr colspan="2" align="center"><td>&nbsp;</td><td><input type="submit" name="submit" value="Pay :Rs <%=amount%>" style="background-color:red;color:white;"></td></tr>

          </table>
        
        </form>
    </div>  
  </div>
 </div>


    
    
<!-- ENd of Product Items List -->


<%@ include file="footer.html" %>

</body>
</html>