package cn.pasteme.common;

import cn.pasteme.common.entity.TemporaryDO;
import cn.pasteme.common.mapper.TemporaryMapper;
import cn.pasteme.common.mapper.TemporaryTestMapper;
import org.checkerframework.checker.units.qual.A;
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
 * @date 2019/10/06 01:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationTemporaryMapperTests {
    @Autowired
    private TemporaryMapper temporaryMapper;

    @Autowired
    private TemporaryTestMapper temporaryTestMapper;
    
    private static String TEST_KEY = "sqysb";
    
    @Before
    public void beforeTest() {
        temporaryTestMapper.createTable();
        TemporaryDO temporaryDO = new TemporaryDO();
        temporaryDO.setKey(TEST_KEY);
        temporaryDO.setLang("plain");
        temporaryDO.setContent("shuizhuzhu");
        temporaryDO.setPassword("irene");
        temporaryDO.setClientIp("127.0.0.1");
        Assert.assertNotNull(temporaryTestMapper);
        Assert.assertEquals(Long.valueOf(1), temporaryTestMapper.insert(temporaryDO));
    }

    @After
    public void afterTest() {
        temporaryTestMapper.delete(TEST_KEY);
        Assert.assertNull(temporaryMapper.getByKey(TEST_KEY));
    }

    @Test
    public void getByKeyTest() {
        Assert.assertEquals(TEST_KEY, temporaryMapper.getByKey(TEST_KEY).getKey());
    }

    @Test
    public void createTest() {
        String testKey = "sbsqy";
        temporaryTestMapper.delete(testKey);
        Assert.assertNull(temporaryMapper.getByKey(testKey));
        TemporaryDO temporaryDO = new TemporaryDO();
        temporaryDO.setKey(testKey);
        temporaryDO.setLang("plain");
        temporaryDO.setContent("shuishui");
        temporaryDO.setPassword("ireneLiu");
        temporaryDO.setClientIp("127.0.0.1");
        Assert.assertNotNull(temporaryMapper);
        Assert.assertEquals(Long.valueOf(1), temporaryMapper.create(temporaryDO));
    }

    @Test
    public void eraseByKeyTest() {
        Assert.assertNotNull(temporaryMapper.getByKey(TEST_KEY));
        Assert.assertEquals(Long.valueOf(1), temporaryMapper.eraseByKey(TEST_KEY));
        Assert.assertNull(temporaryMapper.getByKey(TEST_KEY));
    }
}
