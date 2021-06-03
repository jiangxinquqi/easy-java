package com.xiao.dao.mapper;

import com.xiao.dao.model.BonusDO;

public interface BonusMapper {
    int insert(BonusDO record);

    int insertSelective(BonusDO record);
}