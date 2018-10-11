package com.datou.vue.controller;

import com.datou.vue.pojo.Role;
import com.datou.vue.service.RoleService;
import com.datou.vue.utils.VueResult;
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

    /**
     * 添加部门
     */
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
    @RequestMapping(value = "/api/role/roleList", method = RequestMethod.GET)
    public VueResult roleList() {

        List<Role> roleList = roleService.roleList();

        return VueResult.ok(roleList);
    }

    /**
     * 修改部门
     */
    @RequestMapping(value = "/api/role/editRole", method = RequestMethod.POST)
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
    @RequestMapping(value = "/api/role/deleteRole/{roleId}", method = RequestMethod.GET)
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

}
