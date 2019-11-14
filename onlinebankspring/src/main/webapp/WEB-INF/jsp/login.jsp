<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html class="full-height" lang="en-US">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/mdb.min.css" rel="stylesheet">
<link href="static/styles/main.css" rel="stylesheet">
</head>
<body>
	<header>
		<nav
			class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar"
			id="navbar">
			<div class="container">
				<a class="navbar-brand" href="/index"><strong>Index</strong></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarContent" aria-controls="navbarContent"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarContent">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link active" href="/about">About</a></li>
						<!--              <li class="nav-item"><a class="nav-link" href="#projects">Projects</a></li>
              <li class="nav-item"><a class="nav-link" href="#pricing">Pricing</a></li>  -->
						<li class="nav-item"><a class="nav-link" href="/register">Registration</a></li>
						<li class="nav-item"><a class="nav-link" href="/contact">Contact</a></li>
						<li class="nav-item" role="button"><a class="nav-link"
							href="/login">Login</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<section class="view hm-gradient" id="intro">
			<div class="full-bg-img d-flex align-items-center">
				<div class="container">
					<div class="row no-gutters">
						<div class="col-md-10 col-lg-6 text-center text-md-left margins">
							<div class="white-text">
								<div class="wow fadeInLeft" data-wow-delay="0.3s">
									<h1 class="h1-responsive font-bold mt-sm-5">
										<strong>${msg}${error2}</strong>
									</h1>
									<div class="h6">Lorem ipsum dolor sit amet, consectetur
										adipisicing elit. Rem repellendus quasi fuga nesciunt dolorum
										nulla magnam veniam sapiente, fugiat! Commodi sequi non animi
										ea dolor molestiae iste.</div>
								</div>
								<br>
								<div class="wow fadeInLeft" data-wow-delay="0.3s">
									<a class="btn btn-white dark-grey-text font-bold ml-0"
										href="https://www.youtube.com/watch?v=60ItHLz5WEA"
										target="_blank"><i class="fa fa-play mr-1"></i> View Demo</a><a
										class="btn btn-outline-white" href="#">Learn more</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</header>

	<h1>${msg}</h1>
	<!-- <form action="login" method="post">
<input type="text" name="email" placeholder="Email">
<input type="password" name="password" placeholder="Password">
<button>Submit</button> 
</form>-->
	<!-- Intro Section-->
	<section class="text-center py-5 grey lighten-4" id="about">
		<div class="container">
			<div class="wow fadeIn">
				<h2 class="h1 pt-5 pb-3">Login</h2>
				<form:form action="login" modelAttribute="customer" method="post">
					<form:input path="email" type="email" placeholder="Email" />
					<form:password path="password" placeholder="Password" />
					<button>Submit</button>
				</form:form>
			</div>
		</div>
	</section>


	<script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="static/js/popper.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/js/mdb.min.js"></script>
	<script>
		new WOW().init();
	</script>

</body>
</html>