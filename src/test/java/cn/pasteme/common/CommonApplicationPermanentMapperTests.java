package cn.pasteme.common;

import cn.pasteme.common.entity.PermanentDO;
import cn.pasteme.common.mapper.PermanentMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author Irene
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CommonApplicationPermanentMapperTests {
    
    @Autowired
    private PermanentMapper permanentMapper;

    @Test
    public void createTest(){
        Long key;
        Long count = permanentMapper.countAll();

        // create
        {
            PermanentDO permanentDO = new PermanentDO();
            permanentDO.setLang("plain");
            permanentDO.setContent("sqy is sunny boy");
            permanentDO.setClientIp("0.0.0.0");
            assertEquals(Long.valueOf(1), permanentMapper.create(permanentDO));

            key = permanentDO.getKey();
        }
        
        assertEquals(Long.valueOf(count + 1), permanentMapper.countAll());

        // getByKey
        {
            assertNull(permanentMapper.getByKey(-1L));
            assertEquals(key, permanentMapper.getByKey(key).getKey());
        }

        // eraseByKey
        {
            assertNotNull(permanentMapper.getByKey(key));
            assertEquals(Long.valueOf(1), permanentMapper.eraseByKey(key));
            assertNull(permanentMapper.getByKey(key));
        }
    }
}
