package cn.pasteme.common.utils.converter;

/**
 * @author Moyu
 * @version 1.0.0
 */
public class DoToDtoConverter extends BeansConverter {

    public static <T, E> E convert(T source, E target, String... ignore) {
        return BeansConverter.convert(source, target, ignore);
    }
}