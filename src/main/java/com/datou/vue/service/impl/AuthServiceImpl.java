package com.datou.vue.service.impl;

import com.datou.vue.mapper.AuthMapper;
import com.datou.vue.pojo.Auth;
import com.datou.vue.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<Auth> getAllAuthList() {

        List<Auth> authList = authMapper.getAllAuthList();

        return authList;
    }

}
