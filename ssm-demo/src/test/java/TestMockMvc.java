import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @ClassName TestMockMvc
 * @Description mvc mock测试Demo
 * @Author sjqi
 * @Date 8:55 2019/4/12
 * @Version 1.0
 * 注解 @WebAppConfiguration：无需启用servlet容器就能获取web上下文，
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
@WebAppConfiguration
public class TestMockMvc {
    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;

    @Before
    public void setup() {
        //采用web应用上下文设置的方式初始化mockmvc对象。
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testReturnJsp() throws Exception {
        //通过preform 发送http 请求
        //通过andExpect判断请求是否执行成功
        //andDo 对请求之后的结果进行输出
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/getUsersBy")
                .param("name", "xiaoming").param("age", "20")
                .param("birthday", "2019-09-20"))
                .andExpect(MockMvcResultMatchers.view().name("forward:getHello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("======================");
        System.out.println(result.getHandler());
    }

    @Test
    public void testReturnJson() throws Exception {
        MvcResult result = mockMvc.perform(get("/responseBody/returnPOJO")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("sjqi"))
                .andDo(print())
                .andReturn();
    }
}
