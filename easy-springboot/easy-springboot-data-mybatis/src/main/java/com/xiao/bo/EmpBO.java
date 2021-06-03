package com.xiao.bo;

import com.xiao.dao.model.DeptDO;
import com.xiao.dao.model.EmpDO;
import lombok.Data;

/**
 * @desc: 功能描述：<雇员业务模型>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/5/29 9:53
 */
@Data
public class EmpBO extends EmpDO {

    private DeptDO dept;

}