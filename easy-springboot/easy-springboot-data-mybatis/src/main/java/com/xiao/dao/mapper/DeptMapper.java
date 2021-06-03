package com.xiao.dao.mapper;

import com.xiao.bo.DeptBO;
import com.xiao.dao.model.DeptDO;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptno);

    int insert(DeptDO record);

    int insertSelective(DeptDO record);

    DeptDO selectByPrimaryKey(Integer deptno);

    int updateByPrimaryKeySelective(DeptDO record);

    int updateByPrimaryKey(DeptDO record);

    DeptBO getFullInfoById(Integer deptno);

    DeptBO getFullInfoById2(Integer deptno);

}