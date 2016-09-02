package zj.thread.consumer_producer;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class TestCP {

    public static void main(String[] args) {
        EventStorage storage = new EventStorage();

        Thread consumer = new Thread(new EventConsumer(storage));
        Thread producer = new Thread(new EventProducer(storage));

        consumer.start();
        producer.start();

    }

}
