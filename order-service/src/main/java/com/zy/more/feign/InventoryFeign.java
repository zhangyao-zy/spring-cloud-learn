package com.zy.more.feign;

import com.zy.more.Result;
import com.zy.more.entity.InventoryDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;

/**
 * @author: zhangyao
 * @create:2020-07-01 16:42
 **/
@FeignClient(name = "inventory",path = "/inventory")
public interface InventoryFeign {
    /**
     * 修改库存信息
     * @Date: 2020/7/1 17:01
     * @Author: zhangyao
     * @Description:
     * @param inventoryDO:
     * @return: com.zy.more.Result
     **/
    @PostMapping
    public Result saveInventory(InventoryDO inventoryDO);

    /**
     * 根据商品id查询库存信息
     * @Date: 2020/7/1 17:02
     * @Author: zhangyao
     * @Description:
     * @param productId:
     * @return: com.zy.more.Result<com.zy.more.entity.InventoryDO>
     **/
    @GetMapping("/{productId}")
    public Result<InventoryDO> getInventoryById(@PathVariable("productId") Integer productId);
}
