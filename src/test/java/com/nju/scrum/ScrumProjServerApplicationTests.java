package com.nju.scrum;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.nju.scrum.service.ApplyService;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
//静态导入 省的写MockMvcRequestBuilders 这几个Builder了
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//一般自动装配的是bean，如果需要装配ioc容器本身，要用这个注解
@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ScrumProjServerApplication.class})
public class ScrumProjServerApplicationTests {
    //  传入springmvc的iod容器本身
    @Autowired
    WebApplicationContext context;
    @Autowired
    ApplyService applyService;
    //  虚拟mvc请求，获取到处理结果
    private MockMvc mockMvc;

    @Before//每次测试之前都需要初始化，用before标注
    public void initMokcMcx() {
//      要初始化mockmvc对象，需要mvc的ioc容器本身
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
//    @Test
//    public void testLogin() throws Exception {
//        //this.mockMvc.perform 返回ResultAction接口的实现类 有andReturn andDo等方法
//        //andReturn返回MvcResult类型 有getResponse等方法
//        //getResponse返回MockHttpServletResponse类型，有getXXX等一些列Resp应有属性的方法
//        //可以通过getContentAsString获得Response中Content属性的值，可以后续转成JSON格式
//        MvcResult res = this.mockMvc.perform(get("/api/login/o9VBV4yQfCMsqJif_6DdAEhKzAIo")
//                ).andDo(print()).andReturn();
//        String  content = res.getResponse().getContentAsString();
//        int statusNum = res.getResponse().getStatus();
//        JSONObject json = new JSONObject(content);
//        //使用spring自己的断言类Assert
//        Assert.isTrue(statusNum==200,"http状态码不是200");
//        Assert.isTrue(json.getInt("code") == 0 ,"返回状态码不是0");
//        Assert.isTrue(json.getString("msg").equals("登录成功"),"不是登录成功");
//        Assert.isTrue(json.getJSONObject("data").getInt("uid") == 1,"uid不对");
//        Assert.isTrue(json.getJSONObject("data").getString("openid").equals("111"),"openid不对");
//        Assert.isTrue(json.getJSONObject("data").getString("uname").equals("张三"), "uname不对");
//    }
    @Test
    public void testRegister() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("openid", "19960305");
        map.put("uname","刘正元");
        JSONObject js = new JSONObject(map);
        MvcResult res = this.mockMvc.perform(post("/api/register")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(js.toString())).andDo(print()).andReturn();
        String  content = res.getResponse().getContentAsString();
        JSONObject json = new JSONObject(content);
        int statusNum = res.getResponse().getStatus();
        //使用spring自己的断言类Assert
        Assert.isTrue(statusNum==200,"http状态码不是200");
        Assert.isTrue(json.getInt("code") != 1 ,"返回状态码是1,未传入openid");
    }

    @Test
    public void testApplyService() {
        System.out.println(applyService.selectByPid(3));
        applyService.confirmApply(1,1);
    }


    @Test
    public void testSelectByPid() throws Exception{
        MvcResult res = this.mockMvc.perform(get("/api/plan/apply/3")
                ).andDo(print()).andReturn();
    }

    @Test
    public void testConfirmApply () throws Exception {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("applyid", 2);
        map.put("pass",0);
        JSONObject js = new JSONObject(map);
        MvcResult res = this.mockMvc.perform(put("/api/plan/apply")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(js.toString())).andDo(print()).andReturn();
    }

    @Test
    public void testAttractions() throws Exception {
        MvcResult res = this.mockMvc.perform(get("/api/attractions")
                .param("type","all")
                ).andDo(print()).andReturn();
    }
    @Test
    public void testGetPlan() throws Exception {
        MvcResult res1 = this.mockMvc.perform(get("/api/plan/openid/111").param("state","0123").characterEncoding("utf-8")).andDo(print()).andReturn();
        MvcResult res2 = this.mockMvc.perform(get("/api/plan/uname/张三").param("state","0123").characterEncoding("utf-8")).andDo(print()).andReturn();
        MvcResult res3 = this.mockMvc.perform(get("/api/plan/attraction/夫子庙").param("state","0123").characterEncoding("utf-8")).andDo(print()).andReturn();
    }

    @Test
    public void testGetAttraction() throws Exception {
        MvcResult res1 = this.mockMvc.perform(get("/api/attractions/").characterEncoding("utf-8")).andDo(print()).andReturn();
        MvcResult res2 = this.mockMvc.perform(get("/api/attractions/1").characterEncoding("utf-8")).andDo(print()).andReturn();
    }

    @Test
    public void testEvalutePeople() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pid", 35);
        map.put("fromid","mf1832113");
        map.put("toid","111");
        map.put("mess","你是个好人");
        JSONObject js = new JSONObject(map);
        MvcResult res1 = this.mockMvc.perform(post("/api/plan/evaluation")
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(js.toString())).andDo(print()).andReturn();
    }
}

