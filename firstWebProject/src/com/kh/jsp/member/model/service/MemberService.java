package com.kh.jsp.member.model.service;

import java.sql.Connection;

import com.kh.jsp.member.model.dao.MemberDao;
import com.kh.jsp.member.model.vo.Member;
import static com.kh.jsp.common.JDBCTemplate.*;
// Service :
//         Controller인 서블릿에서
//         전달한 정보를 업무 수행로직(비즈니스 로직)에 따라
//         가공하여 Dao에게 전달하는 역할
public class MemberService {

   private Connection con;
   private MemberDao mDao = new MemberDao();
   
   public Member selectMember(Member m) {
      con = getConnection();
      
      Member result = mDao.selectMember(con,m);
      
      close(con);
      
      // 예외처리
      
      return result;
   }

}