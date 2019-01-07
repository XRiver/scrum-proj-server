package com.nju.scrum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
//    public void testLogin() throws Exception {
//        this.mockMvc.perform(get("/api/login")
//                .param("openid", "111")).andDo(print());
//    }
    public void testLogin() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/login")
                .param("openid", "111");
        MvcResult result = mockMvc.perform(request).andReturn();
        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();
        System.out.println(content);
        System.out.println(status);
    }




}

