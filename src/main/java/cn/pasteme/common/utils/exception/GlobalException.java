package cn.pasteme.common.utils.exception;

import cn.pasteme.common.utils.result.CodeMsg;
import lombok.Getter;


/**
 * Created by 白振宇 on 2019/9/29 22:14
 */
@Getter
public class GlobalException extends RuntimeException {

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }
}
