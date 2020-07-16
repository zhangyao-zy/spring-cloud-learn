package com.zy.more.service;

import com.zy.more.Result;
import com.zy.more.entity.OrderDO;
import com.zy.more.entity.OrderListProductDO;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author: zhangyao
 * @create:2020-06-30 22:24
 **/
public interface OrderService {

    /**
     * 查询全部订单
     * @Date: 2020/6/30 22:46
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result<javax.persistence.criteria.Order>
     **/
    Result<OrderDO> getOrderList();

    /**
     * 分页查询订单
     * @Date: 2020/6/30 22:46
     * @Author: zhangyao
     * @Description:
     * @param pageRequest:
     * @return: com.zy.more.Result<javax.persistence.criteria.Order>
     **/
    Result<OrderDO> getOrderList(PageRequest pageRequest);

    /**
     * 生成订单
     * @Date: 2020/6/30 22:47
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result
     **/
    Result insertOrder(List<OrderListProductDO> listProductDOList);

    /**
     * 更新订单状态 0未支付 1已支付 2已完成
     * @Date: 2020/7/1 9:51
     * @Author: zhangyao
     * @Description:
     * @param orderNo:
     * @param state:
     * @return: com.zy.more.Result
     **/
    Result updateOrderState(String orderNo, String state);

}
