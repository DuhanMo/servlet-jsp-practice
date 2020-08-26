package com.kh.jsp.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.board.model.dao.BoardDao;
import com.kh.jsp.board.model.vo.Board;

import static com.kh.jsp.common.JDBCTemplate.*;
public class BoardService {

	private BoardDao bDao = new BoardDao();
	
	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = bDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Board> list = bDao.selectList(con,currentPage,limit);
		
		close(con);
		
		return list;
	}

	public Board selectOne(int bno) {
		Connection con = getConnection();
		
		Board b = bDao.selectOne(con,bno);
		
		close(con);
		
		return b;
	}

	public int insertBoard(Board b) {
		Connection con = getConnection();
		
		int result = bDao.insertBoard(con, b);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

	public Board updateView(int bno) {
		Connection con = getConnection();
		
		Board b = bDao.selectOne(con, bno);
		
		close(con);
		return b;
	}

	public int updateBoard(Board b) {
		Connection con = getConnection();
		int result = bDao.updateBoard(con,b);
		if(result > 0) commit(con);
		else rollback(con);
		return result;
	}

}








