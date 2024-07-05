<%@page import="java.net.URLDecoder"%>
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
	<c:if test="${sessionScope.loginMember == null  }">
		<h1>게시글 작성은 로그인 후 사용할 수 있습니다.</h1>
	</c:if>
	<c:if test="${sessionScope.loginMember != null }">
		<form action="BoardWriteController" name="boardForm"
			onsubmit="boardCheck();">
			<table id="writeBoardTbl">
				<tr>
					<td><input name="token" value="${generatedToken } "
						type="hidden"> 
						<textarea class="writeArea"
							placeholder="작성!" name="b_text" autofocus="autofocus"
							autocomplete="off" maxlength="200"></textarea>
					</td>
					<td><button class="writeBtn">게시</button></td>
				</tr>
			</table>
		</form>
	</c:if>
	<form action="BoardSearchController" name="boardSearchForm"
		onsubmit="searchCheck();">
		<table>
			<tr>
				<td><input id="searchInput" autocomplete="off" autofocus="autofocus" name="search"></td>
				<td>&nbsp;&nbsp;&nbsp;<button id="searchBtn">검색</button></td>
			</tr>
		</table>
	</form>
	<c:if test="${pageNo != 1 }">
		<a href="BoardPageController?p=${pageNo - 1 }" id="boardL">&lt;</a>
	</c:if>
	<c:if test="${pageNo != pageCount && boardCount != 0 }">
		<a href="BoardPageController?p=${pageNo + 1 }" id="boardR">&gt;</a>
	</c:if> 
	<div>${no }</div>
	<c:forEach var="board" items="${boards }">
		<table class="boardContentTbl">
			<tr>
				<td class="boardPhoto" rowspan="3" valign="top" align="center"><img
					src="img/${board.m_photo }"></td>
				<td class="boardWriter">- ${board.b_writer } -</td>
			</tr>
			<tr>
				<td class="boardWhen" align="right"><fmt:formatDate
						value="${board.b_when }" type="both" dateStyle="long"
						timeStyle="short" /></td>
			</tr>
			<tr>
				<td class="boardText">${board.b_text }</td>
			</tr>
			<c:if test="${board.b_writer == sessionScope.loginMember.m_id }">
				<tr>
					<td colspan="2" align="right" class="boardBtn">
						<button onclick="boardUpdate(${board.b_no});">수정</button>
						<button onclick="boardDelete(${board.b_no});">삭제</button>
					</td>
				</tr>
			</c:if>
		</table>
	</c:forEach>
</body>
</html>