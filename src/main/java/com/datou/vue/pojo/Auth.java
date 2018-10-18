package com.datou.vue.pojo;

import java.io.Serializable;

/**
 * 权限
 * CREATE TABLE `auth` (
 *   `auth_id` varchar(36) NOT NULL,
 *   `auth_name` varchar(36) DEFAULT NULL COMMENT '菜单名称',
 *   `auth_code` varchar(36) DEFAULT NULL COMMENT '权限名称',
 *   `auth_page` varchar(36) DEFAULT NULL COMMENT '请求链接',
 *   `auth_dir` int(10) DEFAULT NULL COMMENT '是否生成菜单，1是0否',
 *   `auth_zindex` int(10) DEFAULT NULL COMMENT '菜单顺序',
 *   `auth_parent_id` varchar(36) DEFAULT NULL COMMENT '父级id，0表示没有父级',
 *   PRIMARY KEY (`auth_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Auth implements Serializable {

    private String authId;
    private String authName;
    private String authCode;
    private String authPage;
    private Integer authDir;
    private Integer authZindex;
    private String authParentId;

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAuthPage() {
        return authPage;
    }

    public void setAuthPage(String authPage) {
        this.authPage = authPage;
    }

    public Integer getAuthDir() {
        return authDir;
    }

    public void setAuthDir(Integer authDir) {
        this.authDir = authDir;
    }

    public Integer getAuthZindex() {
        return authZindex;
    }

    public void setAuthZindex(Integer authZindex) {
        this.authZindex = authZindex;
    }

    public String getAuthParentId() {
        return authParentId;
    }

    public void setAuthParentId(String authParentId) {
        this.authParentId = authParentId;
    }
}
