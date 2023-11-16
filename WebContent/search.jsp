<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page
        import="com.shashi.service.impl.*, com.shashi.service.*,com.shashi.beans.*,java.util.*,javax.servlet.ServletOutputStream,java.io.*"%>
<!DOCTYPE html>
<html>
<head>
  <title>Ellison Electronics</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/changes.css">
  <script
          src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script
          src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid text-center"
     style="margin-top: 45px; background-color: #f2f2f2; color: #f2f2f2; padding: 50px;">
<form class="form-inline" action="index.jsp" method="get">
  <div class="input-group">
    <input type="text" class="form-control" size="50" name="search"
           placeholder="Search Items" required>
    <div class="input-group-btn">
      <input type="submit" class="btn btn-danger" value="Search" />
    </div>
  </div>


</form>
<p align="center"
   style="color: blue; font-weight: bold; margin-top: 5px; margin-bottom: 5px;"
   id="message"></p>
</div>


</body>
</html>
