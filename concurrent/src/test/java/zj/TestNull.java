package zj;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lzj Created on 2016/3/29.
 */
public class TestNull {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Object obj = new Object();
        map.put("obj", obj);
        obj = null;
        System.out.println(map.get("obj"));
    }

}
