package zj.lock.condition;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class ContentProducer implements Runnable {

    private FileMock mock;

    private FileBuffer buffer;

    public ContentProducer(FileMock mock, FileBuffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String line;
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()) {
            line = mock.nextLine();
            buffer.insert(line);
        }
        //通知缓冲区停止生成更多的行
        buffer.setPendingLines(false);
    }


}
