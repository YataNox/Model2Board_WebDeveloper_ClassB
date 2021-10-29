package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;

public class EditMemberAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDto mdto = new MemberDto();
		mdto.setName(request.getParameter("name"));
		mdto.setUserid(request.getParameter("userid"));
		mdto.setUserpwd(request.getParameter("userpwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.updateMember(mdto);
		HttpSession session = request.getSession();
		
		if(result==1) {
			request.setAttribute("message", "회원정보를 수정하였습니다.");
			session.setAttribute("loginUser", mdto);
		}else {
			request.setAttribute("message", "회원정보를 수정하지 못했습니다.");
		}
				
		RequestDispatcher dp = request.getRequestDispatcher("board.do?command=boardlist");
		dp.forward(request, response);
	}
}
