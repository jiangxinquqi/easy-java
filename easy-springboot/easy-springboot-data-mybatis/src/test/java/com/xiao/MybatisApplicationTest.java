package com.xiao;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiao.dao.MybatisApplication;
import com.xiao.dao.mapper.UserMapper;
import com.xiao.dao.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/5 14:39
 */
@SpringBootTest(classes = {MybatisApplication.class})
@RunWith(SpringRunner.class)
public class MybatisApplicationTest {

    @Autowired
    private UserMapper userMapper;

    /*插入测试*/
    @Test
    public void add() {
        User user = new User();
        user.setId(null);
        user.setName("肖建军");
        user.setAge(18);
        userMapper.insert(user);
    }

    /*分页测试*/
    @Test
    public void pageInfo() {
        PageHelper.startPage(1, 2);
        List<User> users = userMapper.selectAll();
        PageInfo result = new PageInfo(users);
        String s = JSON.toJSONString(result);
        System.out.println(s);
    }
}
