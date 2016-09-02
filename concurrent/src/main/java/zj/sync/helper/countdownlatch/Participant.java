package zj.sync.helper.countdownlatch;

import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class Participant implements Runnable {

    private Videoconference conference;

    private String name;

    public Participant(Videoconference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long) Math.random() * 10;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //调用countDown();
        conference.arrive(name);
    }


}
