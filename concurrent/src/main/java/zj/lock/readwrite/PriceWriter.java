package zj.lock.readwrite;

import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class PriceWriter implements Runnable {

    private PriceInfo priceInfo;

    public PriceWriter(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        //循环修改两个价格3次,每次修改后休眠2秒钟
        for (int i = 0; i < 3; i++) {
            System.out.println("Writer : Attempt to modify the prices.");
            priceInfo.setPrices(Math.random() * 10, Math.random() * 8);
            System.out.println("Writer : Prices have been modified.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
