package cn.pasteme.common.utils.exception;

import cn.pasteme.common.utils.result.ResponseCode;
import lombok.Getter;


/**
 * @author Lucien, 白振宇
 * @version 1.0.0
 */
@Getter
public class GlobalException extends RuntimeException {

    private ResponseCode responseCode;

    public GlobalException(ResponseCode responseCode) {
        super(responseCode.toString());
        this.responseCode = responseCode;
    }
}
