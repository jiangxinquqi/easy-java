package com.xiao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/12 16:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class RedisApplicationTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    /* 存入 String类型的数据 设置过期时间为 1000秒*/
    @Test
    public void setStringTest() {
        stringRedisTemplate.opsForValue().set("aaa", "aaa", 1000L, TimeUnit.SECONDS);
        stringRedisTemplate.opsForValue().set("bbb", "bbb", 1L, TimeUnit.HOURS);
    }

    /* 根据键查询值 */
    @Test
    public void getTest() {
        String aaa = stringRedisTemplate.opsForValue().get("aaa");
        String ccc = stringRedisTemplate.opsForValue().get("ccc");
        log.info("{},{}", aaa, ccc);
    }

    /* 序列化对象与发序列化 */
    @Test
    public void objectTest() throws Exception {

        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user, 200, TimeUnit.SECONDS);

        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        Assert.assertEquals(20, ((User) redisTemplate.opsForValue().get("超人")).getAge().longValue());
        Assert.assertEquals(30, ((User) redisTemplate.opsForValue().get("蝙蝠侠")).getAge().longValue());
        Assert.assertEquals(40, ((User) redisTemplate.opsForValue().get("蜘蛛侠")).getAge().longValue());

    }


}
