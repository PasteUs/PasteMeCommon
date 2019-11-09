package cn.pasteme.common.manager;

import cn.pasteme.common.dto.PasteRequestDTO;
import cn.pasteme.common.dto.PasteResponseDTO;

import cn.pasteme.common.utils.result.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Lucien, Irene
 * @version 1.1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TemporaryManagerImplTests {

    @Autowired
    TemporaryManager temporaryManager;

    private String TEST_KEY_ONE = "OctSevenOne";

    private PasteRequestDTO pasteRequestDTO = new PasteRequestDTO();

    private PasteResponseDTO pasteResponseDTO = new PasteResponseDTO();

    @Before
    public void before() {
        pasteRequestDTO.setKey(TEST_KEY_ONE);
        pasteRequestDTO.setLang("plain");
        pasteRequestDTO.setContent("Oct");
        pasteRequestDTO.setPassword("holiday over");
        pasteRequestDTO.setClientIp("0.0.0.0");

        BeanUtils.copyProperties(pasteRequestDTO, pasteResponseDTO);
    }

    @Test
    @Transactional
    @Rollback
    public void main() {
        Long count = temporaryManager.countAll().getData();

        // save
        {
            Response<String> stringResponse = temporaryManager.save(pasteRequestDTO);
            assertTrue(stringResponse.isSuccess());
            assertEquals(TEST_KEY_ONE, stringResponse.getData());
        }

        assertEquals(Long.valueOf(count + 1), temporaryManager.countAll().getData());

        // get
        {
            Response<PasteResponseDTO> pasteResponseDTOResponse = temporaryManager.get(TEST_KEY_ONE);

            assertTrue(pasteResponseDTOResponse.isSuccess());
            assertEquals(pasteResponseDTO, pasteResponseDTOResponse.getData());
        }

        assertEquals(count, temporaryManager.countAll().getData());
    }
}
