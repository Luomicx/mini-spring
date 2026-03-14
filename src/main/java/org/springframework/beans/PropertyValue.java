package org.springframework.beans;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-03-13
 * @Description:
 * @Version: 1.0
 */
public class PropertyValue {
    private String name;
    private Object value;

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
