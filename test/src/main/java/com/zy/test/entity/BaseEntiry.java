package com.zy.test.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author: zhangyao
 * @create:2020-07-17 16:36
 **/
@Data
public abstract class BaseEntiry {
    @Id
    @Column(name = "product_id")
    private Integer productId;
}
