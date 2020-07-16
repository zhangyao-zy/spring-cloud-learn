package com.zy.more.dao;

import com.zy.more.entity.ProductDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: zhangyao
 * @create:2020-06-28 10:54
 **/
@Repository
public interface ProductDao extends JpaRepository<ProductDO,Integer> {
}
