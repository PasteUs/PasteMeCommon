package cn.pasteme.common.utils;

import cn.pasteme.common.entity.PasteDO;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

/**
 * @Author: 白振宇
 * @Date： 2019/10/2 2:02
 */
public class PwdMatch<E> {
    public static<T> T match(Optional<PasteDO> pasteDO, T t, String pwd) {
        pasteDO.filter(p -> {
            boolean flag = false;
            try {
                flag = p.getPassword() == null || p.getPassword().isEmpty() || (pwd != null && !pwd.isEmpty() && Md5.getMd5Str(pwd).equals(p.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return flag;
        }).ifPresent(p -> BeanUtils.copyProperties(p, t));
        return t;
    }
}
