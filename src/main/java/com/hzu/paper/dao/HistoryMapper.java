package com.hzu.paper.dao;

import com.hzu.paper.entity.History;

import java.util.List;

public interface HistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);

    List<History> findHistoryByUserId(String userId);

    List<String> findAllId(String userId);

    void deleteAll(List<String> list);
}