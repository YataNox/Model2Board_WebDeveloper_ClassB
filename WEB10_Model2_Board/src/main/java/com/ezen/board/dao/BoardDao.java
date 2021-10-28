package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDao {
	private BoardDao() {}
	private static BoardDao ist = new BoardDao();
	public static BoardDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
}
