package com.hzu.paper.dao;

import com.hzu.paper.entity.CollectionHistory;
import com.hzu.paper.entity.CollectionKey;

import java.util.List;

public interface CollectionMapper {
    int deleteByPrimaryKey(CollectionKey key);

    int insert(CollectionHistory record);

    int insertSelective(CollectionHistory record);

    CollectionHistory selectByPrimaryKey(CollectionKey key);

    int updateByPrimaryKeySelective(CollectionHistory record);

    int updateByPrimaryKeyWithBLOBs(CollectionHistory record);

    int updateByPrimaryKey(CollectionHistory record);

    List<CollectionHistory> findCollectionByUserId(String userId);
}