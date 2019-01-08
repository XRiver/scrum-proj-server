package com.nju.scrum.service;

import com.nju.scrum.pojo.Apply;

import java.util.List;

public interface ApplyService {
    //根据出行计划Pid 查询所有的相关申请
    List<Apply> selectByPid(int pid);

    //通过或拒绝申请 0 拒绝 1 统一
    void confirmApply(int applyid, int pass);
}
