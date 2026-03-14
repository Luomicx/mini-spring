package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.ioc.service.HelloService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-03-13
 * @Description:
 * @Version: 1.0
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {

    @Test
    public void testBeanFactory() throws Exception {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        defaultListableBeanFactory.registerBeanDefinition("helloService", beanDefinition);

        HelloService helloService = (HelloService) defaultListableBeanFactory.getBean("helloService");
        helloService.sayHello();
    }
}
