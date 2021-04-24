package com.xiao.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

/**
 * @desc: 功能描述：（zk测试）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2021/4/22 10:28
 */
@Slf4j
public class zkTest {

    private ZooKeeper zk = null;

    @Before
    public void zkInit() {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zk =
                    new ZooKeeper(
                            "zk01:2181,zk02:2181,zk03:2181",
                            4000, new Watcher() {
                        @Override
                        public void process(WatchedEvent event) {
                            if (Event.KeeperState.SyncConnected == event.getState()) {
                                //如果收到了服务端的响应事件，连接成功
                                countDownLatch.countDown();
                            }
                        }
                    });
            countDownLatch.await();
            //CONNECTED
            log.info(String.valueOf(zk.getState()));
        } catch (Exception e) {
            log.error("连接失败：{}", e);
        }

    }

    @Test
    public void zkCreate() throws KeeperException, InterruptedException {
        String xiaojianjun = zk.create("/xiaojianjun", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        log.info(xiaojianjun);
    }

}