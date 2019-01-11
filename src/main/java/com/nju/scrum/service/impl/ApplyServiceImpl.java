package com.nju.scrum.service.impl;

import com.nju.scrum.mapper.ApplyMapper;
import com.nju.scrum.pojo.Apply;
import com.nju.scrum.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;
    @Override
    public List<Apply> selectByPid(int pid) {
        return applyMapper.selectByPid(pid);
    }

    @Override
    public void confirmApply(int applyid, int pass) {
        applyMapper.confirmApply(applyid, pass);
    }

    @Override
    public void isDealed(int applyid) {
        applyMapper.isDealed(applyid);
    }
}
