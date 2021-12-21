<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<nav class="navbar  navbar-inverse navi  f-nav">
	<div class="navbar navbar-collapse pt-3  ">
		<ul class="navbar-right nav navbar-nav ">
			<li><a href="#" title="" ><p >xin chao ${userLogined.username}
				</p><p class="dropdown-content"><a>123</a></p></a></li>
			<li><a href="${base}/login" title=""><p>Wellcome,sign in</p></a></li>
			<li><a href="${base}/logout" title=""><p>sign out</p></a></li>
		</ul>
	</div>
</nav>
<nav class="navbar navbar-inverse navi secNav">
  <div class="container-fluid contain-navi">
    <div class="navbar-header  ">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand logo" href="${base}/index" id="logo" ><p>MIKE</p></a>
    </div>
    <div class="collapse navbar-collapse pt-3" id="myNavbar">
      <ul class="nav navbar-nav nav-white">
        <li class="shoe_drop"><a href="#"  class="btn" data-toggle="collapse" data-target="#shoemenu1">SHOES
        </a>
      </li>
        
        <li><a href="#">ABOUT US</a></li>
        <li><a href="${base}/contact">CONTACT</a></li>
      </ul>
  
      
      <ul class="nav navbar-nav navbar-right icon-r">
        <li><a href="#"><span class="glyphicon glyphicon-heart"></span></a></li>
        <li><a href="${base}/cart"><span id="cartIndex" class="glyphicon glyphicon-shopping-cart">${totalItems}</span></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right allsearch">
      	<form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2 ipsearch" type="search" placeholder="Search" aria-label="Search" >
      <button class="glyphicon glyphicon-search search_icon " type="submit"></button>
    </form>
      </ul>
    </div>
  </div>
</nav>
<div id="shoemenu1" class="row  collapse" >
<c:forEach items="${categories}" var="category">
  <a href="${base }/category/${category.seo}" class="col-sm-4  btn" data-toggle="collapse" data-target="#basketball_shoe">${category.name}</a>
</c:forEach>
</div>

  <div class="container-fluid slide_text slide_text_top">
  <dir class="row ">
 <div id="myCarousel" class="carousel slide" data-ride="carousel">
 
      

 
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <p>Well come to the MIKE</p>             
        </div>

        <div class="item">
          <p>THE GREATEST WEBSITE FOR A GREATEST <span style="color: red">ATHLETE!</span> </p> 
           
        </div>
        <div class="item">
          <p>DEVELOP WITH BURNING PASSION do not copy with any case <3 </p> 
           
        </div>
      </div>
      </div>
    </dir>
  </div>