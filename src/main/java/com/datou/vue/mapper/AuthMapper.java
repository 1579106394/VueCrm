package com.datou.vue.mapper;

import com.datou.vue.pojo.Auth;

import java.util.List;

public interface AuthMapper {

    // 获取全部的权限
    List<Auth> getAllAuthList();

}
