package cn.pasteme.common.utils.exception;

import cn.pasteme.common.utils.result.ResponseCode;
import lombok.Getter;


/**
 * @author 白振宇
 * @version 1.0.0
 */
@Getter
public class GlobalException extends RuntimeException {

    private ResponseCode cm;

    public GlobalException(ResponseCode cm) {
        super(cm.toString());
        this.cm = cm;
    }
}
