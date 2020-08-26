package com.kh.jsp.notice.model.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.commit;
import static com.kh.jsp.common.JDBCTemplate.getConnection;
import static com.kh.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.notice.model.dao.NoticeDao;
import com.kh.jsp.notice.model.vo.Notice;
public class NoticeService {

	private NoticeDao nDao = new NoticeDao();
	
	public ArrayList<Notice> selectList() {
		Connection con = getConnection();
		
		ArrayList<Notice> list = nDao.selectList(con);
		
		close(con);
		return list;
	}

	public Notice selectOne(int nno) {
		// 게시글 상세보기를 통해 1회 조회 할떄 2가지 기능이 실행된다.
		// 1. nno에 해당하는 게시글 내용을 가져오기(SELECT)
		// 2. 게시글 내용이 성공적으로 불러와졌다면 조회수가 1증가해야한다.(UPDATE)
		Connection con = getConnection();
		
		Notice n = nDao.selectOne(con,nno);
		
		if(n != null) {
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
		
		// 0: 실행한 행의 개수 없음
		// 1이상: n개의 행 실행
		// -1 : 실행중 에러발생
		
		
		if(result >= 1) commit(con);
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

	public int updateNotice(Notice n) {
		Connection con = getConnection();
		
		int result = nDao.updateNotice(con,n);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

	public int deleteNotice(int nno) {
		Connection con = getConnection();
		
		int result = nDao.deleteNotice(con,nno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

	public ArrayList<Notice> searchNotice(String category, String keyword) {
		Connection con = getConnection();
		ArrayList<Notice> list = null;
		
		if(category.length() >0) list= nDao.searchNotice(con,category,keyword);
		else list = nDao.selectList(con);
		
		
		return list;
	}

}












