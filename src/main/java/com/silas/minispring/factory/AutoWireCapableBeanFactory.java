package com.silas.minispring.factory;

import com.silas.minispring.BeanDefinition;
import com.silas.minispring.BeanReference;
import com.silas.minispring.PropertyValue;

import java.lang.reflect.Field;

/**
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description: 可自动装配内容 BeanFactory
 * @Version: 1.0
 */
public class AutoWireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }
}
