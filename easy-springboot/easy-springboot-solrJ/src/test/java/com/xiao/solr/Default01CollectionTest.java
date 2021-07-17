package com.xiao.solr;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 功能描述：<solrJ测试程序>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/7/17 15:09
 */
@Slf4j
public class Default01CollectionTest {

    private CloudSolrClient solrClient;

    private static final String name = "我爱这土地 【作者】bai艾青【朝代】du现代 假如我是一只鸟,我也应该用嘶哑的喉zhi咙歌唱: 这被dao暴风雨所打击着的土地,这永远汹涌着我们的悲愤的河流, 这无止息地吹刮着的激怒的风";

    @Before
    public void init() {
        List<String> solrUrls = new ArrayList<>();
        solrUrls.add("http://solr01.cloud.com:8983/solr");
        solrUrls.add("http://solr02.cloud.com:8983/solr");
        solrUrls.add("http://solr03.cloud.com:8983/solr");
        solrClient = new CloudSolrClient.Builder(solrUrls).build();
        solrClient.setDefaultCollection("default_01");
        solrClient.connect();
    }

    @Test
    public void testAddDocument() throws IOException, SolrServerException {
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "01_" + System.currentTimeMillis());
        document.addField("name_cn", name);
        solrClient.add(document);
        solrClient.commit();
    }

    @Test
    public void testAddBean() throws IOException, SolrServerException {
        Document document = new Document();
        document.setId("01_Bean_" + System.currentTimeMillis());
        document.setName_cn(name);
        solrClient.addBean(document);
        solrClient.commit();
    }

    @Test
    public void testQueryBean() throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery("*:*");
        query.setRows(200);
        QueryResponse response = solrClient.query(query);
        List<Document> beans = response.getBeans(Document.class);
        log.info("总记录数：{}", beans.size());
        log.info(JSON.toJSONString(beans));
    }

}
