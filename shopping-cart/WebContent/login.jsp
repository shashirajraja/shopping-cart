<!DOCTYPE html>
<html>
<head>
<title>Online Shopping Card</title>
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
      <input type="email" class="form-control" size="50" placeholder="Search Items" required>
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
      <a class="navbar-brand" href="#">Shopping Center</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#home">HOME</a></li>
        <li><a href="#band">Products</a></li>
        <li><a href="#contact">CONTACT</a></li>
        <li><a href="#tour">Login</a></li>
        <li><a href="">Register</a></li>
        <li><a href=""> <span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
            <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="#">Mobiles</a></li>
            <li><a href="#">Tvs</a></li>
            <li><a href="#">Laptops</a></li>
          </ul>
        </li>
        <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
      </ul>
    </div>
  </div>
</nav>
<!-- End of Navigation Bar -->

<!-- Start of Product Items List -->
<div class="products">
<div class="row text-center">
  <div class="col-sm-4">
    <div class="thumbnail">
      <img src="images/sanfran.jpg" alt="Paris">
      <p><strong>Paris</strong></p>
      <p>Fri. 27 November 2015</p>
      <button class="btn" >Buy Tickets</button>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="thumbnail">
      <img src="images/sanfran.jpg" alt="New York">
      <p><strong>New York</strong></p>
      <p>Sat. 28 November 2015</p>
      <button class="btn">Buy Tickets</button>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="thumbnail">
      <img src="images/sanfran.jpg" alt="San Francisco">
      <p><strong>San Francisco</strong></p>
      <p>Sun. 29 November 2015</p>
      <button class="btn">Buy Tickets</button>
    </div>
  </div>
</div>
</div>
<!-- ENd of Product Items List -->


<!-- Start the footer Contacts -->
<a name="contact"></a>
<div class="container">
  <h3 class="text-center">Contact</h3>
  <p class="text-center"><em>We love our fans!</em></p>
  <div class="row test">
    <div class="col-md-4">
      <p>Fan? Drop a note.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span>Chicago, US</p>
      <p><span class="glyphicon glyphicon-phone"></span>Phone: +00 1515151515</p>
      <p><span class="glyphicon glyphicon-envelope"></span>Email: mail@mail.com</p>
    </div>
    <div class="col-md-8">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn pull-right" type="submit">Send</button>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End of Contact or about us -->

</body>
</html>