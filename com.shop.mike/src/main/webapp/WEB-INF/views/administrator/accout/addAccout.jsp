<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
       <jsp:include page="/WEB-INF/views/administrator/layout/header.jsp"></jsp:include>
    <div class="col-sm-9">
    <main>
                    	<section class="row" style="width: 800px;">
			                 <div class="col mt-4">
			                     <sf:form class="col-sm-12" id="form-1" action="${base }/admin/addAccout" method="POST" modelAttribute="account">
			                     	
			                         <div class="card mb-4">
			                         	<div class="card-header">
			                                 <h2>Add New User</h2>
			                             </div>
			                             <div class="card-body">
		                                 	<div class="row">
                                               	<div class="col-sm-8 form-group">
                                                    <label for="fullname" class="form-label">Full Name</label>
                                                    <sf:input type="text" placeholder="Enter Full Name Here.."
                                                        class="form-control user-fullname" id="fullname" name="fullname" path="fullname"></sf:input>
                                                    <span class="form-message" id="error_fullname" style="color: red;"></span>
                                                </div>
                                             </div>
                                             <div class="row">
                                                <div class="col-sm-8 form-group">
                                                    <label for="username" class="form-label">Username</label>
                                                    <sf:input type="text"  placeholder="Enter Username Here.."
                                                        class="form-control user-username" id="username" name="username" path="username"></sf:input>
                                                    <span class="form-message " id="error_username" style="color: red;"></span>
                                                </div>
                                             </div>
                                       		 <div class="row">
                                                <div class="col-sm-8 form-group">
                                                    <label for="password" class="form-label">Password</label>
                                                    <sf:input type="password" placeholder="Enter Password Here.."
                                                        class="form-control user-password" id="password" name="password" path="password"></sf:input>
                                                    <span class="form-message" id="error_password" style="color: red;"></span>
                                                </div>
                                             </div>
                                           	 <div class="row">
                                                <div class="col-sm-8 form-group">
                                                    <label for="email" class="form-label">Email</label>
                                                    <sf:input type="email" placeholder="Enter Email Here.."
                                                        class="form-control user-email" id="email" name="email" path="email"></sf:input>
                                                    <span class="form-message" id="error_email" style="color: red;"></span>
                                                </div>
                                              </div>
                                              <div class="row">
                                                <div class="col-sm-4 form-group">
                                                    <label for="role">Vai Trò</label>
                                                    <select class="form-control" id="role" name="role">
														<c:forEach items="${roles}" var="item">
															<option value="${item.id }">${item.name }</option>
														</c:forEach>
													</select>
                                                </div>
                                              </div>
		                             	</div>
			                            <div class="card-footer text-muted">
			                             	<a href="${base}/admin/account/addAccount" class="btn btn-success">New</a>
			                                <button class="btn btn-primary" type="submit">Save</button>
			                            </div>
			                         </div>
			                     </sf:form>
			                 </div>
			             </section>
                    </main>
                    </div>
  </div>
</div>



</body>
</html>
