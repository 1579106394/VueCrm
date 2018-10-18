package com.datou.vue.controller;

import com.datou.vue.pojo.Auth;
import com.datou.vue.pojo.User;
import com.datou.vue.service.AuthService;
import com.datou.vue.utils.VueResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 权限相关的Controller
 */
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * 获取所有的权限
     */
    @RequestMapping(value = "/api/auth/allAuthList", method = RequestMethod.GET)
    public List<Auth> getAllAuthList() {

        List<Auth> authList = authService.getAllAuthList();

        return authList;
    }

    /**
     * 根据登录的用户获取权限列表
     */
    @RequestMapping(value = "/api/auth/authList", method = RequestMethod.GET)
    public VueResult authList() {

        // 获取登录状态
        Subject subject = SecurityUtils.getSubject();

        User user = (User) subject.getPrincipal();



        return VueResult.ok(user);
    }

}
