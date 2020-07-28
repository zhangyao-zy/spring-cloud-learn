package com.zy.test.service.impl;

import com.zy.test.entity.Product;
import com.zy.test.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhangyao
 * @create:2020-07-17 16:43
 **/
@Service
public class TestService {
    @Autowired
    TestMapper testMapper;

    public List<Product> getProduct(){
        Product product = new Product();
        List<Product> products = testMapper.select(product);
        return products;
    }
}
