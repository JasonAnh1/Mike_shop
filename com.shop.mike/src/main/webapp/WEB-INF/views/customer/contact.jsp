<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Cinzel:wght@900&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Bebas+Neue&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css" href="${base}../css/index.css">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${base}../css/index.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
	<section class="mb-4">

		<!--Section heading-->
		<h2 class="h1-responsive font-weight-bold text-center my-4">Contact
			us</h2>
		<!--Section description-->
		<p class="text-center w-responsive mx-auto mb-5">${Dulieubannhapla}</p>

		<div class="row">

			<!--Grid column-->
			<div class="col-md-9 mb-md-0 mb-5">
				<sf:form id="contact-form" name="contact-form"
					action="${base}/contact" modelAttribute="contact"
					method="POST">

					<!--Grid row-->
					<div class="row">

						<!--Grid column-->
						<div class="col-md-6">
							<div class="md-form mb-0">
								<sf:input type="text" id="firstName" name="firstName" class="form-control"
									path="firtName"></sf:input>
								<label for="name" class="">First name</label>
							</div>
						</div>
						<!--Grid column-->
                          <div class="col-md-6">
							<div class="md-form mb-0">
								<sf:input type="text" id="lastName" name="lastName" class="form-control"
									path="lastName"></sf:input>
								<label for="name" class="">Last name</label>
							</div>
						</div>
						<!--Grid column-->
						<div class="col-md-6">
							<div class="md-form mb-0">
								<sf:input type="text" id="email" name="email"
									class="form-control" path="email"></sf:input>
								<label for="email" class="">Your email</label>
							</div>
						</div>
						<!--Grid column-->

					</div>
					<!--Grid row-->



					<!--Grid row-->
					<div class="row">

						<!--Grid column-->
						<div class="col-md-12">

							<div class="md-form">
								<sf:textarea type="text" id="message" name="message" rows="2"
									class="form-control md-textarea" path="message"></sf:textarea>
								<label for="message">Your message</label>
							</div>

						</div>
					</div>
					<!--Grid row-->
				</sf:form>
				<div class="text-center text-md-left">
					<a class="btn btn-primary"
						onclick="document.getElementById('contact-form').submit();">Send</a>
				<!-- <!-- 		<a class="btn -btn-primary" onclick="SaveContact();">Send</a> --> -->
				</div>
				<div class="status"></div>
			</div>


			<!--Grid column-->

			<!--Grid column-->
			<div class="col-md-3 text-center">
				<ul class="list-unstyled mb-0">
					<li><i class="fas fa-map-marker-alt fa-2x"></i>
						<p>San Francisco, CA 94126, USA</p></li>

					<li><i class="fas fa-phone mt-4 fa-2x"></i>
						<p>+ 01 234 567 89</p></li>

					<li><i class="fas fa-envelope mt-4 fa-2x"></i>
						<p>contact@mdbootstrap.com</p></li>
				</ul>
			</div>
			<!--Grid column-->

		</div>

	</section>
	<!--Section: Contact v.2-->
	</div>
	<!--footer-->
	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
</body>
<script src="${base}js/jquery.js" type="text/javascript" charset="utf-8"
	async defer></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="${base}js/index.js"></script>
</html>