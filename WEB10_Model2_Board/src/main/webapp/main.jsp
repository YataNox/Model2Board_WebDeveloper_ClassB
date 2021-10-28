<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Main</title>
	</head>
	<body>
		<table>
			<tr>
				<td colspan="5" stlye="border:white">
					<div style="float:left;">
						${loginUser.name}(${loginUser.userid})님 로그인
						<input type="button" value="회원정보수정" onClick="location.href=board.do?command=editMemberForm">
						<input type="button" value="로그아웃" onClick="location.href=board.do?command=logout">
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>