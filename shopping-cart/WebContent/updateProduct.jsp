<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*, com.shashi.beans.*,com.shashi.dao.*" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	/* Checking the user credentials */
		String utype = (String)session.getAttribute("usertype");
		String uname = (String)session.getAttribute("username");
		String pwd = (String)session.getAttribute("password");
	
		if(utype== null || !utype.equals("admin")){
			
			response.sendRedirect("loginFirst.jsp");
			
		}
		
		else if(uname == null || pwd==null){
	
			response.sendRedirect("loginFirst.jsp");
			
		}	
		
		
		String prodid = request.getParameter("prodid");
		
		ProductBean product = new ProductDaoImpl().getProductDetails(prodid);
		
		
		if(prodid != null && product !=null){
			//out.println("Product ID: "+prodid);
			
	%>
	
	<%@ include file="adminHeader.html" %>
	
	<div class="products" style="background-color: #E6F9E6;">
	
		<p id="message" class="tab" align="center">
			
			Update Product
			<!-- <form>
			<button type="submit" formaction="addProduct.jsp" style="background-color:red; color:white">Add products</button>
			<button type="submit" formaction="#">Remove Products</button>
			<button type="submit" formaction="#">Update Products</button>
			</form> -->
		
		</p><br>
		
		<div class="tab" align="center">
			
		<div style="margin: 5px">
      
        <form action="./UpdateProductSrv" method="post" >
        	<input type="hidden" name="pid" value="<%=product.getProdId() %>">
          <table border="0">
            <tr><td>Product Name: </td><td><input type="text" name="name"style="font-size: 15px;font-weight: normal; width:80%" value="<%=product.getProdName() %>" required></td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr><td>Product Type&nbsp;</td><td><select name="type" style="font-size: 15px;font-weight: normal; width:80%" value="<%=product.getProdType() %>">
            				<option value="mobile">Mobile</option>
            				<option value="tv">Tv</option>
            				<option value="camera">Camera</option>
            				<option value="laptop">Laptop</option>
            				<option value="tablet">Tablet</option>
            				<option value="speaker">Speaker</option>
            				<option value="other">Some Other Appliances</option>
            							</select></td></tr>
            <tr><td><br></td><td><br></td></tr>            
            <tr><td>Detail Info</td><td><textarea name="info"style="font-size: 15px;font-weight: normal;width: 80%; height: 80px" required><%=product.getProdInfo() %></textarea></td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr><td>Price</td><td><input type="text" name="price"style="font-size: 15px;font-weight: normal; width:80%;" value="<%=product.getProdPrice() %>" required></td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr><td>Quantity</td><td><input type="number" name="quantity" style="font-size: 15px;font-weight: normal; width:80%" value="<%=product.getProdQuantity() %>" required></td></tr>
            <tr><td><br></td><td><br></td></tr>
            <tr><td>Picture</td><td>
            	<img src="./ShowImage?pid=<%=product.getProdId() %>" alt="Product Image" width="200px" height="200px"/></td></tr>
                        <tr><td><br></td><td><br></td></tr>
            <tr colspan="2" align="center"><td><button><a href="adminHome.jsp">Cancle</a></button>&nbsp;</td>
            			<td><input type="submit" name="submit" value="Update Product"></td></tr>

          </table>
        
        </form>
    </div>  

		</div>
	</div>
	
	<%@ include file="footer.html" %>
	
	<%
	
		}
		else{
	%>
		<%@ include file="adminHome.jsp" %>
	<%
		}
	%>
</body>
</html>