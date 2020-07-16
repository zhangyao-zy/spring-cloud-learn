package com.zy.more.controller;

import com.zy.more.Page;
import com.zy.more.Result;
import com.zy.more.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangyao
 * @create:2020-06-28 18:18
 **/
@RestController
@RequestMapping("/product")
@RefreshScope
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public Result getProduct(Page page){
        if(page.getPage()==0){
            return productService.getProduct();
        }else{
            return productService.getProduct(PageRequest.of(page.getPage(),page.getSize()));
        }
    }
}
