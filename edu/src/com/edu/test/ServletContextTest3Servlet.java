package com.edu.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/context3")
public class ServletContextTest3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ServletContext sc = this.getServletContext();

        ShareObject obj1 = new ShareObject();
        obj1.setCount(100);
        obj1.setStr("객체공유테스트 - 1");
        sc.setAttribute("data1",obj1);

        ShareObject obj2 = new ShareObject();
        obj2.setCount(200);
        obj2.setStr("객체공유테스트 - 2");
        sc.setAttribute("data2",obj2);

        out.print("ServletContext 객체에 데이터 등록을 하였습니다.!");
        out.close();


    }
}
