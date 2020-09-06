package com.edu.test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "timer", urlPatterns = "/third")
public class FlowFilterThree implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        long startTime = System.currentTimeMillis();
        chain.doFilter(req,resp);
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        System.out.println("수행 시간 : " + executeTime);
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
