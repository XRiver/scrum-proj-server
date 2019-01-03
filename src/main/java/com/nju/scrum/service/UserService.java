package com.nju.scrum.service;

import com.nju.scrum.pojo.User;

public interface UserService {
    String login(String openid);

    String register(User user);

    User selectUserByOpenId(String openid);
}
