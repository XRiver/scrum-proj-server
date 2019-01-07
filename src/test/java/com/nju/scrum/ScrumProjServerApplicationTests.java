package com.nju.scrum;


import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
//静态导入 省的写MockMvcRequestBuilders 这几个Builder了
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
    //  虚拟mvc请求，获取到处理结果
    private MockMvc mockMvc;

    @Before//每次测试之前都需要初始化，用before标注
    public void initMokcMcx() {
//      要初始化mockmvc对象，需要mvc的ioc容器本身
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testLogin() throws Exception {
        //this.mockMvc.perform 返回ResultAction接口的实现类 有andReturn andDo等方法
        //andReturn返回MvcResult类型 有getResponse等方法
        //getResponse返回MockHttpServletResponse类型，有getXXX等一些列Resp应有属性的方法
        //可以通过getContentAsString获得Response中Content属性的值，可以后续转成JSON格式
        MvcResult res = this.mockMvc.perform(get("/api/login")
                .param("openid", "111")).andReturn();
        String  content = res.getResponse().getContentAsString();
        Integer statusNum = res.getResponse().getStatus();
        JSONObject json = new JSONObject(content);
        System.out.println(json.getInt("code"));
        System.out.println(json.getString("msg"));
        System.out.println(json.getJSONObject("data").getInt("uid"));
        System.out.println(json.getJSONObject("data").getString("openid"));
        System.out.println(json.getJSONObject("data").getString("uname"));
    }




}

