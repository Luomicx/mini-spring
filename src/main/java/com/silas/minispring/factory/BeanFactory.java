package com.silas.minispring.factory;

import com.silas.minispring.BeanDefinition;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description: beanFactory interface
 * @Version: 1.0
 */
public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
