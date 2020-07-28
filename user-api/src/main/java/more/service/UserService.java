package more.service;

import com.zy.more.Result;
import org.springframework.data.domain.PageRequest;

/**
 * @author: zhangyao
 * @create:2020-07-21 09:15
 **/
public interface UserService {
    /**
     * @Date: 2020/7/21 9:26
     * @Author: zhangyao
     * @Description: 获取用户列表
     * @return: com.zy.more.Result
     **/
    Result getUser();

    /**
     * @Date: 2020/7/21 9:28
     * @Author: zhangyao
     * @Description:
     * @param of:
     * @return: com.zy.more.Result
     **/
    Result getUser(PageRequest of);


    /**
     * @Date: 2020/7/23 17:35
     * @Author: zhangyao
     * @Description: 根据用户名查询用户信息
     * @return: com.zy.more.Result
     **/
    Result findUserByUserName(String name);
}
