package com.nju.scrum.service;

import com.nju.scrum.pojo.*;

import java.util.List;

public interface PlanService {
    List<Plan> selectByAttraction(String aName, String state);
    List<Plan> selectByCreatorName(String name, String state);
    List<Plan> selectByCreatorOpenid(String openid, String state);
    String createPlan(Plan plan);
    String applyPlan(String openid, Integer pid, String mess);
    String changeState(int pid, String state);
    Plan selectByPid(int pid);
    List<User> selectMembersByPid(Integer pid);
    void evaluatePeople(Evaluation evaluation);
    void createAnnouncement(Announcement announcement);
    void createSummary(Summary summary);
    List<Plan> selectJoinedPlanByOpenid(String openid, String state);
}
