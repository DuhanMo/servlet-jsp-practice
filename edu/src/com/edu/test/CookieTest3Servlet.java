package com.edu.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie3")
public class CookieTest3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cnt = 0;
        Cookie[] list = request.getCookies();
        for (int i = 0; list!=null && i < list.length; i++) {
            if(list[i].getName().equals("count")){
                cnt = Integer.parseInt(list[i].getValue());
            }

        }
        cnt++;
        Cookie c = new Cookie("count",cnt+"");
        c.setMaxAge(60*60*24*10);
        response.addCookie(c);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<h1>방문 횟수 : " + cnt);
        out.close();
    }

}
