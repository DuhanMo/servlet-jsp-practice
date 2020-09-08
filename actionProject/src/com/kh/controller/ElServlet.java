package com.kh.controller;

import com.kh.model.vo.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/el.do")
public class ElServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        *
        * JSP 내장객체
        * 1. page : 현재 해당하는 페이지에서만 사용 가능 --> 공유범위가 가장 작다(한 페이지)
        * 2. request : 현재 페이지 + 응답페이지까지 사용 가능 --> 공유범위가 그 다음으로 크다(단, 제한적)
        * 3. session : 한 브라우저당 1개 존재, 모든 jsp에서 사용 가능 --> 공유범위가 모든 jsp
        * 4. application : 한 애플리케이션당 1개 존재, 애플리케이션 전역에서 사용 가능 --> 공유범위가 가장 크다.
        * */
        //requestScope 에 담기
        request.setAttribute("classRoom","H강의장");
        request.setAttribute("student",new Person("홍길동",20,'남'));
        // sessionScope 담기
        HttpSession session = request.getSession();
        session.setAttribute("academy","KH정보교육원");
        session.setAttribute("teacher",new Person("유승제",38,'남'));

        RequestDispatcher view = request.getRequestDispatcher("views/01_el/01_el.jsp");
        view.forward(request,response);
    }
}
