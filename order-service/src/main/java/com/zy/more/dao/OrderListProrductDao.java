package com.zy.more.dao;

import com.zy.more.entity.OrderListProductDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zhangyao
 * @create:2020-06-30 22:56
 **/
@Repository
public interface OrderListProrductDao extends JpaRepository<OrderListProductDO,Integer> {
    /**
     * 根据订单编号查询订单详情(商品列表)
     * @Date: 2020/7/1 10:33
     * @Author: zhangyao
     * @Description:
     * @param orderNo:
     * @return: java.util.List<com.zy.more.entity.OrderListProductDO>
     **/
    List<OrderListProductDO> findAllByOrderNo(String orderNo);

}
