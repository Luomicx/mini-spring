package org.springframework.beans.factory.config;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-03-13
 * @Description: 单例注册表
 * @Version: 1.0
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
