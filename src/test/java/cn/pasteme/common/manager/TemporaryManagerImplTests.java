package cn.pasteme.common.manager;

import cn.pasteme.common.dto.PasteRequestDTO;
import cn.pasteme.common.dto.PasteResponseDTO;
import cn.pasteme.common.entity.TemporaryDO;

import cn.pasteme.common.mapper.TemporaryMapper;
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
 * @date 2019/10/07 20:04
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemporaryManagerImplTests {
    @Autowired
    TemporaryManager temporaryManager;

    @Autowired
    TemporaryMapper temporaryMapper;

    private String TEST_KEY_ONE = "OctSevenOne";
    private String TEST_KEY_TWO = "OctSevenTwo";
    private PasteRequestDTO pasteRequestDTO = new PasteRequestDTO();
    private TemporaryDO temporaryDO = new TemporaryDO();

    @Before
    public void beforeTest() {
        pasteRequestDTO.setKey(TEST_KEY_ONE);
        pasteRequestDTO.setLang("plain");
        pasteRequestDTO.setContent("Oct");
        pasteRequestDTO.setPassword("holiday over");
        pasteRequestDTO.setClientIp("127.0.0.1");

        temporaryDO.setKey(TEST_KEY_TWO);
        temporaryDO.setPassword("password");
        temporaryDO.setLang("plain");
        temporaryDO.setContent("Oct");
        temporaryDO.setClientIp("127.0.0.1");
        temporaryMapper.create(temporaryDO);
    }

    @After
    public void afterTest() {
    }

    @Test
    public void saveTest() {
        Assert.assertEquals(TEST_KEY_ONE, temporaryManager.save(pasteRequestDTO));
    }

    @Test
    public void getTest() {
        PasteResponseDTO pasteResponseDTO = new PasteResponseDTO();
        pasteResponseDTO.setLang("plain");
        pasteResponseDTO.setContent("Oct");
        Assert.assertEquals(pasteResponseDTO.getLang(), temporaryManager.get(TEST_KEY_TWO).getLang());
        Assert.assertEquals(pasteResponseDTO.getContent(),temporaryManager.get(TEST_KEY_TWO).getContent());
    }

    @Test
    public void eraseTest() {
        Assert.assertTrue(temporaryManager.erase(TEST_KEY_TWO));
    }

    @Test
    public void statusTest() {
        Assert.assertEquals(Integer.valueOf(0),temporaryManager.status(TEST_KEY_TWO) );
    }
}
