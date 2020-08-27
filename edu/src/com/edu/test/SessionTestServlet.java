package com.edu.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String param = request.getParameter("p");
        String msg = null;
        HttpSession session = null;

        if(param.equals("create")){
            session = request.getSession();
            if (session.isNew()){
                msg = "새로운 세션 객체 생성됨";
            }else {
                msg = "새로운 세션 객체 리턴";
            }
        }else if (param.equals("delete")){
            session = request.getSession(false);
            if (session != null){
                session.invalidate();
                msg = "세션 객체 삭제 작업 롼료";
            }else {
                msg = "삭제할 세션 객체 존재하지 않음";
            }
        }else if (param.equals("add")){
            session = request.getSession(true);
            session.setAttribute("msg","메세지입니다");
            msg = "세션 객체에 데이터 등록 완료 ";
        }else if (param.equals("get")){
            session = request.getSession(false);
            if (session != null){
                String str = (String)session.getAttribute("msg");
                msg = str;
            }else {
                msg = "데이터를 추출할 세션 객체 존재하지 않음";
            }

        }else if (param.equals("remove")){
            session = request.getSession(false);
            if(session != null){
                session.removeAttribute("msg");
                msg = "세션 객체의 데이터 삭제 완료";
            }else {
                msg = "데이터를 삭제할 세션 객체 존재하지 않음";
            }
        }else if (param.equals("replace")){
            session = request.getSession();
            session.setAttribute("msg", "새로운 메세지입니다.");
            msg = "세션 객체에 데이터 등록 완료";
        }
        out.print("처리 결과 : " + msg);
        out.close();
    }
}
