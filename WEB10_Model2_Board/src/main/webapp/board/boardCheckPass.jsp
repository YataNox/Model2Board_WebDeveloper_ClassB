<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>boardCheckPass.jsp</title>
		<script type="text/javascript" src="script/board.js"></script>
		<link rel="stylesheet" type="text/css" href="css/board.css">
		</head>
	<body>
		<div align="center">
			<h1>비밀번호 확인</h1>
			<form action="board.do" name="frm" method="get">
				<input type="hidden" name="command" value="boardCheckPass">
				<input type="hidden" name="num" value="${param.num}">
				<table style="width:80%">
					<tr>
						<th>수정/삭제 비밀번호</th>
						<td><input type="password" name="pass" size="20"></td>
					</tr>
				</table><br>
				<input type="submit" value="확인" onclick="return passCheck()">
				<br><br>${message}
			</form>
		</div>
	</body>
</html>