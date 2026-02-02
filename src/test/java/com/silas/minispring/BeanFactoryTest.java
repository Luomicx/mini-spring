package com.silas.minispring;

import com.silas.minispring.factory.AutoWireCapableBeanFactory;
import com.silas.minispring.factory.BeanFactory;
import org.junit.Test;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description: Test BeanFactory
 * @Version: 1.0
 */
public class BeanFactoryTest {

    @Test
    public void Test() {
        //1. 初始化beanFactory
        BeanFactory beanFactory = new AutoWireCapableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.silas.minispring.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
