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
					<a href="${base}/admin/addCategories" class="btn-success">Add category</a>
					<hr>
					<table class="table">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>description</th>
								<th>created_date</th>
								<th>updated_date</th>
								<th>created_by</th>
								<th>updated_by</th>
								<th>status</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listcate}" var="o">
								<tr>
									<td>${o.id}</td>
									<td>${o.name}</td>
									<td>${o.description}</td>
									<td>created_date</td>
									<td>updated_date</td>
									<td>created_by</td>
									<td>updated_by</td>
									<td>status</td>
									<td><a class="btn-success" href="updateCategories?cid=${o.id}">Edit</a>
										<a class="btn-danger" href="deleteCategories?id=${o.id}">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>






				</div>
			</div>
		</div>
</body>
</html>
