package com.kh.jsp.boardComment.model.service;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.boardComment.model.dao.BoardCommentDao;
import com.kh.jsp.boardComment.model.vo.BoardComment;
public class BoardCommentService {

	private BoardCommentDao bcDao = new BoardCommentDao();
	
	public ArrayList<BoardComment> selectList(int bno) {
		Connection con = getConnection();
		ArrayList<BoardComment> clist = 
				bcDao.selectList(con, bno);
		close(con);
		return clist;
	}

	public int insertComment(BoardComment bco) {
		Connection con = getConnection();
		int result = bcDao.insertComment(con,bco);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

}







