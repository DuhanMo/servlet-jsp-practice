package com.kh.jsp.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import static com.kh.jsp.common.JDBCTemplate.*;
import com.kh.jsp.member.model.vo.Member;
// Dao(Data Access Object)
//      Service로부터 받은 정보를
//         실제 데이터 베이스에 전달하여
//     CRUD를 수행하는 객체
public class MemberDao {

   private Properties prop;
   
   public MemberDao(){
      prop = new Properties();
      
      String filePath = MemberDao.class.getResource("/config/member-query.properties").getPath();
      try{
         prop.load(new FileReader(filePath));
      }catch(FileNotFoundException e){
         e.printStackTrace();
      }catch(IOException e){
         e.printStackTrace();
      }
   }
   
   public Member selectMember(Connection con, Member m) {
      Member result = null; // 결과를 담을 객체
      PreparedStatement pstmt = null;
      ResultSet rset = null; // Select의 결과를 담을 객체
      
      String sql = prop.getProperty("selectMember");
      
      try{
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, m.getUserId());
         pstmt.setString(2, m.getUserPwd());
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
               result = new Member();
               
               result.setUserId(m.getUserId());
               result.setUserPwd(m.getUserPwd());
                  
               result.setUserName(rset.getString(3));
               result.setAge(rset.getInt("age"));
               result.setGender(rset.getString("GENDER"));
               result.setEmail(rset.getString("email"));
               result.setPhone(rset.getString("phone"));
               result.setAddress(rset.getString("address"));
               result.setHobby(rset.getString("hobby"));
               
            }
         
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         close(rset);
         close(pstmt);
      }
      
      return result;
   }

}