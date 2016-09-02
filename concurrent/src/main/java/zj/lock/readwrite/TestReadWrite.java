package zj.lock.readwrite;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class TestReadWrite {

    public static void main(String[] args) {

        PriceInfo priceInfo = new PriceInfo();
        PriceReader[] readers = new PriceReader[5];
        Thread[] threadsReader = new Thread[5];
        //5个读取线程
        for (int i = 0; i < 5; i++) {
            readers[i] = new PriceReader(priceInfo);
            threadsReader[i] = new Thread(readers[i]);
        }
        //1个写入线程
        PriceWriter priceWriter = new PriceWriter(priceInfo);
        Thread threadWriter = new Thread(priceWriter);

        threadWriter.start();
        //启动所有线程
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }


    }


}
