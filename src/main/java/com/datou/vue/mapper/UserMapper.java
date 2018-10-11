package com.datou.vue.mapper;

import com.datou.vue.pojo.User;
import com.datou.vue.vo.Page;

import java.util.List;

/**
 * 用户相关Mapper
 */
public interface UserMapper {

    // 新增用户
    void addUser(User user);

    // 获取用户列表
    List<User> getUserList(Page<User> p);

    Integer getUserListCount(Page<User> p);
}
