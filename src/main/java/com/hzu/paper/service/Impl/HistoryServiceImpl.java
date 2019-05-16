package com.hzu.paper.service.Impl;

import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.dao.HistoryMapper;
import com.hzu.paper.entity.History;
import com.hzu.paper.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public Result addHistory(History history) {

        int count = historyMapper.insert(history);
        if (count < 0){
            return new Result(false,StatusCode.ERROR,"添加失败");
        }
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @Override
    public Result findHistoryByUserId(String userId) {

        return new Result(true,StatusCode.OK,"查询成功",historyMapper.findHistoryByUserId(userId));
    }

    @Override
    public Result delHistory(Integer id) {
        int count = historyMapper.deleteByPrimaryKey(id);
        if (count < 0){
            return new Result(false,StatusCode.ERROR,"删除失败");
        }
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @Override
    public Result delAll(String userId) {
        List<String> listId = historyMapper.findAllId(userId);
        if (listId.size()<=0){
            return new Result(false,StatusCode.ERROR,"删除失败,没有数据");
        }
        historyMapper.deleteAll(listId);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
