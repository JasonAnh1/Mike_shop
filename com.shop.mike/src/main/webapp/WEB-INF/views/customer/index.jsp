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
<!-- comom -->
<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
	<main>
		<div class="hero-image">
			<img src="../image/nikebanner.gif" height="500px" width="100%">
			<div class="hero-text">
				<h1 style="font-size: 150px">
					<i>MIKE</i>
				</h1>
			</div>

		</div>
		<!-- <----------------contenttext->>>>>>>> -->
		<div class="container-fluid content_text">
			<h1>YOUR MIKE CONECTION</h1>
			<p>More sport,more inspire,more feature</p>
			<button type="button" class="btn btn-dark">Get your great</button>
		</div>
		<br>
		<!-- //gif2----------------------------------------------------------------------------- -->
		<div class="container-fluid gif2">
			<h2 class="text-left">
				Don't Miss
				<button class="btn ">LearnMore</button>
			</h2>

			<div class="gif_2">
				<img src="../image/cee5b9f75e73c20a0f89cf4d43a7e0ba.gif "
					width="100%">
			</div>
		</div>
		<!--  ----------------------------bátketballshoer -->
		<div class="container-fluid text-center">
			<h3 class="text-left product_type">Hot</h3>
			<br>
			<div class="row">
		<c:forEach items="${product.data}" var="product">
				<div class="col-sm-4 card_hover"> 
      <img class="image_card" src="${base}/uploads/${product.avatar}"  style="width:100%" height="100%"  alt="Image">
      <h3>${product.title}<span class="green_check"> <i class="fas fa-check-circle"></i></span></h3>   
      <p>
      <fmt:setLocale value="vi_VN" scope="session" /> <fmt:formatNumber
value="${product.price}" type="currency" />
      </p>
      <div class="readmore">
      <div class="buy_like">
       <a href="${base }/detail/${product.seo}">Detail <i class="fas fa-heart-circle"></i><br></a>
       <a onclick="cart(${product.id},1)">Add to cart<i class="fas fa-cart-plus"></i><br></a>
     <!--   <a href=""> I like This <i class="fas fa-heart-circle"></i></a> -->
      </div>
    </div>
    </div>
</c:forEach>


			</div>
		</div>




		<!-- -------------------------------------------dropdownshowproduct -->

		<!-- <div class="btn-group btn-group-justified btn-css">
  <a  class="btn btn-primary " data-toggle="collapse" data-target="#JORDAN">JORDAN</a>
   <a  class="btn btn-primary " data-toggle="collapse" data-target="#BLAZER">BLAZER</a>
  <a class="btn btn-primary" data-toggle="collapse" data-target="#AIRFORCE">AIRFORCE</a>
</div >
<div class="container-fluid ">

  <div class="row  justify-content-between ">
    <div class="col-12 p-0 m-0 justify-content-between">

    <div id="JORDAN" class="row nike_dropdown">
      <div  class="col-sm-5 img_drop">
        <img  src="../image/jd33.jpg"   width="100%"height="400px" alt="">
      </div>
      <div class="col-sm-7 nike_content"><h2>Introducing the <a>Air Jordan 33</a> with FastFit</h2>
        When the Air Jordan XXXIII lands next month, it will introduce a new promise for pinnacle basketball shoe comfort, performance and style: Nike’s FastFit technology.

“This year’s game shoe, the AJ XXXIII, is the first basketball shoe to feature FastFit technology, which provides ultimate lockdown to prepare athletes for flight,” says Michael Jordan. “From day one, we’ve taken pride in the Air Jordan game shoe, where we focus on athlete insights and the latest innovations to create silhouettes that are distinctly Jordan. That balance also allows the game shoe to continually revolutionize both in sport and style.”

With the addition of FastFit, the Air Jordan XXXIII follows a clear Jordan path. For example, while Air has been the hallmark of Michael Jordan’s signature line since 1985, it took Tinker Hatfield’s 1988 design for the Jordan III to cement its defining attribute. In that shoe the Air technology was made visible, and with it, MJ’s hangtime took on an advanced aura (literally, as he soared from the free throw line in the ’88 dunk contest).</div>
<button type="button" class="btn btn-default btn_indrop"><a href="#">BUY 5.450.000d</a> <i class="fas fa-cart-plus"></i></button>
    </div>
-------------------------------------blazer -----------------------------------

 <div id="BLAZER" class="row nike_dropdown collapse">
      <div  class="col-sm-5 img_drop">
        <img  src="../image/blazer-mid-77-vintage-shoe-dNWPTj.png"   width="100%"height="550px" alt="">
      </div>
      <div class="col-sm-7 nike_content"><h2>Introducing the <a>Blazer mid 77</a></h2>
        <span>In the '70s, Nike was the new shoe on the block. So new in fact, we were still breaking into the basketball scene and testing prototypes on the feet of our local team. Of course, the design improved over the years, but the name stuck. The Nike Blazer Mid '77 Vintage—classic from the beginning.
<br>
Colour Shown: White/Black<br>
Style: BQ6806-100<br></span></div>
<button type="button" class="btn btn-default btn_indrop"><a href="#">BUY 5.450.000d</a> <i class="fas fa-cart-plus"></i></button>
    </div>


------------------------------------------------airforce--------------------

  <div id="AIRFORCE" class="row nike_dropdown collapse">
      <div  class="col-sm-5 img_drop">
        <img  src="../image/air-force-1-07-lv8-shoes-jB2B7C.jpg"   width="100%"height="550px" alt="">
      </div>
      <div class="col-sm-7 nike_content"><h2>Introducing the <a>Nike Air Force 1 '07 LV8</a></h2>
        <span>The radiance lives on in the Nike Air Force 1 '07 LV8, the b-ball icon that puts a fresh spin on what you know best. It's got crisp leather and a little something extra to show you're on top.The Swoosh is outlined with a gold trim, the heel and tongue use gold metallic accents and other premium details are highlighted in gold.
<br>
Colour Shown: White/Metallic Gold/White/Black<br>
</br>
Style: DA8481-100<br></span></div>
<button type="button" class="btn btn-default btn_indrop"><a href="#">BUY 5.450.000d</a> <i class="fas fa-cart-plus"></i></button>
    </div> -->
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
	</main>
	<!--footer-->
	<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>

</body>
<!--js  -->
<script src="${base}/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="${base}/js/index.js"></script>
<script  type="text/javascript" src="${base}/js/home.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</html>
