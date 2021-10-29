package com.ezen.board.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;

public class JoinAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDto mdto = new MemberDto();
		
		mdto.setName(request.getParameter("name"));
		mdto.setUserid(request.getParameter("userid"));
		mdto.setUserpwd(request.getParameter("userpwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		MemberDao mdao = MemberDao.getInstance();
		
		/*int result =*/ mdao.insertMember(mdto);
		// String message = "";
		
		/*
		 * if(result == 1) { message = "회원가입 완료. 로그인하세요."; }else { message =
		 * "회원가입 실패. 관리자에게 문의하세요"; }
		 */

		// RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
		// dp.forward(request, response);
		// 최종 도착 페이지에서 새로고침을 하면 데이터도 한 번 더 추가되려고 시도합니다.
		// 새로고침에 의해 포워딩 이전 코드가 다시 실행되지 않으려면 sendRedirect를 이용합니다.
		response.sendRedirect("board.do?command=loginForm");
	}
}
