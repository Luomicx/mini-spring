package com.silas.minispring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description:
 * @Version: 1.0
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
