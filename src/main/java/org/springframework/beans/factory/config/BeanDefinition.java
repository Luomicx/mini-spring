package org.springframework.beans.factory.config;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-03-13
 * @Description: BeanDefinition实例保存bean的信息，包括class类型、方法构造参数、是否为单例等，此处简化只包含class类型
 * @Version: 1.0
 */
public class BeanDefinition {
    private Class beanClass;

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }
}
