package zj.dao;

import java.util.List;

/**
 * Created by lzj on 2016/9/23.
 */
public interface UserFileDao {

    List<String> listByUserId(String userId);

}
