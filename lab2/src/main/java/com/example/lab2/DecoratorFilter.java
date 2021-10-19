package com.example.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class DecoratorFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SimpleResponseWrapper wrapper = new SimpleResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, wrapper);
        String content = wrapper.toString();
        content = content.replace("<body>", "<body> Hello from filter!");
        content += "<p> Thank you from filter!";
        PrintWriter out = response.getWriter();
        out.write(content);
    }
}
