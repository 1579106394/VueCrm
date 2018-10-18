package com.datou.vue.pojo;

import java.io.Serializable;

/**
 * CREATE TABLE `user` (
 *   `user_id` varchar(36) NOT NULL,
 *   `user_created_time` varchar(50) NOT NULL,
 *   `user_update_time` varchar(50) NOT NULL,
 *   `user_name` varchar(20) NOT NULL,
 *   `user_telephone` bigint(15) NOT NULL,
 *   `user_age` int(10) NOT NULL,
 *   `user_role` int(2) NOT NULL DEFAULT '1' COMMENT '所属部门',
 *   `user_sex` int(2) NOT NULL COMMENT '1男2女',
 *   `user_delete` int(2) NOT NULL DEFAULT '1' COMMENT '1未删除，2删除',
 *   PRIMARY KEY (`user_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

public class User implements Serializable {
    private String userId;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String userCreatedTime;
    private String userUpdateTime;
    private String userName;
    private Long userTelephone;
    private Integer userAge;
//    private Integer userRole; // 暂时是integer
    private Role userRole;
    private Integer userSex;
    private Integer userDelete;

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCreatedTime() {
        return userCreatedTime;
    }

    public void setUserCreatedTime(String userCreatedTime) {
        this.userCreatedTime = userCreatedTime;
    }

    public String getUserUpdateTime() {
        return userUpdateTime;
    }

    public void setUserUpdateTime(String userUpdatTime) {
        this.userUpdateTime = userUpdatTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(Long userTelephone) {
        this.userTelephone = userTelephone;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserDelete() {
        return userDelete;
    }

    public void setUserDelete(Integer userDelete) {
        this.userDelete = userDelete;
    }
}
