package com.hzu.paper.service.Impl;

import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.dao.CollectionMapper;
import com.hzu.paper.entity.CollectionHistory;
import com.hzu.paper.entity.CollectionKey;
import com.hzu.paper.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public Result addCollection(CollectionHistory collectionHistory) {

        int count = collectionMapper.insertSelective(collectionHistory);
        if(count <0){
            return new Result(false,StatusCode.ERROR,"添加失败");
        }
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @Override
    public Result delCollection(CollectionKey collectionKey) {
        int count = collectionMapper.deleteByPrimaryKey(collectionKey);
        if(count <0){
            return new Result(false,StatusCode.ERROR,"删除失败");
        }
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @Override
    public Result findCollection(String userId) {
        return new Result(true,StatusCode.OK,"查询成功",collectionMapper.findCollectionByUserId(userId));
    }

}
