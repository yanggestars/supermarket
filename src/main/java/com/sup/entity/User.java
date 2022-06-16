package com.sup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
@TableName("smbms_user")
public class User implements Serializable {
    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名称
     */
    @TableField("userName")
    private String userName;

    /**
     * 用户密码
     */
    @TableField("userPassword")
    private String userPassword;

    /**
     * 性别（1:女、 2:男）
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 登录用户名
     */
    @TableField("loginName")
    private String loginName;

    /**
     * 邮件
     */
    @TableField("mail")
    private String mail;


}
