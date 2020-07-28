package com.zy.test.mapper;

import com.zy.test.entity.Product;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: zhangyao
 * @create:2020-07-17 16:41
 **/
@Component
public interface TestMapper extends Mapper<Product> {
}
