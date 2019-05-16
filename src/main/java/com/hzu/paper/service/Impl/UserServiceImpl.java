package com.hzu.paper.service.Impl;

import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.dao.UserMapper;
import com.hzu.paper.entity.User;
import com.hzu.paper.service.UserService;
import com.hzu.paper.utils.HttpRequest;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result addUser(User user) {

        int count = userMapper.findUserById(user.getYhid());
        if(count ==0){
            userMapper.insertSelective(user);
        }
        return new Result(true,StatusCode.OK,"登录成功");
    }

    @Override
    public Result getUserId(String username, String code) {
        // 登录凭证不能为空
        if (code == null || code.length() == 0) {
            return new Result(false,StatusCode.ERROR,"查询失败");
        }
        // 小程序唯一标识 (在微信小程序管理后台获取)
        String wxspAppid = "wxe0d156a5aac77e36";
        // 小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "9a59467bbc96e5a99bdfedf1be63e087";
        // 授权（必填）
        String grant_type = "authorization_code";
        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        //////////////// ////////////////
        // 请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
                + grant_type;
        // 发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        // 解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);
        System.out.println(json.toString());
        String openid = (String) json.get("openid");
        System.out.println("userId:"+openid);
        if(StringUtils.isEmpty(openid)){
            return new Result(false,StatusCode.ERROR,"请求失败");
        }
        int count = userMapper.findUserById(openid);
        if (count == 0){
            User user = new User();
            user.setYhid(openid);
            user.setUserName(username);
            userMapper.insert(user);
        }
        return new Result(true,StatusCode.OK,"请求成功",openid);
    }

    @Override
    public Result updateUser(User user) {
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count == 0){
            return new Result(false,StatusCode.ERROR,"更新失败");
        }
        return new Result(true,StatusCode.OK,"修改成功");
    }


}
