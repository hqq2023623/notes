package zj.thread.twophase;

import zj.thread.guarded.AlarmAgent;
import zj.thread.guarded.AlarmInfo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lzj on 2017/5/2.
 */
public class AlarmSendingThread extends AbstractTerminatableThread {

    private final AlarmAgent alarmAgent = new AlarmAgent();

    private final BlockingQueue<AlarmInfo> alarmQueue;

    private final ConcurrentMap<String, AtomicInteger> submittedAlarmRegistry;

    public AlarmSendingThread() {
        alarmQueue = new ArrayBlockingQueue<AlarmInfo>(100);
        submittedAlarmRegistry = new ConcurrentHashMap<>();
        alarmAgent.init();
    }

    @Override
    protected void doRun() throws Exception {
        AlarmInfo alarmInfo = alarmQueue.take();
        //消费一个线程，表示执行完毕
        terminationToken.reservations.decrementAndGet();
        try {
            alarmAgent.sendAlarm(alarmInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (alarmInfo.type == AlarmType.RESUME) {
            String key = AlarmType.FAULT.toString() + " : " + alarmInfo.id + "@" + alarmInfo.extraInfo;
            submittedAlarmRegistry.remove(key);
            key = AlarmType.RESUME.toString() + " : " + alarmInfo.id + "@" + alarmInfo.extraInfo;
            submittedAlarmRegistry.remove(key);
        }

    }

    public int sendAlarm(final AlarmInfo alarmInfo) {
        AlarmType type = alarmInfo.type;
        String id = alarmInfo.id;
        String extraInfo = alarmInfo.extraInfo;
        if (terminationToken.isToShutdown()) {
            System.err.println("rejected alarm:" + id);
            return -1;
        }
        int duplicatedSubmissionCount = 0;
        try {
            AtomicInteger prevSubmittedCounter;
            prevSubmittedCounter = submittedAlarmRegistry.putIfAbsent(type.toString() + ":" + id + "@" + extraInfo, new AtomicInteger(0));
            if (null == prevSubmittedCounter) {
                terminationToken.reservations.incrementAndGet();
                alarmQueue.put(alarmInfo);
            } else {
                duplicatedSubmissionCount = prevSubmittedCounter.incrementAndGet();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return duplicatedSubmissionCount;

    }

    @Override
    protected void doCleanUp(Exception cause) {
        if (cause != null && !(cause instanceof InterruptedException)) {
            cause.printStackTrace();
        }
        alarmAgent.disconnect();
    }
}
