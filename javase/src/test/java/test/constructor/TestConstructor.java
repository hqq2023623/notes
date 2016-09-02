package test.constructor;

import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class TestConstructor {

    //没有私有的构造函数
    @Test
    public void test01() throws Exception {

        Class clz = NoDefaultConstructor.class;
        //只有一个声明的构造函数
        assertEquals(1, clz.getDeclaredConstructors().length);
        assertEquals(1, clz.getConstructors().length);

        Constructor constructor = clz.getConstructor(String.class);
        //有有参构造函数就不会有默认的无参构造函数,就无法new
//        NoDefaultConstructor no = (NoDefaultConstructor) clz.newInstance();
//        System.out.println(no == null);

    }


    //有私有无参的构造函数,给了无参的就会被反射攻破
    @Test
    public void test02() throws Exception {
        Class clz = HasPrivateConstrutor.class;
        assertEquals(2, clz.getDeclaredConstructors().length);

        //不能进入private构造函数
        //HasPrivateConstrutor has = (HasPrivateConstrutor) clz.newInstance();
        //System.out.println(has == null);

        //需要取得Constructor然后setAccessible(True);
//        int i = 1;
//        for (Constructor c : clz.getDeclaredConstructors()) {
//            System.out.println(c.getName() + i++);
//            for (Class types : c.getParameterTypes()) {
//                System.out.println(types.getName() + i++);
//            }
//        }
        Constructor pri = clz.getDeclaredConstructors()[0];
        pri.setAccessible(true);
        HasPrivateConstrutor has2 = (HasPrivateConstrutor) pri.newInstance();
        System.out.println(has2);

    }

}
