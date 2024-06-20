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
	// V
	//	웹디자이너 B

	request.setCharacterEncoding("UTF-8");
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
	int z = (Integer) request.getAttribute("z");
	%>
	<h1>V2</h1>
	<%=x%>+<%=y%>=<%=z%>
</body>
</html>
