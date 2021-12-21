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
<a href="${base}/admin/addProduct" class="btn-success">Add
						accout</a>

					<hr>
                <main>
                    <div class="container-fluid">
                        <div class="row content">
			<div class="col-sm-3 sidenav">
				<jsp:include page="/WEB-INF/views/administrator/layout/header.jsp"></jsp:include>

				<div class="col-sm-9">
                        <div class="row">
                            <div class="col-xl-6">
                                <div class="card mb-4"></div>
                            </div>
                            <div class="col-xl-6">
                                <div class="card mb-4"></div>
                            </div>
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fas fa-table mr-1"></i>
                                    Data Table Customer Account
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Fullname</th>
                                                    <th>Username</th>
                                                    <th>Password</th>
                                                    <th>Email</th>
                                                    <th>Edit</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            	<c:forEach items="${users }" var="item" varStatus="loop">
	                                           		<tr>
	                                                    <td>${loop.index + 1 }</td>
	                                                    <td>${item.fullname }</td>
	                                                    <td>${item.username }</td>
	                                                    <td>${item.password }</td>
	                                                    <td>${item.email }</td>
	                                                    <td class="d-flex "> 
	                                                        <a type="button" class="btn btn-primary" href="#">Update</a>
	                                                        <button type="button" class="btn btn-danger remove ml-1">Remove</button>
	                                                    </td>
	                                                </tr> 
                                            	</c:forEach>
                                                                                           
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                    </div>
                    </div>
                </main>
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
