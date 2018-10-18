package com.datou.vue.controller;

import com.datou.vue.pojo.User;
import com.datou.vue.service.UserService;
import com.datou.vue.utils.VueResult;
import com.datou.vue.vo.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户功能
     */
    @RequiresPermissions("user-add")
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
     * 修改用户
     */
    @RequiresPermissions("user-edit")
    @RequestMapping(value = "/api/user/editUser", method = RequestMethod.PUT)
    public VueResult editUser(@RequestBody User u) {

        try {
            userService.editUser(u);
        }catch (Exception e) {
            e.printStackTrace();
            return VueResult.build(400, "修改用户失败！");
        }

        return VueResult.ok();
    }

    /**
     * 用户列表
     */
    @RequiresPermissions("user-list")
    @RequestMapping(value = "/api/user/userList", method = RequestMethod.POST)
    public VueResult getUserList(@RequestBody Page<User> p) {

        // 封装一个page对象返回
        Page page = userService.getUserList(p);

        return VueResult.ok(page);
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("user-delete")
    @RequestMapping(value = "/api/user/deleteUser/{userId}", method = RequestMethod.DELETE)
    public VueResult deleteUser(@PathVariable String userId) {

        try {
            User user = new User();
            user.setUserId(userId);
            userService.deleteUser(user);
        }catch (Exception e) {
            e.printStackTrace();
            return VueResult.build(400, "删除失败！");
        }


        return VueResult.ok();
    }

}
