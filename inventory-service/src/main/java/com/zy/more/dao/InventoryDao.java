package com.zy.more.dao;

import com.zy.more.entity.InventoryDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: zhangyao
 * @create:2020-06-30 18:22
 **/
@Repository
public interface InventoryDao extends JpaRepository<InventoryDO,Integer> {
    /**
     * 根据商品id查询库存商品信息
     * @Date: 2020/7/1 17:04
     * @Author: zhangyao
     * @Description:
     * @param productId:
     * @return: com.zy.more.entity.InventoryDO
     **/
    InventoryDO findByProductId(Integer productId);
}
