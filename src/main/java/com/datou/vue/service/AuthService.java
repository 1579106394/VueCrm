package com.datou.vue.service;

import com.datou.vue.pojo.Auth;

import java.util.List;

public interface AuthService {

    // 获取所有权限
    List<Auth> getAllAuthList();

}
