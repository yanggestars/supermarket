package com.sup.mapper;

import com.sup.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pty
 * @since 2022-06-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
