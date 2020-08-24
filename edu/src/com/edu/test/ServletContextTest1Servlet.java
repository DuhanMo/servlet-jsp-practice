package com.edu.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/context1")
public class ServletContextTest1Servlet extends HttpServlet {
//    ServletContext sc;
//
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        sc = config.getServletContext();
//
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ServletContext sc = this.getServletContext();
        String location = sc.getInitParameter("contextConfig");
        out.println("location : " + location);
        out.close();
    }
}
