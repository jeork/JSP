<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src = "js/go.js"></script>
</head>
<body>

	<table class="indexTbl">
		<tr>
			<th class="titleTh" align="center" colspan="2">
			<a href="HomeController">SNS Mode</a>
			</th>
		</tr>
		<tr>
			<td class = "menuTd" align="center" >
			<a href="BoardController">Board</a>
			
			</td>
			<td class = "menuTd" align="center" >Print</td>
		</tr>
		<tr>
			<td class="contentTd" align="center" colspan="2">
				<jsp:include page="${contentPage}"/>
			</td>
		</tr>
	</table>
			<div class = "dataDiv" >
				<jsp:include page="${dataPage}"/>
			</div>
</body>
</html>