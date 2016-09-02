package test;

import javax.sound.midi.Soundbank;

/**
 * 覆盖equals和hashCode方法
 * Created by lzj on 2016/3/26.
 */
public class TestEquals {

    private int id;

    public static void main(String[] args) {
        TestEquals x = new TestEquals();
        TestEquals y = new TestEquals();
        x.id = 1;
        y.id = 1;
        //equals相等，hashCode一定相等，本例中id相同，则id求余的值必然相同
        //hashCode不等，equals一定不等，本例中id求余的值不同则id值必然不同，equals自然不等
        System.out.println("当x和y的id值相等时，equals结果： " + x.equals(y));

        //equals不相等，但是hashCode可以相等
        x.id = 37;
        y.id = 74;
        System.out.println("当x和y的id值不等，hashCode相等时，equals结果： " + x.equals(y));

    }

    /**
     * 重写hashCode
     * 1.equals相等，hashCode一定相等
     * 2.hashCode不等，equals一定不等
     *
     * @return id求余37的hash值
     */
    @Override
    public int hashCode() {
        //确保equals用到的所有比较参数不变的时候返回值仙宫
        return id % 37;
    }

    /**
     * 重写equals，有以下准则
     * 1.反射性： 对于非空对象x ， x.equals(x)永远为true
     * 2.对称性： 若x.equals(y) ， 那么 y.equals(x)
     * 3.传递性： 若x.equals(y) && y.equals(z) ， 那么 x.equals(z)
     * 4.一致性： 参与equals比较的参数不变的情况下，equals结果不变
     * 5.对于所有非空对象和null进行equals运算后得到的永远是false
     * 根据实际情况，本例中只需要两个对象id相等即视为equals
     * @param obj 比较的对象
     * @return this.id == obj.id
     */
    @Override
    public boolean equals(Object obj) {
        //反射性：自身永远等于自身
        if (obj == this) {
            return true;
        }
        //一个对象和不同类型的对象永远不等
        if (obj == null || !(obj instanceof TestEquals)) {
            return false;
        }
        return this.id == ((TestEquals) obj).id;
    }
}
