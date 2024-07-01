<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="regController" method="post"
		enctype="multipart/form-data">
		<table class="regTbl">
			<tr>
				<th align="center">회원가입</th>
			</tr>
			<tr>
				<td colspan="2" class="inputTd" align="right">ID : <input
					name="m_id" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="inputTd" align="right">PW : <input
					name="m_pw" type="password">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="inputTd" align="right">PW Check : <input
					name="m_pwCk" type="password">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="inputTd" align="right">이름 : <input
					name="m_name" />
				</td>
			</tr>
			<tr>
				<td colspan="2" class="inputTd" align="right">전화번호 : <input
					name="m_phone">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="inputTd" align="right">생년월일 :
				<select	name="m_y">
					<c:forEach var="y" begin="${cy-100 }" end="${cy }" step="1">
						<option>${y }</option>
					</c:forEach>
				</select>&nbsp;년&nbsp;
				<select name="m_m">
					<c:forEach var="m" begin="1" end="12">
						<option>${m }</option>
					</c:forEach>
				</select>&nbsp;월&nbsp;
				<select name="m_d">
					<c:forEach var="d" begin="1" end="31">
						<option>${d }</option>
					</c:forEach>
				</select>&nbsp;일&nbsp;	
				</td>
			</tr>
			<tr>
				<td colspan="2" class="inputTd" align="right">사진 : <input
					name="m_img" type="file">
				</td>
			</tr>
			<tr>
				<td align="right">
					<button>회원가입</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>