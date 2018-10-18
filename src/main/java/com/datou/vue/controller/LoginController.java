package com.datou.vue.controller;

import com.datou.vue.jedis.JedisClient;
import com.datou.vue.pojo.User;
import com.datou.vue.utils.JsonUtils;
import com.datou.vue.utils.VueResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录相关的controller
 * 前后端分离之后不知道怎么操作，先在这里试试
 */
@RestController
public class LoginController {

    @Autowired
    private JedisClient jedisClient;

    // 用户登录
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public VueResult userLogin(@RequestBody User u,
                               HttpServletRequest request, HttpServletResponse response) {
        // 1.获取当前对象，状态为“未认证”
        Subject subject = SecurityUtils.getSubject();


        // 2.设置用户名和密码，得到一个token
        AuthenticationToken token = new UsernamePasswordToken(u.getUsername(), u.getPassword());

        try {
            subject.login(token); // 这里需要一个realm
        } catch (Exception e) {
            e.printStackTrace();
            return VueResult.build(400, "登录失败！"); // 登录失败
        }

        User user = (User) subject.getPrincipal();


        // 存到redis中
        jedisClient.set("user" + user.getUsername(), JsonUtils.objectToJson(user));

        HttpSession session = request.getSession();

        String sessionId = session.getId();

        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        cookie.setPath("http://localhost:3000/");
        response.addCookie(cookie);
        return VueResult.ok(sessionId);
    }

/*    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/error.html") went
    public String error() {
        return "error";
    }*/

}
