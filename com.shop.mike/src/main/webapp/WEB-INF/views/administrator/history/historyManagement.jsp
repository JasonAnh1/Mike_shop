<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>B</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="/WEB-INF/views/administrator/layout/css.jsp"></jsp:include>

</head>
<body>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<jsp:include page="/WEB-INF/views/administrator/layout/header.jsp"></jsp:include>

				<div class="col-sm-9">


					<a href="${base}/admin/addProduct" class="btn-success">Add
						product</a>

					<hr>

					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>#</th>
								<th>Code</th>
								<th>Fullname</th>
								<th>Phone Number</th>
								<th>Email</th>
								<th>Address</th>
								<th>TotalPrice</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${saleorder }" var="item" varStatus="loop">
								<tr>
									<th>${loop.index + 1 }</th>
									<th>${item.code }</th>
									<th>${item.customerName }</th>
									<th>${item.customerPhone }</th>
									<th>${item.customerEmail }</th>
									<th>${item.customerAddress }</th>
									<th><fmt:setLocale value="vi_VN" scope="session" /> <fmt:formatNumber
											value="${item.total }" type="currency" /></th>
									<th>
										<button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#myModal"
											onclick="detail(${item.id})">Detail</button>
									</th>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
		</div>

		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Detail SaleOrder</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->

					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>#</th>
								<th>Image</th>
								<th>Product Name</th>
								<th>Product Quantity</th>
								<th>Product Price</th>
							</tr>
						</thead>
						<tbody id="detailSaleOrder">
						</tbody>
					</table>

					<!-- Paging -->
					<!-- 						<div class="row">
							<div class="col-12 d-flex justify-content-center">
								<div id="paging"></div>
							</div>
						</div> -->
				</div>
			</div>
		</div>
</body>
<jsp:include page="/WEB-INF/views/administrator/layout/Pagging.jsp"></jsp:include>
<!-- <script type="text/javascript">
			$(document).ready(function() {
				$("#paging").pagination({
					currentPage: ${productSearch.currentPage},
			        items: ${productSearch.totalItems},
			        itemsOnPage: 5,
			        cssStyle: 'dark-theme',
			        onPageClick: function(pageNumber, event) {
			        	$('#page').val(pageNumber);
			        	$('#btnSearch').trigger('click');						
					},
			    });
			});
		</script> -->
</html>
