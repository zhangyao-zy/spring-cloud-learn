package more.dao;

import more.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zhangyao
 * @create:2020-06-28 10:54
 **/
@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    /**
     * @Date: 2020/7/23 17:37
     * @Author: zhangyao
     * @Description: 根据用户名查询用户信息
     * @return: java.util.List<more.entity.User>
     **/
    List<User> findUserByUserName(String name);
}
