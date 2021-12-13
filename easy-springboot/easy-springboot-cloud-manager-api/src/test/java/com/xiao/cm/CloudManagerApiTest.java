package com.xiao.cm;

import com.alibaba.fastjson.JSON;
import com.cloudera.api.ClouderaManagerClientBuilder;
import com.cloudera.api.DataView;
import com.cloudera.api.model.ApiClusterList;
import com.cloudera.api.model.ApiConfigList;
import com.cloudera.api.v42.RootResourceV42;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class CloudManagerApiTest {

    private RootResourceV42 cloudManagerService;

    @Before
    public void init() {
        cloudManagerService = new ClouderaManagerClientBuilder()
                .withHost("cdp01.cloud.com")
                .withPort(7180)
                .withUsernamePassword("admin", "admin")
                .build()
                .getRootV42();
    }

    @Test
    public void testClusters() {
        ApiClusterList apiClusters = cloudManagerService.getClustersResource().readClusters(DataView.FULL);
        log.info("集群信息: {}", JSON.toJSONString(apiClusters));
    }

    @Test
    public void test() {
        ApiConfigList apiConfigs = cloudManagerService.getClustersResource()
                .getServicesResource("shallwe")
                .getRoleConfigGroupsResource("yarn")
                .readConfig("yarn-RESOURCEMANAGER-BASE", DataView.FULL);
        System.out.println(JSON.toJSONString(apiConfigs));
    }

}
