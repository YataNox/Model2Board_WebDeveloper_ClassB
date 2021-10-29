package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

public class BoardWriteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 내용들을 BoardDto에 담아서 BoardDao의 insertBoard메소드로
		// 전달해서 레코드를 추가합니다.
		
		BoardDto bdto = new BoardDto();
		bdto.setUserid(request.getParameter("userid"));
		bdto.setPass(request.getParameter("pass"));
		bdto.setEmail(request.getParameter("email"));
		bdto.setTitle(request.getParameter("title"));
		bdto.setContent(request.getParameter("content"));
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.insertBoard(bdto);
		
		// 최종 board.do?command=boardlist로 이동합니다.
		response.sendRedirect("board.do?command=boardlist");
	}
}
