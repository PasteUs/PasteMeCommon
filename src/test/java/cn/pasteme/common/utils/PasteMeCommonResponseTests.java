package cn.pasteme.common.utils;

import cn.pasteme.common.utils.result.Response;
import cn.pasteme.common.utils.result.ResponseCode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lucien
 * @version 1.0.0
 */
@Slf4j
public class PasteMeCommonResponseTests {

    @Test
    public void main() {
        {
            Response<Long> response = Response.error(ResponseCode.FORBIDDEN);
            Assert.assertFalse(response.isSuccess());
            Assert.assertNull(response.getData());

            Response<String> result = Response.error(response);
            Assert.assertFalse(result.isSuccess());
            Assert.assertNull(result.getData());
        }

        try {
            Response<String> response = Response.success("Hello World!");
            Assert.assertTrue(response.isSuccess());
            Assert.assertEquals("Hello World!", response.getData());

            Response.error(response);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals("Error response is required", e.getMessage());
        }
    }
}
