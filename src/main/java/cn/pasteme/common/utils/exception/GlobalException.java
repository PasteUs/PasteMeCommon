package cn.pasteme.common.utils.exception;

import cn.pasteme.common.utils.result.CodeMessage;
import lombok.Getter;


/**
 * @author 白振宇
 * @date 2019/09/29 22:14
 */
@Getter
public class GlobalException extends RuntimeException {

    private CodeMessage cm;

    public GlobalException(CodeMessage cm) {
        super(cm.toString());
        this.cm = cm;
    }
}
