package com.sup.mapper;

import com.sup.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pty
 * @since 2022-06-05
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据角色ID查询当前角色拥有的菜单ID和权限ID
     * @param roleId
     * @return
     */
    List<Integer> queryRolePermissionIdsByRid(@Param("roleId") Integer roleId);

    /**
     * 保存角色和菜单权限之间的关系
     * @param rid
     * @param pid
     */
    void saveRolePermission(@Param("rid") Integer rid,@Param("pid") Integer pid);

    /**
     * 查询当前用户拥有的角色ID集合
     * @param id
     * @return
     */
    List<Integer> queryUserRoleIdsByUid(@Param("id") Integer id);

}
