package com.edu.test;

import javax.servlet.*;
import java.io.IOException;

public class FlowFilterTwo implements Filter {
    public void destroy() {
        System.out.println("destroy() 호출....... two");

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


//        req.setCharacterEncoding("UTF-8");
        System.out.println("doFilter() 호출 전....... two");
        chain.doFilter(req,resp);
        System.out.println("doFilter() 호출 후 ....... two");

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init() 호출....... two");
    }

}
