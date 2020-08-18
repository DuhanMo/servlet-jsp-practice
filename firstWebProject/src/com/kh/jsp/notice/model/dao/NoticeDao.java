package com.kh.jsp.notice.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.jsp.common.JDBCTemplate.*;
import com.kh.jsp.notice.model.vo.Notice;

public class NoticeDao {
   private Properties prop;
   
   
   public NoticeDao() {
      prop= new Properties();
      String filePath = NoticeDao.class.getResource("/config/notice-query.properties").getPath();
      
      try {
         prop.load(new FileReader(filePath));
      }catch (IOException e) {
         e.printStackTrace();
      }
   }


   public ArrayList<Notice> selectList(Connection con) {
      ArrayList<Notice> list =new ArrayList<Notice>();
      Statement stmt = null;
      
      ResultSet rset = null;
      
      String sql = prop.getProperty("selectList");
      
      try {
         stmt=con.createStatement();
         rset=stmt.executeQuery(sql);
         //INSERT,UPDATE,DELETE : executeUpdate()
         //SELECT : executeQuery()
         while (rset.next()) {
            Notice n = new Notice();
            
            n.setNno(rset.getInt("nno"));
            n.setNtitle(rset.getString("ntitle"));
            n.setNcontent(rset.getString("ncontent"));
            n.setNwriter(rset.getString("nwriter"));
            n.setNcount(rset.getInt("ncount"));
            n.setNdate(rset.getDate("ndate"));

            list.add(n);
         }
         
      }catch (Exception e) {
         // TODO: handle exception
      }finally {
         close(rset);
         close(stmt);
      }
      
      return list;
   }

}