package cn.pasteme.common.enumeration;

import lombok.Getter;

/**
 * @author Moyu
 * @version 1.0.0
 */
public enum FieldEnum implements ValueEnum {

    // key
    FIELD_KEY("key", 0);

    @Getter
    private int value;

    @Getter
    private String name;


    FieldEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
