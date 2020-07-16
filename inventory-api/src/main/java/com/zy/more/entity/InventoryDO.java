package com.zy.more.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Date: 2020/6/30 17:20
 * @Author: zhangyao
 **/
@Data
@Entity
@Table(name = "inventory")
@DynamicInsert
@DynamicUpdate
public class InventoryDO implements Serializable {
    /**
     * 库存主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventoryId;

    /**
     * 库存商品id
     */
    private Integer productId;

    /**
     * 库存数量
     */
    private Integer inventoryNum;

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

