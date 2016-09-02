package com.zj.action.chapter02;

import javax.servlet.*;
import java.io.IOException;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有状态的servlet<br/>没有做同步操作,是不安全的
 * Created by LZJ on 2015/12/7.
 */
public class UnsafeServlet02 implements Servlet {

    private int count = 0;

    //使用Atomic类来保证操作的原子性
    private AtomicInteger ai = new AtomicInteger(0);

    private Vector<Integer> vector = null;

    //惰性初始化
    public Vector<Integer> getVector() {
        vector = new Vector<>();
        //虽然vector的每个操作都是原子的,但是把多个操作整合到一个复合操作时,还是需要额外的锁
        //此时vector的状态不可以确定(方法本身不是同步的,会有多个线程同时进来)
        if (!vector.contains(1)) {
            vector.add(1);
        }
        return vector;
    }

    public int getCount() {
        return count;
    }

    public int getAi() {
        return ai.get();
    }

    //虽然是安全的,但是性能不咋滴
    public synchronized void safe() {
        //synchronized保证了一段操作的原子性,同一时间只有一个线程可以执行
        //在修改状态变量的时候也要确保对相关联的状态变量的安全操作
        //对于每一个涉及多个变量的不变约束,需要同一个锁保护其所有的变量
        synchronized (ai) {

        }
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        count++;
        servletResponse.getWriter().write(count);
        //最常见的竞争条件:检查再运行
        if (count == 1) {
            servletResponse.getWriter().write(count++);
        } else {
            servletResponse.getWriter().write(++count);
        }
        //自增
        ai.incrementAndGet();
        servletResponse.getWriter().write(getAi());

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
