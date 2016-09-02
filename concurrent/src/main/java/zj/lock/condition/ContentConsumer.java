package zj.lock.condition;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class ContentConsumer implements Runnable {

    private FileBuffer buffer;

    public ContentConsumer(FileBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String line;
        while (buffer.hasPendingLines()) {
            line = buffer.get();
            //处理数据行
            processLine(line);
        }

    }

    //休眠10ms来模拟对数据行的处理时间
    private void processLine(String line) {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
