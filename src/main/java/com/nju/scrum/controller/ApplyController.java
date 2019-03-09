package com.nju.scrum.controller;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.nju.scrum.pojo.Apply;
import com.nju.scrum.pojo.R;
import com.nju.scrum.service.ApplyService;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.INTERNAL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ApplyController {
    @Autowired
    ApplyService applyService;

    //返回的是尚未经过审批的申请者信息列表
    @GetMapping("/plan/apply/{pid}")
    public R selectByPid(@PathVariable("pid") Integer pid) {
        R r = new R();
        if (pid == null) {
            r.setCode(1);
            r.setMsg("未传入pid");
        } else {
            try {
                r.setCode(0);
                r.setMsg("查询成功");
                r.setData(applyService.selectByPid(pid));
            } catch (Exception e) {
                r.setCode(1);
                r.setMsg("查询失败");
            }
        }
        return r;
    }

    @PutMapping("/plan/apply")
    public  R confirmApply(@RequestBody Map<String,Integer> params) {
        int applyid = params.get("applyid");
        int pass = params.get("pass");
        R r = new R();
        try {
            applyService.confirmApply(applyid, pass);
            r.setCode(0);
            r.setMsg("同意/拒绝申请成功");
            applyService.isDealed(applyid);
        } catch (Exception e) {
            e.printStackTrace();
            r.setCode(1);
            r.setMsg("同意/拒绝申请失败");
        }
        return r;
    }
}
