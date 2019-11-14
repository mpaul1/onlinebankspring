<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
        <%String invalidloginmsg = ""+session.getAttribute("invalidloginmsg");%>
<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bank of Everyone</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Bank Card Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
	
	<!-- css files -->
    <link href="css/css_slider.css" rel="stylesheet"><!-- Slider css -->
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"><!-- bootstrap css -->
    <link href="css/style.css" rel='stylesheet' type='text/css' /><!-- custom css -->
    <link href="css/font-awesome.min.css" rel="stylesheet"><!-- fontawesome css -->
	<!-- //css files -->
	
	<!-- google fonts -->
	<link href="//fonts.googleapis.com/css?family=Niramit:200,200i,300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext,thai,vietnamese" rel="stylesheet">
	<!-- //google fonts -->
	
</head>
<body>

<!-- header -->
<header>
	<div class="container">
		<!-- nav -->
		<nav class="py-3 d-lg-flex">
			<div id="logo">
				<h1> <a href="index.html"><span class="fa fa-university"></span> Bank of Everyone </a></h1>
			</div>
			<label for="drop" class="toggle"><span class="fa fa-bars"></span></label>
			<input type="checkbox" id="drop" />
			<ul class="menu ml-auto mt-1">
				<li class=""><a href="/index">Home</a></li>
				<li class=""><a href="/about">About</a></li>
				<li class=""><a href="/services">Services</a></li>
				<li class=""><a href="/contact">Contact</a></li>
				<li class="active"><a href="/openaccount"><strong>Open New Account</strong></a></li>
				<li><button type="button" class="btn btn-info btn-round" data-toggle="modal" data-target="#loginModal">Login</button>
				 	  <% if(invalidloginmsg.equalsIgnoreCase("Sorry your login failed, please try again.")){out.print("<div>");out.print(invalidloginmsg);out.print("</div>");}%>
				 </li>
			</ul>
		</nav>
		<!-- //nav -->
	</div>
</header>
<!-- //header -->

<!-- inner-banner -->
<section class="inner-banner" id="home">
	<div class="inner-layer">
		<div class="container">
		</div>
	</div>
</section>
<!-- //inner-banner -->

<!-- breadcrumb -->
<div class="breadcrumb-w3pvt">
	<div class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item">
				<a href="index.jsp">Home</a>
			</li>
			<li class="breadcrumb-item" aria-current="page">New Account</li>
		</ol>
	</nav>
	</div>
</div>
<!-- //breadcrumb -->
	
<!-- Open New Account -->
<section class="contact py-1">
	<div class="container py-lg-1">
		<h2 class="heading mb-sm-5 mb-4">Open A New Account<strong> Today! </strong></h2>
		<div class="row">
		<h3>${error1}</h3>
		<h3>${error2}</h3>
			<form:form class="col-md-6 col-sm-6 col-xs-12" modelAttribute="customer" action="openaccount" method="post">
                <div class="form-group">
                	<label for="firstName">First Name</label>
                	<form:input path="firstName" class="form-control" id="name" placeholder="Your First Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                    <div class="validation"></div>
                </div>
                <div class="form-group">
                	<label for="lastName">Last Name</label>
                  <form:input type="text" path="lastName" class="form-control" id="lastname" placeholder="Your Last Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
                <label for="email">Email</label>
                  <form:input type="email" class="form-control" path="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
                  <div class="validation"></div>
                </div>
               <div class="form-group">
                <label for="password">Password</label>
                  <form:input type="password" class="form-control" path="password" id="password" placeholder="The password you would like to use to login" data-rule="minlen:8" data-msg="Please enter at least 8 chars" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
				  <label for="telephone">Telephone</label>
				    <form:input class="form-control bfh-phone" type="tel" path="telephoneNumber" placeholder="1-(555)-555-5555" id="telephone" data-rule="telephone" data-message="Please enter a valid telephone" data-format="+1 (ddd) ddd-dddd" />
				  <div class="validation"></div>
				</div>
				<div class="form-group">
                <label for="street">Street Address</label>
                  <form:input type="text" class="form-control" path="street" id="street" placeholder="Your Street Address" data-rule="minlen:8" data-msg="Please enter at least 8 chars" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
                <label for="city">City</label>
                  <form:input type="text" class="form-control" path="city" id="city" placeholder="Your City" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
                <label for="state">State</label>
                  <form:input type="text" class="form-control" path="state" id="state" placeholder="Your State" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
                <label for="zip">Zip Code</label>
                  <form:input type="text" class="form-control" path="zipCode" id="zip" placeholder="Your Zip Code" data-rule="minlen:5" data-msg="Please enter at least 5 chars" />
                  <div class="validation"></div>
                </div>
<!--				<div><label for="initialdeposit">Initial Deposit</label></div>
 				<div class="form-group input-group mb-3">	
 					 <div class="input-group-prepend">
 					   <span class="input-group-text">$</span>
 					 </div>
 					 <input type="text" class="form-control" name="initialdeposit" id="initialdeposit" placeholder="Your Inital Deposit" data-rule="minlen:1" data-msg="Please enter at least 1 chars" aria-label="Amount (to the nearest dollar)">
					 <div class="input-group-append">
 					   <span class="input-group-text">.00</span>
 					 </div>
 					 <div class="validation"></div>
				</div> -->
 
                <div class="text-center mb-sm-5 mb-4"><button type="submit">Submit</button></div>
              </form:form>
		</div>
	</div>
