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
					<form class="form-inline" action="${base }/admin/producManage"
						method="get" modela>
						<div class="d-flex flex-row">
							<!-- dữ liệu để thực hiện tìm kiếm sản phẩm -->
							<input type="hidden" id="page" name="page"> <input
								type="text" id="keyword" name="keyword" class="form-control"
								placeholder="Search" value="${searchModel.keyword }"> 
							  <select name="categoryId" id="categoryId">
							  <option value="0">all</option>
								<c:forEach items="${categories}" var="categories" >					
								<option value="${categories.id}">${categories.name}</option>
								</c:forEach>
							</select>
						<%--  <select name="isHot" id="isHot">
								<c:forEach items="${product.isHot}">
								<option value="${product.isHot}">${product.isHot}</option>
								</c:forEach>
							</select>  --%>
							<button type="submit" id="btnSearch" name="btnSearch"
								value="Search" class="btn btn-primary">Seach</button>
						</div>

						<table class="table">
							<thead>
								<tr>
									<th>ID</th>
									<th>name user</th>
									<th>email</th>
									<th>roles</th>
									<th>Edit</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${productSearch.data}" var="o" varStatus="loop">
									<tr>
										<td>${o.id}</td>
										<td>${o.categories.name}</td>
										<td>${o.title}</td>
										<td><fmt:setLocale value="vi_VN" scope="session" /> <fmt:formatNumber
												value="${o.price}" type="currency" /></td>
										<td><a class="btn-success" href="update?uid=${o.id}">Edit</a>
											<button type="button" onclick="deleteProduct(${o.id})"
												id="btnDelete" class="btn btn-danger">Delete</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<!-- Paging -->
						<div class="row">
							<div class="col-12 d-flex justify-content-center">
								<div id="paging"></div>
							</div>
						</div>
					</form>


				</div>
			</div>
		</div>
	
</body>
<jsp:include page="/WEB-INF/views/administrator/layout/Pagging.jsp"></jsp:include>
		<script type="text/javascript">
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
		</script>
</html>
