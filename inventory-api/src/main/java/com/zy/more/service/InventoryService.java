package com.zy.more.service;

import com.zy.more.Result;
import com.zy.more.entity.InventoryDO;
import org.springframework.data.domain.PageRequest;

/**
 * @author: zhangyao
 * @create:2020-06-30 16:54
 **/
public interface InventoryService {
    /**
     * 查询全部
     * @Date: 2020/6/30 17:30
     * @Author: zhangyao
     * @return: com.zy.more.Result<com.zy.more.entity.InventoryDO>
     **/
    Result<InventoryDO> getInventory();

    /**
     * 分页查询
     * @Date: 2020/6/30 17:30
     * @Author: zhangyao
     * @param request:
     * @return: com.zy.more.Result<com.zy.more.entity.InventoryDO>
     **/
    Result<InventoryDO> getInventory(PageRequest request);

    /**
     * 根据id查询库存
     * @Date: 2020/6/30 18:18
     * @Author: zhangyao
     * @Description:
    * @param productId:
    * @return: com.zy.more.Result<com.zy.more.entity.InventoryDO>
     **/
    Result<InventoryDO> getInventoryById(Integer productId);

    /**
     * 插入库存
     * @Date: 2020/6/30 18:18
     * @Author: zhangyao
     * @Description:
    * @param inventoryDO:
    * @return: com.zy.more.Result
     **/
    Result insertInventory(InventoryDO inventoryDO);

    /**
     * 更新库存 (数量)
     * @Date: 2020/6/30 18:19
     * @Author: zhangyao
     * @Description:
     * @param inventoryDO:
     * @return: com.zy.more.Result
     **/
//    Result updateInventory(InventoryDO inventoryDO);
}
