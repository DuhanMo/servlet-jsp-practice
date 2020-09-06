package com.edu.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int i = 1;
        while (i<11){
            out.print("<br>number : " + i);
            i++;

            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();

            }

        }
        out.print("<br>실행완료!");
        out.close();
    }
}
