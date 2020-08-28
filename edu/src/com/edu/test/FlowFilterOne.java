package com.edu.test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class FlowFilterOne implements Filter {
    public void destroy() {
        System.out.println("destroy() 호출....... one");

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        System.out.println("doFilter() 호출 전....... one");
        chain.doFilter(req,resp);
        System.out.println("doFilter() 호출 후 ....... one");

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init() 호출....... one");
    }

}
