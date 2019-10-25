package cn.pasteme.common.utils;

import org.springframework.stereotype.Service;
import javax.validation.constraints.NotBlank;

/**
 * 各种检查器
 * @author Lucien
 * @version 1.0.0
 */
@Service
public class Checker {
    public Boolean isValid(@NotBlank String key) {
        return !key.isBlank() && key.charAt(0) != '0' && key.matches("[a-zA-Z0-9]{3,8}");
    }

    public Boolean containAlpha(@NotBlank String key) {
        return key.matches("[a-zA-Z]");
    }
}
