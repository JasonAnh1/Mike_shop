<!DOCTYPE html>
<html lang="en">
<head>
  <!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
  <title>ESHop</title>
  <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/customer/layout/css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="../css/detail.css">
</head>
<style type="text/css">
.black{
color:black}
</style>
<body>
<jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>

<!---regis form ----->
<div class="container text-center">
  <form method="POST" class="login_form">
  <div class="login">
    
    <h3>
BECOME A NIKE MEMBER</h3>
<p>Create your Nike Member profile and get first access to the very best of Nike products, inspiration and community.</p>
<sf:form class="form-horizontal" action="${base}/register" method="POST" modelAttribute="account">
    <sf:input class="write_in black" name="email"  placeholder="enter your email address" type="email" path="email"></sf:input><br>
    <sf:input class="write_in black" name="username" type="text" placeholder="Username" path="username"></sf:input> <br>
    <sf:input class="write_in black" name="fullname" type="text" placeholder="fullname" path="fullname"></sf:input> <br>
    <sf:input class="write_in black" name="password" type="password" placeholder="Password" path="password"></sf:input><br>
   <!--  <input class="write_in black" type="password" placeholder="Reinput Password"><br> -->
    <input type="checkbox" name=""><span>Keep me signed in</span><br>
    <a href="">forgot your password?</a><br>
    <button class="btn submit_btn" type="submit"   value="Submit">JOIN US</button>
</sf:form>
  </div>

</form>

</div>











<!-- --------------------------------------text run -------------------------->
<div class="container-fluid slide_text">
  <div class="row ">
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
    </div>
  </div>
</main>
 <!-- -------------------------------------footer----------------------- -->
<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>

</body>

<script src="../js/jquery.js" type="text/javascript" charset="utf-8" async defer></script> 
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/index.js"></script>
</html>
