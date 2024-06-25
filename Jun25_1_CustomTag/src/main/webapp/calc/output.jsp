<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table id = "calcTbl">
	<tr>
		<td align="center">
			${param.x } + ${param.y } = ${a }
		</td>
	</tr>
	<tr>
		<td align="center">
			${param.x} - ${param.y } = ${s }
		</td>
	</tr>
	<tr>
		<td align="center">
			${param.x} * ${param.y } = ${m }
		</td>
	</tr>
	<tr>
		<td align="center">
			${param.x} ÷ ${param.y } = ${d }
		</td>
	</tr>
</table>

</body>
</html>