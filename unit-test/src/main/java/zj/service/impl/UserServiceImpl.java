package zj.service.impl;

import zj.dao.UserDao;
import zj.dao.impl.UserDaoImpl;
import zj.service.UserService;

import java.util.List;

/**
 * Created by lzj on 2016/9/23.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<String> queryAll() {
        return userDao.queryAll();
    }
}
