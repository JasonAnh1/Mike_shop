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
					<h4>
						<small>categoriesManagement</small>
					</h4>
					<a href="${base}/admin/addProduct" class="btn-success">Add
						product</a>
					<hr>
					<table class="table">
						<thead>
							<tr>
								<th>productid</th>
								<th>title</th>
								<th>picture</th>

							</tr>
						</thead>
						<tbody>
						<c:forEach items="${listproduct}" var="o">
							<tr>
								<td>${o.product.id}</td>
								<td>${o.title}</td>
								<td><img src="${base}/uploads/${o.path}"
								width="50%" alt=""></td>								

							</tr>
                             </c:forEach>
						</tbody>
					</table>





				</div>
			</div>
		</div>
</body>
</html>
