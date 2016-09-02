package zj.ext;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class Parent {

    //四种访问修饰符的继承性
    public void a() {
        c();
    }

    protected void b() {

    }

    void c() {

    }

    //private方法默认都是final的,虽然可以加final修饰,但是并没有什么意义
    private void d() {


    }


}
