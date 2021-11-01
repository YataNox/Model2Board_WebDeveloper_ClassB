<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>BoardView</title>
		<link rel="stylesheet" type="text/css" href="css/board.css">
		<script type="text/javascript" src="script/board.js"></script>
	</head>
	<body>
		<div id="wrap" align="center">
			<h1>게시글 상세보기</h1>
			<table>
				<tr>
					<th>작성자</th><td>${board.userid}</td>
					<th>이메일</th><td>${board.email}</td>
				</tr>
				<tr>
					<th>작성일</th><td><fmt:formatDate value="${board.writedate}"/></td>
					<th>조회수</th><td>${board.readcount}</td>
				</tr>
				<tr>
					<th>제목</th><td colspan="3">${board.title}</td>
				</tr>
				<tr>
					<th>내용</th><td colspan="3"><pre>${board.content}</pre></td>
				</tr>
			</table>
			<br>
			<input type="button" value="리스트" onclick="location.href='board.do?command=boardlist'">
			<input type="button" value="수정" onclick="open_win('${board.num}', 'update');"/>
			<input type="button" value="삭제" onclick="open_win('${board.num}', 'delete');"/>
			
			<br><br>
			<!-- 여기서부터는 댓글 작성 영역 -->
			<c:set var="now" value="<%=new java.util.Date()%>"></c:set>
				<form action="board.do" method="post" name="frm2">
					<input type="hidden" name="command" value="addreply">
					<input type="hidden" name="boardnum" value="${board.num}">
					<table>
						<tr>
							<th>작성자</th>
							<th>작성일시</th>
							<th>내용</th>
							<th>추가/삭제</th>
						</tr>
						<tr align="center">
							<td width="100">${loginUser.userid}
								<input type="hidden" name="userid" value="${loginUser.userid}">
							</td>
							<td width="100">
								<fmt:formatDate value="${now}"	pattern="MM/dd HH:mm"></fmt:formatDate>
							</td>
							<td width="670">
								<input type="text" name="reply" size="80">
							</td>
							<td>
								<input type="submit" value="답글작성" onclick="return reply_check();">
							</td>
						</tr> <!-- 작성자, 날짜 시간, 작성란, 버튼 -->
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
				</form>
		</div>
	</body>
</html>