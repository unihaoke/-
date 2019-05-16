package com.hzu.paper.controller;

import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.entity.History;
import com.hzu.paper.service.HistoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @PostMapping
    public Result addHistory(@RequestBody History history){
        if(history == null){
            return new Result(false,StatusCode.ERROR,"添加失败");
        }
        return historyService.addHistory(history);
    }

    @GetMapping(value = "/{userId}")
    public Result findHistory(@PathVariable String userId){
        if(StringUtils.isEmpty(userId)){
            return new Result(false,StatusCode.ERROR,"查询失败");
        }
        return historyService.findHistoryByUserId(userId);
    }

    @DeleteMapping(value = "/del/{id}")
    public Result delHistory(@PathVariable Integer id){
        if(id == null){
            return new Result(false,StatusCode.ERROR,"删除失败");
        }
        return historyService.delHistory(id);
    }

    @DeleteMapping(value = "/del/all/{userId}")
    public Result delAll(@PathVariable String userId){
        if(StringUtils.isEmpty(userId)){
            return new Result(false,StatusCode.ERROR,"查询失败");
        }
        return historyService.delAll(userId);
    }
}
