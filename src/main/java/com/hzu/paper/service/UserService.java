package com.hzu.paper.service;

import com.hzu.paper.common.Result;
import com.hzu.paper.entity.User;

public interface UserService {
    Result addUser(User user);

    Result getUserId(String username, String code);

    Result updateUser(User user);
}