</section>
<!-- //Open New Account -->

<!-- //Login Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header border-bottom-0">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="form-title text-center">
          <h4>Login</h4>
        </div>
        <div class="d-flex flex-column text-center">
          <form action="LoginServlet" method="post">
            <div class="form-group">
              <input type="email" name="loginemail" class="form-control" id="email1"placeholder="Your email address...">
            </div>
            <div class="form-group">
              <input type="password" name="loginpassword" class="form-control" id="password1" placeholder="Your password...">
            </div>
            <button type="submit" class="btn btn-info btn-block btn-round">Login</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- //Login Modal -->
		
<!-- footer -->
<footer class="footer py-5">
	<div class="container pt-lg-4">
		<div class="row">
			<div class="col-lg-3 col-sm-6 footer-top">
				<h4 class="mb-4 w3f_title">Contact Info</h4>
				<ul class="list-w3">
					<li><span class="fa mr-1 fa-map-marker"></span>2130 Fulton Street, San Diego, CA 94117-1080 USA</li>
					<li class="my-2"><span class="fa mr-1 fa-phone"></span>1-600-1234-567</li>
					<li class="my-2"><span class="fa mr-1 fa-phone"></span>1-600-1234-567</li>
					<li class=""><span class="fa mr-1 fa-envelope"></span><a href="mailto:info@example.com">info@example.com</a></li>
				</ul>
			</div>
			<div class="col-lg-3 col-sm-6 footv3-left mt-sm-0 mt-4">
				<h4 class="mb-4 w3f_title"> Share Holders</h4>
				<ul class="list-w3">
					<li class="my-2">
						<a href="#">
							Shareholders Information
						</a>
					</li>
					<li class="mb-2">
						<a href="#">
							Stock Information
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Financial Results
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Investors faq's
						</a>
					</li>
					<li>
						<a href="#">
							Regulatory Section
						</a>
					</li>
				</ul>
			</div>
			<div class="col-lg-2 col-sm-4 mt-lg-0 mt-sm-5 mt-4">
				<h4 class="mb-4 w3f_title">Media Center</h4>
				<ul class="list-w3">
					<li class="my-2">
						<a href="#">
							Press Release
						</a>
					</li>
					<li class="mb-2">
						<a href="#">
							Vision & Values
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Winning Awards
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Banking
						</a>
					</li>
				</ul>
			</div>

			<div class="col-lg-2 col-sm-4 mt-lg-0 mt-sm-5 mt-4">
				<h4 class="mb-4 w3f_title">Resources</h4>
				<ul class="list-w3">
					<li class="my-2">
						<a href="#">
							24/7 Help Line
						</a>
					</li>
					<li class="mb-2">
						<a href="#">
							Nearest Branch
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Guidance
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Download
						</a>
					</li>
					<li>
						<a href="#">
							Mobile App
						</a>
					</li>
				</ul>
			</div>
			
			<div class="col-lg-2 col-sm-4 mt-lg-0 mt-sm-5 mt-4">
				<h4 class="mb-4 w3f_title">Other Links</h4>
				<ul class="list-w3">
					<li class="my-2">
						<a href="#">
							Careers
						</a>
					</li>
					<li class="mb-2">
						<a href="#">
							All faq's
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Bank Group
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Credit Cards
						</a>
					</li>
					<li class="my-2">
						<a href="#">
							Loans
						</a>
					</li>
				</ul>
			</div>
			
		</div>
	</div>
	<!-- //footer bottom -->
</footer>
<!-- //footer -->

<!-- middle -->
<section class="middle py-4">
	<div class="container">
		<p><strong class="mr-2">Our Offerings & Calculators:</strong> Personal loans, Home and car loans, loan calculators, Savings accounts, Credit cards, Insurance.</p>
		<p><strong class="mr-2">Bank Smart:</strong> Internet Banking, Online Banking, Cardless transactions, Fixed deposits, Pin generation, Card active status.</p>
	</div>
</section>
<!-- //middle -->

<!-- copyright -->
<section class="copy-right py-4">
	<div class="container">
		<div class="row">
			<div class="col-lg-7">
				<p class="">Â© 2019 Bank of Everyone. All rights reserved | Design by
					<a href="http://w3layouts.com"> W3layouts.</a>
				</p>
			</div>
			<div class="col-lg-5 mt-lg-0 mt-3">
				<ul class="list-w3 d-sm-flex">
					<li>
						<a href="#">
							Privicy Policy
						</a>
					</li>
					<li class="mx-sm-4 mx-3">
						<a href="#">
							Terms & Conditions
						</a>
					</li>
					<li>
						<a href="#">
							Disclaimer.
						</a>
					</li>
					<li>
						<a href="#">
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</section>
<!-- //copyright -->

<!-- move top -->
<div class="move-top text-right">
	<a href="#home" class="move-top"> 
		<span class="fa fa-angle-up  mb-3" aria-hidden="true"></span>
	</a>
</div>
<!-- move top -->
<script src="js/modal.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
    $("#loginModal").on('shown.bs.modal', function(){
        $(this).find('#email1').focus();
    });
});
</script>
</body>
</html>