<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>ESHop</title>
 <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${base}/css/detail.css">
<style type="text/css">
.white{
background-color: #333333;
border-radius: 5px;
}</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>

<!--- detail products ----->
<div class="container-fluid ">    
  <br>
  <div class="row">
    <div class="produc_detail_img">
    <div class="col-sm-4">
    <c:forEach begin="0" end="1"  items="${product.productImages}" var="img">
      <img src="${base}/uploads/${img.path}" class="img-responsive" style="width:100%" alt="Image">
      </c:forEach>
    </div>
    <div class="col-sm-4 img_detail_2"> 
    <c:forEach begin="2" end="3"  items="${product.productImages}" var="img">
      <img src="${base}/uploads/${img.path}" class="img-responsive" style="width:100%" alt="Image">
 </c:forEach>
    </div>
    
  </div>
    <div class="col-sm-4">
      <h3>${product.shortDes}</h3>
      <h2>${product.title}</h2>
      <p><fmt:setLocale value="vi_VN" scope="session" /> <fmt:formatNumber
												value="${product.price}" type="currency" /></p>
      <p> select size</p>
      <div class="shoe_size">
      <div class="btn-group">
  <button type="button" class="btn btn-primary">40</button>
  <button type="button" class="btn btn-primary">41</button>
  <button type="button" class="btn btn-primary">42</button>
</div><br>
<div class="btn-group">
  <button type="button" class="btn btn-primary">43</button>
  <button type="button" class="btn btn-primary">44</button>
  <button type="button" class="btn btn-primary">45</button>
</div><br>
<div class="btn-group">
  <button type="button" class="btn btn-primary">46</button>
  <button type="button" class="btn btn-primary">47</button>
  <button type="button" class="btn btn-primary">48</button>
</div>
  </div>
  <button type="button" class="btn-default buy_btn" onclick="cart(${product.id},1)">ADD to card</button>
  <div class="white">

<br>
${product.details}
Colour Shown: White/University Red/Light Smoke Grey/Black <br> <br>

Style: CV8122-106<br>
View Product Details <br>
  </div>
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

<!-- <script src="../js/jquery.js" type="text/javascript" charset="utf-8" async defer></script> 
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script> -->
<script src="${base}/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="${base}/js/index.js"></script>
<script  type="text/javascript" src="${base}/js/home.js"></script>
</html>
