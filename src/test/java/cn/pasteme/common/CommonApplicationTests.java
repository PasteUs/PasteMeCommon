package cn.pasteme.common;

import cn.pasteme.common.mapper.PermanentMapper;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationTests {

    @Autowired
    private PermanentMapper permanentMapper;

    @Test
    public void contextLoads() {
        System.out.println("Hello World!");
        // System.out.println(JSON.toJSONString(permanentMapper.getByKey(100L)));
    }

}
