package zj.dao.impl;

import zj.dao.UserFileDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lzj on 2016/9/23.
 */
public class UserFileDaoImpl implements UserFileDao {

    private static Map<String, List<String>> files = new HashMap<>();


    static {
        List<String> list = new ArrayList<>();
        list.add("file1");
        files.put("lzj", list);
    }

    @Override
    public List<String> listByUserId(String userId) {
        return files.get(userId);
    }


}
