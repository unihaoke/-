package com.hzu.paper.dao;

import com.hzu.paper.entity.Recode;

public interface RecodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recode record);

    int insertSelective(Recode record);

    Recode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recode record);

    int updateByPrimaryKey(Recode record);
}