package com.nju.scrum.controller;

import com.nju.scrum.pojo.Attraction;
import com.nju.scrum.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@ResponseBody
@Controller
//上面两者叠加等价于@RestController
@RequestMapping("/api/")
public class AttractionController {

    @Autowired
    private AttractionService attractionService;


    @GetMapping("/attractions/{aid}")
    public List<Attraction> getAttraction(@PathVariable("aid") Integer aid) {

        Attraction a = attractionService.selectByPrimaryKey(aid);
        List<Attraction> list = new ArrayList<Attraction>();
        list.add(a);
        return list;

    }


    @GetMapping("/attractions")
    public List<Attraction> getAttractions() {
        return attractionService.selectAll();
    }


    //创建新的景点
    @PostMapping("/attractions")
    public String addAttraction(@RequestParam("file") MultipartFile file, Attraction attraction) {
        //先保存文件
        if (file.isEmpty()) {
            return "forward:/UploadFail.html";
        }
        try {
            //获取类路径的绝对根目录
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            //拼上static下的路径
            File fileDirPath = new File(path.getAbsolutePath(),"static/images/attractions/");
            if (!fileDirPath.exists()) {
                fileDirPath.mkdir();
            }
            //随机文件名
            String originalName = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString()+originalName.substring(originalName.lastIndexOf("."));
            //最终写入的绝对地址
            File dest = new File(fileDirPath.getAbsolutePath() +"/"+ fileName);
            file.transferTo(dest);
            //把图片URL存入Attraction中
            attraction.setPictureurl("images/attractions/"+fileName);
        } catch (IOException e) {
            return "error";
        }
        try {
            attractionService.addAttraction(attraction);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }


    }
}
