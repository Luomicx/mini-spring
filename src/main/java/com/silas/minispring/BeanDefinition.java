package com.silas.minispring;

/**
 * BeanDefinition 是 Spring IoC 容器中极其重要的组成部分。
 * 它用于定义 Bean 的元信息，包括 Bean 的类类型、属性值、构造函数参数等。
 *
 * 在当前的简易实现中，它主要充当 Bean 实例的包装容器。
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


    /**
     * 构造函数：初始化 Bean 定义
     * @param bean 传入的 Bean 实例对象
     */
    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    /**
     * 获取受容器管理的 Bean 实例
     * @return 返回保存在定义中的 Object 实例
     */
    public Object getBean() {
        return bean;
    }
}
