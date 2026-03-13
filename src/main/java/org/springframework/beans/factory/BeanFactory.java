package org.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-03-13
 * @Description:
 * @Version: 1.0
 */
public class BeanFactory {

    private Map<String, Object> beanMap = new HashMap<>();

    public void registerBean(String name, Object bean) {
        beanMap.put(name, bean);
    }

    public Object getBean(String name) {
        return beanMap.get(name);
    }
}
