package com.zy.more.controller;

import com.zy.more.Page;
import com.zy.more.Result;
import com.zy.more.entity.InventoryDO;
import com.zy.more.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author: zhangyao
 * @create:2020-06-30 19:07
 **/
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping
    public Result<InventoryDO> getInventory(Page page){
        if(page.getPage()==0){
            return inventoryService.getInventory();
        }else{
            return inventoryService.getInventory(PageRequest.of(page.getPage(),page.getSize()));
        }
    }


    @GetMapping("/{productId}")
    public Result<InventoryDO> getInventoryById(@PathVariable("productId") Integer productId){
        return inventoryService.getInventoryById(productId);
    }


    /**
     * 新增更新库存商品
     * @Date: 2020/7/3 15:53
     * @Author: zhangyao
     * @Description:
     * @param inventoryDO:
     * @return: com.zy.more.Result
     **/
    @PostMapping
    @PutMapping
    public Result saveInventory(@RequestBody InventoryDO inventoryDO){
        return inventoryService.insertInventory(inventoryDO);
    }
}
