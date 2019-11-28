package cn.pasteme.common.utils.converter;

import org.springframework.beans.BeanUtils;


/**
 * 统一配置领域模型转换规则
 * e.g. 转换时是否忽略属性类型的差别
 * e.g. 是否添加额外默认属性
 *
 * @author Moyu
 * @version 1.1.0
 */
public class BeansConverter {

    protected static <T, E> E convert(T source, E target, String... ignore) {
        BeanUtils.copyProperties(source, target, ignore);
        return target;
    }
}
