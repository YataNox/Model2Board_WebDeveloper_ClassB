package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.board.dto.BoardDto;
import com.ezen.board.dto.ReplyDto;
import com.ezen.board.util.DBman;
import com.ezen.board.util.Paging;

public class BoardDao {
	private BoardDao() {}
	private static BoardDao ist = new BoardDao();
	public static BoardDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BoardDto> selectBoard(Paging paging) 
	{
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		con = DBman.getConnection();
		String sql = "select * from("
				+ "select * from("
				+ "select rownum as rn, t.* from("
				+ "select * from board order by num desc) t) where rn <= ?) where rn >= ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getEndNum());
			pstmt.setInt(2, paging.getStartNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto bdto = new BoardDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setPass(rs.getString("pass"));
				bdto.setEmail(rs.getString("email"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(bdto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public void insertBoard(BoardDto bdto) {
		con = DBman.getConnection();
		String sql = "insert into board(num, userid, pass, email, title, content)"
				+ " values(board_seq.nextVal, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getUserid());
			pstmt.setString(2, bdto.getPass());
			pstmt.setString(3, bdto.getEmail());
			pstmt.setString(4, bdto.getTitle());
			pstmt.setString(5, bdto.getContent());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
	}

	public void updateReadcount(int num) {
		con = DBman.getConnection();
		String sql = "update board set readcount = readcount + 1 where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
	}

	public BoardDto getBoard(int num) {
		BoardDto bdto = null;
		con = DBman.getConnection();
		
		String sql = "select * from board where num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bdto = new BoardDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setPass(rs.getString("pass"));
				bdto.setEmail(rs.getString("email"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				bdto.setReadcount(rs.getInt("readcount"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return bdto;
	}

	public void updateBoard(BoardDto bdto) {
		con = DBman.getConnection();
		String url="update board set userid=?, pass=?, email=?, title=?, content=? "
				+ "where num=?";
		
		try {
			pstmt = con.prepareStatement(url);
			pstmt.setString(1, bdto.getUserid());
			pstmt.setString(2, bdto.getPass());
			pstmt.setString(3, bdto.getEmail());
			pstmt.setString(4, bdto.getTitle());
			pstmt.setString(5, bdto.getContent());
			pstmt.setInt(6, bdto.getNum());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
	}

	public void deleteBoard(int num) {
		con = DBman.getConnection();
		String sql = "delete from board where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			DBman.close(con, pstmt, rs);
		}
	}

	public int getAllCount() {
		int count = 0;
		con = DBman.getConnection();
		String sql = "select count(*) as cnt from board";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				count = rs.getInt("cnt");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			DBman.close(con, pstmt, rs);
		}
		
		return count;
	}

	public void insertReply(ReplyDto rdto) {
		String sql = "insert into reply(num, boardnum, userid, content) values(reply_seq.nextVal, ?, ?, ?)";
		con = DBman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rdto.getBoardnum());
			pstmt.setString(2, rdto.getUserid());
			pstmt.setString(3, rdto.getContent());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
	}

	public ArrayList<ReplyDto> selectReply(int num) {
		ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();
		String sql = "select * from reply where boardnum = ? order by num desc";
		con = DBman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyDto rdto = new ReplyDto();
				rdto.setNum(rs.getInt("num"));
				rdto.setBoardnum(rs.getInt("boardnum"));
				rdto.setUserid(rs.getString("userid"));
				rdto.setWritedate(rs.getTimestamp("writedate"));
				rdto.setContent(rs.getString("content"));
				list.add(rdto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return list;
	}
}
