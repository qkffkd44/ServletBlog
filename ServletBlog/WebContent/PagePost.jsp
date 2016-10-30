<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!-- JSTL을 사용하기 위해서는 라이브러리를 로딩 해야 한다 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Clean Blog - Sample Post</title>

<!-- Bootstrap Core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="css/clean-blog.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i
					class="fa fa-bars"></i>
			</button>
			<c:if test="${not empty sessionScope.Member}">
				<div class="navbar-brand">${sessionScope.Member.id} 님</div>
				<a class="navbar-brand" href="Member.service?cmd=logout">로그아웃</a>
			</c:if>

			<c:if test="${empty sessionScope.Member}">
				<a class="navbar-brand" href="PageHome.jsp"> Start Bootstrap</a>
			</c:if>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="PageHome.jsp">Home</a></li>
				<li><a href="PageAbout.jsp">About</a></li>
				<li><a href="PagePost.jsp">Post</a></li>
				<li><a href="PageLogin.jsp">Login</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('img/post-bg.jpg')">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="post-heading">
					<h1>Man must explore, and this is exploration at its greatest</h1>
					<h2 class="subheading">Problems look mighty small from 150
						miles up</h2>

					on August 24, 2014 </span>
				</div>
			</div>
		</div>
	</div>
	</header>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<p>Want to get in touch with me? Fill out the form below to send
					me a message and I will try to get back to you within 24 hours!</p>
				<!-- Contact Form - Enter your email address on line 19 of the mail/contact_me.php file to make this form work. -->
				<!-- WARNING: Some web hosts do not allow emails to be sent through forms to common mail hosts like Gmail or Yahoo. It's recommended that you use a private domain email address! -->
				<!-- NOTE: To use the contact form, your site must be on a live web host with PHP! The form will not work locally! -->
				<form name="sentMessage" action="board.do?cmd=register"
					method="POST">

					<div class="row control-group">
						<label>Title</label>
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<input type="text" class="form-control" placeholder="Title"
								id="name" name="title" 
								required data-validation-required-message="Please enter your title.">
						</div>
					</div>

					<div class="row control-group">
						<label for="comment">Content</label>
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<textarea class="form-control" rows="15" id="comment"
								name="content"></textarea>
						</div>
					</div>

					<br>
					<div id="success"></div>
					<div class="row">
						<div class="form-group col-xs-12">
							<button type="submit" class="btn btn-default">Send</button>
							<button type="reset" class="btn btn-default">Reset</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>



	<hr>

	<!-- Footer -->
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<ul class="list-inline text-center">
					<li><a href="#"> <span class="fa-stack fa-lg"> <i
								class="fa fa-circle fa-stack-2x"></i> <i
								class="fa fa-twitter fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
					<li><a href="#"> <span class="fa-stack fa-lg"> <i
								class="fa fa-circle fa-stack-2x"></i> <i
								class="fa fa-facebook fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
					<li><a href="#"> <span class="fa-stack fa-lg"> <i
								class="fa fa-circle fa-stack-2x"></i> <i
								class="fa fa-github fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
				</ul>
				<p class="copyright text-muted">Copyright &copy; Your Website
					2016</p>
			</div>
		</div>
	</div>
	</footer>

	<!-- jQuery -->
	<script src="vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>

	<!-- Theme JavaScript -->
	<script src="js/clean-blog.min.js"></script>

</body>

</html>