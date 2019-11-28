package cn.pasteme.common.utils.converter;

/**
 * @author Moyu
 * @version 1.0.0
 */
public class DtoToDoConverter extends BeansConverter {

    private DtoToDoConverter() {}

    public static <T, E> E convert(T source, E target, String... ignore) {
        return BeansConverter.convert(source, target, ignore);
    }
}
