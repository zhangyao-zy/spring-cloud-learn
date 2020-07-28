package com.zy.test.entity;

import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author: zhangyao
 * @create:2020-07-17 16:36
 **/
@Data
public class Product extends BaseEntiry{

    @Id
    @Column(name = "product_id")
    private Integer productId;
    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品编码
     */
    private String productCode;

    /**
     * 商品图片
     */
    private String productImage;

    /**
     * 商品价格
     */
    private String productPrice;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;
}
