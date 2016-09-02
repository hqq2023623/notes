package zj.jvm.ssy;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class Jvm01 {


    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(Singleton.count1 == 1);
        System.out.println(Singleton.count2 == 0);
    }


}

class Singleton {

    //静态变量会先被赋予默认值然后再执行初始化的赋值
    private static Singleton singleton = new Singleton();

    public static int count1;

    public static int count2 = 0;


    private Singleton() {
        count1++;
        count2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }

}
