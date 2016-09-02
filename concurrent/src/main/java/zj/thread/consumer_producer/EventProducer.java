package zj.thread.consumer_producer;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class EventProducer implements Runnable {

    private EventStorage storage;

    public EventProducer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            storage.set();
        }
    }

}
