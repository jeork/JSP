<%@page import="java.util.Scanner"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		랜덤한 숫자(1 ~ 100)를 넣었을 때, 짝인지 홀인지 알려주는 기능
		뽑은 숫자와 홀짝 여부를 웹페이지에 출력
	--%>
	<%!Random r = new Random();

	public int randNum() {
		int n = r.nextInt(100) + 1;
		return n;
	}%>

	<%!public String chkEven(int num) {
		return (num % 2 == 0) ? "짝수" : "홀수";
	}%>

	<%
	int n = randNum();
	String result = chkEven(n);
	%>

	<div>
		랜덤한 숫자 :
		<%=n%><br> 따라서
		<%=result%>입니다<br>
	</div>

</body>
</html>