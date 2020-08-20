package com.kh.jsp.member.model.service;

import java.sql.Connection;

import com.kh.jsp.member.exception.MemberException;
import com.kh.jsp.member.model.dao.MemberDao;
import com.kh.jsp.member.model.vo.Member;
import static com.kh.jsp.common.JDBCTemplate.*;
// Service :
//			Controller인 서블릿에서
//			전달한 정보를 업무 수행로직(비즈니스 로직)에 따라
//			가공하여 Dao에게 전달하는 역할
public class MemberService {

	private Connection con;
	private MemberDao mDao = new MemberDao();

	public Member selectMember(Member m) throws MemberException {
		con = getConnection();

		Member result = mDao.selectMember(con,m);

		close(con);

		// 예외처리
		if(result == null) {
			throw new MemberException("회원 아이디나 비밀번호가 올바르지 않습니다.");
		}
		return result;
	}

	public int insertMember(Member m) throws MemberException {
		con = getConnection();

		int result = mDao.insertMember(con,m);

		if(result > 0) commit(con);
		else rollback(con);

		close(con);
		return result;

	}

	public int updateMember(Member m) throws MemberException {
		con = getConnection();

		int result = mDao.updateMember(con,m);

		if(result > 0) commit(con);
		else rollback(con);

		close(con);
		return result;


	}

	public int deleteMember(String userId) throws MemberException {
		con = getConnection();

		int result = mDao.deleteMember(con,userId);

		if(result > 0) commit(con);
		else rollback(con);

		close(con);
		return result;
	}

}
