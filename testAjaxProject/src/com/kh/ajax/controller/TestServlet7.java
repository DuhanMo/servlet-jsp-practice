package com.kh.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.ajax.model.vo.UserVo;

/**
 * Servlet implementation class TestServlet7
 */
@WebServlet("/test7.do")
public class TestServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		
		List<UserVo> userList = new ArrayList<UserVo>();
		
		// 10명 정보 등록하기
		UserVo user1 = new UserVo(1, "박보검", "남", "010-3333-1004");
		UserVo user2 = new UserVo(2, "송중기", "남", "010-1111-2222");
		UserVo user3 = new UserVo(3, "송영민", "남", "010-9189-9817");
		UserVo user4 = new UserVo(4, "이한솔", "남", "010-4938-0982");
		UserVo user5 = new UserVo(5, "홍석준", "남", "010-4763-3054");
		UserVo user6 = new UserVo(6, "송효근", "남", "010-4149-4719");
		UserVo user7 = new UserVo(7, "강원석", "남", "010-2361-0915");
		UserVo user8 = new UserVo(8, "홍정호", "남", "010-6565-4109");
		UserVo user9 = new UserVo(9, "배수지", "여", "010-1234-1234");
		UserVo user10 = new UserVo(10, "오재원", "남", "010-4444-0123");
		
		userList.add(user1); // 0
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		userList.add(user8);
		userList.add(user9);
		userList.add(user10); // 9
		
		String userIdxes = request.getParameter("userIdx");// 1,2,3
		
		// 결과 전달용 객체
		JSONObject result = new JSONObject();
		UserVo selectedUser = null;
		
		// 결과 한개씩 Json으로 변환할 객체
		JSONObject userInfo = null;
		JSONArray userArray = new JSONArray();
		
		String[] ids = userIdxes.split(",");  // 0:1, 1:2, 2:3
		int index = 0;
		for(String id: ids) {
			index = Integer.parseInt(id)-1;
			
			selectedUser = userList.get(index);
			
			userInfo = new JSONObject();
			
			userInfo.put("userNo", selectedUser.getUserNo());
			userInfo.put("userName",selectedUser.getUserName());
			userInfo.put("gender", selectedUser.getGender());
			userInfo.put("phone", selectedUser.getPhone());
			
			userArray.add(userInfo);
		}
		result.put("list", userArray);
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
