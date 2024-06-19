<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-size: 25px;
}

table {
	margin-right: 10px;
	float: left;
}
</style>
</head>
<body>
	<table border=1>
		<%
		for (int i = 1; i <= 9; i++) {
			out.print("<tr>");
			for (int j = 2; j <= 9; j++) {
				out.print("<td>");
				out.print(j + "x" + i + "=" + (j * i));
				out.print("</td>");
			}
			out.print("<tr>");
		}
		%>
	</table>
</body>
</html>