package zj.dao.impl;

import zj.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzj on 2016/9/23.
 */
public class UserDaoImpl implements UserDao {

    private static List<String> users = new ArrayList<>();

    static {
        users.add("lzj");
        users.add("faker");
    }

    @Override
    public List<String> queryAll() {
        return users;
    }


}
