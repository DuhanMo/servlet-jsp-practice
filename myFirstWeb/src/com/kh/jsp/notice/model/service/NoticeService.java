package com.kh.jsp.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.notice.model.dao.NoticeDao;
import com.kh.jsp.notice.model.vo.Notice;
import static com.kh.jsp.common.JDBCTemplate.*;

public class NoticeService {
	
	private NoticeDao nDao = new NoticeDao();
	
	public ArrayList<Notice> selectList() {
		Connection con = getConnection();
		
		ArrayList<Notice> list = nDao.selectList(con);
		
		close(con);
		return list;
	}

	public Notice selectOne(int nno) {
		// 게시글 상세보기를 통해 회 조회할 때 2가지 기능이 실행된다.
		// 1. nno에 해당하는 게시글 내용 가져오기(SELECT)
		// 2. 게시글 내용이 성공적으로 불러와졌다면, 조회수가 1 증가해야한다(UPDATE)
		Connection con = getConnection();
		
		Notice n = nDao.selectOne(con,nno);
		
		if(n != null){
			int result = nDao.updateReadCount(con,nno);
			
			if(result > 0) commit(con);
			else rollback(con);
		}
		close(con);
		return n;
	}

	public int insertNotice(Notice n) {
		Connection con = getConnection();
		
		int result = nDao.insertNotice(con,n);
		
		// 0일 때 : 실행한 행의 개수 없음
		// 1 이상 추가 : n개의 행이 실행 되었음
		// -1 : 실행 중 에러가 발생함
		
//		if(result>=0) commit(con);
		if(result>=1) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

	public Notice updateView(int nno) {
		Connection con = getConnection();
		
		Notice n = nDao.selectOne(con, nno);
		
		close(con);
		return n;
	}

}
