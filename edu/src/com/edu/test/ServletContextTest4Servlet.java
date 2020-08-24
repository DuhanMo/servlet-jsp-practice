package com.edu.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/context4")
public class ServletContextTest4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ServletContext sc = this.getServletContext();
        ShareObject obj1 = (ShareObject) sc.getAttribute("data1");
        ShareObject obj2 = (ShareObject) sc.getAttribute("data2");

        out.print("DATA 1 : " + obj1.getCount()+", " + obj1.getStr() + "<br>");
        out.print("DATA 2 : " + obj2.getCount()+", " + obj2.getStr() + "<br>");

        out.close();

    }
}
