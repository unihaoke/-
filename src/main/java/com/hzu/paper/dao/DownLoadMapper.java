package com.hzu.paper.dao;

import com.hzu.paper.entity.DownLoad;

import java.util.List;

public interface DownLoadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DownLoad record);

    int insertSelective(DownLoad record);

    DownLoad selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DownLoad record);

    int updateByPrimaryKey(DownLoad record);

    List<DownLoad> findDownLoadByUserId(String userId);

    List<String> findAllId(String userId);

    void deleteAll(List<String> listId);
}