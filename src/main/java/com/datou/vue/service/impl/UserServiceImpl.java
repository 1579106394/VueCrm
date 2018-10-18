package com.datou.vue.service.impl;

import com.datou.vue.mapper.UserMapper;
import com.datou.vue.pojo.User;
import com.datou.vue.service.UserService;
import com.datou.vue.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) throws Exception {
        // 新增用户逻辑
        //补全空属性：userId，userCreatedTime，userUpdateTime
        user.setUserId(UUID.randomUUID().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日 HH:mm:ss");
        String time = sdf.format(new Date());
        user.setUserCreatedTime(time);
        user.setUserUpdateTime(time);

        userMapper.addUser(user);

    }

    @Override
    public void editUser(User u) throws Exception {
        // 补全属性：userUpdateTime
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日 HH:mm:ss");
        String time = sdf.format(new Date());
        u.setUserUpdateTime(time);

        userMapper.updateUser(u);

    }

    @Override
    public void deleteUserFromRole(User u) throws Exception {
        userMapper.deleteUserFromRole(u);
    }

    @Override
    public Page getUserList(Page<User> p) {
        //补全参数：
        //1.当前页已经传递过来，每页显示条数也传递过来了。
        //每页起始位置 = 当前页-1  * 每页显示条数
        Integer currentPage = p.getCurrentPage();
        Integer currentCount = p.getCurrentCount();
        Integer index = (currentPage - 1) * currentCount;
        p.setIndex(index);

        //封装总页数、总条数、数据
        Integer totalCount = userMapper.getUserListCount(p);
        p.setTotalCount(totalCount);
        List<User> userList = userMapper.getUserList(p);
        p.setList(userList);
        //总页数= 总条数/ 每页显示数据
        Integer totalPage = (int) Math.ceil(totalCount / currentCount);
        p.setTotalPage(totalPage);

        return p;
    }

    @Override
    public void deleteUser(User user) throws Exception {
        userMapper.deleteUser(user);
    }

}
