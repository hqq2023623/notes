package zj.sync.helper.countdownlatch;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        Videoconference conference = new Videoconference(10);
        Thread threadConference = new Thread(conference);
        threadConference.start();
        //创建10个与会者对象，分别作为参数创建线程
        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference, "Participant " + i);
            Thread t = new Thread(p);
            t.start();
        }
    }


}
