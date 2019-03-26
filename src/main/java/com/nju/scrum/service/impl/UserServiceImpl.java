package com.nju.scrum.service.impl;

import com.nju.scrum.mapper.UserMapper;
import com.nju.scrum.pojo.User;
import com.nju.scrum.service.UserService;
import org.apache.tomcat.util.security.Escape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.Date;
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

    @Override
    public List<User> selectUncreditUser(long timeStamp) {
        return userMapper.selectUncreditUser(timeStamp);
    }

    @Override
    public void updateUnlockTime(Long unlockTime, String openid) {
        userMapper.updateUnlockTime(unlockTime,openid);
    }

    @Override
    //查询一个用户有没有被封禁
    public boolean isLocked(String openid) {

        try {
            long unlockTime = userMapper.selectUnlockTimeByOpenid(openid);
            long now = new Date().getTime();
            if (unlockTime >= now) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }


}