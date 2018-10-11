package com.datou.vue.pojo;

import java.io.Serializable;

/**
 * CREATE TABLE `role` (
 *   `role_id` varchar(36) NOT NULL COMMENT '部门id',
 *   `role_created_time` varchar(50) NOT NULL,
 *   `role_update_time` varchar(50) NOT NULL,
 *   `role_name` varchar(20) NOT NULL,
 *   `role_parent_id` varchar(36) NOT NULL DEFAULT '0' COMMENT '父id，表示层级关系',
 *   `role_delete` int(2) NOT NULL DEFAULT '1' COMMENT '部门是否删除，1未删除，0已删除',
 *   PRIMARY KEY (`role_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Role implements Serializable {
    private String roleId;
    private String roleCreatedTime;
    private String roleUpdateTime;
    private String roleName;
    private Integer roleDelete;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleCreatedTime() {
        return roleCreatedTime;
    }

    public void setRoleCreatedTime(String roleCreatedTime) {
        this.roleCreatedTime = roleCreatedTime;
    }

    public String getRoleUpdateTime() {
        return roleUpdateTime;
    }

    public void setRoleUpdateTime(String roleUpdateTime) {
        this.roleUpdateTime = roleUpdateTime;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleDelete() {
        return roleDelete;
    }

    public void setRoleDelete(Integer roleDelete) {
        this.roleDelete = roleDelete;
    }
}
