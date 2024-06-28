<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	${r }
</div>
<form action="LoginController" method="post">
	<table class="regTbl">
		<tr>
			<th>로그인</th>
		</tr>
		<tr>
			<td colspan="2" class="inputTd" align="right">
			ID : <input name="id" autocomplete="off">
			</td>
		</tr>
		<tr>
			<td colspan="2" class="inputTd" align="right">
			PW : <input name="pw" type="password">
			</td>
		</tr>
		<tr>
			<td align="right" >
				<button>로그인</button>
			</td>
		</tr>
		<!-- <tr>
			 <td align="right">
				<button>회원가입</button>
			</td>
		</tr> -->
	</table>
</form>
</body>
</html>