package com.edu.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/portalSite")
public class SendRedirectTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("site");
        if(param.equals("naver")){
            response.sendRedirect("http://www.naver.com");
        }else if(param.equals("daum")){
            response.sendRedirect("http://www.daum.net");
        }else if(param.equals("zum")){
            response.sendRedirect("http://zum.com");
        }else if(param.equals("google")){
            response.sendRedirect("http://www.google.com");
        }

    }
}
