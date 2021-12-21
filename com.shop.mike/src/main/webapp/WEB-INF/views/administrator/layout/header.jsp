<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<h4>Mike manage</h4>
      <ul class="nav nav-pills nav-stacked">
        <li ><a href="${base}/admin/categoriesManage">CategoriesManagement</a></li>
        <li><a href="${base}/admin/producManage">ProductManagement</a></li>
        <li><a href="${base}/admin/productImage">Product pictures</a></li>
        <li><a href="${base}/admin/customerAccount">UserAccoutManagement</a></li>
        <li><a href="${base}/admin/adminAccout">AdminAccoutManagement</a></li>
        <li><a href="${base}/admin/addAccout">addAccout</a></li>
        <li><a href="${base}/admin/saleorder">History</a></li>
        <li><a href="#section3">Subcribe</a></li>
        <c:if test="${isAdmin}">
        <li><a href="#section3">Subcribe</a></li>
        </c:if>
         <c:if test="${isMember}">
        <li><a href="#section3">Subcribe</a></li>
        </c:if>
        <li><a href="${base}/logout">logout(${userLogined.email})</a></li>
      </ul><br>
    </div>