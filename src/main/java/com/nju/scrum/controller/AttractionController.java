package com.nju.scrum.controller;
import com.nju.scrum.pojo.Attraction;
import com.nju.scrum.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/attractions/{type}/{aid}")
    public List<Attraction> attractions(@PathVariable("type") String type, @PathVariable("aid") Integer aid) {
        if(type.equals("single")) {
            Attraction a=attractionService.selectByPrimaryKey(aid);
            List<Attraction> list=new ArrayList<Attraction>();
            list.add(a);
            return list;
        }else {
            return null;
        }
    }
    @GetMapping("/attractions/{type}")
    public List<Attraction> attractions(@PathVariable("type") String type) {
        if(type.equals("all")) {
            List<Attraction> list = attractionService.selectAll();
            return list;
        }else {
            return null;
        }
    }

}
