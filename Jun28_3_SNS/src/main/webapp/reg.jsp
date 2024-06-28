<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="regController" method="post" enctype="multipart/form-data">
	<table class="regTbl">
		<tr>
			<th align="center">회원가입
			</th>
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
			<td colspan="2" class="inputTd" align="right">
			PW Check : <input name="pwCk" type="password">
			</td>
		</tr>
		<tr>
			<td colspan="2" class="inputTd" align="right">
			이름 : <input name="name"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="inputTd" align="right">
			전화번호 : <input name="phone" >
			</td>
		</tr>
		<tr>
			<td colspan="2" class="inputTd" align="right">
			생년월일 : <input name="birth" type="date">
			</td>
		</tr>
		<tr>
			<td colspan="2" class="inputTd" align="right">
			 사진 : <input name="img" type="file">
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