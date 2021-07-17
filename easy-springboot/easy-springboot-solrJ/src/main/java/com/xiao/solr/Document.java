package com.xiao.solr;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

/**
 * @desc: 功能描述：<文档>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/7/17 16:11
 */
@Data
public class Document {

    @Field
    private String id;
    @Field
    private String name_cn;

}
