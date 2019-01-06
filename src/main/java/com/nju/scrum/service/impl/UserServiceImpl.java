package com.nju.scrum.service.impl;

import com.nju.scrum.mapper.UserMapper;
import com.nju.scrum.pojo.User;
import com.nju.scrum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(String openid) {
        if (openid==null){
            return "1";
        }
        List<User> list=userMapper.selectByOpenId(openid);
        if (list.isEmpty()){
            return "2";
        }else {
            return "0";
        }
    }

    @Override
    public String register(User user) {
        if(user.getOpenid()==null){
            return "1";
        }else if (!userMapper.selectByOpenId(user.getOpenid()).isEmpty()){
            return "2";
        } else {
            userMapper.insert(user);
            return "0";
        }
    }

    @Override
    public User selectUserByOpenId(String openid) {
        return userMapper.selectByOpenId(openid).get(0);
    }
}