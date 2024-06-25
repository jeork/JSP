<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- core가 있어야 fmt를 쓸 수 있는건 아님 -->
<!-- core / fmt 자주 쓰는 기능이라 보통은 둘 다 가져다 쓰는 경향이 있음 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- fmt : 문자열 / 날짜 형태 포맷팅  -->
	<hr>
	<fmt:formatNumber value="${a }" type="number" />
	<!-- 숫자 -->
	<hr>
	<fmt:formatNumber value="${a }" type="currency" currencySymbol="$" />
	<!-- 통화 -->
	<hr>
	<fmt:formatNumber vlaue="${b }" type="percent" />
	<!-- 퍼센트(소수점 반올림) -->
	<hr>
	<fmt:formatNumber value="${c }" pattern="#.00" />
	<!-- 소수점 둘째자리까지(반올림) -->

	<!--
		Date 속성
		: type = "date / time / both"
			1.date
				dateStyle = "short / long"
			2. time 
				timeStyle
			3.both
				dateStyle = "short/long"
				timeStyle = "short/long"
				
	 -->
	<fmt:formatDate value="${d}" type="both" dateStyle="long"
		timeStyle="short" />
	<hr>

	<!-- 패턴 -->
	<fmt:formatDate value="${d }" pattern="yyyy-MM-dd E a HH" />

</body>
</html>