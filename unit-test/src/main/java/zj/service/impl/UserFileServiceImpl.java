package zj.service.impl;

import zj.dao.UserFileDao;
import zj.dao.impl.UserFileDaoImpl;
import zj.service.UserFileService;

import java.util.List;

/**
 * Created by lzj on 2016/9/23.
 */
public class UserFileServiceImpl implements UserFileService {

    private UserFileDao userFileDao = new UserFileDaoImpl();

    @Override
    public List<String> listByUserId(String userId) {
        return userFileDao.listByUserId(userId);
    }


}
