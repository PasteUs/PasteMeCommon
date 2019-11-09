package cn.pasteme.common.entity;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Lucien
 * @version 1.0.0
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

