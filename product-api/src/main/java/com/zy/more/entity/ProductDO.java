package com.zy.more.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Date: 2020/6/28 11:19
 * @Author: zhangyao
 * @Description:
 **/
@Data
@Entity
@Table(name = "product")
@DynamicInsert
@DynamicUpdate
public class ProductDO implements Serializable {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private static final long serialVersionUID = 1L;
}

