package com.zy.more.service.impl;

import com.zy.more.Result;
import com.zy.more.dao.OrderDao;
import com.zy.more.entity.OrderDO;
import com.zy.more.entity.OrderListProductDO;
import com.zy.more.service.OrderListProductService;
import com.zy.more.service.OrderService;
import com.zy.more.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhangyao
 * @create:2020-06-30 22:57
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    SnowFlake snowFlake;

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderListProductService orderListProductService;


    /**
     * 查询全部订单
     *
     * @Date: 2020/6/30 22:46
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result<javax.persistence.criteria.Order>
     **/
    @Override
    public Result<OrderDO> getOrderList() {
        return Result.ok().setData(orderDao.findAll());
    }

    /**
     * 分页查询订单
     *
     * @param pageRequest :
     * @Date: 2020/6/30 22:46
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result<javax.persistence.criteria.Order>
     **/
    @Override
    public Result<OrderDO> getOrderList(PageRequest pageRequest) {
        return Result.ok().setData(orderDao.findAll(pageRequest));
    }

    /**
     * 生成订单
     *
     * @Date: 2020/6/30 22:47
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result
     **/
    @Override
    public Result insertOrder(List<OrderListProductDO> list) {
        OrderDO order = new OrderDO();
        String orderNo = String.valueOf(snowFlake.getSnowflakeId());
        order.setOrderNo(orderNo);
        order.setOrderState("0");
        orderDao.save(order);

        //修改list中的商品id
        List<OrderListProductDO> collect = list.stream().peek(e -> {
            e.setOrderNo(orderNo);
        }).collect(Collectors.toList());
        orderListProductService.insertOrderListDetail(collect);
        return Result.ok().setData(order);
    }

    /**
     * 更新订单状态 0未支付 1已支付 2已完成
     *
     * @param state
     * @Date: 2020/6/30 22:47
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result
     */
    @Override
    public Result updateOrderState(String orderNo, String state) {
        OrderDO byOrderNo = orderDao.findByOrderNo(orderNo);
        byOrderNo.setOrderState(state);
        orderDao.save(byOrderNo);
        return Result.ok().setData(byOrderNo);
    }
}
