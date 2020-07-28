package com.zy.test.controller;

import com.zy.test.entity.Product;
import com.zy.test.service.impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhangyao
 * @create:2020-07-17 16:36
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping
    public List<Product> get(){
        return testService.getProduct();
    }
}
