<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>
			<img src="img/${sessionScope.loginMember.m_img }" style="width: 80px">
			</td>
			<td>
				${sessionScope.loginMember.m_id }
			</td>
		</tr>
		<tr>
			<td>
				${sessionScope.loginMember.m_name }님<br> 어서오세요
			</td>
		</tr>
		<tr>
			<td>
				<button onclick = "memberInfoGo();">정보</button>
			</td>
			<td>
				<button onclick="logout();">로그아웃</button>
			</td>
		</tr>
	</table>
</body>
</html>