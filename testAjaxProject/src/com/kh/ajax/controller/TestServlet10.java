package com.kh.ajax.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.ajax.model.vo.UserListUtil;
import com.kh.ajax.model.vo.UserVo;

/**
 * Servlet implementation class TestServlet10
 */
@WebServlet("/test10.do")
public class TestServlet10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet10() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		List<UserVo> userList = UserListUtil.getInstance().getUserList();
		
		JSONObject userInfo = null;
		JSONArray result = new JSONArray();
		
		for(UserVo user: userList) {
			userInfo = new JSONObject();
			
			userInfo.put("userNo", user.getUserNo());
			userInfo.put("userName",user.getUserName());
			userInfo.put("gender", user.getGender());
			userInfo.put("phone",user.getPhone());
			
			result.add(userInfo);
		}
		response.getWriter().print(result.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
