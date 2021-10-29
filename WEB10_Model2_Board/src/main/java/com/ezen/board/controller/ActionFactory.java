package com.ezen.board.controller;

import com.ezen.board.controller.action.Action;
import com.ezen.board.controller.action.BoardListAction;
import com.ezen.board.controller.action.BoardWriteAction;
import com.ezen.board.controller.action.BoardWriteFormAction;
import com.ezen.board.controller.action.EditMemberAction;
import com.ezen.board.controller.action.EditMemberFormAction;
import com.ezen.board.controller.action.IdCheckAction;
import com.ezen.board.controller.action.JoinAction;
import com.ezen.board.controller.action.JoinFormAction;
import com.ezen.board.controller.action.LoginAction;
import com.ezen.board.controller.action.LoginFormAction;
import com.ezen.board.controller.action.LogoutAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory ist = new ActionFactory();
	public static ActionFactory getInstance() {return ist;}
	
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("login")) ac = new LoginAction();
		else if(command.equals("boardlist")) ac = new BoardListAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("idcheck")) ac = new IdCheckAction();
		else if(command.equals("editMemberForm")) ac = new EditMemberFormAction();
		else if(command.equals("editMember")) ac= new EditMemberAction();
		else if(command.equals("logout")) ac = new LogoutAction();
		else if(command.equals("boardWriteForm")) ac = new BoardWriteFormAction();
		else if(command.equals("boardWrite")) ac = new BoardWriteAction();
		return ac;
	}
}
