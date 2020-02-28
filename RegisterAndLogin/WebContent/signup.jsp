<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- asdfg -->
<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="styles.css">



</head>
<body
	style="background-image: url('./images/oo.jpg'); background-repeat: no-repeat; background-size: auto;">
	<div class="container">

		<nav class="navbar  navbar-expand-md navbar-dark bg-dark"
			style="background-color: rgba(0, 0, 0, 0.5) !important;">

			<div
				class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="navbar-brand mx-auto"
						href="home.jsp" style="font-family: cursive;">Homepage</a></li>
				</ul>
			</div>

			<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="login.jsp" style="font-family: cursive;">SIGN IN </a></li>
					<li class="nav-item active"><a class="nav-link"
						href="signup.jsp" style="font-family: cursive;">SIGN UP </a></li>
				</ul>
			</div>

		</nav>
	</div>



	<form action="reg.do" method="post">
		<div class="container">
			<div class="d-flex justify-content-center h-120">
				<div class="card"
					style="height: 450px; margin-top: auto; margin-bottom: auto; width: 400px; background-color: rgba(0, 0, 0, 0.5) !important;">
					<div class="card-header" style="color: white;">
						<h3>Sign Up</h3>
					</div>
					<div class="card-body">

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="Enter name"
								name="userName">

						</div>

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa fa-envelope"></i></span>
							</div>
							<input type="text" class="form-control"
								placeholder="Enter Email ID" name="email">

						</div>


						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa fa-phone"></i></span>
							</div>
							<input type="text" class="form-control"
								placeholder="Enter contact number" name="phnNum">

						</div>

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control"
								placeholder="Password" name="password">

						</div>

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control"
								placeholder="Confirm password" name="confirmPassword">
						</div>

						<div class="form-group">
							<input type="submit" value="Sign Up"
								class="btn float-right login_btn"
								style="color: black; background-color: #FFC312; width: 120px;">
						</div>

					</div>
					<div class="card-footer">
					<div class="d-flex justify-content-center links"
							style="color: white;">Already have an account? <a href="login.jsp"> Sign In</a>

						</div>

					</div>
				</div>
			</div>
		</div>
		
	</form>

	<div align="center">
		<span style="font-family: cursive; color: green;">${name}
			${successMessage}</span> 
			<span style="color: red; font-family: cursive;">${failureMessage}</span>
	</div>


</body>
</html>