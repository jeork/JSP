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
				<img src="img/${sessionScope.loginMember.m_img }">
			</td>
			<td>
				ID : ${sessionScope.loginMember.m_id }<br>
				이름 : ${sessionScope.loginMember.m_name }<br>
				전화번호 : ${sessionScope.loginMember.m_phone }<br>
				생년월일 : ${sessionScope.loginMember.m_birth }<br>
			</td>
		</tr>
	</table>
</body>
</html>