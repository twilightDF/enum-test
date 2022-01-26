package com.twilight.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 重写doFilter 实现解决字符集乱码
 */
public class EncodingFilter implements Filter {

    public EncodingFilter() {
        System.out.println("过滤器构造");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");//将编码改为utf-8
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
