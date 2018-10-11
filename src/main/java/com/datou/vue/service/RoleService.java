package com.datou.vue.service;

import com.datou.vue.pojo.Role;

import java.util.List;

/**
 * 部门操作相关service
 */
public interface RoleService {

    // 新增部门
    void addRole(Role r) throws Exception;

    //获取部门列表
    List<Role> roleList();

    // 编辑部门
    void editRole(Role r) throws Exception;

    // 删除部门
    void deleteRole(Role role) throws Exception;
}
