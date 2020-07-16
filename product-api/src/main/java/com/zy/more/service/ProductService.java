package com.zy.more.service;

import com.zy.more.Result;
import com.zy.more.entity.ProductDO;
import org.springframework.data.domain.PageRequest;

/**
 * @author: zhangyao
 * @create:2020-06-28 11:21
 **/
public interface ProductService {

    /**
     * @Date: 2020/6/30 15:38
     * @Author: zhangyao
     * @Description:

    * @return: com.zy.more.Result<com.zy.more.entity.ProductDO>
     **/
    Result<ProductDO> getProduct();

    /**
     * 分页查询
     * @Date: 2020/6/30 15:38
     * @Author: zhangyao
     * @Description:
     * @param pageable:
     * @return: com.zy.more.Result<com.zy.more.entity.ProductDO>
     **/
    Result<ProductDO> getProduct(PageRequest pageable);

    /**
     * 插入
     * @Date: 2020/6/30 15:38
     * @Author: zhangyao
     * @Description: 插入
    * @param productDO:
    * @return: com.zy.more.Result
     **/
    Result insertProduct(ProductDO productDO);
}
