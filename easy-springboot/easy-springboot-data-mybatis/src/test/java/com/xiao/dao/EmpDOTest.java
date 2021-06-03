package com.xiao.dao;

import com.alibaba.fastjson.JSON;
import com.xiao.bo.DeptBO;
import com.xiao.bo.EmpBO;
import com.xiao.dao.mapper.DeptMapper;
import com.xiao.dao.mapper.EmpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc: 功能描述：<雇员测试>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/5/29 8:21
 */
@SpringBootTest(classes = {MybatisApplication.class})
@RunWith(SpringRunner.class)
public class EmpDOTest {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testGetById() {
        System.out.println(JSON.toJSONString(empMapper.selectByPrimaryKey(7369)));
    }

    @Test
    public void testGetFullInfoById() {
        DeptBO deptBO = deptMapper.getFullInfoById(10);
        System.out.println(JSON.toJSONString(deptBO));
    }

    @Test
    public void testGetFullInfoById2() {
        DeptBO deptBO = deptMapper.getFullInfoById2(10);
        System.out.println(JSON.toJSONString(deptBO));
    }

    @Test
    public void testSelectFullInfoByPrimaryKey() {
        EmpBO empBO = empMapper.selectFullInfoByPrimaryKey(7369);
        System.out.println(JSON.toJSONString(empBO));
    }

    @Test
    public void testSelectFullInfoByPrimaryKey2() {
        EmpBO empBO = empMapper.selectFullInfoByPrimaryKey2(7369);
        System.out.println(JSON.toJSONString(empBO));
    }

}