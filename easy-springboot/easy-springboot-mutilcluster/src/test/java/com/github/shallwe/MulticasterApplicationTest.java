package com.github.shallwe;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MulticasterApplicationTest {

    @Autowired
    private UsersConfiguration usersConfiguration;

    @Test
    public void publish() {
        Publisher.publishEvent(new TenantCreatedEvent(new TenantId(123)));
    }

    @Test
    public void testUsersConfig() {
        System.out.println(JSON.toJSONString(usersConfiguration.getUsers()));
    }

}