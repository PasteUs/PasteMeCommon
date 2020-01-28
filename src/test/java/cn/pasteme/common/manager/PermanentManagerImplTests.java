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
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Lucien, Irene
 * @version 1.1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PermanentManagerImplTests {

    @Autowired
    private PermanentManager permanentManager;

    private PasteRequestDTO pasteRequestDTO = new PasteRequestDTO();

    private PasteResponseDTO pasteResponseDTO = new PasteResponseDTO();

    @Before
    public void before() {
        pasteRequestDTO.setLang("plain");
        pasteRequestDTO.setContent("Oct");
        pasteRequestDTO.setPassword("holiday over");
        pasteRequestDTO.setClientIp("0.0.0.0");

        BeanUtils.copyProperties(pasteRequestDTO, pasteResponseDTO);
    }

    @Test
    public void main() {
        String key;
        Long count = permanentManager.countAll().getData();

        // save
        {
            Response<String> stringResponse = permanentManager.save(pasteRequestDTO);
            assertTrue(stringResponse.isSuccess());

            key = stringResponse.getData();
        }

        assertEquals(Long.valueOf(count + 1), permanentManager.countAll().getData());

        // get
        {
            Response<PasteResponseDTO> pasteResponseDTOResponse = permanentManager.get(key);

            assertTrue(pasteResponseDTOResponse.isSuccess());
            assertEquals(pasteResponseDTO, pasteResponseDTOResponse.getData());
        }

        assertEquals(Long.valueOf(count + 1), permanentManager.countAll().getData());
    }
}
