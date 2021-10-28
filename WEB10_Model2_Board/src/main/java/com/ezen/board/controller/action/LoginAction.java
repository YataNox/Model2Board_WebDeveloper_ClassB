package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;

public class LoginAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);
		
		String url = "member/loginForm.jsp";
		
		if(mdto == null) {
			request.setAttribute("message", "존재하지 않는 아이디입니다.");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}
}
