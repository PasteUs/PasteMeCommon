package cn.pasteme.common.entity;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Lucien
 * @date 2019/10/01 01:58
 */
@Data
abstract class AbstractPaste {

    @NotBlank
    private String lang;

    @NotBlank
    private String content;

    @NotNull
    private String password;

    @NotBlank
    private String clientIp;

    @NotNull
    private Date createdAt;
}

