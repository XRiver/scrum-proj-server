package com.nju.scrum.controller;
import com.nju.scrum.pojo.Attraction;
import com.nju.scrum.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@ResponseBody
@Controller
//上面两者叠加等价于@RestController
@RequestMapping("/api/")
public class AttractionController {
    @Autowired
    private AttractionService attractionService;
    @GetMapping("/attractions")
    public List<Attraction> attractions(String type,Integer aid) {
        //模拟试验通过
        //type="single";
        if(type.equals("all")) {
            List<Attraction> list = attractionService.selectAll();
            return list;
        }else {
            aid=4;
            Attraction a=attractionService.selectByPrimaryKey(aid);
            List<Attraction> list=new ArrayList<Attraction>();
            list.add(a);
            return list;
        }
    }

//    @GetMapping("attraction")
//    public Attraction attraction(Integer aid) {
//        //模拟试验通过
//        aid=4;
//        Attraction a=attractionService.selectByPrimaryKey(aid);
//        return a;
//    }
}
