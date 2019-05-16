package com.hzu.paper.service.Impl;

import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.dao.DownLoadMapper;
import com.hzu.paper.entity.DownLoad;
import com.hzu.paper.service.DownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DownLoadServiceImpl implements DownLoadService {

    @Autowired
    private DownLoadMapper downLoadMapper;


    @Override
    public Result addDownLoad(DownLoad downLoad) {

        int count = downLoadMapper.insert(downLoad);
        if (count < 0){
            return new Result(false,StatusCode.ERROR,"添加失败");
        }
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @Override
    public Result findDownLoadByUserId(String userId) {

        return new Result(true,StatusCode.OK,"查询成功",downLoadMapper.findDownLoadByUserId(userId));
    }

    @Override
    public Result delHistory(Integer id) {

        int count = downLoadMapper.deleteByPrimaryKey(id);
        if (count < 0){
            return new Result(false,StatusCode.ERROR,"删除失败");
        }
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @Override
    public Result delAll(String userId) {
        List<String> listId = downLoadMapper.findAllId(userId);
        if (listId.size()<=0){
            return new Result(false,StatusCode.ERROR,"删除失败,没有数据");
        }
        downLoadMapper.deleteAll(listId);
        return new Result(true,StatusCode.OK,"删除成功");
    }


}
