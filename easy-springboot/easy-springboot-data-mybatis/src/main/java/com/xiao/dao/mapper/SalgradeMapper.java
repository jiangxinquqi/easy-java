package com.xiao.dao.mapper;

import com.xiao.dao.model.SalgradeDO;

public interface SalgradeMapper {
    int insert(SalgradeDO record);

    int insertSelective(SalgradeDO record);
}
