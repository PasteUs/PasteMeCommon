package cn.pasteme.common.annotation;

import java.lang.annotation.*;

/**
 * @author Ryan Lee
 * @date 2019/10/01 17:01
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotComponentScan {
}
