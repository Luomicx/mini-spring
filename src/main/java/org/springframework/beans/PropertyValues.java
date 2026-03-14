package org.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-03-13
 * @Description:
 * @Version: 1.0
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();


    public void addPropertyValue(PropertyValue py) {
        propertyValueList.add(py);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (int i = 0;i < propertyValueList.size(); i ++) {
            PropertyValue py = this.propertyValueList.get(i);
            if (py.getName().equals(propertyName)) {
                return py;
            }
        }
        return null;
    }

}
