package com.silas.minispring;

/**
 * BeanDefinition 是 Spring IoC 容器中极其重要的组成部分。
 * 它用于定义 Bean 的元信息，包括 Bean 的类类型、属性值、构造函数参数等。
 * <p>
 * 在当前的简易实现中，它主要充当 Bean 实例的包装容器。
 *
 * @Author: 无糖茶 wiretender.top
 * @CreateTime: 2026-02-02
 * @Description: Bean 定义类，框架通过它来管理 Bean 的生命周期起点
 * @Version: 1.0
 */
public class BeanDefinition {

    /**
     * 持有具体的 Bean 实例。
     * 在后续扩展中，这里通常会改为存储 Bean 的 Class 对象，
     * 从而实现“延迟加载”和“按需实例化”。
     */
    private Object bean;

    private Class beanClass;

    private String beanClassName;

    private PropertyValues propertyValues = new PropertyValues();

    public BeanDefinition() {
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
