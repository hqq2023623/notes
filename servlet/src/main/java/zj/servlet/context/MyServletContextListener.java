package zj.servlet.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Lzj Created on 2016/3/1.
 */
public class MyServletContextListener implements ServletContextListener {

    private ServletContext context = null;

    //ServletContext启动之后调用，准备好处理客户端请求
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.context = sce.getServletContext();
        //在ServletContext中设置属性
        context.setAttribute("author", "lzj");
    }

    //ServletContext将要关闭的时候调用
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.context = null;
    }


}
