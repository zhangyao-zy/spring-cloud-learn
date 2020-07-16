package com.zy.more.service.impl;

import com.zy.more.Result;
import com.zy.more.dao.ProductDao;
import com.zy.more.entity.ProductDO;
import com.zy.more.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: zhangyao
 * @create:2020-06-28 17:28
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    /**
     * 查询全部
     * @Date: 2020/6/30 15:40
     * @Author: zhangyao
     * @Description:
    * @return: com.zy.more.Result<com.zy.more.entity.ProductDO>
     **/
    @Override
    public Result<ProductDO> getProduct() {
        List<ProductDO> all = productDao.findAll();
        return Result.ok().setData(all);
    }


    /**
     * 分页查询
     * @Date: 2020/6/30 15:39
     * @Author: zhangyao
     * @Description:
    * @param pageable:
    * @return: com.zy.more.Result<com.zy.more.entity.ProductDO>
     **/
    @Override
    public Result<ProductDO> getProduct(PageRequest pageable) {
        Page<ProductDO> all = productDao.findAll(pageable);
        return Result.ok().setData(all.getContent());
    }

    /**
     * 插入
     *
     * @param productDO :
     * @Date: 2020/6/30 15:38
     * @Author: zhangyao
     * @Description: 插入
     * @return: com.zy.more.Result
     **/
    @Override
    public Result insertProduct(ProductDO productDO) {
        productDao.save(productDO);
        return Result.ok();
    }
}
