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
 * @date 2019/10/05 23:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationPermanentMapperTests {
    
    @Autowired
    private PermanentTestMapper permanentTestMapper;

    @Autowired
    private PermanentMapper permanentMapper;
    
    private static Long TEST_ID = 99L;

    @Before
    public void beforeTest() {
        PermanentDO permanentDO = new PermanentDO();
        permanentDO.setKey(TEST_ID);
        permanentDO.setLang("plain");
        permanentDO.setContent("shuiqingyuan is sb");
        permanentDO.setPassword("password");
        permanentDO.setClientIp("127.0.0.1");
        Assert.assertNotNull(permanentTestMapper);
        Assert.assertEquals(Long.valueOf(1), permanentTestMapper.create(permanentDO));
    }

    @After
    public void afterTest() {
        Assert.assertEquals(Long.valueOf(1), permanentTestMapper.delete(TEST_ID));
    }

    @Test
    public void getByKeyTest() {
        Assert.assertEquals(TEST_ID, permanentMapper.getByKey(TEST_ID).getKey());

    }

    @Test
    public void eraseByKeyTest(){
        Assert.assertNotNull(permanentMapper.getByKey(TEST_ID));
        Assert.assertTrue(permanentMapper.eraseByKey(TEST_ID));
        Assert.assertNull(permanentMapper.getByKey(TEST_ID));
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
