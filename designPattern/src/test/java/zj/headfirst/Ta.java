package zj.headfirst;

/**
 * @author Lzj Created on 2015/12/18.
 */
public abstract class Ta {

    public void doSth() {
        System.out.println("A");
        doSthImportant();
        System.out.println("B");
    }

    //这是交给子类去实现的
    public abstract void doSthImportant();

    public static void main(String[] args) {
        Ta ta = new Tb();
        ta.doSth();
    }


}
