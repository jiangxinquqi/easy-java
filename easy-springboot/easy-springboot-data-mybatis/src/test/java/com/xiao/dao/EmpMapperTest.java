package com.xiao.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.xiao.dao.mapper.EmpMapper;
import com.xiao.dao.model.EmpDO;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import javax.sql.DataSource;

/**
 * @desc: 功能描述：<mybatis测试>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/5/31 8:20
 */
public class EmpMapperTest {

    @Test
    public void test() {
        DataSource dataSource = new DruidDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(EmpMapper.class);
        configuration.addMappers("mapping/*.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = factory.openSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        EmpDO empDO = mapper.selectByPrimaryKey(7369);
        System.out.println(JSON.toJSONString(empDO));
    }

}