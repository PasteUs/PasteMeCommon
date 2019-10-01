package cn.pasteme.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Lucien
 * @date 2019/10/01 23:54
 */
@Slf4j
@Service
public class Util {

    private static String SEPARATOR = ",";

    /**
     * 取出 token 中的 key
     * @param token key,password
     * @return key
     */
    @NotNull
    public String token2Key(@NotBlank String token) {
        try {
            return token.split(SEPARATOR)[0];
        } catch (Exception e) {
            log.error("token = {}, exception = ", token, e);
            return null;
        }
    }

    /**
     * 取出 token 中的 password
     * 如果 token 中不包含 password 则返回空串
     * @param token key,password
     * @return password
     */
    @NotNull
    public String token2Password(@NotBlank String token) {
        try {
            return token.contains(SEPARATOR) ? token.substring(token.indexOf(SEPARATOR) + 1) : "";
        } catch (Exception e) {
            log.error("token = {}, exception = ", token, e);
            return null;
        }
    }
}
