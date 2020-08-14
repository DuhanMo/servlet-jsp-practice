package com.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuOrderServlet
 */
@WebServlet("/menuOrder.do")
public class MenuOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
//		request.setCharacterEncoding("UTF-8");

		// 2. 전달받은 데이터 확인
		String menu = request.getParameter("menuSelect");

		// 3. 비즈니스 로직
		int price = 0;
		switch(menu) {
		case "텐동" : price = 9000;
		break;
		case "피자" : price = 138000;
		break;
		case "햄버거" : price = 15000;
		break;
		case "커리" : price = 10000;
		break;
		case "양꼬치" : price = 13000;
		break;
		}
		// 4. 실행결과 전송
		request.setAttribute("menu",menu);
		request.setAttribute("price",price);
		
		// Foward 방식
		RequestDispatcher view = request.getRequestDispatcher("views/04_menuResult.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
