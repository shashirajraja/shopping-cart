<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.shashi.service.impl.*, com.shashi.service.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>Least Selling Products</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/changes.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #E6F9E6;">

    <% /* Checking the user credentials */ %>
    <% String userType = (String) session.getAttribute("usertype"); %>
    <% String userName = (String) session.getAttribute("username"); %>
    <% String password = (String) session.getAttribute("password"); %>

    <% if (userName == null || password == null) { %>
        <% response.sendRedirect("login.jsp?message=Session Expired, Login Again!!"); %>
    <% } %>

    <jsp:include page="header.jsp" />

    <div class="text-center" style="color: black; font-size: 14px; font-weight: bold;">Best Selling Products</div>

    <!-- Fetch best selling products using the ProductServiceImp -->
    <% ProductServiceImpl prodDao = new ProductServiceImpl(); %>
    <% List<ProductBean> bestSellingProducts = prodDao.getBestSelling(); %>
    <% out.println("Number of best selling products: " + bestSellingProducts.size()); %>

    <!-- Display best selling products -->
    <div class="container" style="background-color: #E6F9E6;">
        <div class="row text-center">
            <% for (ProductBean product : bestSellingProducts) { %>
                <div class="col-sm-4" style='height: 350px;'>
                    <div class="thumbnail">
                        <img src="./ShowImage?pid=<%=product.getProdId()%>" alt="Product" style="height: 150px; max-width: 180px;">
                        <p class="productname"><%=product.getProdName()%> (<%=product.getProdId()%>)</p>
                        <p class="productinfo"><%=product.getProdInfo()%></p>
                        <p class="price">Rs <%=product.getProdPrice()%></p>
                    </div>
                </div>
            <% } %>
        </div>
    </div>

    <%@ include file="footer.html"%>

</body>
</html>
