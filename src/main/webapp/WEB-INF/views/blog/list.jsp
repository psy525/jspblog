<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty user }">
			<div>${sessionScope.user.userId}님로그인하셨습니다.</div>
			<a href="blog/logout?id=${sessionScope.user.userId }">로그아웃</a>
		</c:when>
		<c:otherwise>
			<div>
				<a href="/blog/login">로그인</a>
			</div>
		</c:otherwise>
	</c:choose>
	<table>
		<tr>
			<th>게시글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등급</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${boards}" var="board">
			<tr>
				<td>${board.id}</td>
				<td><a href="/blog/detail?no=${board.id}">${board.title}</a></td>
				<td>${board.userId}</td>
				<td>${board.gradeName}</td>
				<td>${board.registerDate}</td>
			</tr>
		</c:forEach>
	</table>
		<a href="/blog/register">게시글 등록</a>
</body>
</html>