package com.silas.minispring;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description: 包装一个对象的所有的PropertyValue
 * @Version: 1.0
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue pv) {
        // TODO: 这里可以对于重复的PropertyName进行判断，直接用list无法做到，等后续进行改进
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }
}
