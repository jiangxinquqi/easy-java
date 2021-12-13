package com.xiao.cm;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.yarn.api.records.ApplicationReport;
import org.apache.hadoop.yarn.client.api.YarnClient;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.apache.hadoop.yarn.exceptions.YarnException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

@Slf4j
public class YarnClientTest {

    private YarnClient yarnClient;

    @Before
    public void init() {
        YarnConfiguration configuration = new YarnConfiguration();
        this.yarnClient = YarnClient.createYarnClient();
        this.yarnClient.init(configuration);
        this.yarnClient.start();
    }

    @Test
    public void test() throws YarnException, IOException {
        List<ApplicationReport> applications = yarnClient.getApplications();
        log.info(JSON.toJSONString(applications));
    }

}
