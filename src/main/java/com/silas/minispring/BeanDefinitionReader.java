package com.silas.minispring;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description: 从配置中读取BeanDefinitionReader
 * @Version: 1.0
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
