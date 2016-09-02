package zj.ext;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class Child extends Parent {

    //在同一个包只有private不可见
    public static void main(String[] args) {
        Child c = new Child();
        c.a();
        c.b();
        c.c();
    }


}
