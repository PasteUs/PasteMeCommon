package cn.pasteme.common;

import cn.pasteme.common.entity.PermanentDO;
import cn.pasteme.common.mapper.PermanentMapper;
import cn.pasteme.common.mapper.PermanentTestMapper;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Irene
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationPermanentMapperTests {
    
    @Autowired
    private PermanentTestMapper permanentTestMapper;

    @Autowired
    private PermanentMapper permanentMapper;
    
    private static Long TEST_KEY = 99L;

    @Before
    public void beforeTest() {
        permanentTestMapper.createTable();
        PermanentDO permanentDO = new PermanentDO();
        permanentDO.setKey(TEST_KEY);
        permanentDO.setLang("plain");
        permanentDO.setContent("shuiqingyuan is sb");
        permanentDO.setPassword("password");
        permanentDO.setClientIp("127.0.0.1");
        Assert.assertNotNull(permanentTestMapper);
        Assert.assertEquals(Long.valueOf(1), permanentTestMapper.create(permanentDO));
    }

    @After
    public void afterTest() {
        Assert.assertEquals(Long.valueOf(1), permanentTestMapper.delete(TEST_KEY));
    }

    @Test
    public void getByKeyTest() {
        Assert.assertEquals(TEST_KEY, permanentMapper.getByKey(TEST_KEY).getKey());

    }

    @Test
    public void eraseByKeyTest(){
        Assert.assertNotNull(permanentMapper.getByKey(TEST_KEY));
        Assert.assertEquals(Long.valueOf(1),permanentMapper.eraseByKey(TEST_KEY));
        Assert.assertNull(permanentMapper.getByKey(TEST_KEY));
    }

    @Test
    public void createTest(){
        PermanentDO permanentDO = new PermanentDO();
        permanentDO.setLang("plain");
        permanentDO.setContent("shuiqingyuan is sb");
        permanentDO.setClientIp("");
        Assert.assertEquals(Long.valueOf(1), permanentMapper.create(permanentDO));
    }

}
