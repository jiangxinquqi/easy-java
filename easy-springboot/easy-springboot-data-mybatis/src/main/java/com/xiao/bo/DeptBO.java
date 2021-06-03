package com.xiao.bo;

import com.xiao.dao.model.DeptDO;
import com.xiao.dao.model.EmpDO;
import lombok.Data;

import java.util.List;

/**
 * @desc: 功能描述：<>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/5/29 9:06
 */
@Data
public class DeptBO extends DeptDO {

    private List<EmpDO> emps;

}