package com.hzu.paper.controller;


import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.entity.CollectionHistory;
import com.hzu.paper.entity.CollectionKey;
import com.hzu.paper.service.CollectionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @PostMapping
    public Result addCollection(@RequestBody CollectionHistory collectionHistory){
        if(collectionHistory == null){
            return new Result(false,StatusCode.ERROR,"添加失败");
        }
        return collectionService.addCollection(collectionHistory);
    }

    @PostMapping(value = "/del")
    public Result delCollection(@RequestBody CollectionKey collectionKey){
        if(collectionKey == null){
            return new Result(false,StatusCode.ERROR,"删除失败");
        }
        return collectionService.delCollection(collectionKey);
    }

    @GetMapping(value = "/{userId}")
    public Result findCollection(@PathVariable String userId ){
        if(StringUtils.isEmpty(userId) ){
            return new Result(false,StatusCode.ERROR,"查找失败");
        }
        return collectionService.findCollection(userId);
    }



}
