package com.zy.more.service;

import com.zy.more.Result;
import com.zy.more.entity.OrderListProductDO;

import java.util.List;

/**
 * @author: zhangyao
 * @create:2020-06-30 22:48
 **/
public interface OrderListProductService {

    /**
     *  根据订单编号获取订单详情
     * @Date: 2020/6/30 22:49
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result<com.zy.more.entity.OrderListProductDO>
     **/
    Result<OrderListProductDO> getOrderListDetail(String orderNo);

    /**
     * 插入订单对应商品详情
     * @Date: 2020/6/30 22:50
     * @Author: zhangyao
     * @Description:
     * @param listProductDOList:
     * @return: com.zy.more.Result
     **/
    Result insertOrderListDetail(List<OrderListProductDO> listProductDOList);
}
