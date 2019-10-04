package cn.pasteme.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author 白振宇
 * @date 2019/10/4 11:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PasteRequestDTO extends PasteResponseDTO {

    @NotBlank
    private String key;

    private String password;

}
