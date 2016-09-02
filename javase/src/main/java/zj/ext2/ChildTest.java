package zj.ext2;

import zj.ext.Child;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class ChildTest {

    //在不同包只有public可见,但是可以在public的方法里面调用其他方法
    public static void main(String[] args) {
        Child c = new Child();
        c.a();
    }


}
