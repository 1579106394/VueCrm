package com.datou.vue.mapper;

import com.datou.vue.pojo.Role;

import java.util.List;

/**
 * 部门操作相关mapper
 */
public interface RoleMapper {

    // 新增部门
    void addRole(Role r);

    // 部门列表
    List<Role> roleList();

    // 修改部门
    void updateRole(Role r);

    // 删除部门
    void deleteRole(Role role);
}
