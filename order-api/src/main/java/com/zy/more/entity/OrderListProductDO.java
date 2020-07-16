package com.zy.more.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Date: 2020/6/30 22:44
 * @Author: zhangyao
 * @Description:
 **/
@Data
@Entity
@Table(name = "order_list_product")
@DynamicInsert
@DynamicUpdate
public class OrderListProductDO implements Serializable {
    /**
     * 订单列表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 商品数量
     */
    private Integer productNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}

