package com.zy.more.service.impl;

import com.zy.more.Result;
import com.zy.more.dao.InventoryDao;
import com.zy.more.entity.InventoryDO;
import com.zy.more.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author: zhangyao
 * @create:2020-06-30 18:20
 **/
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryDao inventoryDao;

    /**
     * 查询全部
     *
     * @Date: 2020/6/30 17:30
     * @Author: zhangyao
     * @return: com.zy.more.Result<com.zy.more.entity.InventoryDO>
     **/
    @Override
    public Result<InventoryDO> getInventory() {
        return Result.ok().setData(inventoryDao.findAll());
    }

    /**
     * 分页查询
     *
     * @param request :
     * @Date: 2020/6/30 17:30
     * @Author: zhangyao
     * @return: com.zy.more.Result<com.zy.more.entity.InventoryDO>
     **/
    @Override
    public Result<InventoryDO> getInventory(PageRequest request) {
        return Result.ok().setData(inventoryDao.findAll(request));
    }

    /**
     * 根据id查询库存
     *
     * @param productId :
     * @Date: 2020/6/30 18:18
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result<com.zy.more.entity.InventoryDO>
     **/
    @Override
    public Result<InventoryDO> getInventoryById(Integer productId) {
        return Result.ok().setData(inventoryDao.findByProductId(productId));
    }

    /**
     * 插入库存
     * 更新库存
     * @param inventoryDO :
     * @Date: 2020/6/30 18:18
     * @Author: zhangyao
     * @Description:
     * @return: com.zy.more.Result
     **/
    @Override
    public Result insertInventory(InventoryDO inventoryDO) {
        inventoryDao.save(inventoryDO);
        return Result.ok().setData(inventoryDO);
    }

}
