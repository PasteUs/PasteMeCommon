package cn.pasteme.common;

import cn.pasteme.common.entity.TemporaryDO;
import cn.pasteme.common.mapper.TemporaryMapper;
import cn.pasteme.common.mapper.TemporaryTestMapper;
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
public class CommonApplicationTemporaryMapperTests {
    @Autowired
    private TemporaryMapper temporaryMapper;

    @Autowired
    private TemporaryTestMapper temporaryTestMapper;
    
    private static String TEST_KEY = "sqysb";

    @Before
    public void before() {
        temporaryTestMapper.createTable();
    }

    @Test
    public void main() {

        Assert.assertNull(temporaryMapper.getByKey(TEST_KEY));

        TemporaryDO temporaryDO = new TemporaryDO();
        temporaryDO.setKey(TEST_KEY);
        temporaryDO.setLang("plain");
        temporaryDO.setContent("shuizhuzhu");
        temporaryDO.setPassword("irene");
        temporaryDO.setClientIp("127.0.0.1");

        Assert.assertNotNull(temporaryDO);

        Assert.assertEquals(Long.valueOf(1), temporaryMapper.create(temporaryDO));

        Assert.assertNotNull(temporaryMapper.getByKey(TEST_KEY));

        Assert.assertEquals(Long.valueOf(1), temporaryMapper.eraseByKey(TEST_KEY));

        Assert.assertNull(temporaryMapper.getByKey(TEST_KEY));
    }
}
