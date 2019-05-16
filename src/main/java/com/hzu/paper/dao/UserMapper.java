package com.hzu.paper.dao;

import com.hzu.paper.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String yhid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String yhid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int findUserById(String userId);
}