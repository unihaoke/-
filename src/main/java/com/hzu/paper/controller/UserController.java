package com.hzu.paper.controller;

import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.entity.User;
import com.hzu.paper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Result addUser(@RequestBody User user){
        if(user == null){
            return new Result(false,StatusCode.ERROR,"登录失败");
        }
        return userService.addUser(user);
    }

    @PostMapping(value = "/decode")
    public Result addUserByCode(@RequestBody Map<String,Object> params){
        return userService.getUserId(params.get("username").toString(),params.get("code").toString());
    }

    @PutMapping
    public Result updateUser(@RequestBody User user){
        if(user == null){
            return new Result(false,StatusCode.ERROR,"修改失败");
        }
        return userService.updateUser(user);
    }

}
