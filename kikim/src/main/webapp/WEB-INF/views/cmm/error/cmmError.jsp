<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


	<div class="row">
	    <div class="col-md-12 page-404">
	        <div class="number font-red"> <c:out value="${error.STATUS_CODE }"> </c:out></div>
	        <div class="details">
	            <h3>${error.MESSAGE }</h3>
	            <p>
	                <a href="<c:url value='/'/>"> [HOME] </a>을 클릭하시면, 홈으로 돌아갑니다.   
	            </p>
	        </div>
	    </div>
	</div>

</body>
</html>