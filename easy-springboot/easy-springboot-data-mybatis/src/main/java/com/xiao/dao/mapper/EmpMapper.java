package com.xiao.dao.mapper;

import com.xiao.bo.EmpBO;
import com.xiao.dao.model.EmpDO;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(EmpDO record);

    int insertSelective(EmpDO record);

    EmpDO selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(EmpDO record);

    int updateByPrimaryKey(EmpDO record);

    EmpBO selectFullInfoByPrimaryKey(Integer empno);

    EmpBO selectFullInfoByPrimaryKey2(Integer empno);
}