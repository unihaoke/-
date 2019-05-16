package com.hzu.paper.controller;

import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.entity.DownLoad;
import com.hzu.paper.service.DownLoadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/downLoad")
public class DownLoadController {

    @Autowired
    private DownLoadService downLoadService;

    @PostMapping(value = "/history")
    public Result addHistory(@RequestBody DownLoad downLoad){
        if(downLoad == null){
            return new Result(false,StatusCode.ERROR,"添加失败");
        }
        return downLoadService.addDownLoad(downLoad);
    }

    @GetMapping(value = "/history/{userId}")
    public Result findHistory(@PathVariable String userId){
        if(StringUtils.isEmpty(userId)){
            return new Result(false,StatusCode.ERROR,"查询失败");
        }
        return downLoadService.findDownLoadByUserId(userId);
    }

    @DeleteMapping(value = "/history/del/{id}")
    public Result delHistory(@PathVariable Integer id){
        if(id == null){
            return new Result(false,StatusCode.ERROR,"删除失败");
        }
        return downLoadService.delHistory(id);
    }

    @DeleteMapping(value = "/history/del/all/{userId}")
    public Result delAll(@PathVariable String userId){
        if(StringUtils.isEmpty(userId)){
            return new Result(false,StatusCode.ERROR,"删除失败");
        }
        return downLoadService.delAll(userId);
    }
}
