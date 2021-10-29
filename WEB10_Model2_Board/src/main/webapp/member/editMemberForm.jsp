<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>editMemberForm</title>
		<link rel="stylesheet" type="text/css" href="css/board.css">
		<script type="text/javascript" src="script/board.js"></script>
	</head>
	<body>
		<div id="wrap" align="center">
			<h1>사용자 수정</h1>
		</div>
			<form name="frm" action="board.do" method="post">
				<input type="hidden" name="command" value="editMember">
				<table>
					<tr>
						<th>아이디</th>
						<td>${loginUser.userid}
							<input type="hidden" name="userid" value="${loginUser.userid}">&nbsp;
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userpwd" size="20">&nbsp;*</td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" name="userpwd_check" size="20">&nbsp;*</td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="name" value="${loginUser.name}" size="20"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email" value="${loginUser.email}" size="20"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="phone" value="${loginUser.phone}" size="20"></td>
					</tr>
					<tr>
						<th>등급</th>
						<td>
							<c:choose>
								<c:when test="${loginUser.admin==0}">
									<input type="radio" name="admin" value="0" checked="checked">일반회원&nbsp;
									<input type="radio" name="admin" value="1">관리자
								</c:when>
								<c:otherwise>
									<input type="radio" name="admin" value="0">일반회원&nbsp;
									<input type="radio" name="admin" value="1" checked="checked">관리자
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</table>
				<input type="submit" value="수정" onclick="return editCheck()">&nbsp;
				<input type="reset" value="다시작성"/>
				<input type="button" value="목록으로" onclick="location.href='board.do?command=boardlist'"/>
			</form>
	</body>
</html>