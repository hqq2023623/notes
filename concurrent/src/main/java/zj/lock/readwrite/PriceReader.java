package zj.lock.readwrite;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class PriceReader implements Runnable {

    private PriceInfo priceInfo;

    public PriceReader(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {

        //循环读两个price各10次
        for (int i = 0; i < 10; i++) {
            System.out.println("price1 = " + priceInfo.getPrice1() + "    by " + Thread.currentThread().getName());
            System.out.println("price2 = " + priceInfo.getPrice2() + "    by " + Thread.currentThread().getName());
        }

    }


}
