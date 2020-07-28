package more.service.impl;

import com.zy.more.Result;
import more.dao.UserDao;
import more.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


/**
 * @author: zhangyao
 * @create:2020-06-28 17:28
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    /**
     * @Date: 2020/7/21 9:26
     * @Author: zhangyao
     * @Description: 获取用户列表
     * @return: com.zy.more.Result
     **/
    @Override
    public Result getUser() {
        return Result.ok().setData(userDao.findAll(Sort.by("userId")));
    }

    /**
     * @param of :
     * @Date: 2020/7/21 9:28
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result
     **/
    @Override
    public Result getUser(PageRequest of) {
        return Result.ok().setData(userDao.findAll(of));
    }

    /**
     * @Date: 2020/7/23 17:35
     * @Author: zhangyao
     * @Description: 根据用户名查询用户信息
     * @return: com.zy.more.Result
     **/
    @Override
    public Result findUserByUserName(String name) {
        return Result.ok().setData(userDao.findUserByUserName(name));
    }
}
