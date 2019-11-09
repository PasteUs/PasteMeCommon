package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.PermanentDO;

import lombok.extern.slf4j.Slf4j;
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
 * @version 1.0.1
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CommonApplicationPermanentMapperTests {
    
    @Autowired
    private PermanentMapper permanentMapper;

    @Test
    public void main(){
        Long key;
        Long count = permanentMapper.countAll();

        // create
        {
            PermanentDO permanentDO = new PermanentDO();
            permanentDO.setLang("plain");
            permanentDO.setContent("sqy is sunny boy");
            permanentDO.setClientIp("0.0.0.0");
            permanentDO.setPassword("password");
            assertEquals(Long.valueOf(1), permanentMapper.create(permanentDO));

            key = permanentDO.getKey();
        }
        
        assertEquals(Long.valueOf(count + 1), permanentMapper.countAll());

        // getByKey
        {
            assertNull(permanentMapper.getByKey(-1L));
            PermanentDO permanentDO = permanentMapper.getByKey(key);
            assertEquals(key, permanentDO.getKey());
            assertEquals("plain", permanentDO.getLang());
            assertEquals("sqy is sunny boy", permanentDO.getContent());
            assertEquals("0.0.0.0", permanentDO.getClientIp());
            assertEquals("password", permanentDO.getPassword());
            assertNotNull(permanentDO.getCreatedAt());
            assertNull(permanentDO.getDeletedAt());
        }

        // eraseByKey
        {
            assertNotNull(permanentMapper.getByKey(key));
            assertEquals(Long.valueOf(1), permanentMapper.eraseByKey(key));
            PermanentDO permanentDO = permanentMapper.getByKey(key);
            log.info("permanentDO = {}", permanentDO);
            assertNotNull(permanentDO.getDeletedAt());
        }
    }
}
