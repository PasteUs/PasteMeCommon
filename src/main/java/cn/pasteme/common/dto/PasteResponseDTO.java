package cn.pasteme.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Lucien
 * @version 1.0.0
 */
@Data
public class PasteResponseDTO {

    @NotBlank
    private String lang;

    @NotBlank
    private String content;

}
