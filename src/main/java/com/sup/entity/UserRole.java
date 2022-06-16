package com.sup.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2022-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("smbms_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer uid;

    private Integer rid;


}
