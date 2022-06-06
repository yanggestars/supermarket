package com.sup.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author pty
 * @since 2022-06-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("smbms_bill")
public class Bill implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账单编码
     */
    @TableField("billCode")
    private String billCode;

    /**
     * 商品名称
     */
    @TableField("productName")
    private String productName;

    /**
     * 商品描述
     */
    @TableField("productDesc")
    private String productDesc;

    /**
     * 商品单位
     */
    @TableField("productUnit")
    private String productUnit;

    /**
     * 商品数量
     */
    @TableField("productCount")
    private BigDecimal productCount;

    /**
     * 商品总额
     */
    @TableField("totalPrice")
    private BigDecimal totalPrice;

    /**
     * 是否支付（1：未支付 2：已支付）
     */
    @TableField("isPayment")
    private Integer isPayment;

    /**
     * 创建者（userId）
     */
    @TableField("createdBy")
    private Long createdBy;

    /**
     * 创建时间
     */
    @TableField("creationDate")
    private Date creationDate;

    /**
     * 更新者（userId）
     */
    @TableField("modifyBy")
    private Long modifyBy;

    /**
     * 更新时间
     */
    @TableField("modifyDate")
    private Date modifyDate;

    /**
     * 供应商ID
     */
    @TableField("providerId")
    private Integer providerId;


}
