package com.sup.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author pty
 * @since 2022-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("smbms_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    private String goodsname;

    /**
     * 商品产地
     */
    private String produceplace;

    /**
     * 商品容量
     */
    private String size;

    /**
     * 商品单位
     */
    private String goodspackage;

    /**
     * 商品编码
     */
    private String productcode;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品单价
     */
    private Double price;

    /**
     * 商品数量
     */
    private Integer number;

    /**
     * 供应商id
     */
    private Integer providerid;

    @TableField(exist = false)
    private String providername;
}
