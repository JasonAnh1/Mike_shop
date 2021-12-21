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
</head>
<body>
<jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>


<!--- grid products ----->
 <div class="container-fluid text-center">    

  <h1 class="text-left product_type">Products</h1><br>
 
  <div class="row">
  <c:forEach items="${producsData.data}" var="product">
    <div class="col-sm-4 card_hover"> 
      <img class="image_card" src="${base}/uploads/${product.avatar}"  style="width:100%" height="100%"  alt="Image">
      <h3>${product.title}<span class="green_check"> <i class="fas fa-check-circle"></i></span></h3>   
      <p><fmt:setLocale value="vi_VN" scope="session" /> <fmt:formatNumber
												value="${product.price}" type="currency" /></p>
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
  












<!-- --------------------------------------text run -------------------------->
<div class="container-fluid slide_text">
  <dir class="row ">
 <div id="myCarousel" class="carousel slide" data-ride="carousel">
 
      

 
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <p>FREE <a>delivery</a> around the world</p>             
        </div>

        <div class="item">
          <p>1 years Warranty</p> 
          <div class="carousel-caption">
          </div>      
        </div>
      </div>
      </div>
    </dir>
  </div>
</main>
 <!-- -------------------------------------footer----------------------- -->
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
