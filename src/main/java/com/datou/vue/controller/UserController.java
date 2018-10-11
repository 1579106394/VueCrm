package com.datou.vue.controller;

import com.datou.vue.pojo.User;
import com.datou.vue.service.UserService;
import com.datou.vue.utils.VueResult;
import com.datou.vue.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户功能
     */
    @RequestMapping(value = "/api/user/addUser", method = RequestMethod.POST)
    public VueResult addUser(@RequestBody User u) {

        try {
            userService.addUser(u);
        }catch (Exception e) {
            return VueResult.build(400, "新增用户失败！");
        }

        return VueResult.ok();
    }

    /**
     * 用户列表
     */
    @RequestMapping(value = "/api/user/userList", method = RequestMethod.POST)
    public VueResult getUserList(@RequestBody Page<User> p) {

        // 封装一个page对象返回
        Page page = userService.getUserList(p);

        return VueResult.ok(page);
    }

}