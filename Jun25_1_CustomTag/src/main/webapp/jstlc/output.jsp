<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>n = ${param.n }</h1>
	<!-- 조건문 -->

	<c:if test="${param.n %2==0 }">
		짝수
	</c:if>
	<hr>

	<!-- if-else + switch-case 느낌 -->
	<c:choose>
		<c:when test="${param.n >10 }">
			10보다 크다
		</c:when>
		<c:when test="${param.n >=5 }">
			5~10 사이
		</c:when>
		<c:otherwise>
			나머지		
		</c:otherwise>
	</c:choose>

	<!-- 반복문 -->
	<%
	/*for(int i = 1; i<=5; i+=2){
		System.out.println(i);
	}*/
	%>
	<c:forEach var="v" begin="1" end="${param.n }" step="2">
		<marquee> ${v }</marquee>
	</c:forEach>
	<hr>
	<%
	/*
	for (int i : ar){
		 System.out.println(i);
	}*/
	%>
	<c:forEach var="i" items="${al}">
		<marquee>${i.name} - ${i.age }]</marquee>
	</c:forEach>
	<hr>

	<!-- try-catch -->
	<c:catch var="myExcept">
		<%
		int result = 100 / 2;
		%>
		계산 결과 : <%=result%>
	</c:catch>
	<br>
	<c:catch var="myExcept">
		<%
		int result = 100 / 0;
		%>
		계산 결과 : <%=result%>
	</c:catch>
	<c:if test="${myExcept != null }">
		에러 발생 : ${myExcept.message }
	</c:if>
	<br>

	<c:out value="${param.n } hi "></c:out>
	<c:set var="name" value="yo"></c:set><!-- 변수 만들기 -->
	<c:out value="${name }"/><br>

	<!-- StringTokenizer -->
	<c:forTokens var = "item" items="서울,대전,대구,부산,찍고,아하" delims=",">
		지역 : ${item }<br>
	</c:forTokens>
		
	
	
</body>
</html>