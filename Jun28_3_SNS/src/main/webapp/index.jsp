<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>

	<table>
		<tr>
			<th class="titleTh" align="center" colspan="2">제목</th>
		</tr>
		<tr>
			<td class = "menuTd" align="center" colspan="2">메뉴</td>
		</tr>
		<tr>
			<td class="contentTd" align="center">
				<jsp:include page="${contentPage}"/>
			</td>
			<td class = "dataTd" align="center">
				<jsp:include page="${dataPage}"/>
			</td>
		</tr>
	</table>
</body>
</html>