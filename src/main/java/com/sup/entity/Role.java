package com.sup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2022-06-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("smbms_role")
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色编码
     */
    @TableField("roleCode")
    private String roleCode;

    /**
     * 角色名称
     */
    @TableField("roleName")
    private String roleName;

    /**
     * 创建者
     */
    @TableField("createdBy")
    private Long createdBy;

    /**
     * 创建时间
     */
    @TableField("creationDate")
    private LocalDateTime creationDate;

    /**
     * 修改者
     */
    @TableField("modifyBy")
    private Long modifyBy;

    /**
     * 修改时间
     */
    @TableField("modifyDate")
    private LocalDateTime modifyDate;


}
