package zj.lock.condition;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class TestCondition {

    public static void main(String[] args) {

        FileMock mock = new FileMock(100, 10);
        FileBuffer buffer = new FileBuffer(20);

        //一个生产者
        ContentProducer producer = new ContentProducer(mock, buffer);
        Thread threadProducer = new Thread(producer, "Producer");

        ContentConsumer[] consumers = new ContentConsumer[3];
        Thread[] threadConsumers = new Thread[3];

        //三个消费者
        for (int i = 0; i < 3; i++) {
            consumers[i] = new ContentConsumer(buffer);
            threadConsumers[i] = new Thread(consumers[i], "Consumer" + i);
        }

        //启动生产者和消费者线程
        threadProducer.start();
        for (int i = 0; i < 3; i++) {
            threadConsumers[i].start();
        }

    }


}
