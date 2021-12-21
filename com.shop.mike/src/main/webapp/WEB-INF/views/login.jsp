<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ESHop</title>
<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="../css/detail.css">
<style type="text/css">
.black{
color:black}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>


	<div class="container text-center">
		<form method="POST" action="/perform_login" class="login_form">
			<div class="login">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<!-- kiểm tra xem đã login thành công hay không, bằng cách kiểm tra biến login_error -->
				<c:if test="${not empty param.login_error}">
					<div class="alert alert-danger" role="alert">Login attempt
						was not successful, try again!!!</div>
				</c:if>
				<h3>
					YOUR ACCOUNT FOR <br>EVERYTHING NIKE
				</h3>
				<input class="write_in black" type="text" name="username"
					placeholder="Username"> <br> <input class="write_in black"
					type="password" name="password" placeholder="Password"><br>
				<input type="checkbox" name=""><span>Keep me signed
					in</span><br> <a href="">forgot your password?</a><br>
				<button class="btn submit_btn" type="submit" value="Submit">SIGN
					IN</button>
				<div>
					not a member? <a href="${base}/register">join us</a>
				</div>

			</div>

		</form>

	</div>











	<!-- --------------------------------------text run -------------------------->
	<div class="container-fluid slide_text">
		<div class="row ">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">




				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<p>
							FREE <a>delivery</a> around the world
						</p>
					</div>

					<div class="item">
						<p>1 years Warranty</p>
						<div class="carousel-caption"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- -------------------------------------footer----------------------- -->
	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>

</body>

<script src="../js/jquery.js" type="text/javascript" charset="utf-8"
	async defer></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/index.js"></script>
</html>
