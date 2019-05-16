package com.hzu.paper.controller;

import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.service.PaperService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @GetMapping(value = "/{userId}/{keyWord}")
    public Result searchPaper(@PathVariable String userId,@PathVariable String keyWord){
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(keyWord)){
            return new Result(false,StatusCode.ERROR,"用户ID和关键字为空");
        }
        return paperService.findPaper(userId,keyWord);
    }
    @GetMapping(value = "/{lwId}")
    public Result findByLwId(@PathVariable String lwId){
        if(StringUtils.isEmpty(lwId)){
            return new Result(false,StatusCode.ERROR,"论文ID为空");
        }
        return paperService.findPaperById(lwId);
    }

    @GetMapping(value = "/downLoad/{keyWord}")
    public Result downLoadPaper(@PathVariable String keyWord){
        if(StringUtils.isEmpty(keyWord)){
            return new Result(false,StatusCode.ERROR,"关键字为空");
        }
        return paperService.downLoadPaper(keyWord);
    }
}
