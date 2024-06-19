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
	<%
	// 값
	//	parameter
	//	html에서 만들어낸 값
	%>


	<h1>Second</h1>
	<hr>
	<%
	request.setCharacterEncoding("UTF-8");
	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));

	RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");

	int c = a + b;
	request.setAttribute("c", c);

	String d = "ㅋ";
	request.setAttribute("d", d);

	Random e = new Random();
	request.setAttribute("e", e);

	//rd.forward(request, response);
	rd.include(request, response);
	%>
	<div>
		첫번째 숫자 :
		<%=a%><br> 두번째 숫자 :
		<%=b%>
	</div>
</body>
</html>