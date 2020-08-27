package com.edu.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logProc")
public class LoginOutServlet extends HttpServlet {
    // 로그인 처리
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out  = response.getWriter();
        String id = request.getParameter("id");
        String pwd  = request.getParameter("pwd");

        if (id.isEmpty() || pwd.isEmpty()){
            out.print("ID 또는 비밀번호를 입력해주세요");
            return;
        }
        HttpSession session = request.getSession();
        if(session.isNew() || session.getAttribute("id") == null){
            session.setAttribute("id",id);
            out.print("로그인을 완료 하였습니다.");

        }else {
            out.print("현재 로그인 상태입니다.");
        }
    }

    //로그아웃 처리
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        if(session != null && session.getAttribute("id") != null){
            session.invalidate();
            out.print("로그아웃 작업 완료하였습니다.");
        }else {
            out.print("현재 로그인 상태가 아닙니다.");
        }
        out.close();
    }
}
