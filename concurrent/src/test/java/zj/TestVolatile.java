package zj;

/**
 * 理解volatile特性的一个好方法：
 * 把对volatile变量的单个读/写，看成是使用同一个锁对这些单个读/写操作做了同步
 * 每次读写操作都会把最新结果同步到主内存
 *
 * @author Lzj Created on 2016/3/25.
 */
public class TestVolatile {

    private volatile long vo = 0L;

    private long lo = 0L;


    public void set(long l) {
        vo = l;
    }

    public void getAndIncrement() {
        vo++;
    }

    public long get() {
        return vo;
    }

    //对单个的普通变量的写用同一个锁同步
    public synchronized void set2(long l) {
        lo = l;
    }

    //普通方法调用
    public void getAndIncrement2() {
        //调用已同步的读方法
        long temp = get();
        temp += 1L;
        //调用已同步的写方法
        set(temp);
    }

    //对单个的普通变量的读用同一个锁同步
    public synchronized long get2() {
        return lo;
    }


    class VolatileBarrier {
        int a;
        volatile int v1 = 1;
        volatile int v2 = 2;

        //内存屏障的设置 ， 读-Load(从内存中读取)， 写Store（向内村中写）
        //volatile读
        // LoadLoad屏障
        // LoadStore屏障
        // **************
        //StoreStore屏障
        //volatile写
        //StoreLoad屏障
        void readWrite() {
            //第一个volatile读
            int i = v1;
            //LoadLoad屏障，禁止上面的volatile读和下面的volatile读重排序
            //这里省略了LoadStore屏障，因为下面的普通写不可能越过上面的volatile读
            //第二个volatile读
            int j = v2;
            //这里省略了LoadLoad屏障，因为下面根本没有普通读操作
            //LoadStore屏障，禁止下面的普通写和上面的volatile读重排序
            //普通写
            a = i + j;
            //第一个volatile写
            //StoreStore屏障，禁止上面的普通写和下面的普通写重排序
            v1 = i + 1;
            //省略StoreLoad屏障，省略StoreLad屏障，因为下面跟着一个volatile写
            //StoreStore屏障（第二个volatile写的），禁止上面的volatile写和下面的volatile写重排序
            //第二个volatile写
            v2 = j * 2;
            //StoreLoad屏障，防止上面的volatile写与后面可能有的volatile读/写重排序


        }


    }


}
