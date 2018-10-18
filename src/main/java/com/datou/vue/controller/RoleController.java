package com.datou.vue.controller;

import com.datou.vue.pojo.Role;
import com.datou.vue.pojo.User;
import com.datou.vue.service.RoleService;
import com.datou.vue.service.UserService;
import com.datou.vue.utils.VueResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门操作相关controller
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    /**
     * 添加部门
     */
    @RequiresPermissions("role-add")
    @RequestMapping(value = "/api/role/addRole", method = RequestMethod.POST)
    public VueResult addRole(@RequestBody Role r) {

        try {
            roleService.addRole(r);
        }catch (Exception e) {
            e.printStackTrace();
            return VueResult.build(400, "添加部门失败！");
        }

        return VueResult.ok();
    }

    /**
     * 部门列表
     */
    @RequiresPermissions("role-list")
    @RequestMapping(value = "/api/role/roleList", method = RequestMethod.GET)
    public VueResult roleList() {

        List<Role> roleList = roleService.roleList();

        return VueResult.ok(roleList);
    }

    /**
     * 修改部门
     */
    @RequiresPermissions("role-edit")
    @RequestMapping(value = "/api/role/editRole", method = RequestMethod.PUT)
    public VueResult editRole(@RequestBody Role r) {

        try {
            roleService.editRole(r);
        }catch (Exception e) {
            e.printStackTrace();
            return VueResult.build(400, "修改部门失败！");
        }

        return VueResult.ok();
    }

    /**
     * 删除部门
     */
    @RequiresPermissions("role-delete")
    @RequestMapping(value = "/api/role/deleteRole/{roleId}", method = RequestMethod.DELETE)
    public VueResult deleteRole(@PathVariable String roleId) {

        try {
            Role role = new Role();
            role.setRoleId(roleId);
            roleService.deleteRole(role);
        }catch (Exception e) {
            e.printStackTrace();
            return VueResult.build(400, "删除失败！");
        }


        return VueResult.ok();
    }

    /**
     * 删除员工
     */
    @RequiresPermissions("role-deleteuser")
    @RequestMapping(value = "/api/role/deleteUser/{userId}", method = RequestMethod.DELETE)
    public VueResult deleteUser(@PathVariable String userId) {

        try {
            User u = new User();
            u.setUserId(userId);
            userService.deleteUserFromRole(u);

        }catch (Exception e) {
            e.printStackTrace();
            return VueResult.build(400, "删除失败");
        }

        return VueResult.ok();
    }

}
