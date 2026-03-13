package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-03-13
 * @Description: BeanDefinition注册表接口
 * @Version: 1.0
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表注入BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
