package com.kh.ajax.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test4.do")
public class TestServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String singer1 = request.getParameter("singer1");
        String singer2 = request.getParameter("singer2");
        String singer3 = request.getParameter("singer3");
        response.getWriter().println(singer1+singer2+singer3);
        System.out.printf("이번 초대 가수는 %s %s %s 입니다.\n",singer1,singer2,singer3);

    }
}
