package com.zy.more.service.impl;

import com.zy.more.Result;
import com.zy.more.dao.OrderListProrductDao;
import com.zy.more.entity.InventoryDO;
import com.zy.more.entity.OrderListProductDO;
import com.zy.more.feign.InventoryFeign;
import com.zy.more.service.OrderListProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author: zhangyao
 * @create:2020-07-01 10:26
 **/
@Service
public class OrderListProductServiceImpl implements OrderListProductService {

    @Autowired
    OrderListProrductDao orderListProrductDao;

    @Autowired
    InventoryFeign inventoryFeign;

    /**
     * 根据订单编号获取订单详情
     *
     * @param orderNo
     * @Date: 2020/6/30 22:49
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result<com.zy.more.entity.OrderListProductDO>
     */
    @Override
    public Result<OrderListProductDO> getOrderListDetail(String orderNo) {
        return Result.ok().setData(orderListProrductDao.findAllByOrderNo(orderNo));
    }

    /**
     * 插入订单对应商品详情
     *
     * @param listProductDOList :
     * @Date: 2020/6/30 22:50
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result
     **/
    @Override
    public Result insertOrderListDetail(List<OrderListProductDO> listProductDOList) {
        //保存订单详情
        orderListProrductDao.saveAll(listProductDOList);
        for (OrderListProductDO orderListProductDO : listProductDOList) {
            InventoryDO inventoryDO = new InventoryDO();
            inventoryDO.setProductId(orderListProductDO.getProductId());
            //调用库存服务,查询库存数量
            inventoryDO = inventoryFeign.getInventoryById(orderListProductDO.getProductId()).getData();
            Assert.isTrue(inventoryDO.getInventoryNum()>=0&&inventoryDO.getInventoryNum()>=orderListProductDO.getProductNum(),"库存商品数量不够");
            //远程调用库存服务,修改商品库存
            inventoryDO.setInventoryNum(inventoryDO.getInventoryNum()-orderListProductDO.getProductNum());
            inventoryFeign.saveInventory(inventoryDO);
        }
        return Result.ok();
    }
}
