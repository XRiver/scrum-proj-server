package com.nju.scrum.service;

import com.nju.scrum.pojo.User;

import java.util.List;

public interface UserService {
    String login(String openid);

    String register(User user);

    User selectUserByOpenId(String openid);

    List<User> selectUncreditUser(long timeStamp);

    void updateUnlockTime(long unlockTime, String openid);

}
