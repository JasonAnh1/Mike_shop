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
<link rel="stylesheet" type="text/css" href="${base}/css/cart.css">
<style type="text/css">
.black {
	background-color: black !important;
	color: black;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>

	 <section>
        <p>Giỏ hàng của bạn</p>
        <c:forEach items="${cart.cartItems }" var="item">
        	<div class="container-product d-flex">
	            <span onclick="deleteCart(${item.productId})" class="delete"><i class="fal fa-times"></i></span>
	            
	            <div class="content">
	            <img src="${base }/uploads/${item.path}" width="10%">
	                <h6 class="">${item.productName }</h6>
	                <span class="priceUnit">
	                	<fmt:setLocale value="vi_VN" scope="session" />
                        <fmt:formatNumber value="${item.priceUnit }" type="currency" />
	                </span><br>
	                <div class="quantity btn-group">
	                    <button type="button" value="-" onclick="changeQuantity(${item.productId}, ${item.priceUnit }, this)">-</button>
	                    <input type="text" name="quantity" value="${item.quantity }" readonly>
	                    <button type="button" value="+" onclick="changeQuantity(${item.productId}, ${item.priceUnit }, this)">+</button>
	                </div>
	                <div class="sub-total">
	                	<fmt:setLocale value="vi_VN" scope="session" />
                        <fmt:formatNumber value="${item.priceUnit * item.quantity }" type="currency" />
	                </div>
	            </div>
	        </div>
        </c:forEach>
        <div class="total">
            Tổng tiền:
            <span>
            </span>
        </div>
        <div class="cart-control">
            <a href="${base }/home" type="button"><i class="fas fa-reply"></i> TIẾP TỤC MUA HÀNG</a>
            <a href="${base }/cart/checkout" type="button">THANH TOÁN</a>
        </div>
    </section>












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

<jsp:include page="/WEB-INF/views/customer/layout/js.jsp"></jsp:include>
<script type="text/javascript" src="${base }/js/cart.js"></script>
<script type="text/javascript" src="${base }/js/home.js"></script>
</html>
