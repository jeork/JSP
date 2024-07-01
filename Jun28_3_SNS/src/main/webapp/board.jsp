<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.loginMember==null }">
		<h1>게시글 작성은 로그인 후 사용할 수 있습니다.</h1>
	</c:if>
	<c:if test="${sessionScope.loginMember != null }">
		<form action="">
			
		</form>
		
	</c:if>


</body>
</html>