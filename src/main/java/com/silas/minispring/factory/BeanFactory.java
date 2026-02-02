package com.silas.minispring.factory;

import com.silas.minispring.BeanDefinition;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description: beanFactory interface Bean的容器
 * @Version: 1.0
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
