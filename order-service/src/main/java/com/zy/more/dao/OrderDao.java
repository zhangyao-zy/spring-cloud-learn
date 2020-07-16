package com.zy.more.dao;

import com.zy.more.entity.OrderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: zhangyao
 * @create:2020-06-30 22:55
 **/
@Repository
public interface OrderDao extends JpaRepository<OrderDO,Integer> {
    /**
     * 根据订单号查询
     * @Date: 2020/7/1 9:55
     * @Author: zhangyao
     * @Description:
     * @param orderNo:
     * @return: com.zy.more.entity.OrderDO
     **/
    OrderDO findByOrderNo(String orderNo);
}
