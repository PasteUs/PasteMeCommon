package cn.pasteme.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Author: 白振宇
 * @Date: 2019/10/4 11:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PasteRequestDTO extends PasteDTO {

    private String password;

}
