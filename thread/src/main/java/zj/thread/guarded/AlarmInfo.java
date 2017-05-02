package zj.thread.guarded;

import zj.thread.twophase.AlarmType;

/**
 * Created by lzj on 2017/5/2.
 */
public class AlarmInfo {

    public AlarmType type;

    public String id;

    public String extraInfo;

    public AlarmInfo(String id, AlarmType type) {
        this.type = type;
        this.id = id;
    }
}
