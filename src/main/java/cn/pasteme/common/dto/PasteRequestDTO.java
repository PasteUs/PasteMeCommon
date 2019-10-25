package cn.pasteme.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author 白振宇
 * @version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PasteRequestDTO extends PasteResponseDTO {

    @NotBlank
    private String key;

    private String password;

    private String clientIp;

    public PasteRequestDTO(String key, String password) {
        this.key = key;
        this.password = password;
    }

    public PasteRequestDTO() {}

}
