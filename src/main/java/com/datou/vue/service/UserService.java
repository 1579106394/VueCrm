package com.datou.vue.service;

import com.datou.vue.pojo.User;
import com.datou.vue.vo.Page;

/**
 * 用户相关功能
 */
public interface UserService {

    // 添加用户
    void addUser(User user) throws Exception;

    // 获取用户列表
    Page getUserList(Page<User> p);
}
