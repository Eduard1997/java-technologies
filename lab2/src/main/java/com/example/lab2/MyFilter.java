package com.example.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebFilter("/process-form")
public class MyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;

        String servletPath = req.getServletPath();
        String remoteAddr = request.getRemoteAddr();

        System.out.println(" ");
        System.out.println("Logging Date: " + new Date());
        System.out.println("Servlet path: " + servletPath );
        System.out.println("Call from : " + remoteAddr);

        chain.doFilter(request, response);
    }
}
