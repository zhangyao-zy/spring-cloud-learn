package com.zy.more.controller;

import com.alibaba.fastjson.JSON;
import com.zy.more.Page;
import com.zy.more.Result;
import com.zy.more.entity.OrderDO;
import com.zy.more.entity.OrderListProductDO;
import com.zy.more.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zhangyao
 * @create:2020-07-01 11:23
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    /**
     * 查询订单
     * @Date: 2020/7/1 11:26
     * @Author: zhangyao
     * @Description:
     * @param page:
     * @return: com.zy.more.Result<com.zy.more.entity.OrderDO>
     **/
    @GetMapping
    public Result<OrderDO> getOrder(Page page){
        if(page.getPage()==0){
            return orderService.getOrderList();
        }else{
            return orderService.getOrderList(PageRequest.of(page.getPage(),page.getSize()));
        }
    }


    /**
     * 创建订单
     * @Date: 2020/7/1 11:32
     * @Author: zhangyao
     * @Description:
     * @param list:
     * @return: com.zy.more.Result
     **/
    @PostMapping
    public Result createOrder(@RequestBody List<OrderListProductDO> list){
        return orderService.insertOrder(list);
    }


}
