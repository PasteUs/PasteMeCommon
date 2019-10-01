package cn.pasteme.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Lucien
 * @date 2019/10/01 02:07
 */
@Data
public class PasteDTO {

    private String key;

    @NotBlank
    private String lang;

    @NotBlank
    private String content;

    private String password;
}
