package com.datou.vue.realm;

import com.datou.vue.mapper.AuthMapper;
import com.datou.vue.mapper.UserMapper;
import com.datou.vue.pojo.Auth;
import com.datou.vue.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VueRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthMapper authMapper;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("============授权方法执行了===========");

        // 获取用户登录信息
        User user = (User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();


        // 根据用户查询角色咯。。。

        // 然后根据角色查询权限咯。。

        //先硬编码，将权限都写进去
        List<Auth> authList = authMapper.getAllAuthList();

        for (Auth auth: authList) {
            info.addStringPermission(auth.getAuthCode());
        }

        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        String username = userToken.getUsername();

        // 1.根据用户名查询密码
        User user = userMapper.getUserByUsername(username);

        if(user == null) {
            // 用户名不存在
            return null;
        }

        // 2.框架比对密码是否一致
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());

        return info;
    }
}
