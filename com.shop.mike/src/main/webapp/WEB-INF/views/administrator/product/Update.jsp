<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>add</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="/WEB-INF/views/administrator/layout/css.jsp"></jsp:include>
</head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<body>

	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<jsp:include page="/WEB-INF/views/administrator/layout/header.jsp"></jsp:include>

				<div class="col-sm-9">
					<h4>
						<small>Addproduct or update</small>
					</h4>
					<hr>
					<sf:form class="form-horizontal"
						action="${base}/admin/update" method="POST"
						modelAttribute="product" enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-sm-2">id:</label>
							<div class="col-sm-10">
								<sf:input type="text" class="form-control" id="id"
									placeholder="id" name="id" path="id" readonly="true"></sf:input>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Category</label>
							<div class="col-sm-10">
								<sf:select path="categories.id" class="form-control"
									id="category">
									<sf:options items="${categories}" itemValue="id"
										itemLabel="name" />
								</sf:select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">title:(cannot be left blank )</label>
							<div class="col-sm-10">
								<sf:input type="name" class="form-control" id="title"
									placeholder="Enter title" name="title" path="title"></sf:input>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">price:(cannot be left blank )</label>
							<div class="col-sm-10">
								<sf:input type="number" class="form-control" id="price"
									placeholder="Enter price" name="price" path="price"></sf:input>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">price sale:</label>
							<div class="col-sm-10">
								<sf:input type="number" class="form-control" id="priceSale"
									placeholder="Enter price" name="priceSale" path="priceSale"></sf:input>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2"> short description:(cannot be left blank )</label>
							<div class="col-sm-10">
								<sf:input type="text" class="form-control" id="shortDes"
									placeholder="Enter shortDes" name="shortDes" path="shortDes"></sf:input>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2"> detail:(cannot be left blank )</label>
							<div class="col-sm-10">
								<sf:textarea type="text" class="form-control"  id="summernote"
									placeholder="Enter details" name="details" path="details"></sf:textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="fileProductPictures">Picture(Multiple):</label>
							<div class="col-sm-10">
								<input id="fileProductPictures" name="productPictures"
									type="file" class="form-control-file" multiple="multiple">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="fileProductAvatar">Avatar:</label>
							<div class="col-sm-10">
								<input id="fileProductAvatar" name="productAvatar" type="file"
									class="form-control-file">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="fileProductAvatar">sản phẩm thêm mới sẽ auto hot tích vào nếu như đây không phải sản phẩm hot:</label>
							<div class="col-sm-10">
								<sf:checkbox path="isHot" name="isHot" itemValue="1" class="form-check-input" id="isHot"></sf:checkbox>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<sf:button type="submit" class="btn btn-default">Submit</sf:button>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
			 <script>
    $(document).ready(function() {
        $('#summernote').summernote();
    });
  </script>
</body>
</html>
