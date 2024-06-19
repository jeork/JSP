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
	GET/POST
	원래 요청파라미터=>한글처리
		GET-안함
		POST-해야함
	할지 말지 고민이 될 때는 일단 하고보자
 --%>
	<%
	request.setCharacterEncoding("UTF-8");
//	response.setCharacterEncoding("UTF-8");
// 원래 응답도 한글처리해야 하는데
// 맨위 에서 해주고있어서 필요없음
// (1~2번줄의 "UTF-8")
	String name = request.getParameter("name");
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
	int sum = x + y;
	%>

	<div>
		이름 : <%=name%><br>
		<%=x%> + <%=y%>	= <%=sum%>
	</div>
</body>
</html>