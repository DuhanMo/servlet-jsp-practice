package com.kh.jsp.notice.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jsp.notice.model.vo.Notice;
import static com.kh.jsp.common.JDBCTemplate.*;

public class NoticeDao {

	private Properties prop;
	
	public NoticeDao(){
		prop = new Properties();
		
		String filePath = NoticeDao.class.getResource("/config/notice-query.properties").getPath();
		
		try{
			prop.load(new FileReader(filePath));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Notice> selectList(Connection con) {
		
		ArrayList<Notice> list = null;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try{
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			// Insert, Update, Delete : executeUpdate()
			// select : executeQuery()
			list = new ArrayList<Notice>();
			while(rset.next()){
				Notice n = new Notice();
				n.setNno(rset.getInt(1));
				n.setNtitle(rset.getString("ntitle"));
				n.setNcontent(rset.getString("ncontent"));
				n.setNwriter(rset.getString("nwriter"));
				n.setNcount(rset.getInt("ncount"));
				n.setNdate(rset.getDate("ndate"));
				
				list.add(n);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public Notice selectOne(Connection con, int nno) {
		Notice n = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		
		String sql = prop.getProperty("selectOne");
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			// INSERT, UPDATE, DELETE : executeUpdate();
			// SELECT : executeQuery();
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				n = new Notice();
				n.setNno(nno);
				n.setNtitle(rset.getString("ntitle"));
				n.setNcontent(rset.getString("ncontent"));
				n.setNwriter(rset.getString("nwriter"));
				n.setNcount(rset.getInt("ncount"));
				n.setNdate(rset.getDate("ndate"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return n;
	}

	public int updateReadCount(Connection con, int nno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReadCount");
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int insertNotice(Connection con, Notice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNotice");
		
		try{
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n.getNtitle());
			pstmt.setString(2, n.getNcontent());
			pstmt.setString(3, n.getNwriter());
			pstmt.setDate(4, n.getNdate());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

}
