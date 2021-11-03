package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardUpdateAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num = "";
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("upload");
		BoardDto bdto = new BoardDto();
		
		try {
			MultipartRequest multi = new MultipartRequest(request,
					path, 5*1024*1024, "UTF-8",
					new DefaultFileRenamePolicy());
			num = multi.getParameter("num");
			bdto.setUserid(multi.getParameter("userid"));
			bdto.setPass(multi.getParameter("pass"));
			bdto.setEmail(multi.getParameter("email"));
			bdto.setTitle(multi.getParameter("title"));
			bdto.setContent(multi.getParameter("content"));
			bdto.setNum(Integer.parseInt(multi.getParameter("num")));
			String filename = multi.getFilesystemName("imgfilename");
			if(filename == null)
				filename = multi.getParameter("oldfilename");
			bdto.setImgfilename(filename);
		}catch(Exception e) {
			System.out.println("업로드 실패 : " + e);
		}
	
		BoardDao bdao = BoardDao.getInstance();
		bdao.updateBoard(bdto);
		
		RequestDispatcher dp = request.getRequestDispatcher("board.do?command=boardviewwithoutcount&num=" + num);
		dp.forward(request, response);
	}
}
