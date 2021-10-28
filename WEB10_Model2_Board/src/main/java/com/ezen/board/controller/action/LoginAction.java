package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		}else if(mdto.getUserpwd().equals(userpwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto);
			url = "board.do?command=boardlist";
		}
		else if(!mdto.getUserpwd().equals(userpwd)) {
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		else {
			request.setAttribute("message", "DB 또는 System 오류");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}
}
