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
@Table(name = "`order`")
@DynamicInsert
@DynamicUpdate
public class OrderDO implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 订单状态 0未支付 1已支付 2已完成
     */
    private String orderState;

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

