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
  <title>update</title>
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
      <h4><small>catergories</small></h4>
      <hr>
   <sf:form class="form-horizontal" action="${base}/admin/updateCategories" method="POST" modelAttribute="categories">
  <div class="form-group">
      <label class="control-label col-sm-2" >id:</label>
      <div class="col-sm-10">
        <sf:input type="text" class="form-control" id="id" placeholder="id" name="id" path="id" readonly="true"></sf:input>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Name:</label>
      <div class="col-sm-10">
        <sf:input type="name" class="form-control" id="name" placeholder="Enter name" name="name" path="name"></sf:input>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2">description:</label>
      <div class="col-sm-10">          
        <sf:input type="text" class="form-control" id="description" placeholder="Enter description" name="description" path="description"></sf:input>
      </div>
    </div>
						 <div class="form-group">
      <label class="control-label col-sm-2">created_by:</label>
      <div class="col-sm-10">          
        <sf:input type="text" class="form-control" id="createdBy" placeholder="Enter Creater" name="createdBy" path="createdBy"></sf:input>
      </div>
    </div> 

    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <sf:button type="submit" id="btn-save" class="btn btn-default">Submit</sf:button>
      </div>
    </div>
  </sf:form>
    
      
      
      
      
     
    </div>
  </div>
</div>



</body>
</html>
