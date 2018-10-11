package com.datou.vue.service.impl;

import com.datou.vue.mapper.RoleMapper;
import com.datou.vue.pojo.Role;
import com.datou.vue.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void addRole(Role r) throws Exception{
        // 补全属性。1.创建时间，2.最后修改时间，4.roleId
        r.setRoleId(UUID.randomUUID().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String time = sdf.format(new Date());
        r.setRoleCreatedTime(time);
        r.setRoleUpdateTime(time);

        roleMapper.addRole(r);
    }

    @Override
    public List<Role> roleList() {

        List<Role> roleList = roleMapper.roleList();

        return roleList;
    }

    @Override
    public void editRole(Role r) throws Exception {
        // 补全属性：roleUpdateTime
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日 HH:mm:ss");
        String time = sdf.format(new Date());
        r.setRoleUpdateTime(time);

        roleMapper.updateRole(r);
    }

    @Override
    public void deleteRole(Role role) throws Exception {
        roleMapper.deleteRole(role);
    }
}
