package zj.thread.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class TestConcurrent {

    private Map<String, Object> map = new HashMap<>();

    private ConcurrentMap<String, Object> conMap = new ConcurrentHashMap<>();


    public static void main(String[] args) {


    }

    //不使用同步容器
    private synchronized void hashMap() {
        Object o = map.get("1");
        if (o != null) {
            o.hashCode();
            map.put("1",o);
        }
    }

    //使用同步容器
    private void concurrentMap() {
        synchronized (conMap) {
            Object o = conMap.get("1");
            if (o != null) {
                o.hashCode();
                conMap.put("1",o);
            }
        }

    }


}
