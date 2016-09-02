package com.zj.action.chapter02;

import javax.servlet.*;
import java.io.IOException;

/**
 * 无状态的Servlet<br/>无状态的对象永远是线程安全的
 * Created by LZJ on 2015/12/7.
 */
public class StatelessServlet01 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //每次返回的变量a都是各自的方法栈的本地变量
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        int a = 1;
        servletResponse.getWriter().write(a);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
